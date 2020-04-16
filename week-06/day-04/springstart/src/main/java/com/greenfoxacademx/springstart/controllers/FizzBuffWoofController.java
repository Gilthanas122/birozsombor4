package com.greenfoxacademx.springstart.controllers;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FizzBuffWoofController {

  AtomicLong counter = new AtomicLong(1);

  @RequestMapping(value = ("/web/fizzbuzzwoof"))
  public String countWithFizzBuzzWoof(Model model) {
    long holder = counter.getAndIncrement();
    String number = "";
    String fontSize = "16";
    if (holder % 3 == 0) {
      number += "Fizz";
    }
    if (holder % 5 == 0) {
      number += "Buzz";
    }
    if (holder % 7 == 0) {
      number += "Woof";
    }
    if (!number.isEmpty()) {
      switch (number.length()) {
        case 4:
          fontSize = "24";
          break;
        case 8:
          fontSize = "48";
          break;
        case 12:
          fontSize = "72";
          break;
      }
    } else {
      number = Long.toString(holder);
    }
    model.addAttribute("number", number);
    model.addAttribute("fontSize", fontSize);
    return "fizzbuzzwoofpage";
  }
}
