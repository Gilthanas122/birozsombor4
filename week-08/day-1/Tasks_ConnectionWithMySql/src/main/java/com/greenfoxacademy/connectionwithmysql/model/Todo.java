package com.greenfoxacademy.connectionwithmysql.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
  @Temporal(TemporalType.DATE)
  private Date dateOfCreation;
  @Temporal(TemporalType.DATE)
  private Date dateOfDue;

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
    this.dateOfDue = new Date();
    this.urgent = urgent;
    this.done = done;
    this.assignee = null;
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

  public Date getDateOfDue() {
    return dateOfDue;
  }

  public void setDateOfDue(Date dateOfDue) {
    this.dateOfDue = dateOfDue;
  }

  public Assignee getAssignee() {
    return assignee;
  }

  public void setAssignee(Assignee assignee) {
    this.assignee = assignee;
  }

  public void setDateOfDueWithStringParameter(String dateOfDue) {
    try {
      TimeZone zone = TimeZone.getTimeZone("UTC");
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
      format.setTimeZone(zone);
      this.setDateOfDue(format.parse(dateOfDue));
    } catch (Exception e) {
      System.out.println("Failed date parsing");
      System.exit(-1);
    }
  }

  public String getDateOfDueAsString() {
    try {
      TimeZone zone = TimeZone.getTimeZone("UTC");
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
      format.setTimeZone(zone);
      return format.format(this.dateOfDue);
    } catch (Exception e) {
      System.out.println("Failed date parsing");
      System.exit(-1);
    }
    return null;
  }
}
