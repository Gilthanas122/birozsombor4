public class CodingHours {
    public static void main(String[] args) {
        int dailyCodingHours = 6;
        int weeks = 17;
        int daysOfAWeek = 5;
        int weeklyWorkHours = 52;
        int semesterCodingHours = weeks * daysOfAWeek * dailyCodingHours;
        int semesterWorkHours = weeks * weeklyWorkHours;

        System.out.println("An attendee spent " + semesterCodingHours + " hours in a semester with coding.");
        System.out.println("One attendee spent " + (((double)semesterCodingHours/semesterWorkHours)*100) +  "% of his time with coding.");
    }
}
