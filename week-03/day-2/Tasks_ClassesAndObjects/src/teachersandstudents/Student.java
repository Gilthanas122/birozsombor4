package teachersandstudents;

public class Student {
  public void learn() {
    System.out.println("The student is learning something new!");
  }

  public void question(Teacher teacher) {
    teacher.answer();
  }
}
