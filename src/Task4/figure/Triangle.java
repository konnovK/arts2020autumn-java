package Task4.figure;

public abstract class Triangle implements Figure {
    protected double a;
    protected double b;
    protected double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double perimeter() {
        return a + b + c;
    }

    @Override
    public double area() {
        var p = perimeter() / 2;
        return p * (p - a) * (p - b) * (p - c);
    }

    @Override
    public String info() {
        return "я треугольник со сторонами " + a + ", " + b + ", и " + c;
    }
}
