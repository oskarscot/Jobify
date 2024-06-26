package me.oskarscot.springdeed.database.listing;

import java.util.List;
import me.oskarscot.springdeed.model.common.listing.JobListing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListingRepository extends JpaRepository<JobListing, Integer> {

  List<JobListing> findByLocation(String location);

}
