package com.greenfoxacademy.dependencyinjection.usefulutilities.controller;

import com.greenfoxacademy.dependencyinjection.usefulutilities.service.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsefulUtilController {

  private UtilityService utilityService;

  @Autowired
  public UsefulUtilController(UtilityService utilityService) {
    this.utilityService = utilityService;
  }

  @GetMapping("/useful")
  public String getMainPage() {
    return "useful";
  }

  @GetMapping("/useful/colored")
  public String getColoredBackground(Model model) {
    model.addAttribute("randomColor", utilityService.randomColor());
    return "colored";
  }

  @GetMapping("/useful/email")
  public String getEmail(Model model, @RequestParam String email) {
    model.addAttribute("emailAddress", email);
    model.addAttribute("validationResult", utilityService.validateEmail(email));
    return "email";
  }

  @GetMapping("/useful/caesar")
  public String getEmail(Model model, @RequestParam (required = false) String text,
                         @RequestParam (required = false) Integer number) {
    model.addAttribute("text", utilityService.caesar(text, number));
    return "caesar";
  }
}
