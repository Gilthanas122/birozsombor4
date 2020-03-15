import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Triangles {
  public static void mainDraw(Graphics graphics) {
    int howManyRows = 21;
    drawTriangles(howManyRows, graphics);
  }

  public static void drawTriangles(int howManyRows, Graphics graphics) {
    int size = WIDTH / howManyRows;
    int startX = 0;
    int startY = HEIGHT;
    int x = startX;
    int y = startY;
    int completedLines = 0;
    for (int i = howManyRows; i > 0; i--) {
      for (int j = i; j > 0; j--) {
        drawTriangle(x, y, size, graphics);
        x += size;
      }
      completedLines++;
      x = 0 + (completedLines * (size / 2));
      y -= size;
    }
  }

  public static void drawTriangle(int x, int y, int size, Graphics graphics) {
    graphics.drawLine(x, y, x + size, y);
    graphics.drawLine(x, y, x + (size / 2), y - size);
    graphics.drawLine(x + (size / 2), y - size, x + size, y);
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