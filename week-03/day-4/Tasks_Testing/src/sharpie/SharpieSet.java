package sharpie;

import java.util.ArrayList;
import java.util.List;
import sharpie.Sharpie;

public class SharpieSet {
  List<Sharpie> setOfSharpies;

  public SharpieSet() {
    setOfSharpies = new ArrayList<>();
  }

  public int countUsable() {
    int counter = 0;
    for (Sharpie sharpie : this.setOfSharpies) {
      if (sharpie.inkAmount > 0) {
        counter++;
      }
    }
    return counter;
  }

  public void removeTrash() {
    for (int i = 0; i < this.setOfSharpies.size(); i++) {
      if (this.setOfSharpies.get(i).inkAmount <= 0) {
        this.setOfSharpies.remove(i);
        i--;
      }
    }
  }
}