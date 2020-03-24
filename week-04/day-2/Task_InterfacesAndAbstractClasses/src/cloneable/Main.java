package cloneable;

public class Main {
  public static void main(String[] args) {
    Student student = new Student("John", 20, "male", "BME");
    Student johnTheClone = new Student();
    try {
      johnTheClone = student.clone();
    } catch (CloneNotSupportedException e) {
      System.out.println("Clone is not supported!");
      e.printStackTrace();
    }
    System.out.println(student.toString());
    System.out.println(johnTheClone.toString());

    System.out.println(student.name + " from " + student.previousOrganization);
    System.out.println(johnTheClone.name + " from " + johnTheClone.previousOrganization);
  }
}
