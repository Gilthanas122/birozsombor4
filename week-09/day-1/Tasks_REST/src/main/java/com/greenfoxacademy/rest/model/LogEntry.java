package com.greenfoxacademy.rest.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Date;
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
public class LogEntry {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt;

  private String endpoint;
  private String data;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn
  private Log log;

  public LogEntry() {
  }

  public LogEntry(String endpoint, Object o) {
    this.createdAt = new Date();
    this.endpoint = endpoint;
    this.data = createJsonFromObjectAndConvertToString(o);
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public String getEndpoint() {
    return endpoint;
  }

  public void setEndpoint(String endpoint) {
    this.endpoint = endpoint;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public Log getLog() {
    return log;
  }

  public void setLog(Log log) {
    this.log = log;
  }

  private String createJsonFromObjectAndConvertToString(Object o) {
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      return objectMapper.writeValueAsString(o);
    } catch (JsonProcessingException e) {
      System.out.println("Something went wrong with JsonProcessingToString");
      System.exit(-1);
    }
    return null;
  }
}
