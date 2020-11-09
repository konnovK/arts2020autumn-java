package inheritance.figure.interfaces;

public interface RightTriangle extends Triangle {

    @Override
    default double getC() {
        return Math.sqrt(getA()*getA() + getB()*getB());
    }

    static RightTriangle create(double a, double b) {
        return new RightTriangle() {
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
