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


    connectFunction(new int[][] {{10, 10}, {290, 10}, {290, 290}, {10, 290}}, graphics);
    connectFunction(new int[][] {{50, 100}, {70, 70}, {80, 90}, {90, 90}, {100, 70}, {120, 100}, {85, 130}, {50, 100}}, graphics);
  }

  private static void connectFunction(int[][] coordinates, Graphics graphics) {
    int xHolder = 0;
    int yHolder = 0;
    int secondXHolder = 0;
    int secondYHolder = 0;

    for (int i = 0; i < coordinates.length; i++) {
      if (i == 0) {
        xHolder = coordinates[i][0];
        yHolder = coordinates[i][1];
      } else {
        secondXHolder = coordinates[i][0];
        secondYHolder = coordinates[i][1];
        graphics.drawLine(xHolder, yHolder, secondXHolder, secondYHolder);
        //System.out.println("DRAW --> First point: {" + xHolder + ", " + yHolder + "} Second point: {" + secondXHolder + ", " + secondYHolder + "}");
        xHolder = coordinates[i][0];
        yHolder = coordinates[i][1];
      }
      if (i == coordinates.length - 1) {
        graphics.drawLine(xHolder, yHolder, coordinates[0][0], coordinates[0][1]);
        //System.out.println("DRAW --> First point: {" + xHolder + ", " + yHolder + "} Second point: {" + coordinates[0][0] + ", " + coordinates[0][1] + "}");
      }
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
