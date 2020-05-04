package com.greenfoxacademy.rest.service;

import com.greenfoxacademy.rest.model.Log;
import com.greenfoxacademy.rest.model.LogEntry;
import com.greenfoxacademy.rest.repository.LogRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class LogServiceImpl implements LogService {

  private LogRepository logRepository;

  @Autowired
  public LogServiceImpl(LogRepository logRepository) {
    this.logRepository = logRepository;
  }

  @Override
  public Log getLog() {
    return logRepository.findById(1l).get();
  }

  @Override
  public void addNewLogEntry(LogEntry newLog) {
    Log log = logRepository.findById(1l).get();
    List<LogEntry> logEntries = log.getEntries();
    logEntries.add(newLog);
    log.setEntries(logEntries);
    log.setEntryCount(log.getEntries().size());
    newLog.setLog(log);
    logRepository.save(log);
  }
}
