package com.greenfoxacademy.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Log {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "log")
  private List<LogEntry> entries;

  private int entryCount;

  public Log() {
    this.entries = new ArrayList<>();
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public List<LogEntry> getEntries() {
    return entries;
  }

  public void setEntries(List<LogEntry> entries) {
    this.entries = entries;
  }

  public int getEntryCount() {
    return entryCount;
  }

  public void setEntryCount(int entryCount) {
    this.entryCount = entryCount;
  }
}
