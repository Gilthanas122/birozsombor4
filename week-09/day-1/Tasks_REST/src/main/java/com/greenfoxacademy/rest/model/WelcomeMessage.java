package com.greenfoxacademy.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(value = {"name", "title"})
public class WelcomeMessage {

  private String name;
  private String title;

  @JsonProperty("welcome_message")
  private String welcomeMessage;

  public WelcomeMessage(String name, String title) {
    this.name = name;
    this.title = title;
    this.welcomeMessage = "Oh, hi there " + this.name + ", my dear " + this.title + "!";
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getWelcomeMessage() {
    return welcomeMessage;
  }

  public void setWelcomeMessage(String welcome_message) {
    this.welcomeMessage = welcome_message;
  }
}
