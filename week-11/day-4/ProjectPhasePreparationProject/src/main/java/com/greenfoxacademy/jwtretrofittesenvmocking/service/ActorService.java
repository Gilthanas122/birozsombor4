package com.greenfoxacademy.jwtretrofittesenvmocking.service;

import com.greenfoxacademy.jwtretrofittesenvmocking.model.dao.Actor;
import com.greenfoxacademy.jwtretrofittesenvmocking.model.call.ActorDTO;

public interface ActorService {

  void fetchActorById(Long id);

  boolean isActorStoredAlready(Long id);

  Actor getActorById(Long id);

  void saveActor(Actor actor);

  Actor convertActorDTOToActor(ActorDTO actorDTO);
}
