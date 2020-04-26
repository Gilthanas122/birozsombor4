package com.greenfoxacademy.dependencyinjection;

import com.greenfoxacademy.dependencyinjection.coloringaround.service.MyColor;
import com.greenfoxacademy.dependencyinjection.hellodiproject.service.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DependencyInjectionApplication implements CommandLineRunner {

  Printer printer;
  MyColor myColor;

  @Autowired
  public DependencyInjectionApplication(Printer printer, MyColor myColor) {
    this.printer = printer;
    this.myColor = myColor;

  }

  public static void main(String[] args) {
    SpringApplication.run(DependencyInjectionApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    printer.log("hello");
    myColor.printColor();
  }
}
