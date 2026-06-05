import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * TodoList
 */
public class TodoList {
  private String name;
  private List<TodoItem> list = new ArrayList<TodoItem>();

  public TodoList(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public List<TodoItem> getList() {
    return Collections.unmodifiableList(list);
  }

  public void printList() {
    if (list.isEmpty()) {
      System.out.println("List is empty.");
      return;
    }

    for (TodoItem todo : list) {
      String taskStatus = todo.isCompleted() ? "[X]" : "[ ]";
      String taskId = "(" + todo.getId() + ")";
      String taskTitle = todo.getTitle();
      System.out.println(taskStatus + " " + taskTitle + " " + taskId);
    }
  }

  public void createTodo(String todo) {
    var item = new TodoItem(todo, false);
    list.add(item);
  }

  public void toggleTodo(int id) {
    if (id < 0) {
      return;
    }

    for (TodoItem todoItem : list) {
      if (todoItem.getId() == id) {
        todoItem.toggleStatus();
        break;
      }
    }
  }

  public void removeTodo(int id) {
    if (id < 0) {
      return;
    }

    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getId() == id) {
        list.remove(i);
        break;
      }
    }
  }

}
