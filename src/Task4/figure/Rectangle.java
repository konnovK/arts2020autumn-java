package Task4.figure;

public class Rectangle extends Parallelogram {

    public Rectangle(double a, double b) {
        super(a, b);
    }

    @Override
    public double area() {
        return a * b;
    }

    @Override
    public String info() {
        return "я прямоугольник со сторонами " + a + " и " + b;
    }
}
