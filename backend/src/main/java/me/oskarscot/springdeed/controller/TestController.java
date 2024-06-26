package me.oskarscot.springdeed.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ping")
public class TestController {

  @GetMapping
  public ResponseEntity<String> ping() {
    return ResponseEntity.ok("Pong!");
  }

}
