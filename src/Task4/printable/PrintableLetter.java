package Task4.printable;

public class PrintableLetter extends PrintableString {

    public PrintableLetter(char c, int count) {
        super(String.valueOf(c).repeat(Math.max(0, count)));
    }
}
