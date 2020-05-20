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
  private ActionRepository actionRepository;

  @Autowired
  public ActionService(FoxService foxService, ActionRepository actionRepository) {
    this.foxService = foxService;
    this.actionRepository = actionRepository;
  }

  public List<String> getActionHistoryAsListOfStrings(Long foxId) {
    Fox selectedFox = foxService.getFoxById(foxId);
    SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    return selectedFox.getActionHistory().stream()
        .map(action -> df.format(action.getDate()) + " : " + action.getDescription())
        .collect(Collectors.toList());
  }

  public List<String> getActionHistoryAsListOfStringsWithNewActionOnTop(Long foxId) {
    Fox selectedFox = foxService.getFoxById(foxId);
    SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    List<String> list = selectedFox.getActionHistory().stream()
        .map(action -> df.format(action.getDate()) + " : " + action.getDescription())
        .collect(Collectors.toList());
    Collections.sort(list, Collections.reverseOrder());
    return list;
  }

  public void addNewActionChangeFood(Long foxId, String selectedFood) {
    Fox selectedFox = foxService.getFoxById(foxId);
    if (selectedFox.getFood().getName().equals(selectedFood)) {
      return;
    } else {
      Action newAction = new Action("Food has been changed " +
          "from: " + selectedFox.getFood().getName() + " to: " + selectedFood);
      newAction.setFox(selectedFox);
      actionRepository.save(newAction);
    }
  }

  public void addNewActionChangeDrink(Long foxId, String selectedDrink) {
    Fox selectedFox = foxService.getFoxById(foxId);
    if (selectedFox.getDrink().getName().equals(selectedDrink)) {
      return;
    } else {
      Action newAction = new Action("Drink has been changed from: "
          + selectedFox.getDrink().getName() + " to: " + selectedDrink);
      newAction.setFox(selectedFox);
      actionRepository.save(newAction);
    }
  }

  public void addNewActionLearnTrick(Long foxId, String selectedTrick) {
    Fox selectedFox = foxService.getFoxById(foxId);
    if (selectedFox.getTricks().stream()
        .map(trick -> trick.getName())
        .filter(trick -> trick.equals(selectedTrick))
        .collect(Collectors.toList())
        .size() > 0) {
      return;
    } else {
      Action newAction = new Action("Learned to: " + selectedTrick);
      newAction.setFox(selectedFox);
      actionRepository.save(newAction);
    }
  }
}
