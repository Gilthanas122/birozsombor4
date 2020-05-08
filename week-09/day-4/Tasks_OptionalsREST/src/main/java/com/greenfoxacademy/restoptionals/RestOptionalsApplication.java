package com.greenfoxacademy.restoptionals;

import com.greenfoxacademy.restoptionals.model.Cargo;
import com.greenfoxacademy.restoptionals.model.Food;
import com.greenfoxacademy.restoptionals.repository.CargoRepository;
import com.greenfoxacademy.restoptionals.repository.DraxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestOptionalsApplication implements CommandLineRunner {

  private CargoRepository cargoRepository;
  private DraxRepository draxRepository;

  @Autowired
  public RestOptionalsApplication(CargoRepository cargoRepository, DraxRepository draxRepository) {
    this.cargoRepository = cargoRepository;
    this.draxRepository = draxRepository;
  }

  public static void main(String[] args) {
    SpringApplication.run(RestOptionalsApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    cargoRepository.save(new Cargo());
    draxRepository.save(new Food("TestFood", 666, 666));
  }
}
