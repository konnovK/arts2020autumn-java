package inheritance.figure.interfaces;

public interface Parallelogram extends Figure {

    double getA();

    double getB();

    @Override
    double perimeter();

    @Override
    double area();
}
