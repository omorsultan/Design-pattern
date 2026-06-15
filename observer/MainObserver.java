package observer;

import java.util.ArrayList;
import java.util.List;

// ১. Observer Interface (Subscriber)
interface Observer {
    void update(String productName);
}

// ২. Concrete Observers (বাস্তব সাবস্ক্রাইবারসমূহ)
class TechEnthusiast implements Observer {
    private String name;

    public TechEnthusiast(String name) {
        this.name = name;
    }

    @Override
    public void update(String productName) {
        System.out.println("Email sent to " + name + ": New tech product available -> " + productName);
    }
}

class RegularCustomer implements Observer {
    private String name;

    public RegularCustomer(String name) {
        this.name = name;
    }

    @Override
    public void update(String productName) {
        System.out.println("SMS sent to " + name + ": Product in stock -> " + productName);
    }
}

// ৩. Subject Interface (Publisher)
interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// ৪. Concrete Subject
class OnlineStore implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String latestProduct;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(latestProduct);
        }
    }

    // দোকানের বিজনেস লজিক
    public void addNewProduct(String productName) {
        this.latestProduct = productName;
        System.out.println("\n--- Store added new product: " + productName + " ---");
        // প্রোডাক্ট আসার সাথে সাথে স্বয়ংক্রিয়ভাবে সবাইকে জানানো হবে
        notifyObservers();
    }
}

// ৫. ক্লায়েন্ট কোড (Execution)
public class MainObserver {
    public static void main(String[] args) {
        OnlineStore samsungStore = new OnlineStore();

        // কাস্টমার বা সাবস্ক্রাইবার তৈরি
        Observer rahim = new TechEnthusiast("Rahim");
        Observer karim = new RegularCustomer("Karim");

        // দোকানে সাবস্ক্রাইব বা রেজিস্টার করা
        samsungStore.registerObserver(rahim);
        samsungStore.registerObserver(karim);

        // নতুন প্রোডাক্ট আসলে সবাই নোটিফিকেশন পাবে
        samsungStore.addNewProduct("Samsung Galaxy S26");

        // করিম সাবস্ক্রিপশন বাতিল করল
        samsungStore.removeObserver(karim);

        // আবার নতুন প্রোডাক্ট আসলো
        samsungStore.addNewProduct("Samsung Galaxy Buds 3");
    }
}