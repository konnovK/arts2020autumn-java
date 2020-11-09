package Task4.figure;

public abstract class Parallelogram implements Figure {

    protected double a;
    protected double b;

    public Parallelogram(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double perimeter() {
        return 2 * (a + b);
    }

    public abstract double area();
}
