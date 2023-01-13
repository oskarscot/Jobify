package me.oskarscot.springdeed.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

  private static final String SECRET = "28472D4B6150645367566B5970337336763979244226452948404D6251655468";

  public String extractUsername(String jwt) {
    return extractClaim(jwt, Claims::getSubject);
  }

  public <T> T extractClaim(String jwt, Function<Claims, T> claimResolver) {
    final Claims claims = extractAllClaims(jwt);
    return claimResolver.apply(claims);
  }

  public String generateToken(Map<String, Object> claims, UserDetails userDetails) {
    return Jwts.builder()
        .setClaims(claims)
        .setSubject(userDetails.getUsername())
        .setIssuedAt(Date.from(Instant.now()))
        .setExpiration(Date.from(Instant.now().plus(Duration.ofDays(1))))
        .signWith(getSigningKey(), SignatureAlgorithm.HS256)
        .compact();
  }

  public String generateToken(UserDetails userDetails) {
    return generateToken(Map.of(), userDetails);
  }

  public boolean isTokenValid(String jwt, UserDetails userDetails) {
    final String username = extractUsername(jwt);
    return username.equals(userDetails.getUsername()) && !isTokenExpired(jwt);
  }

  private boolean isTokenExpired(String jwt) {
    return extractClaim(jwt, Claims::getExpiration).before(Date.from(Instant.now()));
  }


  private Claims extractAllClaims(String token) {
    return Jwts
        .parserBuilder()
        .setSigningKey(getSigningKey())
        .build()
        .parseClaimsJws(token)
        .getBody();
  }

  private Key getSigningKey() {
    byte[] secretKeyBytes = Decoders.BASE64.decode(SECRET);
    return Keys.hmacShaKeyFor(secretKeyBytes);
  }
}
