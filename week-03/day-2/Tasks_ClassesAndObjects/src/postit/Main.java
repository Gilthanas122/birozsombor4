package postit;

import java.awt.Color;

public class Main {
  public static void main(String[] args) {
    PostIt post1 = new PostIt(Color.ORANGE, "Idea 1", Color.BLUE);
    PostIt post2 = new PostIt(Color.PINK, "Awesome", Color.BLACK);
    PostIt post3 = new PostIt(Color.YELLOW, "Superb!", Color.GREEN);
  }
}
