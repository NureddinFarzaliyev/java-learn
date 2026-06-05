public class Main {
  public static void main(String[] args) {

    System.out.println("Hello, world!");

    var myTodo = new TodoList("books");

    System.out.println(myTodo.getName());

    myTodo.createTodo("Item 1");
    myTodo.createTodo("Item 2");
    myTodo.createTodo("Item 3");
    myTodo.createTodo("Item 4");
    myTodo.createTodo("Item 5");

    myTodo.toggleTodo(3);
    myTodo.removeTodo(2);

    myTodo.printList();

    myTodo.printNotCompletedList();
  }
}
