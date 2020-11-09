package inheritance.figure.interfaces;

public interface Rhombus extends Figure {

    double getD1();

    double getD2();

    @Override
    default double perimeter() {
        return Math.sqrt(getD1() * getD1() / 4 + getD2() * getD2() / 4) * 4;
    }

    @Override
    default double area() {
        return (getD1() * getD2()) / 2;
    }

    static Rhombus create(double d1, double d2) {
        return new Rhombus() {
            @Override
            public double getD1() {
                return d1;
            }

            @Override
            public double getD2() {
                return d2;
            }
        };
    }
}
