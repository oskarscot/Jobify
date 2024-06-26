package me.oskarscot.springdeed.service;

import java.util.List;
import me.oskarscot.springdeed.database.listing.ListingRepository;
import me.oskarscot.springdeed.model.common.listing.JobListing;
import org.springframework.stereotype.Service;

@Service
public class ListingService {

  private final ListingRepository listingRepository;

  public ListingService(ListingRepository listingRepository) {
    this.listingRepository = listingRepository;
  }


  public List<JobListing> getAllListings() {
    return listingRepository.findAll();
  }

  public JobListing createListing(JobListing jobListing) {
    return listingRepository.save(jobListing);
  }

}
