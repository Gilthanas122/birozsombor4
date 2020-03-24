package reservations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class Reservation implements Reservationy {
  private String dowBooking;
  private String codeBooking;
  private final static String lettersForCode = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private final static String numbersForCode = "0123456789";
  private static List<String> alreadyCreatedCodes;
  private static Path codesFile = Paths.get("src/reservations/createdCodes.txt");

  static {
    try {
      alreadyCreatedCodes = Files.readAllLines(codesFile);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public Reservation(String dowBooking) throws IOException {
    this.dowBooking = dowBooking;
    this.codeBooking = setRandomCode();
  }

  public Reservation() throws IOException {
    this.dowBooking = setRandomDow();
    this.codeBooking = setRandomCode();
  }

  private String setRandomCode() throws IOException {
    String code = "";
    do {
      code = getARandomCode();
    } while (!isItAvailableCode(code));
    alreadyCreatedCodes.add(code);
    Files.write(codesFile, alreadyCreatedCodes);
    return code;
  }

  private String getARandomCode() {
    String code = "";
    for (int i = 0; i < 8; i++) {
      int letterOrNumber = (int) (Math.random() * 2);
      if (letterOrNumber == 1) {
        int letterIndex = (int) (Math.random() * 26);
        code += lettersForCode.charAt(letterIndex);
      } else {
        int numberIndex = (int) (Math.random() * 10);
        code += numbersForCode.charAt(numberIndex);
      }
    }
    return code;
  }

  private boolean isItAvailableCode(String code) {
    for (String c : alreadyCreatedCodes) {
      if (c.equals(code)) {
        return false;
      }
    }
    return true;
  }

  private String setRandomDow() {
    int random = (int) (Math.random() * 7);
    String[] dows = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
    return dows[random];
  }

  @Override
  public String getDowBooking() {
    return this.dowBooking;
  }

  @Override
  public String getCodeBooking() {
    return this.codeBooking;
  }

  @Override
  public String toString() {
    return "Booking# " + getCodeBooking() + " for " + getDowBooking();
  }
}
