package adapter;

interface PaymentProcessor {
    void pay(int amount);
}


class PayPalGateway {

    public void makePayment(double money) {

        System.out.println(
            "Paid " + money + " using PayPal");
    }
}

class PayPalAdapter
        implements PaymentProcessor {

    private PayPalGateway payPalGateway;

    public PayPalAdapter(
            PayPalGateway payPalGateway) {

        this.payPalGateway = payPalGateway;
    }

    @Override
    public void pay(int amount) {

        payPalGateway.makePayment(amount);
    }
}

public class Main {

    public static void main(String[] args) {

        PaymentProcessor payment =
            new PayPalAdapter(
                new PayPalGateway());

        payment.pay(500);
    }
}