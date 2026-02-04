class Shape {
    void area(int side) {
        System.out.println("Area of square: " + (side * side));
    }

    void area(int length, int breadth) {
        System.out.println("Area of rectangle: " + (length * breadth));
    }
}


public class Exp2 {
    public static void main(String[] args) {
        Shape s = new Shape();

        s.area(5);
        s.area(4, 6);
    }
}
