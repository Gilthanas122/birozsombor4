package com.greenfoxacademy.foxclub.service;

import com.greenfoxacademy.foxclub.model.Fox;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class FoxService {

  private List<Fox> listOfFoxes = new ArrayList<>();

  public FoxService() {
    this.listOfFoxes = initAllFoxes();
  }

  private List<Fox> initAllFoxes() {
    return Arrays.asList(new Fox("Karak", "tás", "water"),
        new Fox("Vuk", "unka", "coke"),
        new Fox("Kag", "liba", "wein"),
        new Fox("Mr. Green", "salad", "water")
    );
  }

  public List<Fox> getListOfFoxes() {
    return listOfFoxes;
  }

  public boolean checkIsItExist(String name) {
    return listOfFoxes.stream()
        .map(fox -> fox.getName().toLowerCase())
        .collect(Collectors.toList())
        .contains(name.toLowerCase());
  }

  public void createNewFoxWithNameAndAddToTheList(String name) {
    listOfFoxes.add(new Fox(name, "default", "default"));
  }

  public Fox getSelectedFoxByName(String name) {
    for (Fox f : listOfFoxes) {
      if (f.getName().equals(name)) {
        return f;
      }
    }
    return null;
  }
}
