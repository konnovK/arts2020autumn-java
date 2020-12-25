package dict;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Dictionaries {
    public static void main(String[] args) {
        List<DictionaryEntry> des = new ArrayList<>();

        final String PATH = "./dictionary.txt";
        final String QUERIES = "./strict-queries.txt";
        final String FULL_TEXT_SEARCH_QUERIES = "./full-text-search.txt";


        try (Scanner scanner = new Scanner(new File(PATH))) {
            scanner.useDelimiter("\n");
            scanner.tokens().forEach(line -> {
                var words = line.split(" ");
                des.add(
                        new DictionaryEntry(
                                words[0].toLowerCase().trim(),
                                String.join(" ", Arrays.copyOfRange(words, 1, words.length)
                                )
                        )
                );
            });
        } catch (FileNotFoundException e) {
            System.out.println("проблема при чтении файла");
            return;
        }


        var map = listToMap(des);


        // обычный поиск
        try (
                Scanner scanner = new Scanner(new File(QUERIES));
                PrintStream ps = new PrintStream("./outQueries.txt", StandardCharsets.UTF_8)
        ) {
            scanner.tokens().forEach(word -> {
                String translation = map.getOrDefault(word.toLowerCase().trim(), null);
                if (translation != null)
                    ps.print(word + ": " + translation);
            });
        } catch (IOException ignored) {
        }


        System.out.println("#");


        // полный поиск (медленно, только для 10-ти)
        try (
                Scanner scanner = new Scanner(new File(FULL_TEXT_SEARCH_QUERIES));
                PrintStream ps = new PrintStream("./outFullTextQueries.txt", StandardCharsets.UTF_8)
        ) {
            scanner.tokens().limit(10).forEach(word ->
                    map.keySet().stream()
                            .filter(key -> key.contains(word.toLowerCase().trim()))
                            .forEach(key -> {
                                String translation = map.getOrDefault(key.toLowerCase(), null);
                                if (translation != null) ps.print(word + ": " + translation);
                            })
            );
        } catch (IOException ignored) {
        }
    }

    private static Map<String,String> listToMap(List<DictionaryEntry> list) {
        Map<String,String> tmp = new HashMap<>();
        list.forEach(de -> tmp.put(de.getWord(), de.getTranslation()));
        return tmp;
    }
}
