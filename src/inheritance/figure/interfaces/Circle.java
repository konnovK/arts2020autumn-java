package inheritance.figure.interfaces;

public interface Circle extends Figure {

    double getR();

    @Override
    default double perimeter() {
        return 2 * Math.PI * getR();
    }

    @Override
    default double area() {
        return Math.PI * getR() * getR();
    }

    static Circle create(double r) {
        return () -> r;
    }
}
