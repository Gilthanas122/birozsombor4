package com.greenfoxacademy.foxclub.service;

import com.greenfoxacademy.foxclub.model.Fox;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoxService {

  private List<Fox> listOfFoxes;
  private NutritionService nutritionService;

  @Autowired
  public FoxService(NutritionService nutritionService) {
    this.nutritionService = nutritionService;
    this.listOfFoxes = initAllFoxes();
  }

  private List<Fox> initAllFoxes() {
    return Arrays.asList(new Fox("Karak",
            nutritionService.getSelectedFood("hotdog"),
            nutritionService.getSelectedDrink("coke")),
        new Fox("Vuk",
            nutritionService.getSelectedFood("pizza"),
            nutritionService.getSelectedDrink("water")),
        new Fox("Kag",
            nutritionService.getSelectedFood("bread"),
            nutritionService.getSelectedDrink("beer")),
        new Fox("Mr. Green",
            nutritionService.getSelectedFood("salad"),
            nutritionService.getSelectedDrink("water"))
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
    listOfFoxes.add(new Fox(name,
        nutritionService.getSelectedFood("bread"),
        nutritionService.getSelectedDrink("water")));
  }

  public Fox getSelectedFoxByName(String name) {
    Fox fox = null;
    for (Fox f : listOfFoxes) {
      if (f.getName().equals(name)) {
        fox = f;
        break;
      }
    }
    return fox;
  }
}
