class Shape {
    public double area() { return 0; }
}

class Circle extends Shape {
    final double radius;

    Circle(double radius) { this.radius = radius; }

    @Override
    public double area() { return Math.PI * radius * radius; }
}

class Rectangle extends Shape {
    final double width, height;

    Rectangle(double width, double height) { this.width = width; this.height = height; }

    @Override
    public double area() { return width * height; }
}

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        System.out.println("Circle area: " + circle.area());

        Rectangle rectangle = new Rectangle(4, 6);
        System.out.println("Rectangle area: " + rectangle.area());
    }
}

