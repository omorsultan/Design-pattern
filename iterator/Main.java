package iterator;

// ১. Iterator Interface
interface Iterator {
    boolean hasNext(); // পরবর্তী এলিমেন্ট আছে কি না চেক করে
    Object next();     // পরবর্তী এলিমেন্টটি রিটার্ন করে
}

// ২. Collection Interface
interface Collection {
    Iterator createIterator(); // ইটারেটর তৈরি করার মেথড
}

// ৩. Concrete Iterator (নির্দিষ্টভাবে নোটিফিকেশন অ্যারের জন্য ইটারেটর)
class NotificationIterator implements Iterator {
    private String[] notificationList;
    private int pos = 0; // কারেন্ট পজিশন ট্র্যাক করার জন্য

    public NotificationIterator(String[] notificationList) {
        this.notificationList = notificationList;
    }

    @Override
    public boolean hasNext() {
        // পজিশন সীমার মধ্যে আছে কি না এবং ডেটা নাল কি না চেক করে
        return pos < notificationList.length && notificationList[pos] != null;
    }

    @Override
    public Object next() {
        String notification = notificationList[pos];
        pos++; // পজিশন এক বাড়িয়ে দেওয়া হলো
        return notification;
    }
}

// ৪. Concrete Collection (ইন্টারনাল স্ট্রাকচার এখন সম্পূর্ণ এনক্যাপসুলেটেড বা গোপন)
class NotificationCollection implements Collection {
    private static final int MAX_ITEMS = 3;
    private int numberOfItems = 0;
    private String[] notificationList;

    public NotificationCollection() {
        notificationList = new String[MAX_ITEMS];
        addNotification("Notification 1: Your order has been shipped.");
        addNotification("Notification 2: New login detected.");
        addNotification("Notification 3: Bill paid successfully.");
    }

    public void addNotification(String str) {
        if (numberOfItems < MAX_ITEMS) {
            notificationList[numberOfItems] = str;
            numberOfItems++;
        }
    }

    // ক্লায়েন্টকে সরাসরি অ্যারে না দিয়ে একটি ইটারেটর অবজেক্ট দেওয়া হচ্ছে
    @Override
    public Iterator createIterator() {
        return new NotificationIterator(notificationList);
    }
}

// ৫. ক্লায়েন্ট কোড (Execution)
public class Main {
    public static void main(String[] args) {
        Collection collection = new NotificationCollection();
        
        // ক্লায়েন্ট জানেই না ব্যাকএন্ডে অ্যারে নাকি অন্য কিছু ব্যবহার হচ্ছে
        Iterator iterator = collection.createIterator();

        System.out.println("--- Printing Notifications using Iterator Pattern ---");
        while (iterator.hasNext()) {
            String notification = (String) iterator.next();
            System.out.println(notification);
        }
    }
}