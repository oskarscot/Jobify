package me.oskarscot.springdeed.auth;

import lombok.RequiredArgsConstructor;
import me.oskarscot.springdeed.config.JwtService;
import me.oskarscot.springdeed.data.user.Role;
import me.oskarscot.springdeed.data.user.User;
import me.oskarscot.springdeed.data.user.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

  private final PasswordEncoder passwordEncoder;
  private final UserRepository repository;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public ResponseEntity<AuthenticationResponse> register(RegisterRequest registerRequest) {
    if(repository.findByEmail(registerRequest.getEmail()).isPresent()) {
      return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    final User user = User.builder()
        .firstName(registerRequest.getFirstName())
        .lastName(registerRequest.getLastName())
        .email(registerRequest.getEmail())
        .password(passwordEncoder.encode(registerRequest.getPassword()))
        .role(Role.USER)
        .build();

    repository.save(user);

    return getAuthenticationResponseResponseEntity(user);
  }

  public ResponseEntity<AuthenticationResponse> authenticate(AuthenticationRequest authenticationRequest) {
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));

    final User user = repository.findByEmail(authenticationRequest.getEmail()).orElseThrow();

    return getAuthenticationResponseResponseEntity(user);
  }

  private ResponseEntity<AuthenticationResponse> getAuthenticationResponseResponseEntity(User user) {
    final String token = jwtService.generateToken(user);

    return ResponseEntity.ok(new AuthenticationResponse(token));
  }

  public boolean validate(String jwt) {
    return !jwtService.isTokenExpired(jwt);
  }

}
