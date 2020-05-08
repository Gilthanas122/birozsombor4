package com.greenfoxacademy.restoptionals.service;

import com.greenfoxacademy.restoptionals.model.Cargo;
import com.greenfoxacademy.restoptionals.model.FillResponse;
import com.greenfoxacademy.restoptionals.repository.CargoRepository;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoraServiceImpl implements RoraService {

  private CargoRepository cargoRepository;

  @Autowired
  public RoraServiceImpl(CargoRepository cargoRepository) {
    this.cargoRepository = cargoRepository;
  }

  public Cargo getActualCargoStatus() {
    Cargo cargo = cargoRepository.findTopByOrderByIdDesc().get();
    return new Cargo(cargo.getAmmoCaliber25(), cargo.getAmmoCaliber30(), cargo.getAmmoCaliber50());
  }

  @Override
  public boolean checkIsInvalidCaliber(String caliber) {
    List<String> calibers = Arrays.asList(".25", ".30", ".50");
    if (calibers.contains(caliber)) {
      return false;
    } else {
      return true;
    }
  }

  @Override
  public Cargo addNewCargoStatus(String caliber, Long amount) {
    Cargo cargo = cargoRepository.findTopByOrderByIdDesc().get();
    Cargo updatedCargo = new Cargo(cargo.getAmmoCaliber25(), cargo.getAmmoCaliber30(), cargo.getAmmoCaliber50());
    switch (caliber) {
      case ".25":
        updatedCargo.setAmmoCaliber25(updatedCargo.getAmmoCaliber25() + amount);
        break;
      case ".30":
        updatedCargo.setAmmoCaliber30(updatedCargo.getAmmoCaliber30() + amount);
        break;
      case ".50":
        updatedCargo.setAmmoCaliber50(updatedCargo.getAmmoCaliber50() + amount);
        break;
    }
    updatedCargo.updateShipstatus();
    cargoRepository.save(updatedCargo);
    return updatedCargo;
  }

  @Override
  public FillResponse createAndGetFillResponse(String caliber, Long amount) {
    Cargo cargo = cargoRepository.findTopByOrderByIdDesc().get();
    return new FillResponse(caliber, amount, cargo.getShipStatus(), cargo.getReady());
  }
}
