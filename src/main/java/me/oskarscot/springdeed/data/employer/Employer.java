package me.oskarscot.springdeed.data.employer;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.oskarscot.springdeed.data.listing.JobListing;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "springdeed_employers")
public class Employer {

  @Id
  private int id;
  private String name;

  @OneToMany(mappedBy = "employer", fetch = FetchType.LAZY)
  private List<JobListing> listings;

}
