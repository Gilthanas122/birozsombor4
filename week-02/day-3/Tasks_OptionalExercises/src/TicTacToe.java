import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TicTacToe {
  public static void main(String[] args) throws IOException {
    // Write a function that takes a filename as a parameter
    // The file contains an ended Tic-Tac-Toe match
    // We have provided you some example files (draw.txt, win-x.txt, win-o.txt)
    // Return "X", "O" or "Draw" based on the input file

    System.out.println(ticTacResult("files/win-o.txt"));
    // Should print "O"

    System.out.println(ticTacResult("files/win-x.txt"));
    // Should print "X"

    System.out.println(ticTacResult("files/draw.txt"));
    // Should print "Draw"
  }

  private static String ticTacResult(String location) throws IOException {
    Path path = Paths.get(location);
    List<String> lines = Files.readAllLines(path);
    String line1 = lines.get(0);
    String line2 = lines.get(1);
    String line3 = lines.get(2);
    //FOR X WIN
    if (line1.startsWith("X")) {
      if (line2.startsWith("X")) {
        if (line3.startsWith("X")) {
          return new String("X");
        }
      }
    }
    if (!line1.startsWith("X") && !line1.endsWith("X")) {
      if (!line2.startsWith("X") && !line2.endsWith("X")) {
        if (!line3.startsWith("X") && !line3.endsWith("X")) {
          return new String("X");
        }
      }
    }
    if (line1.endsWith("X")) {
      if (line2.endsWith("X")) {
        if (line3.endsWith("X")) {
          return new String("X");
        }
      }
    }
    if (line1.startsWith("X") && line1.endsWith("X")) {
      if (!line2.contains("X")) {
        if (!line3.contains("X")) {
          return new String("X");
        }
      }
    }
    if (!line1.contains("X")) {
      if (line2.startsWith("X") && line2.endsWith("X")) {
        if (!line3.contains("X")) {
          return new String("X");
        }
      }
    }
    if (!line1.contains("X")) {
      if (!line2.contains("X")) {
        if (line3.startsWith("X") && line3.endsWith("X")) {
          return new String("X");
        }
      }
    }
    if (line1.startsWith("X")) {
      if (!line2.startsWith("X") && line2.endsWith("X") && line2.contains("X")) {
        if (line3.endsWith("X")) {
          return new String("X");
        }
      }
    }
    if (line1.endsWith("X")) {
      if (!line2.startsWith("X") && line2.endsWith("X") && line2.contains("X")) {
        if (line3.startsWith("X")) {
          return new String("X");
        }
      }
    }
    //FOR O WIN
    if (line1.startsWith("O")) {
      if (line2.startsWith("O")) {
        if (line3.startsWith("O")) {
          return new String("O");
        }
      }
    }
    if (!line1.startsWith("O") && !line1.endsWith("O")) {
      if (!line2.startsWith("O") && !line2.endsWith("O")) {
        if (!line3.startsWith("O") && !line3.endsWith("O")) {
          return new String("O");
        }
      }
    }
    if (line1.endsWith("O")) {
      if (line2.endsWith("O")) {
        if (line3.endsWith("O")) {
          return new String("O");
        }
      }
    }
    if (line1.startsWith("O") && line1.endsWith("O")) {
      if (!line2.contains("O")) {
        if (!line3.contains("O")) {
          return new String("O");
        }
      }
    }
    if (!line1.contains("O")) {
      if (line2.startsWith("O") && line2.endsWith("O")) {
        if (!line3.contains("O")) {
          return new String("O");
        }
      }
    }
    if (!line1.contains("O")) {
      if (!line2.contains("O")) {
        if (line3.startsWith("O") && line3.endsWith("O")) {
          return new String("O");
        }
      }
    }
    if (line1.startsWith("O")) {
      if (!line2.startsWith("O") && line2.endsWith("O") && line2.contains("O")) {
        if (line3.endsWith("O")) {
          return new String("O");
        }
      }
    }
    if (line1.endsWith("O")) {
      if (!line2.startsWith("O") && line2.endsWith("O") && line2.contains("O")) {
        if (line3.startsWith("O")) {
          return new String("O");
        }
      }
    }
    return new String("DRAW");
  }
}
