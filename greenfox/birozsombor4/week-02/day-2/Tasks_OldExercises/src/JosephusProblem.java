import java.util.ArrayList;
import java.util.Scanner;

public class JosephusProblem {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("JOSEPHUS PROBLEM \nNumber of max position: ");
    int userInput = input.nextInt();
    System.out.println("Winner position: " + josephusProblem(userInput));
  }

  public static int josephusProblem(int maxNumber) {
    String originalBinaryInString = Integer.toBinaryString(maxNumber);
    char replaceChar = originalBinaryInString.charAt(0);
    String newBinaryInString = originalBinaryInString.substring(0 + 1);
    newBinaryInString += replaceChar;
    int winnerPosition = Integer.parseInt(newBinaryInString, 2);
    return winnerPosition;
  }

  public static int problemSolver(int maxNumber) {
    ArrayList<Integer> listOfMembers = makeList(maxNumber);
    System.out.println("How many people before killing? " + listOfMembers.size());
    System.out.println(listOfMembers);
    int numberOfIteration = maxNumber - 1;

    for (int i = 0; i < 13; i++) {

      if (listOfMembers.size() == 2) {
        listOfMembers.remove(1);
        break;
      }

      if (i + 1 < listOfMembers.size()) {
        listOfMembers.remove(i + 1);
        System.out.println(listOfMembers);
        //i++;
      }
      if (i == listOfMembers.size() - 1) {
        listOfMembers.remove(0);
        System.out.println(listOfMembers);
        i = 0;
        //i--;
      } else {
        //i--;
        //System.out.println(listOfMembers);
      }
    }


    System.out.println("How many people AFTER killing? " + listOfMembers.size());
    System.out.println(listOfMembers.get(0));
    return listOfMembers.get(0);
  }

  private static ArrayList<Integer> makeList(int maxNumber) {
    ArrayList<Integer> makeList = new ArrayList<>();
    for (int i = 0; i < maxNumber; i++) {
      makeList.add(i + 1);
    }
    return makeList;
  }
}
