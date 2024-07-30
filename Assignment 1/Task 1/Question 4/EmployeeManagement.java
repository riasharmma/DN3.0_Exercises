import java.util.*;

class Employee {

  private int employeeId;
  private String name;
  private String position;
  private double salary;

  public Employee(int employeeId, String name, String position, double salary) {
    this.employeeId = employeeId;
    this.name = name;
    this.position = position;
    this.salary = salary;
  }

  public int getEmployeeId() {
    return employeeId;
  }

  public String getName() {
    return name;
  }

  public String getPosition() {
    return position;
  }

  public double getSalary() {
    return salary;
  }

  @Override
  public String toString() {
    return (
      "Employee{" +
      "employeeId=" +
      employeeId +
      ", name='" +
      name +
      '\'' +
      ", position='" +
      position +
      '\'' +
      ", salary=" +
      salary +
      '}'
    );
  }
}

class EmployeeManagement {

  Employee[] employees;
  int size;

  public EmployeeManagement(int capacity) {
    employees = new Employee[capacity];
    size = 0;
  }

  // Add an employee
  public boolean addEmployee(Employee employee) {
    if (size == employees.length) {
      // Resize array if full
      employees = Arrays.copyOf(employees, size * 2);
    }
    employees[size++] = employee;
    return true;
  }

  // Search for an employee by employeeId
  public Employee searchEmployee(int employeeId) {
    for (int i = 0; i < size; i++) {
      if (employees[i].getEmployeeId() == employeeId) {
        return employees[i];
      }
    }
    return null;
  }

  // Traverse and print all employees
  public void traverseEmployees() {
    for (int i = 0; i < size; i++) {
      System.out.println(employees[i]);
    }
  }

  // Delete an employee by employeeId
  public boolean deleteEmployee(int employeeId) {
    for (int i = 0; i < size; i++) {
      if (employees[i].getEmployeeId() == employeeId) {
        // Shift elements to the left
        for (int j = i; j < size - 1; j++) {
          employees[j] = employees[j + 1];
        }
        employees[--size] = null;
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    EmployeeManagement empMan = new EmployeeManagement(2);

    empMan.addEmployee(new Employee(1, "Alice", "Engineer", 70000));
    empMan.addEmployee(new Employee(2, "Bob", "Manager", 80000));
    empMan.addEmployee(new Employee(3, "Charlie", "Technician", 50000));

    System.out.println("Traverse Employees:");
    empMan.traverseEmployees();

    System.out.println("\nSearch for Employee with ID 2:");
    System.out.println(empMan.searchEmployee(2));

    System.out.println("\nDelete Employee with ID 2:");
    empMan.deleteEmployee(2);
    empMan.traverseEmployees();
  }
}
