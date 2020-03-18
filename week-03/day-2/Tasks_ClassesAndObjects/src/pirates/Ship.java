package pirates;

import java.util.ArrayList;
import java.util.List;

public class Ship {

  enum BattleStatus {
    LOOSED,
    READY,
    WINNER,
  }
  List<Pirate> crew;
  Pirate captain;
  BattleStatus battleStatus;

  public Ship() {
    crew = new ArrayList<>();
    this.battleStatus = BattleStatus.READY;
    fillShip();
  }

  public void fillShip() {
    this.captain = new Pirate(true);
    int numberOfPirates = (int) (Math.random() * 100);
    for (int i = 0; i < numberOfPirates; i++) {
      crew.add(new Pirate());
    }
  }

  public void killAllPassedOutDuringBattle() {
    for (int i = 0; i < crew.size(); i++) {
      if (crew.get(i).state == Pirate.States.PASSED_OUT) {
        crew.get(i).state = Pirate.States.DEAD;
      }
    }
  }

  public void updateCrewSize() {
    for (int i = 0; i < crew.size(); i++) {
      if (crew.get(i).state == Pirate.States.DEAD) {
        crew.remove(i);
      }
    }
    //this.crewSize = this.crew.size();
  }

  public void removeThisAmountPirate(int amount) {
    for (int i = 0; i < amount; i++) {
      crew.get(i).state = Pirate.States.DEAD;
    }
    updateCrewSize();
  }

  public void getInfoAboutCaptain() {
    System.out.println("-------------------------------------------------------");
    System.out.println("Infos about the captain: ");
    System.out.println("The captain drank " + this.captain.rumOMeter + "x times.");
    System.out.println("Is he/she consumed rum: " + this.captain.consumedRum);
    System.out.println("The captain is now: " + this.captain.state.toString());
    System.out.println("-------------------------------------------------------");
  }

  public void getInfo() {
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    getInfoAboutCaptain();
    System.out.println("There are " + this.crew.size() + " more pirates in the crew");
    System.out.println("Battle status of the ship: " + this.battleStatus.toString());
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
  }

  public boolean battle(Ship otherShip) {
    //System.out.println("B     A     T     T     L     E");
    boolean actualShipHasWon;

    this.killAllPassedOutDuringBattle();
    this.updateCrewSize();
    int thisScore = this.crew.size() - this.captain.rumOMeter;

    otherShip.killAllPassedOutDuringBattle();
    otherShip.updateCrewSize();
    int otherShipScore = otherShip.crew.size() - otherShip.captain.rumOMeter;

    if (thisScore >= otherShipScore) {
      int numberOfLosses = (int) (Math.random() * otherShip.crew.size());
      otherShip.removeThisAmountPirate(numberOfLosses);
      actualShipHasWon = true;
      this.battleStatus = BattleStatus.WINNER;
      otherShip.battleStatus = BattleStatus.LOOSED;
      this.partyTime();
    } else {
      int numberOfLosses = (int) (Math.random() * this.crew.size());
      this.removeThisAmountPirate(numberOfLosses);
      actualShipHasWon = false;
      this.battleStatus = BattleStatus.LOOSED;
      otherShip.battleStatus = BattleStatus.WINNER;
      otherShip.partyTime();
    }
    return actualShipHasWon;
  }

  public void partyTime() {
    int captainsRumAmount = ((int) (Math.random() * 10));
    int crewRumAmount = (((int) (Math.random() * 10)) * this.crew.size());

    for (int i = 0; i < captainsRumAmount; i++) {
      this.captain.drinkSomeRum();
    }
    while (crewRumAmount != 0) {
      for (int i = 0; i < this.crew.size(); i++) {
        this.crew.get(i).drinkSomeRum();
        crewRumAmount--;
      }
    }
  }
}
