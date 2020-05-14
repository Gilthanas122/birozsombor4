package com.greenfoxacademy.petshelter;

import com.greenfoxacademy.petshelter.model.Human;
import com.greenfoxacademy.petshelter.repository.HumanRepository;
import com.greenfoxacademy.petshelter.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PetShelterApplication implements CommandLineRunner {

  private HumanRepository humanRepository;
  private PetRepository petRepository;

  @Autowired
  public PetShelterApplication(HumanRepository humanRepository, PetRepository petRepository) {
    this.humanRepository = humanRepository;
    this.petRepository = petRepository;
  }

  public static void main(String[] args) {
    SpringApplication.run(PetShelterApplication.class, args);
  }


  @Override
  public void run(String... args) throws Exception {
    humanRepository.save(new Human("Zsombor", 22));
    humanRepository.save(new Human("Bill", 33));
    humanRepository.save(new Human("John", 44));
  }
}
