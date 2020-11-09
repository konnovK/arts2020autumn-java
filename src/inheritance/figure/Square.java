package inheritance.figure;

public class Square extends Rectangle {
    public Square(double a) {
        super(a, a);
    }

    @Override
    public String info() {
        return "я квадрат со стороной " + a;
    }
}
