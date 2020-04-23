package com.greenfoxacademy.dependencyinjection.coloringaround.service;

import com.greenfoxacademy.dependencyinjection.hellodiproject.service.Printer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("redColor")
public class RedColor implements MyColor {

  @Override
  public void printColor(Printer printer) {
    printer.log("printColor RED through Printer service");
  }
}
