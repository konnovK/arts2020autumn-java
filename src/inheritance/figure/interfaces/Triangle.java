package inheritance.figure.interfaces;

public interface Triangle extends Figure {

    double getA();

    double getB();

    double getC();

    @Override
    default double perimeter() {
        return getA() + getB() + getC();
    }

    @Override
    default double area() {
        var p = perimeter() / 2;
        return p * (p - getA()) * (p - getB()) * (p - getC());
    }
}