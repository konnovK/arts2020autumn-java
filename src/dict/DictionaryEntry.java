package dict;

public class DictionaryEntry {
    private String word;
    private String translation;

    public DictionaryEntry(String word, String translation) {
        this.word = word;
        this.translation = translation;
    }

    public String getTranslation() {
        return translation;
    }

    public String getWord() {
        return word;
    }
}
