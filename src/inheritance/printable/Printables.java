package inheritance.printable;

import java.util.Arrays;

public class Printables {
    public static void main(String[] args) {
        Printable[] ps = new Printable[4];

        ps[0] = new PrintableLetter('c', 10);
        ps[1] = new PrintableString("qwerty");
        ps[2] = new Printable() {
            @Override
            public void print() {
                System.out.println("banana");
            }
        };
        ps[3] = () -> System.out.println("qqq");

        Arrays.stream(ps).forEach(Printable::print);
    }
}
