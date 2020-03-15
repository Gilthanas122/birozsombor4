import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Checkerboard {
  public static void mainDraw(Graphics graphics) {
    // Fill the canvas with a checkerboard pattern.
    int size = 20; //in a 320x320 Panel will be 16 lines and 16 columns
    int x = 0;
    int y = 0;
    int howManyCheck = 0;
    for (int row = 0; row < HEIGHT / size; row++) {
      for (int column = 0; column < WIDTH / size; column++) {
        if (howManyCheck % 2 != 0) {
          graphics.setColor(Color.black);
          graphics.fillRect(x, y, size, size);
          howManyCheck++;
        } else {
          graphics.setColor(Color.white);
          graphics.fillRect(x, y, size, size);
          howManyCheck++;
        }
        x += size;
      }
      x = 0;
      y += size;
      howManyCheck++;
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