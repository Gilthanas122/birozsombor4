package farm;

import animal.Animal;
import java.util.ArrayList;
import java.util.List;

public class Farm {
  List<Animal> listOfAnimal;
  int numberOfFreePlaces;
  public Farm(){
    listOfAnimal = new ArrayList<>();
    this.numberOfFreePlaces = 10;
  }
  public void breed(){
    if (listOfAnimal.size() <= numberOfFreePlaces){
      listOfAnimal.add(new Animal());
    }
  }
  public void slaughter(){
    Animal theLeastHungry = new Animal();
    for (Animal animal : this.listOfAnimal) {
      if (animal.hunger>=theLeastHungry.hunger){
        theLeastHungry = animal;
      }
    }
    for (Animal animal : this.listOfAnimal) {
      if (animal.hunger<theLeastHungry.hunger){
        theLeastHungry = animal;
      }
    }
    listOfAnimal.remove(listOfAnimal.indexOf(theLeastHungry));
  }

}
