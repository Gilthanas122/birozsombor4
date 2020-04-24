package com.greenfoxacademy.foxclub.controller;

import com.greenfoxacademy.foxclub.model.Fox;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FoxController {

  @GetMapping(value = "/nutritionStore")
  public String getNutritionStoreView(@RequestParam String name) {
    name = "";
    return "nutritionstore";
  }
}
