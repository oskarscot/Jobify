package me.oskarscot.springdeed.model.common.listing;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateListingRequest {

  private String title;
  private String description;
  private String location;
  private double salary;
  private int employer;

}
