import java.util.*;

class Product {

  int productId;
  String productName;
  int quantity;
  int price;

  public Product(int productId, String productName, int quantity, int price) {
    this.productId = productId;
    this.productName = productName;
    this.quantity = quantity;
    this.price = price;
  }

  public int getProductId() {
    return productId;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String product) {
    this.productName = product;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }
}

public class Inventory_Management_System {

  ArrayList<Product> products;

  public Inventory_Management_System() {
    products = new ArrayList<>();
  }

  public void addProduct(Product product) {
    products.add(product);
  }

  public void updateProduct(int productId, Product product) {
    for (int i = 0; i < products.size(); i++) {
      if (products.get(i).getProductId() == productId) {
        products.set(i, product);
        return;
      }
    }
    System.out.println("Product not found !!!");
  }

  public void deleteProduct(int productId) {
    for (int i = 0; i < products.size(); i++) {
      if (products.get(i).getProductId() == productId) {
        products.remove(i);
        return;
      }
    }
    System.out.println("Product not found!!!");
  }

  public void displayProduct() {
    for (Product product : products) {
      System.out.println(
        "Product ID: " +
        product.productId +
        "\tProduct Name: " +
        product.productName +
        "\tQuantity: " +
        product.quantity +
        "\tProduct Price: Rs." +
        product.price
      );
    }
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    Inventory_Management_System ims = new Inventory_Management_System();
    Product product1 = new Product(1, "product1", 100, 250);
    Product product2 = new Product(2, "product2", 150, 400);
    ims.addProduct(product1);
    ims.addProduct(product2);
    ims.displayProduct();
    Product newProduct = new Product(1, "updatedProduct", 120, 350);
    ims.updateProduct(1, newProduct);
    ims.displayProduct();
    ims.deleteProduct(1);
    ims.displayProduct();
  }
}
