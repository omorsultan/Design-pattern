package bridge;
// Implementor
interface Color {
    void applyColor();
}

// Concrete Implementors
class RedColor implements Color {

    @Override
    public void applyColor() {
        System.out.println("Red Color");
    }
}

class BlueColor implements Color {

    @Override
    public void applyColor() {
        System.out.println("Blue Color");
    }
}

// Abstraction
abstract class Shape {

    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    abstract void draw();
}

// Refined Abstractions
class Circle extends Shape {

    public Circle(Color color) {
        super(color);
    }

    @Override
    void draw() {
        System.out.print("Drawing Circle with ");
        color.applyColor();
    }
}

class Rectangle extends Shape {

    public Rectangle(Color color) {
        super(color);
    }

    @Override
    void draw() {
        System.out.print("Drawing Rectangle with ");
        color.applyColor();
    }
}

// Client
public class Main {

    public static void main(String[] args) {

        Shape circle1 = new Circle(new RedColor());
        Shape circle2 = new Circle(new BlueColor());

        Shape rectangle1 = new Rectangle(new RedColor());
        Shape rectangle2 = new Rectangle(new BlueColor());

        circle1.draw();
        circle2.draw();

        rectangle1.draw();
        rectangle2.draw();
    }
}