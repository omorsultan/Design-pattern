# Builder Design Pattern (বিল্ডার ডিজাইন প্যাটার্ন)

Builder Design Pattern (বিল্ডার ডিজাইন প্যাটার্ন) হলো অবজেক্ট-ওরিয়েন্টেড প্রোগ্রামিংয়ের একটি Creational Design Pattern। সহজ কথায়, যখন কোনো একটি অবজেক্ট তৈরি করার প্রক্রিয়া অত্যন্ত জটিল হয়ে যায় এবং ধাপে ধাপে (Step-by-step) সেটিকে তৈরি করার প্রয়োজন হয়, তখন বিল্ডার প্যাটার্ন ব্যবহার করা হয়।

নিচে Refactoring.Guru-এর আলোকে এটি বিস্তারিত বাংলায় ব্যাখ্যা করা হলো:

---

## মূল সমস্যা (The Problem)

ধরুন, আপনাকে একটি House (বাড়ি) অবজেক্ট তৈরি করতে হবে। একটি সাধারণ বাড়ি তৈরি করতে দেয়াল, ছাদ, দরজা ও জানালা লাগবে। কিন্তু আপনার যদি এমন একটি বাড়ি লাগে যাতে সুইমিং পুল, চমৎকার বাগান, সেন্ট্রাল হিটিং সিস্টেম এবং গ্যারেজ থাকবে?

সাধারণ উপায়ে এটি সমাধান করতে গেলে আপনি দুটি সমস্যায় পড়বেন:

1. **বিশাল কনস্ট্রাক্টর (Telescoping Constructor):** আপনি একটি কনস্ট্রাক্টর তৈরি করলেন যাতে বাড়ির সব সম্ভাব্য প্রপার্টি প্যারামিটার হিসেবে থাকবে। যেমন: `House(walls, doors, windows, hasSwimmingPool, hasGarage, hasGarden...)`। সমস্যা হলো, বেশিরভাগ বাড়ির ক্ষেত্রেই গ্যারেজ বা সুইমিং পুল থাকবে না। ফলে অবজেক্ট তৈরি করার সময় আপনাকে জোর করে অনেকগুলো প্যারামিটারে null বা false পাস করতে হবে, যা কোডকে অত্যন্ত নোংরা (Messy) করে তোলে।
2. **অসংখ্য সাব-ক্লাস তৈরি হওয়া:** আপনি যদি প্রতিটা কম্বিনেশনের জন্য আলাদা সাব-ক্লাস তৈরি করতে যান (যেমন: `HouseWithGarage`, `HouseWithPool`, `HouseWithPoolAndGarden`), তবে আপনার প্রজেক্টে সাব-ক্লাসের বন্যা বয়ে যাবে।

---

## সমাধান (The Solution)

Builder প্যাটার্ন বলে— অবজেক্ট তৈরির এই বিশাল কোডটিকে তার নিজস্ব ক্লাস থেকে বের করে সম্পূর্ণ আলাদা একটি অবজেক্টে নিয়ে যান, যাকে বলা হবে Builder।



এই প্যাটার্নটি অবজেক্ট তৈরির প্রক্রিয়াটিকে ছোট ছোট ধাপে ভাগ করে দেয় (যেমন: `buildWalls()`, `buildDoors()`, `buildPool()`)। একটি অবজেক্ট তৈরি করতে আপনার ঠিক যে যে আদেশ বা ধাপগুলো প্রয়োজন, আপনি কেবল সেই মেথডগুলোই কল করবেন। সব মেথড কল করার কোনো বাধ্যবাধকতা নেই।

---

## ডিরেক্টর (The Director)

বিল্ডার প্যাটার্নে একটি চমৎকার কনসেপ্ট আছে, যাকে বলা হয় Director।

ডিরেক্টর ক্লাসের কাজ হলো— কোন ধাপের পর কোন ধাপটি আসবে অর্থাৎ অবজেক্ট তৈরির সঠিক ক্রম বা সিকোয়েন্স (Sequence) নিয়ন্ত্রণ করা।

উদাহরণস্বরূপ: ডিরেক্টরের কাছে `makeSportsCar()` বা `makeSUV()` এর মতো নির্দিষ্ট কিছু গাইডলাইন বা রেসিপি থাকে। ক্লায়েন্ট শুধু ডিরেক্টরকে বলবে, "আমাকে একটি স্পোর্টস কার বানিয়ে দাও।" ডিরেক্টর তখন বিল্ডারকে দিয়ে ধাপে ধাপে সেটি তৈরি করিয়ে দেবে। (মনে রাখবেন, ডিরেক্টর ক্লাসটি ব্যবহার করা বাধ্যতামুলক নয়, ক্লায়েন্ট চাইলে সরাসরি বিল্ডারকেও ধাপে ধাপে কল করতে পারে)।

---

## জাভা (Java) কোড উদাহরণ

নিচে একটি সহজ উদাহরণ দেওয়া হলো যেখানে বিল্ডার প্যাটার্নের বহুল ব্যবহৃত Method Chaining (একটি মেথডের পর আরেকটি মেথড ডট দিয়ে কল করা) পদ্ধতি দেখানো হয়েছে:

```java
// ১. মূল প্রোডাক্ট ক্লাস
class Car {
    private int seats;
    private String engine;
    private boolean tripComputer;
    private boolean gps;

    // কনস্ট্রাক্টর প্রাইভেট করা থাকে, যাতে সরাসরি new Car() দিয়ে কেউ অবজেক্ট তৈরি করতে না পারে
    public Car(int seats, String engine, boolean tripComputer, boolean gps) {
        this.seats = seats;
        this.engine = engine;
        this.tripComputer = tripComputer;
        this.gps = gps;
    }

    public void showSpecs() {
        System.out.println("Car with " + seats + " seats, Engine: " + engine + 
                           ", GPS: " + gps + ", Trip Computer: " + tripComputer);
    }
}

// ২. বিল্ডার ক্লাস
class CarBuilder {
    private int seats;
    private String engine;
    private boolean tripComputer;
    private boolean gps;

    public CarBuilder setSeats(int seats) {
        this.seats = seats;
        return this; // নিজের রেফারেন্স রিটার্ন করছে (Method Chaining এর জন্য)
    }

    public CarBuilder setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public CarBuilder setTripComputer(boolean tripComputer) {
        this.tripComputer = tripComputer;
        return this;
    }

    public CarBuilder setGPS(boolean gps) {
        this.gps = gps;
        return this;
    }

    // সবশেষে অবজেক্টটি তৈরি করে রিটার্ন করার মেথড
    public Car build() {
        return new Car(seats, engine, tripComputer, gps);
    }
}

// ৩. ক্লায়েন্ট কোড
public class Main {
    public static void main(String[] args) {
        // ধাপে ধাপে এবং চমৎকার রিডেবল উপায়ে স্পোর্টস কার তৈরি
        Car sportsCar = new CarBuilder()
                            .setSeats(2)
                            .setEngine("V8 Engine")
                            .setGPS(true)
                            // এখানে আমরা setTripComputer কল করিনি, ফলে ওটা ডিফল্ট বা ফলস থাকবে
                            .build();

        sportsCar.showSpecs();
    }
}