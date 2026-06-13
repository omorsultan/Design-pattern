package decorator;

interface Coffee {
  String getDescription();
  int getCost();
}

class BasicCoffee implements Coffee{

  public String getDescription(){
    return "Basic Coffee";
  }
  public int getCost(){
    return 100;
  }
}

abstract class CoffeeDecorator implements Coffee{
  protected Coffee coffee;

  public CoffeeDecorator(Coffee coffee){
    this.coffee = coffee;
  }
}

class MilkDecorator extends CoffeeDecorator{
  public MilkDecorator(Coffee coffee){
    super(coffee);
  }
  public String getDescription(){
    return coffee.getDescription() + ",Milk" ;
  }
  public int getCost(){
    return coffee.getCost() + 20;
  }

}

class SugarDecorator extends CoffeeDecorator {

    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Sugar";
    }

    @Override
    public int getCost() {
        return coffee.getCost() + 10;
    }
}

class CreamDecorator extends CoffeeDecorator {

    public CreamDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Cream";
    }

    @Override
    public int getCost() {
        return coffee.getCost() + 30;
    }
}
public class Main {
  public static void main(String[] args) {
    
    Coffee coffee = new BasicCoffee();

    System.out.println("-- Basic Coffee-- ");
    System.out.println(coffee.getDescription());
    System.out.println("Cost " + coffee.getCost());


     System.out.println();

        coffee = new MilkDecorator(coffee);
        coffee = new SugarDecorator(coffee);
        coffee = new CreamDecorator(coffee);

        System.out.println("----- Custom Coffee -----");
        System.out.println(coffee.getDescription());
        System.out.println("Cost: " + coffee.getCost());
  }

}
