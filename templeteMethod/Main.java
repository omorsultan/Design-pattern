package templeteMethod;


// ১. Abstract Class - যা অ্যালগরিদমের কঙ্কাল বা টেমপ্লেট ধারণ করে
abstract class BeverageTemplate {

    // এটিই হলো 'Template Method'। এটিকে final করা হয়েছে যেন সাবক্লাস একে ওভাররাইড করতে না পারে।
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    // কমন ধাপ (সবাই শেয়ার করবে)
    private void boilWater() {
        System.out.println("Boiling water...");
    }

    // কমন ধাপ (সবাই শেয়ার করবে)
    private void pourInCup() {
        System.out.println("Pouring into cup...");
    }

    // এই ধাপগুলো সাবক্লাস নিজের মতো করে ইমপ্লিমেন্ট করবে
    protected abstract void brew();
    protected abstract void addCondiments();
}

// ২. Concrete Subclass 1: Coffee
class Coffee extends BeverageTemplate {
    @Override
    protected void brew() {
        System.out.println("Dripping Coffee through filter...");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding Sugar and Milk...");
    }
}

// ৩. Concrete Subclass 2: Tea
class Tea extends BeverageTemplate {
    @Override
    protected void brew() {
        System.out.println("Steeping the tea bag...");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding Lemon...");
    }
}

// ৪. Execution (Main Class)
public class Main {
    public static void main(String[] args) {
        System.out.println("--- Making Coffee using Template Method ---");
        BeverageTemplate coffee = new Coffee();
        coffee.prepareRecipe(); // টেমপ্লেট মেথড কল করা হলো

        System.out.println("\n--- Making Tea using Template Method ---");
        BeverageTemplate tea = new Tea();
        tea.prepareRecipe();
    }
}