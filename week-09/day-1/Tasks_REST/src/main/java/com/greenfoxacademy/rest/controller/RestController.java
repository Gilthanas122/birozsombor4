package com.greenfoxacademy.rest.controller;

import com.greenfoxacademy.rest.model.Doubling;
import com.greenfoxacademy.rest.model.Error;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}
