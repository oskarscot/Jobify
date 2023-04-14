package me.oskarscot.springdeed.data.listing;

import java.util.List;
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
