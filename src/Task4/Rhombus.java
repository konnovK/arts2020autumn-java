package Task4;

public class Rhombus extends Parallelogram {


    private final double d1;
    private final double d2;

    public Rhombus(double d1, double d2) {
        super(Math.sqrt(d1 * d1 / 4 + d2 * d2 / 4), Math.sqrt(d1 * d1 / 4 + d2 * d2 / 4));

        this.d1 = d1;
        this.d2 = d2;
    }


    @Override
    public double area() {
        return (d1 * d2) / 2;
    }

    @Override
    public String info() {
        return "я ромб со стороной " + a + " и диагоналями " + d1 + " и " + d2;
    }
}
