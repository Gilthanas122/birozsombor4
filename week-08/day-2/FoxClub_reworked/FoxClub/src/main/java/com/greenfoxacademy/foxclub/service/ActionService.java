package com.greenfoxacademy.foxclub.service;

import com.greenfoxacademy.foxclub.model.Action;
import com.greenfoxacademy.foxclub.model.Fox;
import com.greenfoxacademy.foxclub.repository.ActionRepository;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActionService {

  private FoxService foxService;
  private NutritionService nutritionService;
  private ActionRepository actionRepository;

  @Autowired
  public ActionService(FoxService foxService, NutritionService nutritionService, ActionRepository actionRepository) {
    this.foxService = foxService;
    this.nutritionService = nutritionService;
    this.actionRepository = actionRepository;
  }

  public List<String> getActionHistoryAsListOfStrings(Fox selectedFox) {
    SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    return selectedFox.getActionHistory().stream()
        .map(action -> df.format(action.getDate()) + " : " + action.getDescription())
        .collect(Collectors.toList());
  }

  public List<String> getActionHistoryAsListOfStringsWithNewActionOnTop(Fox selectedFox) {
    SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    List<String> list = selectedFox.getActionHistory().stream()
        .map(action -> df.format(action.getDate()) + " : " + action.getDescription())
        .collect(Collectors.toList());
    Collections.sort(list, Collections.reverseOrder());
    return list;
  }

  public void addNewActionChangeFood(Fox selectedFoxByName, String selectedFood) {
    if (selectedFoxByName.getFood().getName().equals(selectedFood)) {
      return;
    } else {
      Action newAction = new Action("Food has been changed " +
          "from: " + selectedFoxByName.getFood().getName() + " to: " + selectedFood);
      newAction.setFox(selectedFoxByName);
      actionRepository.save(newAction);

      List<Action> selectedFoxActionHistory = selectedFoxByName.getActionHistory();
      selectedFoxActionHistory.add(newAction);
      selectedFoxByName.setActionHistory(selectedFoxActionHistory);
      foxService.updateFoxInDatabase(selectedFoxByName);
    }
  }

  public void addNewActionChangeDrink(Fox selectedFoxByName, String selectedDrink) {
    if (selectedFoxByName.getDrink().getName().equals(selectedDrink)) {
      return;
    } else {
      Action newAction = new Action("Drink has been changed from: "
          + selectedFoxByName.getDrink().getName() + " to: " + selectedDrink);
      newAction.setFox(selectedFoxByName);
      actionRepository.save(newAction);

      List<Action> selectedFoxActionHistory = selectedFoxByName.getActionHistory();
      selectedFoxActionHistory.add(newAction);
      selectedFoxByName.setActionHistory(selectedFoxActionHistory);
      foxService.updateFoxInDatabase(selectedFoxByName);
    }
  }

  /*public void addNewActionLearnTrick(Fox selectedFoxByName, String selectedTrick) {
    selectedFoxByName.getActionHistory().put(new Date(),
        new Action("Learned to: " + selectedTrick));
  }*/
}
