package builder.pizza.Messy;

// একটি সাধারণ পিৎজা ক্লাস
class Pizza {
    public String size;          // বাধ্যতামূলক (যেমন: Small, Medium, Large)
    public boolean cheese;       // অপশনাল
    public boolean pepperoni;    // অপশনাল
    public boolean mushroom;     // অপশনাল
    public boolean onions;       // অপশনাল
    public boolean extraSauce;   // অপশনাল

    // ১. প্রথম কনস্ট্রাক্টর: শুধুমাত্র সাইজ দিয়ে
    public Pizza(String size) {
        this.size = size;
    }

    // ২. দ্বিতীয় কনস্ট্রাক্টর: সাইজ এবং চিজ দিয়ে
    public Pizza(String size, boolean cheese) {
        this.size = size;
        this.cheese = cheese;
    }

    // ৩. তৃতীয় কনস্ট্রাক্টর: সাইজ, চিজ এবং পেপারনি দিয়ে
    public Pizza(String size, boolean cheese, boolean pepperoni) {
        this.size = size;
        this.cheese = cheese;
        this.pepperoni = pepperoni;
    }

    // ৪. চতুর্থ কনস্ট্রাক্টর: সব প্রপার্টি নিয়ে (Telescoping Constructor)
    public Pizza(String size, boolean cheese, boolean pepperoni, boolean mushroom, boolean onions, boolean extraSauce) {
        this.size = size;
        this.cheese = cheese;
        this.pepperoni = pepperoni;
        this.mushroom = mushroom;
        this.onions = onions;
        this.extraSauce = extraSauce;
    }

    public void showPizza() {
        System.out.println("Pizza Size: " + size + 
                           ", Cheese: " + cheese + 
                           ", Pepperoni: " + pepperoni + 
                           ", Mushroom: " + mushroom + 
                           ", Onions: " + onions + 
                           ", Extra Sauce: " + extraSauce);
    }
}

// ক্লায়েন্ট কোড (এখানেই আসল ঝামেলা!)
public class Main {
    public static void main(String[] args) {
        
        // কেস ১: শুধু একটি লার্জ পিৎজা লাগবে, কোনো টপিং ছাড়া। 
        // কিন্তু আমাদের সব ভ্যালু ম্যানুয়ালি false পাস করতে হচ্ছে! কোন false কিসের জন্য, তা বোঝাই যাচ্ছে না।
        Pizza simplePizza = new Pizza("Large", false, false, false, false, false);
        simplePizza.showPizza();


        // কেস ২: একটি মিডিয়াম পিৎজা লাগবে যাতে শুধু চিজ এবং এক্সট্রা সস থাকবে।
        // মাঝখানের পেপারনি, মাশরুম না লাগলেও সিরিয়াল ঠিক রাখার জন্য জোর করে false লিখতে হচ্ছে।
        Pizza customPizza = new Pizza("Medium", true, false, false, false, true);
        customPizza.showPizza();
        
    }
}