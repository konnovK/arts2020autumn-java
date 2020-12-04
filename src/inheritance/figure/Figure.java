package inheritance.figure;

import inheritance.printable.Printable;

public interface Figure extends Printable {

    double area();

    double perimeter();

    String info();

    static double capacity1(Figure f) {
        return f.area() / (f.perimeter() * f.perimeter());
    }

    default double capacity2() {
        return this.area() / (this.perimeter() * this.perimeter());
    }

    @Override
    default void print() {
        System.out.println(
                        this.info() +
                        "\narea: " + this.area() +
                        "\nperimeter: " + this.perimeter() +
                        "\ncapacity1: " + Figure.capacity1(this) +
                        "\ncapacity2: " + this.capacity2() + "\n###"
        );
    }
}
