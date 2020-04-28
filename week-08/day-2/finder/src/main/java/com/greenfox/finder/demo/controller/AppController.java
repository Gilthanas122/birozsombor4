package com.greenfox.finder.demo.controller;

import com.greenfox.finder.demo.service.UserService;
import com.greenfox.finder.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by aze on 25/10/17.
 */
@Controller
public class AppController {


  private UserService service;

  @Autowired
  public AppController(UserService userService) {
    this.service = userService;
  }

  @GetMapping("/app")
  public String index(Model model) {
    model.addAttribute("new_user", new User());
    model.addAttribute("users", service.getAll());
    return "main";
  }

  @PostMapping("/app")
  public String create(@ModelAttribute User user) {
    service.save(user);
    return "redirect:/app";
  }
}