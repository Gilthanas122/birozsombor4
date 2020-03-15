import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Diagonals {
  public static void mainDraw(Graphics graphics) {
    // Draw the canvas' diagonals.
    // If it starts from the upper-left corner it should be green, otherwise it should be red.
    graphics.setColor(Color.GREEN);
    graphics.drawLine(0,0, WIDTH,HEIGHT);

    graphics.setColor(Color.RED);
    graphics.drawLine(WIDTH/2,0,WIDTH/2,HEIGHT);
    graphics.drawLine(WIDTH, 0, 0,HEIGHT);
    graphics.drawLine(WIDTH,HEIGHT/2,0,HEIGHT/2);
    //graphics.drawLine(WIDTH,HEIGHT, 0, 0);
    graphics.drawLine(WIDTH/2,HEIGHT,WIDTH/2,0);
    graphics.drawLine(0,HEIGHT,WIDTH,0);
    graphics.drawLine(0,HEIGHT/2, WIDTH, HEIGHT/2);


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