import java.util.*;

class Order {

  private int orderId;
  private String customerName;
  private double totalPrice;

  public Order(int orderId, String customerName, double totalPrice) {
    this.orderId = orderId;
    this.customerName = customerName;
    this.totalPrice = totalPrice;
  }

  public int getOrderId() {
    return orderId;
  }

  public String getCustomerName() {
    return customerName;
  }

  public double getTotalPrice() {
    return totalPrice;
  }

  @Override
  public String toString() {
    return (
      "Order{" +
      "orderId=" +
      orderId +
      ", customerName='" +
      customerName +
      '\'' +
      ", totalPrice=" +
      totalPrice +
      '}'
    );
  }
}

class Customer_Order {

  public static void BubbleSort(Order[] orders) {
    int n = orders.length;
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
          Order temp = orders[j];
          orders[j] = orders[j + 1];
          orders[j + 1] = temp;
        }
      }
    }
  }

  public static void sort(Order[] orders) {
    quickSort(orders, 0, orders.length - 1);
  }

  private static void quickSort(Order[] orders, int low, int high) {
    if (low < high) {
      int pi = partition(orders, low, high);
      quickSort(orders, low, pi - 1);
      quickSort(orders, pi + 1, high);
    }
  }

  private static int partition(Order[] orders, int low, int high) {
    double pivot = orders[high].getTotalPrice();
    int i = (low - 1);
    for (int j = low; j < high; j++) {
      if (orders[j].getTotalPrice() < pivot) {
        i++;
        Order temp = orders[i];
        orders[i] = orders[j];
        orders[j] = temp;
      }
    }
    Order temp = orders[i + 1];
    orders[i + 1] = orders[high];
    orders[high] = temp;
    return i + 1;
  }

  public static void main(String[] args) {
    Customer_Order ob = new Customer_Order();
    Order[] orders = {
      new Order(1, "Alice", 250.0),
      new Order(2, "Bob", 150.0),
      new Order(3, "Charlie", 300.0),
      new Order(4, "David", 200.0),
    };

    System.out.println("Original Orders:");
    for (Order order : orders) {
      System.out.println(order);
    }

    ob.BubbleSort(orders);
    System.out.println("\nOrders after Bubble Sort:");
    for (Order order : orders) {
      System.out.println(order);
    }

    orders =
      new Order[] {
        new Order(1, "Alice", 250.0),
        new Order(2, "Bob", 150.0),
        new Order(3, "Charlie", 300.0),
        new Order(4, "David", 200.0),
      };

    ob.sort(orders);
    System.out.println("\nOrders after Quick Sort:");
    for (Order order : orders) {
      System.out.println(order);
    }
  }
}
