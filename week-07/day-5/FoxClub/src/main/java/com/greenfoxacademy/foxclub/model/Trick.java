package com.greenfoxacademy.foxclub.model;

public class Trick {
  private String name;
  private String imageSrc;
  private String alt;

  public Trick(String name, String imageSrc, String alt) {
    this.name = name;
    this.imageSrc = imageSrc;
    this.alt = alt;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getImageSrc() {
    return imageSrc;
  }

  public void setUrl(String imageSrc) {
    this.imageSrc = imageSrc;
  }

  public String getAlt() {
    return alt;
  }

  public void setAlt(String alt) {
    this.alt = alt;
  }
}
