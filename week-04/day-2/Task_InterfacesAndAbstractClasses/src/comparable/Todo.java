package comparable;

public class Todo implements Comparable<Todo> {

  private String task;
  private String priority;
  private boolean hasItDone;

  public Todo(String task, String priority, boolean hasItDone) {
    this.task = task;
    this.priority = priority;
    this.hasItDone = hasItDone;
  }

  public void printAllFields() {
    System.out.println("Task: " + this.task + " | Priority: " + this.priority + " | Done : " + this.hasItDone);
  }

  @Override
  public int compareTo(Todo todo) {
    //return Boolean.compare(this.hasItDone, todo.hasItDone);
    return this.task.compareTo(todo.task);
  }
}
