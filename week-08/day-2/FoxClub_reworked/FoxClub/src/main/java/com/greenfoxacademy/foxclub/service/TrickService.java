/*package com.greenfoxacademy.foxclub.service;

import com.greenfoxacademy.foxclub.model.Trick;
import com.greenfoxacademy.foxclub.repository.TrickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TrickService {

  private TrickRepository trickRepository;

  @Autowired
  public TrickService(TrickRepository trickRepository) {
    this.trickRepository = trickRepository;
  }

  public Iterable<Trick> getTrickList() {
    return trickRepository.findAll();
  }

  /*public List<Trick> getUnlearnedListOfTricks(Fox selectedFox) {
    return this.trickList.stream()
        .filter(x -> !selectedFox.getListOfTricks().contains(x))
        .collect(Collectors.toList());
  }

  public List<Trick> getLearnedListOfTricks(Fox selectedFox) {
    return this.trickList.stream()
        .filter(x -> selectedFox.getListOfTricks().contains(x))
        .collect(Collectors.toList());
  }

  public Trick getSelectedTrickByName(String name) {
    return trickRepository.findByNameContainingIgnoreCase(name);
  }
}
*/
