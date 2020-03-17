package pirates;

import java.util.ArrayList;
import java.util.List;

public class Ship {
  List<Pirate> crew;
  Pirate captain;
  boolean captainsConsumedRum;
  Pirate.States captainsState;
  int crewSize;

  public Ship() {
    crew = new ArrayList<>();
  }

  public void fillShip() {
    this.captain = new Pirate(true);
    this.captainsState = captain.state;
    int numberOfPirates = (int) (Math.random() * 100);
    for (int i = 0; i < numberOfPirates; i++) {
      crew.add(new Pirate());
    }
  }

  public void updateCrewSize() {
    for (int i = 0; i < crew.size(); i++) {
      if (crew.get(i).state == Pirate.States.DEAD) {
        crew.remove(i);
      }
    }
    this.crewSize = this.crew.size();
  }

  public void getInfoAboutCaptain() {
    System.out.println("The captain drank " + this.captain.rumOMeter + "times.");
    if (this.captain.rumOMeter > 0) {
      this.captainsConsumedRum = true;
      System.out.println("So the consumed rum. " + "(" + captainsConsumedRum + ")");
    }
    System.out.println("The captain is now: " + this.captain.state.toString());
  }

  public void getInfo() {
    System.out.println("Infos about the captain: ");
    getInfoAboutCaptain();
    System.out.println("There are " + crewSize + " more pirates in the crew");
  }

  public boolean battle(Ship otherShip) {
    boolean actualShipHasWon;
    Ship winnerShip = new Ship();
    this.updateCrewSize();
    int thisScore = this.crewSize - this.captain.rumOMeter;
    otherShip.updateCrewSize();
    int otherShipScore = otherShip.crewSize - otherShip.captain.rumOMeter;
    if (thisScore > otherShipScore) {
      int numberOfLosses = (int) (Math.random() * otherShip.crew.size());
      for (int i = 0; i < numberOfLosses; i++) {
        otherShip.crew.remove(i);
      }
      actualShipHasWon = true;
    } else {
      int numberOfLosses = (int) (Math.random() * this.crew.size());
      for (int i = 0; i < numberOfLosses; i++) {
        this.crew.remove(i);
        winnerShip = this;
      }
      actualShipHasWon = false;
      winnerShip = otherShip;
    }

    partyTime(winnerShip, this, otherShip);

    return actualShipHasWon;
  }

  public void partyTime(Ship winnerShip, Ship yourShip, Ship otherShip) {
    for (int i = 0; i < ((int) (Math.random() * 10)); i++) {
      winnerShip.captain.drinkSomeRum();
    }
    for (int i = 0; i < (((int) (Math.random() * 10)) * winnerShip.crew.size()); i++) {
      winnerShip.crew.get(i).drinkSomeRum();
    }
    this.crew = winnerShip.crew;
    this.captain = winnerShip.captain;
    this.captainsConsumedRum = winnerShip.captainsConsumedRum;
    this.captainsState = winnerShip.captainsState;
  }
}
