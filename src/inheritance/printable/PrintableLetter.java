package inheritance.printable;

public class PrintableLetter extends PrintableString {

    public PrintableLetter(char c, int count) {
        super(String.valueOf(c).repeat(count));
    }
}
