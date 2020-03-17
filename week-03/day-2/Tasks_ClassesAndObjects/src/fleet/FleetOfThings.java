package fleet;

import java.util.ArrayList;
import java.util.List;

public class FleetOfThings {

  public static void main(String[] args) {
    Fleet fleet = new Fleet();
    // - You have the `Thing` class
    // - You have the `Fleet` class
    // - You have the `FleetOfThings` class with a `main` method
    // - Download those, use those
    // - In the main method create a fleet
    // - Achieve this output:
    // Create a fleet of things to have this output:
    // 1. [ ] Get milk
    // 2. [ ] Remove the obstacles
    // 3. [x] Stand up
    // 4. [x] Eat lunch
    List<Thing> things = new ArrayList<>();
    things.add(new Thing("Get milk"));
    things.add(new Thing("Remove the obstacles"));
    things.add(new Thing("Stand up"));
    things.get(2).complete();
    things.add(new Thing("Eat lunch"));
    things.get(3).complete();
    for(Thing thing : things){
      fleet.add(thing);
    }

    System.out.println(fleet);
  }
}