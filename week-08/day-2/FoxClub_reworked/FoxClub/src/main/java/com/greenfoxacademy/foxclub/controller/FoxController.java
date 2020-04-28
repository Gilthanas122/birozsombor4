package com.greenfoxacademy.foxclub.controller;

import com.greenfoxacademy.foxclub.service.ActionService;
import com.greenfoxacademy.foxclub.service.FoxService;
import com.greenfoxacademy.foxclub.service.NutritionService;
import com.greenfoxacademy.foxclub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FoxController {

  private ActionService actionService;
  //private TrickService trickService;
  private NutritionService nutritionService;
  private FoxService foxService;
  private UserService userService;

  @Autowired
  public FoxController(NutritionService nutritionService, FoxService foxService,
                       ActionService actionService, UserService userService
                       //TrickService trickService
  ) {
    this.nutritionService = nutritionService;
    this.foxService = foxService;
    //this.trickService = trickService;
    this.actionService = actionService;
    this.userService = userService;
  }

  @GetMapping(value = "/nutritionStore")
  public String getNutritionStoreView(@RequestParam String username, Model model) {
    model.addAttribute("lastSelectedFoodIndex",
        nutritionService.getLastSelectedFoodIndex(userService.getUserByUsername(username).getFox()));
    model.addAttribute("lastSelectedDrinkIndex",
        nutritionService.getLastSelectedDrinkIndex(userService.getUserByUsername(username).getFox()));
    model.addAttribute("foods", nutritionService.getListOfFoods());
    model.addAttribute("drinks", nutritionService.getListOfDrinks());
    model.addAttribute("selectedUser", userService.getUserByUsername(username));
    return "nutritionStore";
  }

  @PostMapping(value = "/nutritionStore")
  public String changeNutritionForFox(@RequestParam String username, String selectedFood,
                                      String selectedDrink) {
    actionService.addNewActionChangeFood(userService.getUserByUsername(username).getFox(), selectedFood);
    actionService.addNewActionChangeDrink(userService.getUserByUsername(username).getFox(), selectedDrink);
    foxService.updateFoxFood(userService.getUserByUsername(username).getFox(), selectedFood);
    foxService.updateFoxDrink(userService.getUserByUsername(username).getFox(), selectedDrink);
    return "redirect:/?username=" + username;
  }

  /*@GetMapping(value = "/trickCenter")
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
  }*/

  @GetMapping(value = "/actionHistory")
  public String getActionHistoryView(@RequestParam String username, Model model) {
    model.addAttribute("actions",
        actionService.getActionHistoryAsListOfStrings(userService.getUserByUsername(username).getFox()));
    model.addAttribute("selectedUser", userService.getUserByUsername(username));
    return "actionHistory";
  }
}
