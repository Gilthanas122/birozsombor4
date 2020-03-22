package domino;

import java.util.ArrayList;
import java.util.List;

public class Dominoes {
  public static void main(String[] args) {
    List<Domino> dominoes = initializeDominoes();
    List<Domino> organizedDomines = new ArrayList<>();
    // You have the list of Dominoes
    // Order them into one snake where the adjacent dominoes have the same numbers on their adjacent sides
    // eg: [2, 4], [4, 3], [3, 5] ...
    organizedDomines.add(dominoes.get(0));
    dominoes.remove(0);
    int organizedIndex = 0;

    for (int i = 0; i < dominoes.size(); i++) {
      if (organizedDomines.get(organizedIndex).getRightSide() == dominoes.get(i).getLeftSide()) {
        organizedDomines.add(dominoes.get(i));
        organizedIndex++;
        dominoes.remove(i);
        i = -1;
      }
    }

    for (Domino domino : organizedDomines) {
      dominoes.add(domino);
    }

    System.out.println(dominoes);
  }

  static List<Domino> initializeDominoes() {
    List<Domino> dominoes = new ArrayList<>();
    dominoes.add(new Domino(5, 2));
    dominoes.add(new Domino(4, 6));
    dominoes.add(new Domino(1, 5));
    dominoes.add(new Domino(6, 7));
    dominoes.add(new Domino(2, 4));
    dominoes.add(new Domino(7, 1));
    return dominoes;
  }
}