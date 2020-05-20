package com.greenfoxacademy.foxclub.controller;

import com.greenfoxacademy.foxclub.model.Fox;
import com.greenfoxacademy.foxclub.service.ActionService;
import com.greenfoxacademy.foxclub.service.FoxService;
import com.greenfoxacademy.foxclub.service.NutritionService;
import com.greenfoxacademy.foxclub.service.TrickService;
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
  private TrickService trickService;
  private NutritionService nutritionService;
  private FoxService foxService;
  private UserService userService;

  @Autowired
  public FoxController(NutritionService nutritionService, FoxService foxService,
                       ActionService actionService, UserService userService,
                       TrickService trickService
  ) {
    this.nutritionService = nutritionService;
    this.foxService = foxService;
    this.trickService = trickService;
    this.actionService = actionService;
    this.userService = userService;
  }

  @GetMapping(value = "/nutritionStore")
  public String getNutritionStoreView(@RequestParam String username, Model model) {
    Fox foxOfUser = userService.getUserByUsername(username).getFox();
    model.addAttribute("lastSelectedFoodIndex",
        nutritionService.getLastSelectedFoodIndex(foxOfUser.getId()));
    model.addAttribute("lastSelectedDrinkIndex",
        nutritionService.getLastSelectedDrinkIndex(foxOfUser.getId()));
    model.addAttribute("foods", nutritionService.getListOfFoods());
    model.addAttribute("drinks", nutritionService.getListOfDrinks());
    model.addAttribute("selectedUser", userService.getUserByUsername(username));
    return "nutritionStore";
  }

  @PostMapping(value = "/nutritionStore")
  public String changeNutritionForFox(@RequestParam String username, String selectedFood,
                                      String selectedDrink) {
    Fox foxOfUser = userService.getUserByUsername(username).getFox();
    actionService.addNewActionChangeFood(foxOfUser.getId(), selectedFood);
    actionService.addNewActionChangeDrink(foxOfUser.getId(), selectedDrink);
    foxService.updateFoxFood(foxOfUser.getId(), selectedFood);
    foxService.updateFoxDrink(foxOfUser.getId(), selectedDrink);
    return "redirect:/?username=" + username;
  }

  @GetMapping(value = "/trickCenter")
  public String getTrickCenterView(@RequestParam String username,
                                   @RequestParam(required = false) String performedTrick,
                                   Model model) {
    Fox foxOfUser = userService.getUserByUsername(username).getFox();
    model.addAttribute("tricks",
        trickService.getUnlearnedListOfTricks(foxOfUser.getId()));
    model.addAttribute("selectedUser", userService.getUserByUsername(username));
    model.addAttribute("learnedTricks",
        trickService.getLearnedListOfTricks(foxOfUser.getId()));
    if (performedTrick != null) {
      model.addAttribute("performedTrick", trickService.getTrickByName(performedTrick));
    }
    return "trickCenter";
  }

  @PostMapping(value = "/trickCenter")
  public String learnANewTrick(@RequestParam String username, String selectedTrick) {
    Fox foxOfUser = userService.getUserByUsername(username).getFox();
    actionService.addNewActionLearnTrick(foxOfUser.getId(), selectedTrick);
    foxService.updateFoxTricks(foxOfUser.getId(), selectedTrick);
    return "redirect:/?username=" + username;
  }

  @PostMapping(value = "/performTrick")
  public String performALearnedTrick(@RequestParam String username, String performedTrick) {
    return "redirect:/trickCenter?username=" + username + "&performedTrick=" + performedTrick;
  }

  @GetMapping(value = "/actionHistory")
  public String getActionHistoryView(@RequestParam String username, Model model) {
    Fox foxOfUser = userService.getUserByUsername(username).getFox();
    model.addAttribute("actions",
        actionService.getActionHistoryAsListOfStrings(foxOfUser.getId()));
    model.addAttribute("selectedUser", userService.getUserByUsername(username));
    return "actionHistory";
  }
}
