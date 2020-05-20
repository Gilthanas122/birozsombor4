package com.greenfoxacademy.petshelter.service;

import com.greenfoxacademy.petshelter.model.Pet;
import java.util.List;

public interface PetService {
  List<Pet> getAllPet();

  void savePet(Pet pet, Long humanId);

  boolean isPetNameExist(String name);

  void deletePetById(Long id);

  Pet getPetById(Long id);
}
