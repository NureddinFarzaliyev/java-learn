public class TodoItem {
  private static int idCounter = 1;

  private String title;
  private boolean completed = false;
  private final int id;

  public TodoItem(String title, boolean completed) {
    this.title = title;
    this.completed = completed;
    this.id = idCounter++;
  }

  public void toggleStatus() {
    completed = !completed;
  }

  public String getTitle() {
    return title;
  }

  public boolean isCompleted() {
    return completed;
  }

  public int getId() {
    return id;
  }

  public String getInfo() {
    String taskStatus = completed ? "[X]" : "[ ]";
    String taskId = "(" + id + ")";
    String taskTitle = title;
    return taskStatus + " " + taskTitle + " " + taskId;
  }

  public void printInfo() {
    System.out.println(getInfo());
  }
}
