package Task4.figure;

public class RightTriangle extends Rectangle {

    public RightTriangle(double a, double b) {
        super(a, b);
    }

    @Override
    public double area() {
        return super.area() / 2;
    }

    @Override
    public double perimeter() {
        return (super.perimeter() / 2) + Math.sqrt(a*a + b*b);
    }

    @Override
    public String info() {
        return "я прямоугольный треугольник со сторонами " + a + " и " + b;
    }
}
