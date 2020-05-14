package com.greenfoxacademy.petshelter.controller;

import com.greenfoxacademy.petshelter.dto.ErrorDTO;
import com.greenfoxacademy.petshelter.service.HumanService;
import com.greenfoxacademy.petshelter.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class PetApiController {

  private HumanService humanService;
  private PetService petService;

  @Autowired
  public PetApiController(HumanService humanService, PetService petService) {
    this.humanService = humanService;
    this.petService = petService;
  }

  @GetMapping("/pet-names-older-human")
  public ResponseEntity getPetNamesOfOlderOwners(@RequestParam("age") Integer ageLimit) {
    if (humanService.isHumansExistAboveAge(ageLimit)) {
      return ResponseEntity.ok(humanService.getListOfPetNamesFromOwnersAboveAge(ageLimit));
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDTO("None of the pets' " +
        "owners are older then " + ageLimit));
  }
}
