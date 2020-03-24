package printable;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Domino> dominoes = new ArrayList<>();
    dominoes.add(new Domino(1, 5));
    dominoes.add(new Domino(2, 6));
    dominoes.add(new Domino(3, 1));
    dominoes.add(new Domino(4, 2));

    List<Todo> todos = new ArrayList<>();
    todos.add(new Todo("Buy milk", "high", true));

    for (Domino d : dominoes) {
      d.printAllFields();
    }

    for (Todo t : todos) {
      t.printAllFields();
    }
  }
}
