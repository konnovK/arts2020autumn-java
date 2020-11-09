package Task4.figure;

public class RightTriangle implements Figure {

    private final double a;
    private final double b;

    public RightTriangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double area() {
        return (a * b) / 2;
    }

    @Override
    public double perimeter() {
        return a + b + Math.sqrt(a*a + b*b);
    }

    @Override
    public String info() {
        return "я прямоугольный треугольник со сторонами " + a + " и " + b;
    }
}
