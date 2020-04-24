package com.greenfoxacademy.foxclub.service;

import com.greenfoxacademy.foxclub.model.Fox;
import com.greenfoxacademy.foxclub.model.Trick;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class TrickService {

  List<Trick> trickList;

  public TrickService() {
    this.trickList = initAllTricks();
  }

  private List<Trick> initAllTricks() {
    return Arrays.asList(new Trick("write html"),
        new Trick("code in JAVA"),
        new Trick("do some magic with streams"),
        new Trick("be able to read Thymeleaf documentations"));
  }

  public List<Trick> getTrickList() {
    return trickList;
  }

  public List<Trick> getUnlearnedListOfTricks(Fox selectedFox) {
    return this.trickList.stream()
        .filter(x -> !selectedFox.getListOfTricks().contains(x))
        .collect(Collectors.toList());
  }

  public Trick getSelectedTrick(String name) {
    for (Trick t : trickList) {
      if (t.getName().toLowerCase().equals(name.toLowerCase())) {
        return t;
      }
    }
    return null;
  }
}
