package com.greenfoxacademy.restoptionals.service;

import com.greenfoxacademy.restoptionals.model.Cargo;
import com.greenfoxacademy.restoptionals.model.FillResponse;

public interface RoraService {

  Cargo getActualCargoStatus();

  boolean checkIsInvalidCaliber(String caliber);

  void addNewCargoStatus(String caliber, Long amount);

  FillResponse createAndGetFillResponse(String caliber, Long amount);
}
