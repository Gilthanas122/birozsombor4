package com.greenfoxacademy.restoptionals.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FillResponse {

  private String received;
  private Long amount;
  @JsonProperty("shipstatus")
  private String shipStatus;
  private Boolean ready;

  public FillResponse() {
  }

  public FillResponse(String received, Long amount, String shipStatus, Boolean ready) {
    this.received = received;
    this.amount = amount;
    this.shipStatus = shipStatus;
    this.ready = ready;
  }
}
