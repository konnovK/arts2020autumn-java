package Task4.figure;

public interface Figure {

    double area();

    double perimeter();

    String info();

    static double capacity1(Figure f) {
        return f.area() / (f.perimeter() * f.perimeter());
    }

    default double capacity2() {
        return this.area() / (this.perimeter() * this.perimeter());
    }
}
