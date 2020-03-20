package cowsandbulls;

import java.util.ArrayList;

public class CowsAndBulls {
  public enum State {
    PLAYING,
    FINISHED
  }

  int numberToGuess;
  State state;
  int counter;

  public void setNumberToGuess(int numberToGuess) {
    if (!isItValidNumber(numberToGuess)) {
      this.numberToGuess = -1;
    } else {
      this.numberToGuess = numberToGuess;
    }
  }

  public CowsAndBulls() {
    do {
      this.numberToGuess = (int) (1000 + Math.random() * 9000);
    } while (!isItValidNumber(this.numberToGuess));
    this.state = State.PLAYING;
    this.counter = 0;
  }

  public String guess(int guess) {
    if (!isItValidNumber(guess)) {
      return new String("Wrong Input!");
    }
    int cows = 0;
    int bulls = 0;
    ArrayList<Integer> gussedNumberArray = intToArrayList(guess);
    ArrayList<Integer> randomNumberToGuessArray = intToArrayList(this.numberToGuess);
    for (int i = 0; i < gussedNumberArray.size(); i++) {
      if (randomNumberToGuessArray.get(i) == gussedNumberArray.get(i)) {
        bulls++;
      } else if (randomNumberToGuessArray.get(i) != gussedNumberArray.get(i) && randomNumberToGuessArray.contains(gussedNumberArray.get(i))) {
        cows++;
      }
    }
    if (bulls == 4) {
      this.state = State.FINISHED;
    }
    return new String(cows + " cow, " + bulls + " bull");
  }

  public ArrayList<Integer> intToArrayList(int number) {
    ArrayList<Integer> digitsInArray = new ArrayList<>();
    char[] holder = String.valueOf(number).toCharArray();
    for (int i = 0; i < holder.length; i++) {
      digitsInArray.add(Integer.parseInt(String.valueOf(holder[i])));
    }
    return digitsInArray;
  }

  public boolean isItValidNumber(int number) {
    if (number >= 10000 || number < 1000) {
      return false;
    }
    ArrayList<Integer> digits = intToArrayList(number);
    for (int i = 0; i < digits.size(); i++) {
      int holder = digits.get(i);
      digits.remove(i);
      if (digits.contains(holder)) {
        return false;
      }
      i = -1;
    }
    return true;
  }
}
