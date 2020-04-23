package com.greenfoxacademy.dependencyinjection.coloringaround.service;

import com.greenfoxacademy.dependencyinjection.hellodiproject.service.Printer;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class BlueColor implements MyColor {

  @Override
  public void printColor(Printer printer) {
    printer.log("printColor BLUE through Printer service");
  }
}
