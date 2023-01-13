package me.oskarscot.springdeed.auth;

import lombok.RequiredArgsConstructor;
import me.oskarscot.springdeed.config.JwtService;
import me.oskarscot.springdeed.user.Role;
import me.oskarscot.springdeed.user.User;
import me.oskarscot.springdeed.user.UserRepository;
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
    final User user = User.builder()
        .firstName(registerRequest.getFirstName())
        .lastName(registerRequest.getLastName())
        .email(registerRequest.getEmail())
        .password(passwordEncoder.encode(registerRequest.getPassword()))
        .role(Role.USER)
        .build();

    if(repository.findByEmail(user.getEmail()).isPresent()) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    repository.save(user);

    final String jwtToken = jwtService.generateToken(user);

    return ResponseEntity.ok(new AuthenticationResponse(jwtToken));
  }

  public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));

    final User user = repository.findByEmail(authenticationRequest.getEmail()).orElseThrow();

    final String jwtToken = jwtService.generateToken(user);

    return AuthenticationResponse.builder()
        .authenticationToken(jwtToken)
        .build();
  }

}
