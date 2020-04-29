package com.greenfoxacademy.foxclub.controller;

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
                       TrickService trickService, ActionService actionService, UserService userService) {
    this.nutritionService = nutritionService;
    this.foxService = foxService;
    this.trickService = trickService;
    this.actionService = actionService;
    this.userService = userService;
  }

  @GetMapping(value = "/nutritionStore")
  public String getNutritionStoreView(@RequestParam String username, Model model) {
    model.addAttribute("lastSelectedFoodIndex",
        nutritionService.getLastSelectedFoodIndex(foxService.getSelectedFoxByName(
            userService.findUserByName(username).getFox().getName())));
    model.addAttribute("lastSelectedDrinkIndex",
        nutritionService.getLastSelectedDrinkIndex(foxService.getSelectedFoxByName(
            userService.findUserByName(username).getFox().getName())));
    model.addAttribute("foods", nutritionService.getListOfFoods());
    model.addAttribute("drinks", nutritionService.getListOfDrinks());
    model.addAttribute("selectedFox", foxService.getSelectedFoxByName(
        userService.findUserByName(username).getFox().getName()));
    return "nutritionStore";
  }

  @PostMapping(value = "/nutritionStore")
  public String changeNutritionForFox(@RequestParam String username, String selectedFood,
                                      String selectedDrink) {
    actionService.addNewActionChangeFood(foxService.getSelectedFoxByName(
        userService.findUserByName(username).getFox().getName()), selectedFood);
    actionService.addNewActionChangeDrink(foxService.getSelectedFoxByName(
        userService.findUserByName(username).getFox().getName()), selectedDrink);
    foxService.getSelectedFoxByName(
        userService.findUserByName(username).getFox().getName()).setDrink(nutritionService.getSelectedDrink(selectedDrink));
    foxService.getSelectedFoxByName(
        userService.findUserByName(username).getFox().getName()).setFood(nutritionService.getSelectedFood(selectedFood));
    return "redirect:/?username=" + username;
  }

  @GetMapping(value = "/trickCenter")
  public String getTrickCenterView(@RequestParam String username,
                                   @RequestParam(required = false) String performedTrick,
                                   Model model) {
    model.addAttribute("tricks",
        trickService.getUnlearnedListOfTricks(foxService.getSelectedFoxByName(
            userService.findUserByName(username).getFox().getName())));
    model.addAttribute("selectedFox", foxService.getSelectedFoxByName(
        userService.findUserByName(username).getFox().getName()));
    model.addAttribute("learnedTricks",
        trickService.getLearnedListOfTricks(foxService.getSelectedFoxByName(
            userService.findUserByName(username).getFox().getName())));
    if (performedTrick != null) {
      model.addAttribute("performedTrick", trickService.getTrickByName(performedTrick));
    }
    return "trickCenter";
  }

  @PostMapping(value = "/trickCenter")
  public String learnANewTrick(@RequestParam String username, String selectedTrick) {
    actionService.addNewActionLearnTrick(foxService.getSelectedFoxByName(
        userService.findUserByName(username).getFox().getName()), selectedTrick);
    foxService.getSelectedFoxByName(
        userService.findUserByName(username).getFox().getName()).addNewTrick(trickService.getSelectedTrick(selectedTrick));
    return "redirect:/?username=" + username;
  }

  @PostMapping(value = "/performTrick")
  public String performALearnedTrick(@RequestParam String username, String performedTrick) {
    return "redirect:/trickCenter?username=" + username + "&performedTrick=" + performedTrick;
  }

  @GetMapping(value = "/actionHistory")
  public String getActionHistoryView(@RequestParam String username, Model model) {
    model.addAttribute("actions",
        actionService.getActionHistoryAsListOfStrings(foxService.getSelectedFoxByName(
            userService.findUserByName(username).getFox().getName())));
    model.addAttribute("selectedFox", foxService.getSelectedFoxByName(
        userService.findUserByName(username).getFox().getName()));
    return "actionHistory";
  }
}
