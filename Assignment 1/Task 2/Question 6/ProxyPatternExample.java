import java.util.HashMap;
import java.util.Map;

// Step 2: Define Subject Interface
interface Image {
  void display();
}

// Step 3: Implement Real Subject Class
class RealImage implements Image {

  private String filename;

  public RealImage(String filename) {
    this.filename = filename;
    loadFromServer();
  }

  private void loadFromServer() {
    System.out.println("Loading image: " + filename);
  }

  @Override
  public void display() {
    System.out.println("Displaying image: " + filename);
  }
}

// Step 4: Implement Proxy Class
class ProxyImage implements Image {

  private RealImage realImage;
  private String filename;
  private static Map<String, RealImage> cache = new HashMap<>();

  public ProxyImage(String filename) {
    this.filename = filename;
  }

  @Override
  public void display() {
    if (cache.containsKey(filename)) {
      realImage = cache.get(filename);
    } else {
      realImage = new RealImage(filename);
      cache.put(filename, realImage);
    }
    realImage.display();
  }
}

// Step 5: Test the Proxy Implementation
public class ProxyPatternExample {

  public static void main(String[] args) {
    Image image1 = new ProxyImage("image1.jpg");
    Image image2 = new ProxyImage("image2.jpg");
    Image image3 = new ProxyImage("image1.jpg"); // This should use the cached image

    image1.display();
    image2.display();
    image3.display(); // Should load from cache, not from server
  }
}
