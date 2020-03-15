import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LinePlayQuarters {
  public static int[][] destCoordinate = new int[1][2];
  static int WIDTH = 320;
  static int HEIGHT = 320;

  public static void mainDraw(Graphics graphics) {
    int startX = 0;
    int startY = 0;
    //Normal
    //linePlayFunction(graphics, WIDTH, HEIGHT, 'a', startX, startY);

    //divide the canvas to 4
    int newWidth = WIDTH/2;
    int newHeight = HEIGHT/2;
    for (int row = 0; row < 2; row++) {
      linePlayFunction(graphics, newWidth, newHeight, 'b', startX, startY);
      startX+= newHeight;
      startY+=newHeight;
    }




  }
  public static void linePlayFunction(Graphics graphics, int width, int height, char typeOfVariableSet, int startX, int startY){
    int topDistance = 40;
    int distance = 20;
    int increment = 24;
    switch (typeOfVariableSet){
      case 'a':
        topDistance = topDistance;
        distance = distance;
        increment = increment;
        break;
      case 'b':
        topDistance/=2;
        distance/=2;
        increment/=2;
    }
    int startXholder = startX;
    int startYholder = startY;
    //Purple section
    startXholder = topDistance;
    for (int i = 0; i < width / distance-1; i++) {
      linePlay(startXholder, startYholder, 'a', graphics, 'p', width, height, increment);
      startXholder += distance;
    }
    //Green section
    destCoordinate[0][0] = 0;
    destCoordinate[0][1] = 0;
    startXholder = startX;
    startYholder = topDistance;
    for (int i = 0; i < width / distance-1; i++) {
      linePlay(startXholder, startYholder, 'b', graphics, 'g', width, height, increment);
      startYholder += distance;
    }
    destCoordinate[0][0] = 0;
    destCoordinate[0][1] = 0;
  }

  private static void linePlay(int startX, int startY, char destination, Graphics graphics, char color, int width, int height, int icrement) {
    //int[][] destCoordinate = new int[1][2];
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
          destCoordinate[0][0] = width;
          destCoordinate[0][1] = 0;
        } else {
          destCoordinate[0][0] = width;
          destCoordinate[0][1] += icrement;
        }
        break;
      case 'b':
        if (destCoordinate[0][0] == 0 && destCoordinate[0][1] == 0) {
          destCoordinate[0][0] = 0;
          destCoordinate[0][1] = height;
        } else {
          destCoordinate[0][0] += icrement;
          destCoordinate[0][1] = height;
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