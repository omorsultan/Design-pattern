package builder.pizza;

// একটি সাধারণ পিৎজা ক্লাস
class Pizza {
    private String size;          // বাধ্যতামূলক (যেমন: Small, Medium, Large)
    private boolean cheese;       // অপশনাল
    private boolean pepperoni;    // অপশনাল
    private boolean mushroom;     // অপশনাল
    private boolean onions;       // অপশনাল
    private boolean extraSauce;   // অপশনাল

   

    // ৪. চতুর্থ কনস্ট্রাক্টর: সব প্রপার্টি নিয়ে (Telescoping Constructor)
    private Pizza(Builder builder) {
        this.size = builder.size;
        this.cheese = builder.cheese;
        this.pepperoni = builder.pepperoni;
        this.mushroom = builder.mushroom;
        this.onions = builder.onions;
        this.extraSauce = builder.extraSauce;
    }

public static class Builder {
    private String size;          
    private boolean cheese;       // অপশনাল
    private boolean pepperoni;    // অপশনাল
    private boolean mushroom;     // অপশনাল
    private boolean onions;       // অপশনাল
    private boolean extraSauce; 
    
    public Builder setSize(String size){
      this.size = size;
      return this;
    }

    public Builder addChese(boolean cheese){
     this.cheese = cheese;
     return this;
    }
    public Builder addMushroom(boolean mushroom){
     this.mushroom =  mushroom;
     return this;
    }

    public Builder addOnions(boolean onions){
     this.onions =onions ;
     return this;
    }

    public Pizza build(){
      return new Pizza(this);
    }
    

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
       Pizza myPizza = new Pizza.Builder()
                            .setSize("Large")
                            .addChese(true)
                            .build();

        myPizza.showPizza();
        
    }
}