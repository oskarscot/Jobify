package me.oskarscot.springdeed.model.common.listing;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.oskarscot.springdeed.model.common.employer.Employer;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "springdeed_listings")
public class JobListing {

  @Id
  private int id;
  private String title;
  private String description;
  private String location;
  private double salary;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "employer_id")
  private Employer employer;

}
