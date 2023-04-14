package me.oskarscot.springdeed.controller;

import java.util.List;
import me.oskarscot.springdeed.data.listing.CreateListingRequest;
import me.oskarscot.springdeed.data.listing.JobListing;
import me.oskarscot.springdeed.data.listing.ListingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/listings")
@RestController
public class JobListingController {

  private final ListingService listingService;

  public JobListingController(ListingService listingService){
    this.listingService = listingService;
  }

  @GetMapping
  public ResponseEntity<List<JobListing>> getJobListings() { // TODO: Replace with paginated response
    return ResponseEntity.ok(listingService.getAllListings());
  }

  @PostMapping("/add")
  public ResponseEntity<JobListing> createJobListing(@RequestBody CreateListingRequest request) {
    return ResponseEntity.ok(listingService.createListing(JobListing.builder()
        .title(request.getTitle())
        .description(request.getDescription())
        .salary(request.getSalary())
        .location(request.getLocation())
        .build()));
  }


}
