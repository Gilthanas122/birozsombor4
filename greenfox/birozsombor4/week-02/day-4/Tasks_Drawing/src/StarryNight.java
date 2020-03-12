import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class StarryNight {
  public static void mainDraw(Graphics graphics) {
    // Draw the night sky:
    //  - The background should be black
    //  - The stars can be small squares
    //  - The stars should have random positions on the canvas
    //  - The stars should have random color (some shade of grey)
    graphics.setColor(Color.BLACK);
    graphics.fillRect(0,0,WIDTH,HEIGHT);
    for (int i = 0; i < 20; i++) {
      int size = (int) (Math.random()*20);
      int x = (int) (Math.random()*WIDTH);
      int y = (int) (Math.random()*HEIGHT);
      int rgbValue = (int) (Math.random()*256);
      drawSquare(x,y,size,new Color(rgbValue,rgbValue,rgbValue), graphics);
    }

  }

  private static void drawSquare(int x, int y, int size, Color color, Graphics graphics) {
    graphics.setColor(color);
    graphics.fillRect(x,y,size,size);
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
