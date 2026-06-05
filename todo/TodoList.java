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

    list.forEach(TodoItem::printInfo);
  }

  public void printNotCompletedList() {
    if (list.isEmpty()) {
      System.out.println("List is empty.");
      return;
    }

    boolean hasNotCompleted = list.stream()
        .anyMatch(todo -> !todo.isCompleted());

    if (!hasNotCompleted) {
      System.out.println("All tasks are completed.");
      return;
    }

    list.stream()
        .filter(todo -> !todo.isCompleted())
        .forEach(TodoItem::printInfo);

  }

  public void createTodo(String todo) {
    var item = new TodoItem(todo, false);
    list.add(item);
  }

  public void toggleTodo(int id) {
    list.stream()
        .filter(todo -> todo.getId() == id)
        .findFirst()
        .ifPresent(TodoItem::toggleStatus);
  }

  public void removeTodo(int id) {
    list.removeIf(todo -> todo.getId() == id);
  }
}
