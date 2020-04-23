package com.greenfoxacademy.dependencyinjection.coloringaround;

import com.greenfoxacademy.dependencyinjection.hellodiproject.Printer;
import org.springframework.beans.factory.annotation.Autowired;
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
