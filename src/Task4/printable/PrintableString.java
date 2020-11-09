package Task4.printable;

public class PrintableString implements Printable {

    private final String str;

    public PrintableString(String str) {
        this.str = str;
    }

    @Override
    public void print() {
        System.out.println(str);
    }
}
