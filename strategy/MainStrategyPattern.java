package strategy;



// ১. Strategy Interface
interface PaymentStrategy {
    void pay(int amount);
}

// ২. Concrete Strategies (আলাদা আলাদা অ্যালগরিদম ক্লাস)
class BkashPayment implements PaymentStrategy {
    private String phoneNumber;

    public BkashPayment(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paying BDT " + amount + " using Bkash (Acc: " + phoneNumber + ").");
        System.out.println("Bkash Flow: OTP Verified -> PIN Verified.");
    }
}

class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cvv;

    public CreditCardPayment(String cardNumber, String cvv) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paying BDT " + amount + " using Credit Card (" + cardNumber + ").");
        System.out.println("Card Flow: Validating Card -> Processing Payment.");
    }
}

class CashOnDelivery implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Order placed via Cash on Delivery. BDT " + amount + " will be collected at your doorstep.");
    }
}

// ৩. Context Class (যা স্ট্র্যাটেজি অবজেক্ট ধারণ করবে)
class ShoppingCart {
    private int totalAmount = 5000;
    private PaymentStrategy paymentStrategy;

    // রানটাইমে স্ট্র্যাটেজি সেট করার জন্য সেটার মেথড
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout() {
        if (paymentStrategy == null) {
            System.out.println("Please select a payment method first!");
            return;
        }
        System.out.println("Checking out items...");
        // কাজটিকে নির্দিষ্ট স্ট্র্যাটেজির কাছে অর্পণ (Delegate) করা হলো
        paymentStrategy.pay(totalAmount); 
    }
}

// ৪. ক্লায়েন্ট কোড (Execution)
public class MainStrategyPattern {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        System.out.println("--- Scenario 1: User wants to pay via Bkash ---");
        cart.setPaymentStrategy(new BkashPayment("01700000000"));
        cart.checkout();

        System.out.println("\n--- Scenario 2: User changes mind and selects Card ---");
        // কোনো ইম্প্যাক্ট ছাড়াই রানটাইমে অ্যালগরিদম বা স্ট্র্যাটেজি বদলে ফেলা যাচ্ছে
        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9876", "123"));
        cart.checkout();
        
        System.out.println("\n--- Scenario 3: User selects Cash on Delivery ---");
        cart.setPaymentStrategy(new CashOnDelivery());
        cart.checkout();
    }
}