package com.greenfoxacademy.restoptionals.controller;

import com.greenfoxacademy.restoptionals.model.Cargo;
import com.greenfoxacademy.restoptionals.model.Error;
import com.greenfoxacademy.restoptionals.model.Groot;
import com.greenfoxacademy.restoptionals.model.Yondu;
import com.greenfoxacademy.restoptionals.service.RoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuardianController {

  private RoraService roraService;

  @Autowired
  public GuardianController(RoraService roraService) {
    this.roraService = roraService;
  }

  @GetMapping("/groot")
  public ResponseEntity translateToGroot(@RequestParam(required = false) String message) {
    if (message == null || message.isEmpty()) {
      return ResponseEntity.badRequest().body(new Error("I am Groot!"));
    }
    return ResponseEntity.ok(new Groot(message));
  }

  @GetMapping("/yondu")
  public ResponseEntity calculateYondu(@RequestParam(required = false) Float distance,
                                       @RequestParam(required = false) Float time) {
    if (distance == null || time == null) {
      return ResponseEntity.badRequest().body(new Error("Some of the parameter is null."));
    }
    if (time == 0) {
      return ResponseEntity.badRequest().body(new Error("You can't divide with 0!"));
    }
    return ResponseEntity.ok(new Yondu(distance, time));
  }

  @GetMapping("/rocket")
  public ResponseEntity getStatusOfActualCargo() {
    return ResponseEntity.ok(roraService.getActualCargoStatus());
  }

  @GetMapping("/rocket/fill")
  public ResponseEntity fillCargo(@RequestParam(required = false) String caliber,
                                  @RequestParam(required = false) Long amount) {
    if (caliber == null || amount == null){
      return ResponseEntity.badRequest().body(new Error("Missing parameters!"));
    }
    if (roraService.checkIsInvalidCaliber(caliber)) {
      return ResponseEntity.badRequest().body(new Error("Invalid caliber type!"));
    }
    roraService.addNewCargoStatus(caliber, amount);
    return ResponseEntity.ok(roraService.createAndGetFillResponse(caliber, amount));
  }

}
