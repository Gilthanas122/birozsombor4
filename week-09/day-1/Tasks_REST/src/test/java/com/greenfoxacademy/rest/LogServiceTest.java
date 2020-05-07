package com.greenfoxacademy.rest;

import com.greenfoxacademy.rest.model.Log;
import com.greenfoxacademy.rest.model.LogEntry;
import com.greenfoxacademy.rest.repository.LogRepository;
import com.greenfoxacademy.rest.service.LogService;
import com.greenfoxacademy.rest.service.LogServiceImpl;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class LogServiceTest {

  @Test
  public void getLogReturnsLogWithCorrectFields() {
    //Arrange
    LogRepository logRepository = Mockito.mock(LogRepository.class);
    LogServiceImpl logService = new LogServiceImpl(logRepository);

    Optional<Log> fakeLog = Optional.of(new Log());
    fakeLog.get().setId(999);
    fakeLog.get().setEntries(Arrays.asList(new LogEntry()));
    fakeLog.get().setEntryCount(fakeLog.get().getEntries().size());

    Mockito.when(logRepository.findById(1l)).thenReturn(fakeLog);

    //Act
    Log log = logService.getLog();

    //Assert
    Assert.assertEquals(999, log.getId());
    Assert.assertEquals(1, log.getEntryCount());
  }

  @Test
  public void getLogEntriesFromLogWithLimitReturnsCorrectListSize() {
    //Arrange
    LogRepository logRepository = Mockito.mock(LogRepository.class);
    LogService logService = new LogServiceImpl(logRepository);
    List<LogEntry> fakeList = Arrays.asList(new LogEntry(), new LogEntry(), new LogEntry());
    Log fakeLog = new Log();
    fakeLog.setEntries(fakeList);

    Mockito.when(logRepository.findById(1l)).thenReturn(Optional.of(fakeLog));

    //Act
    List<LogEntry> logEntryList = logService.getLogEntriesFromLogWithLimit(2);

    //Assert
    Assert.assertEquals(2, logEntryList.size());
  }

  @Test
  public void getLogEntriesFromLogWithLimitAndSelectedPageReturnsCorrectList() {
    //Arrange
    LogRepository logRepository = Mockito.mock(LogRepository.class);
    LogService logService = new LogServiceImpl(logRepository);
    Log fakeLog = new Log();
    List<LogEntry> fakeList = Arrays.asList(new LogEntry(1),
        new LogEntry(2),
        new LogEntry(3),
        new LogEntry(4),
        new LogEntry(5),
        new LogEntry(6));
    fakeLog.setEntries(fakeList);

    Mockito.when(logRepository.findById(1l)).thenReturn(Optional.of(fakeLog));

    //Act
    List<LogEntry> logEntries = logService.getLogEntriesFromLogWithLimitAndSelectedPage(5, 2);

    //Assert
    Assert.assertEquals(6, logEntries.get(0).getId());
    Assert.assertEquals(1, logEntries.size());
  }

  @Test
  public void getLogEntriesFromLogByQInDataReturnsValidEntries() {
    //Arrange
    LogRepository logRepository = Mockito.mock(LogRepository.class);
    LogService logService = new LogServiceImpl(logRepository);
    Log fakeLog = new Log();
    List<LogEntry> fakeList = Arrays.asList(new LogEntry("result"),
        new LogEntry("error"),
        new LogEntry("result"));
    fakeLog.setEntries(fakeList);

    Mockito.when(logRepository.findById(1l)).thenReturn(Optional.of(fakeLog));

    //Act
    List<LogEntry> logEntries = logService.getLogEntriesFromLogByQInData("result");

    //Assert
    Assert.assertEquals(2, logEntries.size());
    Assert.assertEquals("result", logEntries.get(0).getData());
    Assert.assertEquals("result", logEntries.get(1).getData());
  }

  @Test
  public void addNewLogEntry() {
    //Assert
    LogRepository logRepository = Mockito.mock(LogRepository.class);
    LogService logService = new LogServiceImpl(logRepository);
    Log fakeLogBefore = new Log();
    Log fakeLogAfter = new Log();
    fakeLogAfter.setEntries(Arrays.asList(new LogEntry()));

    Mockito.when(logRepository.findById(1l)).thenReturn(Optional.of(fakeLogBefore));
    Mockito.when(logRepository.save(fakeLogBefore)).thenReturn(fakeLogAfter);

    //Act

    //Assert
    Assert.assertEquals(1, fakeLogAfter.getEntries().size());
  }
}
