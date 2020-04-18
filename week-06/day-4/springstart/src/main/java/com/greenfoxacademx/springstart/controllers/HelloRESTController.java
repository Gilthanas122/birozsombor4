package com.greenfoxacademx.springstart.controllers;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloRESTController {

  AtomicLong counter = new AtomicLong(1);

  @RequestMapping(value = ("/greeting"))
  @ResponseBody
  public Greeting greeting(@RequestParam String name) {
    return new Greeting(counter.getAndIncrement(), "Hello, " + name + "!");
  }
}
