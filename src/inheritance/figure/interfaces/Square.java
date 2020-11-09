package inheritance.figure.interfaces;

public interface Square extends Rectangle, Rhombus {

    @Override
    default double getB() {
        return getA();
    }

    @Override
    default double getD1() {
        return Math.sqrt(2) * getA();
    }

    @Override
    default double getD2() {
        return getD1();
    }

    @Override
    default double perimeter() {
        return 4 * getA();
    }

    @Override
    default double area() {
        return getA() * getA();
    }

    static Square create(double a) {
        return () -> a;
    }
}
