package com.greenfoxacademy.foxclub;

import com.greenfoxacademy.foxclub.model.Drink;
import com.greenfoxacademy.foxclub.model.Food;
import com.greenfoxacademy.foxclub.repository.DrinkRepository;
import com.greenfoxacademy.foxclub.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FoxClubApplication implements CommandLineRunner {

  private FoodRepository foodRepository;
  private DrinkRepository drinkRepository;
  //private TrickRepository trickRepository;

  @Autowired
  public FoxClubApplication(FoodRepository foodRepository, DrinkRepository drinkRepository
                            //TrickRepository trickRepository
  ) {
    this.foodRepository = foodRepository;
    this.drinkRepository = drinkRepository;
    //this.trickRepository = trickRepository;
  }

  public static void main(String[] args) {
    SpringApplication.run(FoxClubApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    //initAllFood
    foodRepository.save(new Food("hotdog"));
    foodRepository.save(new Food("pizza"));
    foodRepository.save(new Food("hamburger"));
    foodRepository.save(new Food("spaghetti"));
    foodRepository.save(new Food("salad"));
    foodRepository.save(new Food("bread"));
    foodRepository.save(new Food("another fox"));
    foodRepository.save(new Food("tás"));
    //initAllDrink
    drinkRepository.save(new Drink("wein"));
    drinkRepository.save(new Drink("coke"));
    drinkRepository.save(new Drink("water"));
    drinkRepository.save(new Drink("beer"));
    //initAllTricks
    /*trickRepository.save(new Trick("write html", "html.png", "html-logo"));
    trickRepository.save(new Trick("code in JAVA", "java.png", "java-logo"));
    trickRepository.save(new Trick("do some magic with streams", "stream.jpg", "stream"));
    trickRepository.save(new Trick("be able to read Thymeleaf documentations", "thymeleaf.png",
    "thymeleaf-logo"));*/

  }
}
