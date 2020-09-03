package Task1;

public class Poem {
    private final String[] lines;

    public Poem(String[] initStrings) {
        lines = initStrings.clone();
    }

    public void checkEasy() {
        for (int i = 0; i < lines.length - 1; i++) {
            if (lines[i].length() < 3)
                continue;
            for (int j = i + 1; j < lines.length; j++) {
                if (lines[j].length() < 3)
                    continue;
                if (lines[i].substring(lines[i].length() - 3).equals(lines[j].substring(lines[j].length() - 3))) {
                    System.out.println("строка " + (i + 1) + " рифмуется со строкой " + (j + 1));
                }
            }
        }
    }

    public void checkHard() {
        final String SAFE_WORDS = ".,!?; ";
        final String EYUOAI = "eyuoai";
        String[] newLines = lines;

        for (int i = 0; i < newLines.length; i++) {
            for (int j = 0; j < SAFE_WORDS.length(); j++) {
                if (newLines[i].length() == 0)
                    continue;
                if (SAFE_WORDS.contains(newLines[i].substring(newLines[i].length() - 1))) {
                    newLines[i] = newLines[i].substring(0, newLines[i].length() - 1);
                }
            }
        }

        for (int i = 0; i < lines.length - 1; i++) {
            if (lines[i].length() < 3)
                continue;

            for (int j = i + 1; j < lines.length; j++) {
                if (lines[j].length() < 3)
                    continue;

                int k = newLines[i].length() - 1;
                int n = newLines[j].length() - 1;
                while (!EYUOAI.contains(Character.toString(newLines[i].charAt(k))) && k != 0) { k--; }
                while (!EYUOAI.contains(Character.toString(newLines[j].charAt(n)))  && n != 0) { n--; }

                if (lines[i].substring(k).equals(lines[j].substring(n))) {
                    System.out.println("строка " + (i + 1) + " рифмуется со строкой " + (j + 1));
                }
            }
        }
    }
}

