package me.oskarscot.springdeed.auth;


import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService authenticationService;

  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest) {
    return authenticationService.register(registerRequest);
  }

  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest authenticationRequest) {
    return authenticationService.authenticate(authenticationRequest);
  }

  @GetMapping(value = "/validate/{token}")
  public ResponseEntity<Boolean> validate(@PathVariable String token) {
    return new ResponseEntity<>(authenticationService.validate(token), HttpStatus.OK);
  }

}
