package com.greenfoxacademy.rest.repository;

import com.greenfoxacademy.rest.model.LogEntry;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogEntryRepository extends CrudRepository<LogEntry, Long> {
  List<LogEntry> findAll();
}
