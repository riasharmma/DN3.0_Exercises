// Step 2: Define Strategy Interface
interface PaymentStrategy {
    void pay(double amount);
}

// Step 3: Implement Concrete Strategies
class CreditCardPayment implements PaymentStrategy {
    private String name;
    private String cardNumber;

    public CreditCardPayment(String name, String cardNumber) {
        this.name = name;
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card. Name: " + name + ", Card Number: " + cardNumber);
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal. Email: " + email);
    }
}

// Step 4: Implement Context Class
class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount) {
        paymentStrategy.pay(amount);
    }
}

// Step 5: Test the Strategy Implementation
public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentStrategy creditCard = new CreditCardPayment("John Doe", "1234-5678-9876-5432");
        PaymentStrategy payPal = new PayPalPayment("john.doe@example.com");

        PaymentContext paymentContext = new PaymentContext(creditCard);
        paymentContext.executePayment(150.75);

        paymentContext = new PaymentContext(payPal);
        paymentContext.executePayment(200.00);
    }
}
