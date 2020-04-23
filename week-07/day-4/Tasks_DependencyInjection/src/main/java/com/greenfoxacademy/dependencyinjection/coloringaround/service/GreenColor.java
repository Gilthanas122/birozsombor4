package com.greenfoxacademy.dependencyinjection.coloringaround.service;

import com.greenfoxacademy.dependencyinjection.hellodiproject.service.Printer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("greenColor")
public class GreenColor implements MyColor {

  @Override
  public void printColor(Printer printer) {
    printer.log("printColor GREEN through Printer service");
  }
}
