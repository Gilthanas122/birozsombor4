package com.greenfoxacademy.rest.service;

import com.greenfoxacademy.rest.model.LogEntry;
import com.greenfoxacademy.rest.repository.LogEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogEntryServiceImpl implements LogEntryService {

  private LogEntryRepository logEntryRepository;

  @Autowired
  public LogEntryServiceImpl(LogEntryRepository logEntryRepository) {
    this.logEntryRepository = logEntryRepository;
  }

  @Override
  public int getCountOfEntries() {
    return logEntryRepository.findAll().size();
  }
}
