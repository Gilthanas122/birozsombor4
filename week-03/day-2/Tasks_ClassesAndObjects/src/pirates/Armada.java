package pirates;

import java.util.ArrayList;
import java.util.List;

public class Armada {
  List<Ship> listOfShips;

  public Armada() {
    listOfShips = new ArrayList<>();
  }

  public void fillWithSips(int amountOfShips) {
    for (int i = 0; i < amountOfShips; i++) {
      this.listOfShips.add(new Ship());
    }
  }

  public boolean war(Armada otherArmada) {
    System.out.println("The WAR HAS BEGUN");
    System.out.println("This armada has: " + this.listOfShips.size()+ " ships and the otherArmada" +
        " has " +otherArmada.listOfShips.size() + " ships.");
    boolean isThisArmadaHasWon = false;
    int otherArmadaShipIndex = 0;
    while (this.listOfShips.size() != 0 || otherArmada.listOfShips.size() != 0) {
      if (otherArmadaShipIndex == otherArmada.listOfShips.size() - 1) {
        otherArmadaShipIndex = 0;
      }
      for (int i = 0; i < this.listOfShips.size(); i++) {
        otherArmada.updateArmadaSize();
        if (otherArmada.listOfShips.size() != 0) {
          while (otherArmada.listOfShips.get(otherArmadaShipIndex).battleStatus == Ship
              .BattleStatus.LOOSED) {
            if (otherArmadaShipIndex + 1 < otherArmada.listOfShips.size()) {
              otherArmadaShipIndex++;
            } else if (otherArmadaShipIndex + 1 == otherArmada.listOfShips.size()) {
              otherArmadaShipIndex = 0;
            }
          }
          this.listOfShips.get(i).battle(otherArmada.listOfShips.get(otherArmadaShipIndex));
          this.updateArmadaSize();
          otherArmada.updateArmadaSize();
        }
      }
      System.out.println("WAR UPDATE: " + this.listOfShips.size() + " vs " + otherArmada.listOfShips.size());
      if (this.listOfShips.size() == 0 || otherArmada.listOfShips.size() == 0){
        break;
      }
    }

    if (otherArmada.listOfShips.size() == 0) {
      isThisArmadaHasWon = true;
    } else if (this.listOfShips.size() == 0) {
      isThisArmadaHasWon = false;
    }
    return isThisArmadaHasWon;
  }

  public void updateArmadaSize() {
    for (int i = 0; i < this.listOfShips.size(); i++) {
      if (this.listOfShips.get(i).battleStatus == Ship.BattleStatus.LOOSED) {
        this.listOfShips.remove(i);
      }
    }
  }
}
