package me.oskarscot.springdeed.controller;

import me.oskarscot.springdeed.model.common.employer.CreateEmployerRequest;
import me.oskarscot.springdeed.model.common.employer.Employer;
import me.oskarscot.springdeed.service.EmployerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/employers")
@RestController
public class EmployerController {

  private final EmployerService employerService;

  public EmployerController(EmployerService employerService){
    this.employerService = employerService;
  }

  @PostMapping("/create")
  public ResponseEntity<Employer> createEmployer(@RequestBody CreateEmployerRequest request) {
    return ResponseEntity.ok(employerService.save(Employer.builder()
        .name(request.getName())
        .build()));
  }

}
