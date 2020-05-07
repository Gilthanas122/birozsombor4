package com.greenfoxacademy.rest.service;

import com.greenfoxacademy.rest.model.Log;
import com.greenfoxacademy.rest.model.LogEntry;
import java.util.List;

public interface LogService {
  Log getLog();

  Log addNewLogEntry(LogEntry newLog);

  List<LogEntry> getLogEntriesFromLogWithLimit(Integer limit);

  List<LogEntry> getLogEntriesFromLogWithLimitAndSelectedPage(Integer limit, Integer page);

  List<LogEntry> getLogEntriesFromLogByQInData(String q);
}
