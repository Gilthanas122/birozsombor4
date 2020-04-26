package com.greenfoxacademy.dependencyinjection.coloringaround.service;

import com.greenfoxacademy.dependencyinjection.hellodiproject.service.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("greenColor")
public class GreenColor implements MyColor {

  private Printer printer;

  @Autowired
  public GreenColor(Printer printer) {
    this.printer = printer;
  }

  @Override
  public void printColor() {
    printer.log("printColor GREEN through Printer service");
  }
}
