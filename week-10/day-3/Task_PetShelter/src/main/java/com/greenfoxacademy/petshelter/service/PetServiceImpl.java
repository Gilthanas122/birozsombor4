package com.greenfoxacademy.petshelter.service;

import com.greenfoxacademy.petshelter.model.Human;
import com.greenfoxacademy.petshelter.model.Pet;
import com.greenfoxacademy.petshelter.repository.PetRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetServiceImpl implements PetService {

  private PetRepository petRepository;
  private HumanService humanService;

  @Autowired
  public PetServiceImpl(PetRepository petRepository, HumanService humanService) {
    this.petRepository = petRepository;
    this.humanService = humanService;
  }

  @Override
  public List<Pet> getAllPet() {
    return petRepository.findAll();
  }

  @Override
  public void savePetToHuman(Pet pet, Long humanId) {
    Human human = humanService.getHumanById(humanId);
    pet.setHuman(human);
    petRepository.save(pet);
  }

  @Override
  public boolean isPetNameExist(String name) {
    return petRepository.getPetByName(name).isPresent();
  }

  @Override
  public void deletePetById(Long id) {
    petRepository.deleteById(id);
  }

  @Override
  public Pet getPetById(Long id) {
    return petRepository.findById(id).orElse(null);
  }
}
