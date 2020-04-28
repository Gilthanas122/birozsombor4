package com.greenfoxacademy.connectionwithmysql.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Todo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String title;
  private String content;
  private String description;
  private boolean urgent = false;
  private boolean done = false;
  private Date dateOfCreation;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn
  private Assignee assignee;

  public Todo() {
  }

  public Todo(String title, String content, String description, boolean urgent, boolean done) {
    this.title = title;
    this.content = content;
    this.description = description;
    this.dateOfCreation = new Date();
    this.urgent = urgent;
    this.done = done;
    //this.assignee = new Assignee("default","default");
  }

  public Todo(String title, String content, String description, boolean urgent, boolean done,
              String name) {
    this.title = title;
    this.content = content;
    this.description = description;
    this.dateOfCreation = new Date();
    this.urgent = urgent;
    this.done = done;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isUrgent() {
    return urgent;
  }

  public void setUrgent(boolean urgent) {
    this.urgent = urgent;
  }

  public boolean isDone() {
    return done;
  }

  public void setDone(boolean done) {
    this.done = done;
  }

  public Date getDateOfCreation() {
    return dateOfCreation;
  }

  public void setDateOfCreation(Date dateOfCreation) {
    this.dateOfCreation = dateOfCreation;
  }

  public Assignee getAssignee() {
    return assignee;
  }

  public void setAssignee(Assignee assignee) {
    this.assignee = assignee;
  }
}
