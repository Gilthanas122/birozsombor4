import javax.swing.*;

import java.awt.*;
import org.w3c.dom.ls.LSOutput;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class SuperHexagon {
  static int WIDTH = 320;
  static int HEIGHT = 320;

  public static void mainDraw(Graphics graphics) {
    int howManyColumns = 7;
    SuperHexagon(howManyColumns, graphics);
  }

  public static void SuperHexagon(int howManyColumns, Graphics graphics) {
    int size = (WIDTH / (howManyColumns * 4));
    int startX = ((WIDTH / 2) - (size / 2) - (size * (howManyColumns / 2 + 1)));
    int startY = HEIGHT / 2 - ((size * 2) * ((howManyColumns / 2 - 1)));
    int buildDownStartY = 0;
    int x = startX;
    int y = startY;
    int howManyHexagonInColumn = howManyColumns / 2;
    int completedColumns = 0;

    for (int column = 0; column < howManyColumns; column++) {
      if (column <= howManyColumns / 2) {
        for (int rowBuildUp = 0; rowBuildUp <= howManyHexagonInColumn; rowBuildUp++) {
          drawHexagon(x, y, size, graphics);
          y += size * 2;
        }
        howManyHexagonInColumn++;
        completedColumns++;
        if (column == howManyColumns / 2) {
          y = startY - (completedColumns * size);
          y += size * 2;
          completedColumns = 1;
          buildDownStartY = y;
        } else {
          y = startY - (completedColumns * size);
        }
      } else {
        howManyHexagonInColumn--;
        for (int rowBuildDown = 0; rowBuildDown < howManyHexagonInColumn; rowBuildDown++) {
          drawHexagon(x, y, size, graphics);
          y += size * 2;
        }
        y = buildDownStartY + (completedColumns * size);
        completedColumns++;
      }
      x += (size + (size / 2));
    }
  }

  public static void drawHexagon(int x, int y, int size, Graphics graphics) {
    graphics.drawLine(x, y, x + size, y);
    graphics.drawLine(x + size, y, x + size + (size / 2), y + size);
    graphics.drawLine(x + size + (size / 2), y + size, x + size, y + (size * 2));
    graphics.drawLine(x + size, y + (size * 2), x, y + (size * 2));
    graphics.drawLine(x, y + (size * 2), x - (size / 2), y + size);
    graphics.drawLine(x - (size / 2), y + size, x, y);
  }
  // Don't touch the code below

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