package prototype;

interface Prototype {

    Prototype clone();
}



class Monster implements Prototype {
    public String type;
    public int health;
    public int speed;
    private String secretWeapon; // প্রাইভেট ফিল্ড

    public Monster(String type, int health, int speed, String secretWeapon) {
        this.type = type;
        this.health = health;
        this.speed = speed;
        this.secretWeapon = secretWeapon;
    }

    public Monster(Monster source){
      if(source != null){
        this.type = source.type;
        this.health= source.health;
        this.speed = source.speed;
        this.secretWeapon = source.secretWeapon;
      }
    }

    public Prototype clone(){
      return new Monster(this);
    }
}

// ক্লায়েন্ট কোড
public class Main {
    public static void main(String[] args) {
        // একটি শক্তিশালী মনস্টার তৈরি করা হলো
        Monster originalMonster = new Monster("Fire Dragon", 500, 80, "Laser Breath");

        Monster clonedMonster = (Monster) originalMonster.clone();

        System.out.println("Original: " + originalMonster.type + ", Weapon: " + originalMonster.health);
        System.out.println("Cloned: " + clonedMonster.type + ", Weapon: " + clonedMonster.health);
        
        // প্রমাণ যে দুটি আলাদা অবজেক্ট (মেমোরি অ্যাড্রেস ভিন্ন)
        System.out.println("Are they the same object? " + (originalMonster == clonedMonster));
    }
}