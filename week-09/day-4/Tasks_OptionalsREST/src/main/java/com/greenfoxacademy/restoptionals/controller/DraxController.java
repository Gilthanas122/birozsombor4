package com.greenfoxacademy.restoptionals.controller;

import com.greenfoxacademy.restoptionals.model.Food;
import com.greenfoxacademy.restoptionals.service.DraxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DraxController {
  private DraxService draxService;

  @Autowired
  public DraxController(DraxService draxService) {
    this.draxService = draxService;
  }

  @GetMapping("/drax")
  public ResponseEntity getCalorieTable() {
    return ResponseEntity.ok(draxService.createAndGetCalorieTable());
  }

  @PostMapping("/drax")
  public ResponseEntity addNewFoodToCalorieTable(@RequestBody Food food) {
    draxService.addNewFoodToCalorieTable(food);
    return ResponseEntity.status(HttpStatus.CREATED).body(food);
  }

  @DeleteMapping("/drax/{id}")
  public ResponseEntity deleteAFoodFromCalorieTable(@PathVariable Long id){
    draxService.deleteFoodById(id);
    return ResponseEntity.ok(draxService.createAndGetCalorieTable());
  }

  @PutMapping("/drax/{id}")
  public ResponseEntity updateFood(@PathVariable Long id,@RequestBody Food food){
    draxService.updateFoodInCalorieTable(food, id);
    return ResponseEntity.ok(draxService.createAndGetCalorieTable());
  }
}
