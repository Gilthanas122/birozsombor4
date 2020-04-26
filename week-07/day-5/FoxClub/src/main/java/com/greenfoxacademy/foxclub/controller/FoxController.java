package com.greenfoxacademy.foxclub.controller;

import com.greenfoxacademy.foxclub.service.ActionService;
import com.greenfoxacademy.foxclub.service.FoxService;
import com.greenfoxacademy.foxclub.service.NutritionService;
import com.greenfoxacademy.foxclub.service.TrickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FoxController {

  private ActionService actionService;
  private TrickService trickService;
  private NutritionService nutritionService;
  private FoxService foxService;

  @Autowired
  public FoxController(NutritionService nutritionService, FoxService foxService,
                       TrickService trickService, ActionService actionService) {
    this.nutritionService = nutritionService;
    this.foxService = foxService;
    this.trickService = trickService;
    this.actionService = actionService;
  }

  @GetMapping(value = "/nutritionStore")
  public String getNutritionStoreView(@RequestParam String name, Model model) {
    model.addAttribute("lastSelectedFoodIndex",
        nutritionService.getLastSelectedFoodIndex(foxService.getSelectedFoxByName(name)));
    model.addAttribute("lastSelectedDrinkIndex",
        nutritionService.getLastSelectedDrinkIndex(foxService.getSelectedFoxByName(name)));
    model.addAttribute("foods", nutritionService.getListOfFoods());
    model.addAttribute("drinks", nutritionService.getListOfDrinks());
    model.addAttribute("selectedFox", foxService.getSelectedFoxByName(name));
    return "nutritionStore";
  }

  @PostMapping(value = "/nutritionStore")
  public String changeNutritionForFox(@RequestParam String name, String selectedFood,
                                      String selectedDrink) {
    actionService.addNewActionChangeFood(foxService.getSelectedFoxByName(name), selectedFood);
    actionService.addNewActionChangeDrink(foxService.getSelectedFoxByName(name), selectedDrink);
    foxService.getSelectedFoxByName(name).setDrink(nutritionService.getSelectedDrink(selectedDrink));
    foxService.getSelectedFoxByName(name).setFood(nutritionService.getSelectedFood(selectedFood));
    return "redirect:/?name=" + name;
  }

  @GetMapping(value = "/trickCenter")
  public String getTrickCenterView(@RequestParam String name,
                                   @RequestParam(required = false) String performedTrick,
                                   Model model) {
    model.addAttribute("tricks",
        trickService.getUnlearnedListOfTricks(foxService.getSelectedFoxByName(name)));
    model.addAttribute("selectedFox", foxService.getSelectedFoxByName(name));
    model.addAttribute("learnedTricks",
        trickService.getLearnedListOfTricks(foxService.getSelectedFoxByName(name)));
    if (performedTrick != null) {
      model.addAttribute("performedTrick", trickService.getTrickByName(performedTrick));
    }
    return "trickCenter";
  }

  @PostMapping(value = "/trickCenter")
  public String learnANewTrick(@RequestParam String name, String selectedTrick) {
    actionService.addNewActionLearnTrick(foxService.getSelectedFoxByName(name), selectedTrick);
    foxService.getSelectedFoxByName(name).addNewTrick(trickService.getSelectedTrick(selectedTrick));
    return "redirect:/?name=" + name;
  }

  @PostMapping(value = "/performTrick")
  public String performALearnedTrick(@RequestParam String name, String performedTrick) {
    return "redirect:/trickCenter?name=" + name + "&performedTrick=" + performedTrick;
  }

  @GetMapping(value = "/actionHistory")
  public String getActionHistoryView(@RequestParam String name, Model model) {
    model.addAttribute("actions",
        actionService.getActionHistoryAsListOfStrings(foxService.getSelectedFoxByName(name)));
    model.addAttribute("selectedFox", foxService.getSelectedFoxByName(name));
    return "actionHistory";
  }
}
