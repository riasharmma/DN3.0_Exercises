import java.util.*;

class Task {

  private int taskId;
  private String taskName;
  private String status;

  public Task(int taskId, String taskName, String status) {
    this.taskId = taskId;
    this.taskName = taskName;
    this.status = status;
  }

  public int getTaskId() {
    return taskId;
  }

  public String getTaskName() {
    return taskName;
  }

  public String getStatus() {
    return status;
  }

  @Override
  public String toString() {
    return (
      "Task{" +
      "taskId=" +
      taskId +
      ", taskName='" +
      taskName +
      '\'' +
      ", status='" +
      status +
      '\'' +
      '}'
    );
  }
}

class Node {

  Task task;
  Node next;

  Node(Task task) {
    this.task = task;
    this.next = null;
  }
}

class Task_Management_System {

  Node head;

  public Task_Management_System() {
    this.head = null;
  }

  // Add a new task
  public void addTask(Task task) {
    Node newNode = new Node(task);
    if (head == null) {
      head = newNode;
    } else {
      Node current = head;
      while (current.next != null) {
        current = current.next;
      }
      current.next = newNode;
    }
  }

  // Search for a task by taskId
  public Task searchTask(int taskId) {
    Node current = head;
    while (current != null) {
      if (current.task.getTaskId() == taskId) {
        return current.task;
      }
      current = current.next;
    }
    return null;
  }

  // Traverse and print all tasks
  public void traverseTasks() {
    Node current = head;
    while (current != null) {
      System.out.println(current.task);
      current = current.next;
    }
  }

  // Delete a task by taskId
  public boolean deleteTask(int taskId) {
    if (head == null) {
      return false;
    }
    if (head.task.getTaskId() == taskId) {
      head = head.next;
      return true;
    }
    Node current = head;
    while (current.next != null && current.next.task.getTaskId() != taskId) {
      current = current.next;
    }
    if (current.next == null) {
      return false;
    }
    current.next = current.next.next;
    return true;
  }

  public static void main(String[] args) {
    Task_Management_System taskManager = new Task_Management_System();

    taskManager.addTask(new Task(1, "Design", "Pending"));
    taskManager.addTask(new Task(2, "Development", "In Progress"));
    taskManager.addTask(new Task(3, "Testing", "Completed"));

    System.out.println("Traverse Tasks:");
    taskManager.traverseTasks();

    System.out.println("\nSearch for Task with ID 2:");
    System.out.println(taskManager.searchTask(2));

    System.out.println("\nDelete Task with ID 2:");
    taskManager.deleteTask(2);
    taskManager.traverseTasks();
  }
}
