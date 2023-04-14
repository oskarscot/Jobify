package me.oskarscot.springdeed.model;

import java.time.OffsetDateTime;

public abstract class Model {

  protected OffsetDateTime createdAt;

  protected Model(final OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public OffsetDateTime getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(final OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

}
