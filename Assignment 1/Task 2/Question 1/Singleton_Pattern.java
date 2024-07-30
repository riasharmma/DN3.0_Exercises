import java.util.*;

public class Singleton_Pattern {

  public static class Logger {

    public static Logger instance;

    public static Logger getInstance() {
      if (instance == null) {
        instance = new Logger();
      }
      return instance;
    }

    public void log(String message) {
      System.out.println("Log: " + message);
    }
  }

  public static void main(String[] args) {
    Logger logger1 = Logger.getInstance();
    logger1.log("This is the first log message.");

    Logger logger2 = Logger.getInstance();
    logger2.log("This is the second log message.");

    if (logger1 == logger2) {
      System.out.println(
        "Logger is a singleton! Both logger1 and logger2 are the same instance."
      );
    } else {
      System.out.println(
        "Logger is NOT a singleton! logger1 and logger2 are different instances."
      );
    }
  }
}
