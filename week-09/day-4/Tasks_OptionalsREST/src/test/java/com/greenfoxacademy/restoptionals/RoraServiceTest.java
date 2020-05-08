package com.greenfoxacademy.restoptionals;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.greenfoxacademy.restoptionals.model.Cargo;
import com.greenfoxacademy.restoptionals.model.FillResponse;
import com.greenfoxacademy.restoptionals.repository.CargoRepository;
import com.greenfoxacademy.restoptionals.service.RoraService;
import com.greenfoxacademy.restoptionals.service.RoraServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.graalvm.compiler.nodes.calc.IntegerDivRemNode;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class RoraServiceTest {

  private RoraService roraService;
  private CargoRepository cargoRepository;

  @BeforeEach
  public void before() {
    cargoRepository = Mockito.mock(CargoRepository.class);
    roraService = new RoraServiceImpl(cargoRepository);
  }

  @Test
  public void getActualCargoStatusReturnsValidDefaultCargo() {
    //Arrange
    Cargo fakeCargo = new Cargo();

    Mockito.when(cargoRepository.findTopByOrderByIdDesc()).thenReturn(Optional.of(fakeCargo));

    //Act
    Cargo cargo = roraService.getActualCargoStatus();

    //Assert
    Assert.assertEquals(Long.valueOf(0), cargo.getAmmoCaliber25());
    Assert.assertEquals(Long.valueOf(0), cargo.getAmmoCaliber30());
    Assert.assertEquals(Long.valueOf(0), cargo.getAmmoCaliber50());
    Assert.assertEquals("empty", cargo.getShipStatus());
    Assert.assertFalse(cargo.getReady());
  }

  @Test
  public void createAndGetFillResponse() {
    //Assert
    Cargo fakeCargo = new Cargo();
    Mockito.when(cargoRepository.findTopByOrderByIdDesc()).thenReturn(Optional.of(fakeCargo));

    //Act
    FillResponse fillResponse = roraService.createAndGetFillResponse(".50", Long.valueOf(5000));

    //Assert
    Assert.assertEquals(".50", fillResponse.getReceived());
    Assert.assertEquals(Long.valueOf(5000), fillResponse.getAmount());
  }

  @Test
  public void checkIsInvalidCaliberWithInvalidParameterReturnsFalse() {
    //Arrange
    //Act
    boolean result = roraService.checkIsInvalidCaliber("apmawdáqmw");

    //Assert
    Assert.assertEquals(true, result);
  }

  @Test
  public void checkIsInvalidCaliberWithValidParameterReturnsTrue() {
    //Arrange
    //Act
    boolean result = roraService.checkIsInvalidCaliber(".50");

    //Assert
    Assert.assertEquals(false, result);
  }

  @Test
  public void addNewCargoStatus() {
    List<Cargo> cargoList = new ArrayList<>();
    Cargo fakeCargo = new Cargo(Long.valueOf(0), Long.valueOf(0), Long.valueOf(100));

    Mockito.when(cargoRepository.findTopByOrderByIdDesc()).thenReturn(Optional.of(fakeCargo));

    //Act
    Cargo updatedCargo = roraService.addNewCargoStatus(".50", Long.valueOf(100));

    //Assert
    Assert.assertEquals(Long.valueOf(200), updatedCargo.getAmmoCaliber50());
  }
}
