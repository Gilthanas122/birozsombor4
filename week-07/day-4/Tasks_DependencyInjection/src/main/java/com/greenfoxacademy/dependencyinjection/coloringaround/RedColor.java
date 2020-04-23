package com.greenfoxacademy.dependencyinjection.coloringaround;

import com.greenfoxacademy.dependencyinjection.hellodiproject.Printer;
import org.springframework.beans.factory.annotation.Autowired;
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
