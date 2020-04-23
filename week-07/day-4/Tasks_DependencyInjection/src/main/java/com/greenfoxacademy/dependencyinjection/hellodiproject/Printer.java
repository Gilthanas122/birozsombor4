package com.greenfoxacademy.dependencyinjection.hellodiproject;

// # HelloBeanWorld application

// Create a Spring project.

import com.greenfoxacademy.dependencyinjection.coloringaround.MyColor;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

// Use the Printer class as a base to let Spring create a dependency from it.
@Service
public class Printer {

  public void log(String message) {
    System.out.println(LocalDateTime.now() + " MY PRINTER SAYS --- " + message);
  }
}

// - Implement the `CommandLineRunner` interface on your application
// - Autowire the `Printer` to your application
// - Use the `log` method

// The output should be similar to the following:
// ```
// SOME SPRING INFO
// 2018-01-09T16:17:25.323 MY PRINTER SAYS --- hello
// SOME SPRING INFO
// ```