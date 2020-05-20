package com.greenfoxacademy.foxclub.service;

import com.greenfoxacademy.foxclub.model.Fox;
import com.greenfoxacademy.foxclub.model.Trick;
import com.greenfoxacademy.foxclub.repository.FoxRepository;
import com.greenfoxacademy.foxclub.repository.TrickRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TrickService {

  private TrickRepository trickRepository;
  private FoxRepository foxRepository;


  @Autowired
  public TrickService(TrickRepository trickRepository, FoxRepository foxRepository) {
    this.trickRepository = trickRepository;
    this.foxRepository = foxRepository;
  }

  public List<Trick> getUnlearnedListOfTricks(Long foxId) {
    Fox selectedFox = foxRepository.findById(foxId).get();
    return trickRepository.findAll().stream()
        .filter(x -> !selectedFox.getTricks().contains(x))
        .collect(Collectors.toList());
  }

  public List<Trick> getLearnedListOfTricks(Long foxId) {
    Fox selectedFox = foxRepository.findById(foxId).get();
    return trickRepository.findAll().stream()
        .filter(x -> selectedFox.getTricks().contains(x))
        .collect(Collectors.toList());
  }

  public Trick getTrickByName(String name) {
    return trickRepository.findByNameContainingIgnoreCase(name);
  }
}

