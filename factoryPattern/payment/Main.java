package factoryPattern.payment;

abstract class Payment{
  abstract void pay();
}

class CreditCardPayment extends Payment{
    public void pay() {
        System.out.println("Paid using Credit Card");
    }
}

class PayPalPayment  extends Payment{
    public void pay() {
        System.out.println("Paid using PayPal");
    }
}

class BKashPayment extends Payment{
    public void pay() {
        System.out.println("Paid using BKash");
    }
}

class paymentFactory {
    public static Payment createPayment(String paymentType){
         if (paymentType.equalsIgnoreCase("creditcard")) {
            return new CreditCardPayment();
        }
        if (paymentType.equalsIgnoreCase("paypal")) {

            return new PayPalPayment();
        }
         if (paymentType.equalsIgnoreCase("bkash")) {

            return new BKashPayment();
        }
        throw new IllegalArgumentException();
    }
}

public class Main {

    public static void paying(String paymentType){
        Payment payment = paymentFactory.createPayment(paymentType);
        payment.pay();
    }
    

    public static void main(String[] args) {
        paying("Bkash");
       
    }
}