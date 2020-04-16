package com.greenfoxacademx.springstart.controllers;

public class Greeting {
  private long id;
  private String content;

  public long getId() {
    return id;
  }

  public String getContent() {
    return content;
  }

  public Greeting(long id, String content) {
    this.id = id;
    this.content = content;
  }
}
