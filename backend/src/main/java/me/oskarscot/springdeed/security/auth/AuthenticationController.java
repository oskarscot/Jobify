package me.oskarscot.springdeed.security.auth;


import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import me.oskarscot.springdeed.config.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService authenticationService;
  private final JwtService jwtService;

  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
    return authenticationService.register(registerRequest);
  }

  @PostMapping("/authenticate")
  public ResponseEntity<?> register(@RequestBody AuthenticationRequest authenticationRequest) {
    return authenticationService.authenticate(authenticationRequest);
  }

  @GetMapping("/validate")
  public ResponseEntity<Object> validateToken(@RequestHeader("Authorization") String token) {
    if (token != null && token.startsWith("Bearer ")) {
      final String jwt = token.substring(7);
      try {
        jwtService.isTokenExpired(jwt);
        return ResponseEntity.ok().build();
      } catch (ExpiredJwtException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
      }
    }
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

  }
}
