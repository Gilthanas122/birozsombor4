import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LinePlayQuarters{
  static int WIDTH = 320;
  static int HEIGHT = 320;

  public static void mainDraw(Graphics graphics) {
    for (int i = 1; i < 15; i++) {
      graphics.setColor(Color.GREEN);
      graphics.drawLine(0, HEIGHT / 15 * i, WIDTH / 15 * i, HEIGHT);
      graphics.setColor(new Color(128, 0, 128));
      graphics.drawLine(WIDTH / 15 * i, 0, WIDTH, HEIGHT / 15 * i);
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