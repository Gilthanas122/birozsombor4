package com.greenfoxacademy.petshelter.service;

import com.greenfoxacademy.petshelter.dto.HumanDTO;
import com.greenfoxacademy.petshelter.model.Human;
import java.util.List;

public interface HumanService {
  List<Human> getAllHuman();

  void saveHuman(Human human);

  void deleteHumanById(Long id);

  Human getHumanById(Long id);

  boolean isHumanExist(Long id);

  boolean isHumanNameExist(String name);

  void updateHuman(HumanDTO humanDTO, Long humanId);
}
