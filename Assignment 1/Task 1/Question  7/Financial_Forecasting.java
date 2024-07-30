import java.util.*;

class Financial_Forecasting {

  public static double calculateFutureValue(
    double initialValue,
    double growthRate,
    int years
  ) {
    if (years == 0) {
      return initialValue;
    }

    return (
      (1 + growthRate) *
      calculateFutureValue(initialValue, growthRate, years - 1)
    );
  }

  public static double calculateFutureValueMemo(
    double initialValue,
    double growthRate,
    int years,
    double[] memo
  ) {
    if (years == 0) {
      return initialValue;
    }

    if (memo[years] != 0) {
      return memo[years];
    }

    memo[years] =
      (1 + growthRate) *
      calculateFutureValueMemo(initialValue, growthRate, years - 1, memo);
    return memo[years];
  }

  public static void main(String[] args) {
    double initialValue = 1000.0;
    double growthRate = 0.05;
    int years = 10;

    double futureValue = calculateFutureValue(initialValue, growthRate, years);
    System.out.println("Future value (simple recursion): " + futureValue);

    double[] memo = new double[years + 1];
    double futureValueMemo = calculateFutureValueMemo(
      initialValue,
      growthRate,
      years,
      memo
    );
    System.out.println("Future value (memoization): " + futureValueMemo);
  }
}
