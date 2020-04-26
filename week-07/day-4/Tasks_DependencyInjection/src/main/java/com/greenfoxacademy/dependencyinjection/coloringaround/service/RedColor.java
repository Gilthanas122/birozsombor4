package com.greenfoxacademy.dependencyinjection.coloringaround.service;

import com.greenfoxacademy.dependencyinjection.hellodiproject.service.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("redColor")
public class RedColor implements MyColor {

  private Printer printer;

  @Autowired
  public RedColor(Printer printer) {
    this.printer = printer;
  }

  @Override
  public void printColor() {
    printer.log("printColor RED through Printer service");
  }
}
