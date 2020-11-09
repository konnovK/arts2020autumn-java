package inheritance.figure.interfaces;

public interface RegularTriangle extends Triangle {

    @Override
    default double getB() {
        return getA();
    }

    @Override
    default double getC() {
        return getA();
    }

    static RegularTriangle create(double a) {
        return () -> a;
    }
}
