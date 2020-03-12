import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ConnectTheDots {
  public static void mainDraw(Graphics graphics) {
    // Create a function that takes 2 parameters:
    // An array of {x, y} points and graphics
    // and connects them with green lines.
    // Connect these to get a box:{{10, 10}, {290,  10}, {290, 290}, {10, 290}}
    // Connect these: {{50, 100}, {70, 70}, {80, 90}, {90, 90}, {100, 70}, {120, 100}, {85, 130}, {50, 100}}


    //connectFunction(new int[][] {{10, 10}, {290, 10}, {290, 290}, {10, 290}}, graphics);
    connectFunction(new int[][] {{50, 100}, {70, 70}, {80, 90}, {90, 90}, {100, 70}, {120, 100}, {85, 130}, {50, 100}}, graphics);
  }

  public static void connectFunction(int[][] coordinates, Graphics graphics) {
    int xHolder = 0;
    int yHolder = 0;
    int secondXHolder = 0;
    int secondYHolder = 0;
    int thirdXHolder = 0;
    int thirdYHolder = 0;
    int howManyElement = 0;

    for (int[] coordinate : coordinates) {
      for (int xOrY = 0; xOrY < 2; xOrY++) {
        if (xOrY == 0 && yHolder == 0) {
          xHolder = coordinate[xOrY];
        }
        if (xOrY == 1) {
          yHolder = coordinate[xOrY];
        }
        if (xHolder != 0 && yHolder != 0 && thirdXHolder != 0 && thirdXHolder != 0 && howManyElement != coordinates.length) {
          graphics.drawLine(xHolder, yHolder, thirdXHolder, thirdYHolder);
          System.out.println("First point: " + xHolder + ", " + yHolder + "Second point: " + thirdXHolder + ", " + thirdYHolder);
          thirdYHolder = 0;
          thirdXHolder = 0;
        }
        if (xOrY == 0 && xHolder != 0 && yHolder != 0) {
          secondXHolder = coordinate[xOrY];
        }
        if (xOrY == 1 && xHolder != 0 && yHolder != 0 && secondXHolder != 0) {
          secondYHolder = coordinate[xOrY];
          graphics.drawLine(xHolder, yHolder, secondXHolder, secondYHolder);
          System.out.println("First point: " + xHolder + ", " + yHolder + "Second point: " + secondXHolder + ", " + secondYHolder);
          xHolder = 0;
          yHolder = 0;
          thirdXHolder = secondXHolder;
          thirdYHolder = secondYHolder;
          if (howManyElement + 1 == coordinates.length) {
            System.out.println(howManyElement + " " + coordinates.length);
            System.out.println("LAST VALUE: " + thirdXHolder + ", " + thirdYHolder);
            System.out.println(coordinates[0][0]);
            graphics.drawLine(thirdXHolder, thirdYHolder, coordinates[0][0], coordinates[0][1]);
          }
          secondXHolder = 0;
          secondYHolder = 0;
        }
      }
      howManyElement++;
    }
  }

  // Don't touch the code below
  static int WIDTH = 320;
  static int HEIGHT = 320;

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Drawing");
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    ImagePanel panel = new ImagePanel();
    panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    jFrame.add(panel);
    jFrame.setLocationRelativeTo(null);
    jFrame.setVisible(true);
    jFrame.pack();
  }

  static class ImagePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics graphics) {
      super.paintComponent(graphics);
      mainDraw(graphics);
    }
  }
}
