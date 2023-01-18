package me.oskarscot.springdeed.config;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecretService {

  private final Environment environment;

  public String getJwtSecret() {
    return environment.getRequiredProperty("jwt.secret");
  }

  public int getJwtExpirationInMinutes() {
    return environment.getRequiredProperty("jwt.expirationInMinutes", Integer.class);
  }
}
