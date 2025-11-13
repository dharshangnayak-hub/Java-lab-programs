abstract class Shape {
    int dim1, dim2;

    Shape(int a, int b) {
        dim1 = a;
        dim2 = b;
    }

    abstract void printArea();
}

class Rectangle extends Shape {
    Rectangle(int a, int b) {
        super(a, b);
    }

    void printArea() {
        double area = dim1 * dim2;
        System.out.println("Area of Rectangle: " + area);
    }
}

class Triangle extends Shape {
    Triangle(int a, int b) {
        super(a, b);
    }

    void printArea() {
        double area = 0.5 * dim1 * dim2;
        System.out.println("Area of Triangle: " + area);
    }
}

class Circle extends Shape {
    Circle(int radius) {
        super(radius, 0);
    }

    void printArea() {
        double area = Math.PI * dim1 * dim1;
        System.out.println("Area of Circle: " + area);
    }
}

public class ShapeTest {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(10, 5);
        Triangle t = new Triangle(10, 5);
        Circle c = new Circle(7);

        r.printArea();
        t.printArea();
        c.printArea();
    }
}
