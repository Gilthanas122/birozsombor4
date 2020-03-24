package comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import printable.Todo;

public class Main {
  public static void main(String[] args) {
    List<Domino> dominoes = new ArrayList<>();
    dominoes.add(new Domino(5, 2));
    dominoes.add(new Domino(4, 6));
    dominoes.add(new Domino(1, 5));
    dominoes.add(new Domino(6, 7));
    dominoes.add(new Domino(2, 4));
    dominoes.add(new Domino(7, 1));

    Collections.sort(dominoes);

    for (Domino d : dominoes) {
      System.out.println(d.toString());
    }

    System.out.println("");

    List<comparable.Todo> todos = new ArrayList<>();
    todos.add(new comparable.Todo("Buy milk", "high", true));
    todos.add(new comparable.Todo("Walk with dog", "high", false));
    todos.add(new comparable.Todo("Eat", "middle", true));
    todos.add(new comparable.Todo("Get infected", "low", false));

    Collections.sort(todos);

    for (comparable.Todo t : todos) {
      t.printAllFields();
    }
  }
}
