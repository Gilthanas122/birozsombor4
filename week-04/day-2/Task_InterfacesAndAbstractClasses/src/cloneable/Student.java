package cloneable;

public class Student implements Cloneable {
  String name;
  int age;
  String gender;
  String previousOrganization;
  int skippedDays;

  public Student() {
    this.previousOrganization = "The School of Life";
    this.skippedDays = 0;
  }

  @Override
  protected Student clone() throws CloneNotSupportedException {
    Student cloned = (Student) super.clone();
    return cloned;
  }

  public Student(String name, int age, String gender, String previousOrganization) {
    this.age = age;
    this.name = name;
    this.gender = gender;
    this.previousOrganization = previousOrganization;
    this.skippedDays = 0;
  }

  public void introduce() {
    System.out.println("Hi, I'm " + this.name + ", a " + this.age + " year old " + this.gender +
        " from " + this.previousOrganization + " who skipped " + this.skippedDays + " days from " +
        "the course already.");
  }

  public void getGoal() {
    System.out.println("Be a junior developer.");
  }

  public void skipDays(int numberOfDays) {
    this.skippedDays = numberOfDays;
  }

}
