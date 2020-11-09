package Task4.figure;

public class RegularTriangle implements Figure {

    private final double a;

    public RegularTriangle(double a) {
        this.a = a;
    }

    @Override
    public double area() {
        return Math.sqrt(3) * a*a / 4;
    }

    @Override
    public double perimeter() {
        return 3 * a;
    }

    @Override
    public String info() {
        return "я правильный треугольник со стороной " + a;
    }
}
