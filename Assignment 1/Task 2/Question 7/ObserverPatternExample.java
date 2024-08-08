import java.util.ArrayList;
import java.util.List;

interface Stock {
  void registerObserver(Observer observer);
  void deregisterObserver(Observer observer);
  void notifyObservers();
}

class StockMarket implements Stock {

  private List<Observer> observers = new ArrayList<>();
  private double stockPrice;

  public void setStockPrice(double stockPrice) {
    this.stockPrice = stockPrice;
    notifyObservers();
  }

  @Override
  public void registerObserver(Observer observer) {
    observers.add(observer);
  }

  @Override
  public void deregisterObserver(Observer observer) {
    observers.remove(observer);
  }

  @Override
  public void notifyObservers() {
    for (Observer observer : observers) {
      observer.update(stockPrice);
    }
  }
}

interface Observer {
  void update(double stockPrice);
}

class MobileApp implements Observer {

  @Override
  public void update(double stockPrice) {
    System.out.println("Mobile App: Stock price updated to $" + stockPrice);
  }
}

class WebApp implements Observer {

  @Override
  public void update(double stockPrice) {
    System.out.println("Web App: Stock price updated to $" + stockPrice);
  }
}

public class ObserverPatternExample {

  public static void main(String[] args) {
    StockMarket stockMarket = new StockMarket();
    Observer mobileApp = new MobileApp();
    Observer webApp = new WebApp();

    stockMarket.registerObserver(mobileApp);
    stockMarket.registerObserver(webApp);

    stockMarket.setStockPrice(100.5);
    stockMarket.setStockPrice(105.3);

    stockMarket.deregisterObserver(mobileApp);
    stockMarket.setStockPrice(110.0);
  }
}
