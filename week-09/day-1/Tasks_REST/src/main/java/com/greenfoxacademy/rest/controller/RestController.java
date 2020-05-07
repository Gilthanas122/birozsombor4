package com.greenfoxacademy.rest.controller;

import com.greenfoxacademy.rest.model.AppendA;
import com.greenfoxacademy.rest.model.Log;
import com.greenfoxacademy.rest.model.TextObject;
import com.greenfoxacademy.rest.model.DoUntil;
import com.greenfoxacademy.rest.model.Doubling;
import com.greenfoxacademy.rest.model.Error;
import com.greenfoxacademy.rest.model.FunctionalArray;
import com.greenfoxacademy.rest.model.LogEntry;
import com.greenfoxacademy.rest.model.SithText;
import com.greenfoxacademy.rest.model.WelcomeMessage;
import com.greenfoxacademy.rest.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
public class RestController {

  private LogService logService;

  @Autowired
  public RestController(LogService logService) {
    this.logService = logService;
  }

  @GetMapping("/doubling")
  public ResponseEntity<?> getDoublingOfANumber(@RequestParam(required = false) Integer input) {
    if (input == null) {
      return ResponseEntity.ok(new Error("Please provide an input!"));
    }
    Doubling doubling = new Doubling(input);
    logService.addNewLogEntry(new LogEntry("/doubling", doubling));
    return ResponseEntity.ok(doubling);
  }

  @GetMapping("/greeter")
  public ResponseEntity<?> getWelcomeMessage(@RequestParam(required = false) String name,
                                             @RequestParam(required = false) String title) {
    if (name == null && title == null) {
      return ResponseEntity.badRequest().body(new Error("Please provide a name and a title!"));
    } else if (name == null) {
      return ResponseEntity.badRequest().body(new Error("Please provide a name!"));
    } else if (title == null) {
      return ResponseEntity.badRequest().body(new Error("Please provide a title!"));
    }
    WelcomeMessage welcomeMessage = new WelcomeMessage(name, title);
    logService.addNewLogEntry(new LogEntry("/greeter", welcomeMessage));
    return ResponseEntity.ok(welcomeMessage);
  }

  @GetMapping("/appenda/{appendable}")
  public ResponseEntity<?> getWordWithAppendA(@PathVariable String appendable) {
    AppendA appendA = new AppendA(appendable);
    logService.addNewLogEntry(new LogEntry("/appenda/" + appendable, appendA));
    return ResponseEntity.ok(appendA);
  }

  @PostMapping("/dountil/{action}")
  public ResponseEntity<?> getDoUntilWithAction(@PathVariable String action,
                                                @RequestBody DoUntil doUntil) {
    if (doUntil.getUntil() == null) {
      return ResponseEntity.ok(new Error("Please provide a number!"));
    }
    doUntil.setResultAsWithAction(action);
    logService.addNewLogEntry(new LogEntry("/dountil/" + action, doUntil));
    return ResponseEntity.ok(doUntil);
  }

  @PostMapping("/arrays")
  public ResponseEntity<?> getResultOfAnArrayWithAction(@RequestBody FunctionalArray functionalArray) {
    if (functionalArray.getNumbers().size() == 0) {
      return ResponseEntity.badRequest().body(new Error("Please provide numbers!"));
    } else if (functionalArray.getWhat().isEmpty()) {
      return ResponseEntity.badRequest().body(new Error("Please provide what to do with numbers!"));
    }
    logService.addNewLogEntry(new LogEntry("/arrays", functionalArray));
    return ResponseEntity.ok(functionalArray);
  }

  @GetMapping("/log")
  public ResponseEntity<?> getAllLogEntries(@RequestParam(required = false) Integer count,
                                            @RequestParam(required = false) Integer page,
                                            @RequestParam(required = false) String q) {
    Log tempLog = new Log();
    if (q != null && (count != null || page != null)) {
      return ResponseEntity.badRequest().body(new Error("You cannot use q parameter with count " +
          "and/or page!"));
    } else if (q != null) {
      tempLog.setEntries(logService.getLogEntriesFromLogByQInData(q));
      return ResponseEntity.ok(tempLog);
    }
    if (count != null && page == null) {
      tempLog.setEntries(logService.getLogEntriesFromLogWithLimit(count));
      return ResponseEntity.ok(tempLog);
    } else if (page != null && count == null) {
      return ResponseEntity.badRequest().body(new Error("Please provide count as well!"));
    } else if (page != null && count != null) {
      tempLog.setEntries(logService.getLogEntriesFromLogWithLimitAndSelectedPage(count, page));
      return ResponseEntity.ok(tempLog);
    }
    return ResponseEntity.ok(logService.getLog());
  }

  @PostMapping("/sith")
  public ResponseEntity<?> translateTextToSith(@RequestBody SithText sithText) {
    if (sithText.getText() == null) {
      return ResponseEntity.badRequest().body(new Error("Feed me some text you have to, padawan " +
          "young you are. Hmmm."));
    }
    sithText.setSithTextWithTranslating();
    logService.addNewLogEntry(new LogEntry("/sith", sithText));
    return ResponseEntity.ok(sithText);
  }

  @PostMapping("/translate")
  public ResponseEntity<?> getCamelizedObject(@RequestBody TextObject textObject) {
    if (textObject.getLang() == null || textObject.getText() == null) {
      return ResponseEntity.badRequest().body(new Error("I can't translate that!"));
    }
    textObject.translate();
    logService.addNewLogEntry(new LogEntry("/translate", textObject));
    return ResponseEntity.ok(textObject);
  }
}
