package Task4.figure.interfaces;

public interface Rectangle extends Parallelogram {

    @Override
    default double perimeter() {
        return 2 * (getA() + getB());
    }

    @Override
    default double area() {
        return getA() * getB();
    }

    static Rectangle create(double a, double b) {
        return new Rectangle() {
            @Override
            public double getA() {
                return a;
            }

            @Override
            public double getB() {
                return b;
            }
        };
    }
}
