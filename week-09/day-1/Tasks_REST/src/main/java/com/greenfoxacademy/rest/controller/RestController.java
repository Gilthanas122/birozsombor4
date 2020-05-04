package com.greenfoxacademy.rest.controller;

import com.greenfoxacademy.rest.model.AppendA;
import com.greenfoxacademy.rest.model.DoUntil;
import com.greenfoxacademy.rest.model.Doubling;
import com.greenfoxacademy.rest.model.Error;
import com.greenfoxacademy.rest.model.FunctionalArray;
import com.greenfoxacademy.rest.model.WelcomeMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
public class RestController {

  @GetMapping("/doubling")
  public ResponseEntity<?> getDoublingOfANumber(@RequestParam(required = false) Integer input) {
    if (input == null) {
      return ResponseEntity.ok(new Error("Please provide an input!"));
    }
    return ResponseEntity.ok(new Doubling(input));
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
    return ResponseEntity.ok(new WelcomeMessage(name, title));
  }

  @GetMapping("/appenda/{appendable}")
  public ResponseEntity<?> getWordWithAppendA(@PathVariable String appendable) {
    return ResponseEntity.ok(new AppendA(appendable));
  }

  @PostMapping("/dountil/{action}")
  public ResponseEntity<?> getDoUntilWithAction(@PathVariable String action,
                                                @RequestBody DoUntil doUntil) {
    if (doUntil.getUntil() == null) {
      return ResponseEntity.ok(new Error("Please provide a number!"));
    }
    doUntil.setResultAsWithAction(action);
    return ResponseEntity.ok(doUntil);
  }

  @PostMapping("/arrays")
  public ResponseEntity<?> getResultOfAnArrayWithAction(@RequestBody FunctionalArray functionalArray) {
    if (functionalArray.getNumbers().size() == 0) {
      return ResponseEntity.badRequest().body(new Error("Please provide numbers!"));
    } else if (functionalArray.getWhat().isEmpty()) {
      return ResponseEntity.badRequest().body(new Error("Please provide what to do with numbers!"));
    }
    return ResponseEntity.ok(functionalArray);
  }
}