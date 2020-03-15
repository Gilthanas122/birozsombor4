import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LinePlayQuarters {
  static int WIDTH = 320;
  static int HEIGHT = 320;

  public static void mainDraw(Graphics graphics) {
    //canvas divided to 4 equal unit
    drawLinePlayQuarters(2, graphics);

    //canvas divided to 8 equal unit
    drawLinePlayQuarters(4, graphics);

    //canvas divided to 16 equal unit
    drawLinePlayQuarters(8, graphics);
  }

  public static void drawLinePlayQuarters(int divider, Graphics graphics) {
    int newWidth = WIDTH / divider;
    int newHeight = HEIGHT / divider;

    for (int row = 0; row < HEIGHT / newHeight; row++) {
      for (int column = 0; column < WIDTH / newWidth; column++) {
        for (int i = 0; i < 16; i++) {
          graphics.setColor(Color.GREEN);
          graphics.drawLine((column * newWidth), newHeight / 15 * i + (row * newWidth), newWidth / 15 * i + (column * newWidth), newHeight + (row * newHeight));
          graphics.setColor(new Color(128, 0, 128));
          graphics.drawLine(newWidth / 15 * i + (column * newWidth), (row * newHeight), newWidth + (column * newWidth), newHeight / 15 * i + (row * newHeight));
          System.out.println(newWidth * column);
        }
      }
    }
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