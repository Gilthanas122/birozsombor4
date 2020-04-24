package com.greenfoxacademy.foxclub.service;

import com.greenfoxacademy.foxclub.model.Action;
import com.greenfoxacademy.foxclub.model.Fox;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ActionService {

  public List<String> getActionHistoryAsListOfStrings(Fox selectedFox) {
    SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    return selectedFox.getActionHistory().entrySet().stream()
        .map((entry) -> df.format(entry.getKey()) + " : " + entry.getValue().getDescription())
        .collect(Collectors.toList());
  }

  public List<String> getActionHistoryAsListOfStringsWithNewActionOnTop(Fox selectedFox) {
    SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    List<String> list = selectedFox.getActionHistory().entrySet().stream()
        .map((entry) -> df.format(entry.getKey()) + " : " + entry.getValue().getDescription())
        .collect(Collectors.toList());
    Collections.sort(list, Collections.reverseOrder());
    return list;
  }

  public void addNewActionChangeFood(Fox selectedFoxByName, String selectedFood) {
    if (selectedFoxByName.getFood().getName().equals(selectedFood)) {
      return;
    } else {
      selectedFoxByName.getActionHistory().put(new Date(),
          new Action("Food has been changed " +
              "from: " + selectedFoxByName.getFood().getName() + " to: " + selectedFood));
    }
  }

  public void addNewActionChangeDrink(Fox selectedFoxByName, String selectedDrink) {
    if (selectedFoxByName.getDrink().getName().equals(selectedDrink)) {
      return;
    } else {
      selectedFoxByName.getActionHistory().put(new Date(),
          new Action("Drink has been changed from: "
              + selectedFoxByName.getDrink().getName() + " to: " + selectedDrink));
    }
  }

  public void addNewActionLearnTrick(Fox selectedFoxByName, String selectedTrick) {
    selectedFoxByName.getActionHistory().put(new Date(),
        new Action("Learned to: " + selectedTrick));
  }
}
