package me.oskarscot.springdeed.security.auth;

import lombok.RequiredArgsConstructor;
import me.oskarscot.springdeed.config.JwtService;
import me.oskarscot.springdeed.exception.ErrorResponse;
import me.oskarscot.springdeed.model.internal.permission.Role;
import me.oskarscot.springdeed.model.internal.User;
import me.oskarscot.springdeed.database.user.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

  private final PasswordEncoder passwordEncoder;
  private final UserRepository repository;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public ResponseEntity<?> register(RegisterRequest registerRequest) {
    if(repository.findByEmail(registerRequest.getEmail()).isPresent()) {
      return ResponseEntity.status(HttpStatus.CONFLICT)
          .body(new ErrorResponse("A user with this email already exists"));
    }

    final User user;
    try {
      user = new User();
          user.setFirstName(registerRequest.getFirstName());
          user.setLastName(registerRequest.getLastName());
          user.setEmail(registerRequest.getEmail());
          user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
          user.setRole(Role.USER);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(new ErrorResponse("Invalid request format"));
    }

    repository.save(user);

    return getAuthenticationResponseResponseEntity(user);
  }

  public ResponseEntity<?> authenticate(AuthenticationRequest authenticationRequest) {
    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));
    } catch (AuthenticationException e) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
          .body(new ErrorResponse("Invalid email or password"));
    }

    final User user = repository.findByEmail(authenticationRequest.getEmail()).orElseThrow();

    return getAuthenticationResponseResponseEntity(user);
  }

  private ResponseEntity<AuthenticationResponse> getAuthenticationResponseResponseEntity(User user) {
    final String token = jwtService.generateToken(user);

    return ResponseEntity.ok(new AuthenticationResponse(token));
  }
}
