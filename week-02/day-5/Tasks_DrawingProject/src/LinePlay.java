import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LinePlay {
  public static int[][] destCoordinate = new int[1][2];
  static int WIDTH = 320;
  static int HEIGHT = 320;

  public static void mainDraw(Graphics graphics) {
    int startX = 0;
    int startY = 0;
    int topDistance = 40;
    int distance = 20;
    //Purple section
    startX = topDistance;
    for (int i = 0; i < WIDTH / distance; i++) {
      linePlay(startX, startY, 'a', graphics, 'p');
      startX += distance;
    }
    //Green section
    destCoordinate[0][0] = 0;
    destCoordinate[0][1] = 0;
    startX = 0;
    startY = topDistance;
    for (int i = 0; i < WIDTH / distance; i++) {
      linePlay(startX, startY, 'b', graphics, 'g');
      startY += distance;
    }
  }

  private static void linePlay(int startX, int startY, char destination, Graphics graphics, char color) {
    //int[][] destCoordinate = new int[1][2];
    int distance = 24;
    switch (color) {
      case 'p':
        graphics.setColor(new Color(128, 0, 128));
        break;
      case 'g':
        graphics.setColor(Color.GREEN);
        break;
    }
    switch (destination) {
      case 'a':
        if (destCoordinate[0][0] == 0 && destCoordinate[0][1] == 0) {
          destCoordinate[0][0] = WIDTH;
          destCoordinate[0][1] = 0;
        } else {
          destCoordinate[0][0] = WIDTH;
          destCoordinate[0][1] += distance;
        }
        break;
      case 'b':
        if (destCoordinate[0][0] == 0 && destCoordinate[0][1] == 0) {
          destCoordinate[0][0] = 0;
          destCoordinate[0][1] = HEIGHT;
        } else {
          destCoordinate[0][0] += distance;
          destCoordinate[0][1] = HEIGHT;
        }
    }
    graphics.drawLine(startX, startY, destCoordinate[0][0], destCoordinate[0][1]);
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