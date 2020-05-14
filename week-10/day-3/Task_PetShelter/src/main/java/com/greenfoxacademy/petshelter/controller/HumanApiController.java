package com.greenfoxacademy.petshelter.controller;

import com.greenfoxacademy.petshelter.dto.ErrorDTO;
import com.greenfoxacademy.petshelter.dto.HumanDTO;
import com.greenfoxacademy.petshelter.service.HumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HumanApiController {

  private HumanService humanService;

  @Autowired
  public HumanApiController(HumanService humanService) {
    this.humanService = humanService;
  }

  @GetMapping("/human/{id}")
  public ResponseEntity getHumanById(@PathVariable Long id) {
    if (humanService.isHumanExist(id)) {
      return ResponseEntity.ok(humanService.getHumanById(id));
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDTO("No human on the given " +
        "index " + id));
  }

  @DeleteMapping("/human/{id}")
  public ResponseEntity deleteHumanById(@PathVariable Long id) {
    if (humanService.isHumanExist(id)) {
      humanService.deleteHumanById(id);
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDTO("No human on the given " +
        "index " + id));
  }

  @PutMapping("/human/{id}")
  public ResponseEntity updateHumanById(@RequestBody HumanDTO humanDTO,
                                        @PathVariable("id") Long humanId) {
    if (humanService.isHumanExist(humanId)) {
      humanService.updateHuman(humanDTO, humanId);
      return ResponseEntity.ok(humanService.getHumanById(humanId));
    }
    return ResponseEntity.notFound().build();
  }
}
