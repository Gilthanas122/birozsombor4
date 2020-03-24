package printable;

public class Todo implements Printable {
  private String task;
  private String priority;
  private boolean hasItDone;

  public Todo(String task, String priority, boolean hasItDone) {
    this.task = task;
    this.priority = priority;
    this.hasItDone = hasItDone;
  }

  @Override
  public void printAllFields() {
    System.out.println("Task: " + this.task + " | Priority: " + this.priority + " | Done : " + this.hasItDone);
  }
}
