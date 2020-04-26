package com.greenfoxacademy.dependencyinjection.coloringaround.service;

import com.greenfoxacademy.dependencyinjection.hellodiproject.service.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class BlueColor implements MyColor {

  private Printer printer;

  @Autowired
  public BlueColor(Printer printer) {
    this.printer = printer;
  }

  @Override
  public void printColor() {
    printer.log("printColor BLUE through Printer service");
  }
}
