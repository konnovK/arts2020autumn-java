package Task4.figure;

public class RightTriangle extends Triangle {

    public RightTriangle(double a, double b) {
        super(a, b, Math.sqrt(a*a + b*b));
    }
}
