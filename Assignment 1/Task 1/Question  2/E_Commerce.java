import java.util.*;

class Product {

  int productId;
  String productName;
  String category;

  public Product(int productId, String productName, String category) {
    this.productId = productId;
    this.productName = productName;
    this.category = category;
  }

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getCategory() {
    return category;
  }
}

class E_commerece {

  ArrayList<Product> products;

  E_commerece() {
    products = new ArrayList<>();
  }

  public void addProduct(Product product) {
    products.add(product);
  }

  public static Product linearSearchProduct(
    Product[] product,
    String searchProductName
  ) {
    for (Product i : product) {
      if (i.getProductName().equalsIgnoreCase(searchProductName)) {
        System.out.println("Product found!!!");
        return i;
      }
    }
    System.out.println("Product not found!!!");
    return null;
  }

  public static Product BinarySearchProduct(
    Product[] product,
    String targetProduct
  ) {
    int left = 0;
    int right = product.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      int cmp =
        product[mid].getProductName().compareToIgnoreCase(targetProduct);
      if (cmp == 0) {
        return product[mid];
      } else if (cmp < 0) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return null;
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    E_commerece ob = new E_commerece();
    Product[] products = {
      new Product(1, "Apple", "Fruits"),
      new Product(2, "Banana", "Fruits"),
      new Product(3, "Cherry", "Fruits"),
      new Product(4, "Dairy", "Dairy"),
      new Product(5, "Eggs", "Dairy"),
      new Product(6, "Flour", "Grains"),
      new Product(7, "Carrot", "Vegetable"),
    };
    Arrays.sort(products, Comparator.comparing(Product::getProductName));
    Product foundProduct = E_commerece.linearSearchProduct(products, "Carrot");
    System.out.println(
      foundProduct != null ? foundProduct.getProductId() : "Product not found"
    );

    // Binary Search
    foundProduct = E_commerece.BinarySearchProduct(products, "Carrot");
    System.out.println(
      foundProduct != null ? foundProduct.getProductId() : "Product not found"
    );
  }
}
