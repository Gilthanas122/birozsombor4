import java.util.Scanner;

public class MileToKmConverter {
    public static void main(String[] args) {
        // Write a program that asks for a double that is a distance in miles,
        // then it converts that value to kilometers and prints it

        Scanner input = new Scanner(System.in);

        System.out.println("Give me a distance in miles, in this format: 12,12");

        double miles = input.nextDouble();
        double milesConvertedToKm = miles * 1.609344;

        System.out.println("Miles --> Km = " + milesConvertedToKm);

    }
}
