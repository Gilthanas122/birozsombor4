package com.greenfoxacademy.jwtretrofittesenvmocking.service;

import com.greenfoxacademy.jwtretrofittesenvmocking.model.dao.ActorDAO;
import com.greenfoxacademy.jwtretrofittesenvmocking.model.dto.ActorDTO;

public interface ActorService {

  void fetchActorById(Long id);

  boolean isActorStoredAlready(Long id);

  ActorDAO getActorById(Long id);

  void saveActor(ActorDAO actorDao);

  ActorDTO convertActorDAOtoDTO(ActorDAO actorDAO);

  ActorDTO convertActorDTOToDAO(ActorDAO actorDAO);
}
