package inheritance.figure;

import java.util.Arrays;

public class Figures {
    public static void main(String[] args) {
        Figure[] fs = new Figure[6];

        fs[0] = new Circle(10);
        fs[1] = new Rectangle(3,4);
        fs[2] = new Square(4);
        fs[3] = new Rhombus(6,8);
        fs[4] = new RegularTriangle(1);
        fs[5] = new RightTriangle(3,4);

        Arrays.stream(fs).forEach(Figures::printInfo);
    }

    private static void printInfo(Figure f) {
        System.out.println(
                f.info() +
                        "\narea: " + f.area() +
                        "\nperimeter: " + f.perimeter() +
                        "\ncapacity1: " + Figure.capacity1(f) +
                        "\ncapacity2: " + f.capacity2() + "\n###"
        );
    }
}
