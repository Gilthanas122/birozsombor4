package reservations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) throws IOException {
    List<Reservation> reservations = new ArrayList<>();

    for (int i = 0; i < 10; i++) {
      reservations.add(new Reservation());
    }

    for (Reservation r : reservations) {
      System.out.println(r.toString());
    }
  }
}
