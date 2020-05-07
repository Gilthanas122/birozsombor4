package com.greenfoxacademy.restoptionals.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.text.DecimalFormat;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Cargo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonIgnore
  private Long id;
  @JsonProperty("caliber25")
  private Long ammoCaliber25;
  @JsonProperty("caliber30")
  private Long ammoCaliber30;
  @JsonProperty("caliber50")
  private Long ammoCaliber50;
  @JsonProperty("shipstatus")
  private String shipStatus;
  private Boolean ready;

  public Cargo() {
    this.ammoCaliber25 = 0l;
    this.ammoCaliber30 = 0l;
    this.ammoCaliber50 = 0l;

    this.shipStatus = "empty";
  }

  public Cargo(Long ammoCaliber25, Long ammoCaliber30, Long ammoCaliber50) {
    this.ammoCaliber25 = ammoCaliber25;
    this.ammoCaliber30 = ammoCaliber30;
    this.ammoCaliber50 = ammoCaliber50;
    this.shipStatus = calculateShipStatus(ammoCaliber25, ammoCaliber30, ammoCaliber50);
    this.ready = (this.ammoCaliber25 + this.ammoCaliber30 + this.ammoCaliber50 == 12500) ? true :
        false;
  }

  private String calculateShipStatus(Long ammoCaliber25, Long ammoCaliber30, Long ammoCaliber50) {
    Long ammo = ammoCaliber25 + ammoCaliber30 + ammoCaliber50;
    Double percent = ((double) ammo / 12500) * 100;
    if (ammo == 12500) {
      return "full";
    } else if (ammo > 12500) {
      return "overloaded";
    } else if (percent == 0) {
      return "empty";
    } else {
      DecimalFormat decimalFormat = new DecimalFormat("#");
      return decimalFormat.format(percent) + "%";
    }
  }
}
