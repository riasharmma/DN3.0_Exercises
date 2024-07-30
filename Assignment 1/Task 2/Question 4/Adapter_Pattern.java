interface PaymentProcessor {
  void processPayment(double amount);
}

class PayPalGateway {

  public void sendPayment(double amount) {
    System.out.println("Payment sent via PayPal: $" + amount);
  }
}

class StripeGateway {

  public void makePayment(double amount) {
    System.out.println("Payment made via Stripe: $" + amount);
  }
}

class PayPalAdapter implements PaymentProcessor {

  private PayPalGateway paypalGateway;

  public PayPalAdapter(PayPalGateway paypalGateway) {
    this.paypalGateway = paypalGateway;
  }

  @Override
  public void processPayment(double amount) {
    paypalGateway.sendPayment(amount);
  }
}

class StripeAdapter implements PaymentProcessor {

  private StripeGateway stripeGateway;

  public StripeAdapter(StripeGateway stripeGateway) {
    this.stripeGateway = stripeGateway;
  }

  @Override
  public void processPayment(double amount) {
    stripeGateway.makePayment(amount);
  }
}

public class Adapter_Pattern {

  public static void main(String[] args) {
    PayPalGateway paypalGateway = new PayPalGateway();
    StripeGateway stripeGateway = new StripeGateway();
    PaymentProcessor paypalAdapter = new PayPalAdapter(paypalGateway);
    PaymentProcessor stripeAdapter = new StripeAdapter(stripeGateway);
    paypalAdapter.processPayment(100.0);
    stripeAdapter.processPayment(50.0);
  }
}
