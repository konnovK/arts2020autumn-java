package Task4.figure;

public class Circle implements Figure {

    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String info() {
        return "я круг радиуса " + radius;
    }

    @Override
    public double capacity2() {
        return 1 / (4 * Math.PI);
    }
}
