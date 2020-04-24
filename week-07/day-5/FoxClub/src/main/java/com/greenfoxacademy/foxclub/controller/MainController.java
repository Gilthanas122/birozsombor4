package com.greenfoxacademy.foxclub.controller;

import com.greenfoxacademy.foxclub.model.Fox;
import com.greenfoxacademy.foxclub.service.ActionService;
import com.greenfoxacademy.foxclub.service.FoxService;
import com.greenfoxacademy.foxclub.service.NutritionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

  private ActionService actionService;
  private FoxService foxService;

  @Autowired
  public MainController(FoxService foxService, ActionService actionService) {
    this.foxService = foxService;
    this.actionService = actionService;
  }

  @GetMapping(value = "/")
  public String getIndex(@RequestParam(required = false) String name, Model model) {
    model.addAttribute("foxes", foxService.getListOfFoxes());
    model.addAttribute("selectedFox", foxService.getSelectedFoxByName(name));
    if (name != null) {
      model.addAttribute("actions",
          actionService.getActionHistoryAsListOfStringsWithNewActionOnTop(foxService.getSelectedFoxByName(name)));
    }
    return "index";
  }

  @GetMapping(value = "/login")
  public String getLoginView() {
    return "login";
  }

  @PostMapping(value = "/login")
  public String getNameFromLogin(String name, String option, Model model) {
    if (name.isEmpty()) {
      return "redirect:/";
    }
    if (foxService.checkIsItExist(name)) {
      switch (option) {
        case "go":
          return "redirect:/?name=" + name;
        case "create":
          model.addAttribute("alreadyExist", true);
          return "login";
      }
    } else {
      switch (option) {
        case "go":
          model.addAttribute("alreadyExist", false);
          return "login";
        case "create":
          foxService.createNewFoxWithNameAndAddToTheList(name);
          return "redirect:/?name=" + name;
      }
    }
    return null;
  }
}
