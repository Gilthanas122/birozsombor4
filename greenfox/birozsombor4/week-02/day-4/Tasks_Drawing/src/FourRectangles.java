import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FourRectangles {

  public static void mainDraw(Graphics graphics) {
    // draw four different size and color rectangles.
    // avoid code duplication.
    for (int i = 0; i < 4; i++) {
      int x = (int) (Math.random() * WIDTH / 2);
      int y = (int) (Math.random() * HEIGHT / 2);
      int size = (int) (Math.random() * WIDTH);
      int colorR = (int) (Math.random() * 256);
      int colorG = (int) (Math.random() * 256);
      int colorB = (int) (Math.random() * 256);
      drawARectangle(x, y, size, colorR, colorG, colorB, graphics);
    }

  }

  private static void drawARectangle(int x, int y, int size, int colorR, int colorG, int colorB, Graphics graphics) {
    graphics.setColor(new Color(colorR, colorG, colorB));
    graphics.fillRect(x, y, size, size);
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