public class SecondsInADay {
  public static void main(String[] args) {
    // Write a program that prints the remaining seconds (as an integer) from a
    // day if the current time is represented by the variables
    int currentHours = 14;
    int currentMinutes = 34;
    int currentSeconds = 42;
    int remainingHours = 24 - currentHours - 1;
    int remainingMinutes = 60 - currentMinutes;
    int remainingSeconds = 60 - currentSeconds;
    int remaining = (remainingHours * 60 * 60) + (remainingMinutes * 60) + remainingSeconds;
    System.out.println("Remaining seconds from the day: " + remaining + "s");
  }
}