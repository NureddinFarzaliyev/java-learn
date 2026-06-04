import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * TodoList
 */
public class TodoList {
  private String name;

  // Use general list type but initialize an array list
  private List<String> list = new ArrayList<String>();

  public TodoList(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public List<String> getList() {
    // Don't return the reference to original list
    return Collections.unmodifiableList(list);
  }

  public void printList() {
    if (list.isEmpty()) {
      System.out.println("List is empty.");
    }
    for (String todo : list) {
      System.out.println("- " + todo);
    }
  }

  public void createTodo(String todo) {
    list.add(todo);
  }
}
