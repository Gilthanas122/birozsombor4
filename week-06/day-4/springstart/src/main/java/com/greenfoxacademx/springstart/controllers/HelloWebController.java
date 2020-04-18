package com.greenfoxacademx.springstart.controllers;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWebController {

  AtomicLong counter = new AtomicLong(1);

  @RequestMapping("/web/greeting")
  public String greeting(Model model, @RequestParam String name) {
    model.addAttribute("name", name);
    model.addAttribute("counter", counter.getAndIncrement());
    return "greeting";
  }
}
