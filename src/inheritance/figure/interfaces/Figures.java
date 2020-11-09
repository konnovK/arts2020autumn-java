package inheritance.figure.interfaces;

public class Figures {
    public static void main(String[] args) {
        Figure[] fs = new Figure[6];

        fs[0] = Circle.create(1);
        fs[1] = Rectangle.create(4,5);
        fs[2] = Square.create(1);
        fs[3] = Rhombus.create(4,4);
        fs[4] = RegularTriangle.create(1);
        fs[5] = RightTriangle.create(3,4);

        for (var f : fs) {
            System.out.println(f.area());
            System.out.println(f.perimeter());
            System.out.println(f.capacity());
            System.out.println("###");
        }
    }
}
