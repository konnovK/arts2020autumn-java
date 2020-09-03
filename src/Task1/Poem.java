package Task1;

public class Poem {
    private static String[] strings;

    public Poem(String[] initStrings) {
        strings = initStrings;
    }

    public void check() {
        for (int i = 0; i < strings.length - 1; i++) {
            for (int j = i + 1; j < strings.length; j++) {
                if (0 == strings[i].substring(strings[i].length() - 3).compareTo(strings[j].substring(strings[j].length() - 3))) {
                    System.out.println("строка " + (i + 1) + " рифмуется со строкой " + (j + 1));
                }
            }
        }
    }
}

