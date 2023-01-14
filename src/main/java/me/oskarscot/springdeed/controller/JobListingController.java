package me.oskarscot.springdeed.controller;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import me.oskarscot.springdeed.data.employer.CreateEmployerRequest;
import me.oskarscot.springdeed.data.employer.Employer;
import me.oskarscot.springdeed.data.employer.EmployerRepository;
import me.oskarscot.springdeed.data.listing.CreateListingRequest;
import me.oskarscot.springdeed.data.listing.JobListing;
import me.oskarscot.springdeed.data.listing.ListingRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/listings")
@RestController
@RequiredArgsConstructor
public class JobListingController {

  private final ListingRepository repository;
  private final EmployerRepository employerRepository;

  @GetMapping
  public ResponseEntity<List<JobListing>> getJobListings() {
    return ResponseEntity.ok(repository.findAll());
  }

  @GetMapping("/employer/{employerId}")
  public ResponseEntity<List<JobListing>> getByEmployer(@PathVariable int employerId) {
    return ResponseEntity.ok(repository.findAll().stream().filter(jobListing -> jobListing.getEmployer().getId() == employerId).collect(
        Collectors.toList()));
  }

  @PostMapping("/add")
  public ResponseEntity<JobListing> createJobListing(@RequestBody CreateListingRequest request) {
    return ResponseEntity.ok(repository.save(JobListing.builder()
        .title(request.getTitle())
        .description(request.getDescription())
        .salary(request.getSalary())
        .location(request.getLocation())
        .employer(employerRepository.findById(0).get())
        .build()));
  }

  @PostMapping("/createEmployer")
  public ResponseEntity<Employer> createEmployer(@RequestBody CreateEmployerRequest request) {
    return ResponseEntity.ok(employerRepository.save(Employer.builder()
        .name(request.getName())
        .build()));
  }

}
