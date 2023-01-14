package me.oskarscot.springdeed.data.listing;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListingRepository extends JpaRepository<JobListing, Integer> {

  List<JobListing> findByLocation(String location);

}
