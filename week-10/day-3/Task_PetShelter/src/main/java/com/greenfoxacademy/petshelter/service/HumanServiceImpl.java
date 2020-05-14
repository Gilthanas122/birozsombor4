package com.greenfoxacademy.petshelter.service;

import com.greenfoxacademy.petshelter.dto.HumanDTO;
import com.greenfoxacademy.petshelter.model.Human;
import com.greenfoxacademy.petshelter.repository.HumanRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HumanServiceImpl implements HumanService {

  private HumanRepository humanRepository;

  @Autowired
  public HumanServiceImpl(HumanRepository humanRepository) {
    this.humanRepository = humanRepository;
  }

  @Override
  public List<Human> getAllHuman() {
    return humanRepository.findAll();
  }

  @Override
  public void saveHuman(Human human) {
    humanRepository.save(human);
  }

  @Override
  public void deleteHumanById(Long id) {
    humanRepository.deleteById(id);
  }

  @Override
  public Human getHumanById(Long id) {
    return humanRepository.findById(id).orElse(null);
  }

  @Override
  public boolean isHumanExist(Long id) {
    return humanRepository.findById(id).isPresent();
  }

  @Override
  public boolean isHumanNameExist(String name) {
    return humanRepository.getHumanByName(name).isPresent();
  }

  @Override
  public void updateHuman(HumanDTO humanDTO, Long humanId) {
    Optional<Human> human = humanRepository.findById(humanId);
    if (human.isPresent()) {
      Human foundHuman = human.get();
      foundHuman.setAge(humanDTO.getAge());
      foundHuman.setName(humanDTO.getName());
      saveHuman(foundHuman);
    }
  }

  @Override
  public boolean isHumansExistAboveAge(Integer ageLimit) {
    return humanRepository.getHumansAboveAge(ageLimit).size() > 0;
  }

  @Override
  public List<String> getListOfPetNamesFromOwnersAboveAge(Integer ageLimit) {
    List<Human> humans = humanRepository.getHumansAboveAge(ageLimit);
    return humans.stream()
        .flatMap(human -> human.getPetList().stream())
        .map(pet -> pet.getName())
        .collect(Collectors.toList());
  }
}
