package greenfoxorganisation;

public class Student extends Person {
  String previousOrganization;
  int skippedDays;

  public Student() {
    super();
    this.previousOrganization = "The School of Life";
    this.skippedDays = 0;
  }

  public Student(String name, int age, String gender, String previousOrganization) {
    super(name, age, gender);
    this.previousOrganization = previousOrganization;
    this.skippedDays = 0;
  }

  @Override
  public void introduce() {
    System.out.println("Hi, I'm " + this.name + ", a " + this.age + " year old " + this.gender +
        " from " + this.previousOrganization + " who skipped " + this.skippedDays + " days from " +
        "the course already.");
  }

  @Override
  public void getGoal() {
    System.out.println("Be a junior developer.");
  }

  public void skipDays(int numberOfDays) {
    this.skippedDays = numberOfDays;
  }

}
