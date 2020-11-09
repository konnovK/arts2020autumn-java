package Task4.figure.interfaces;

public interface Figure {

    double area();

    double perimeter();

    default double capacity() {
        return this.area() / (this.perimeter() * this.perimeter());
    }

}
