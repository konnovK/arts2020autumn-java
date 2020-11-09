package maps;

import java.io.File;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapTask {
    private static final String[] ENG = new String[]{"a", "b", "v", "g", "d", "e", "e", "zh", "z", "i", "i", "k", "l", "m", "n", "o", "p", "r", "s", "t", "u", "f", "kh", "ts", "ch", "sh", "shch", "ie", "y", "", "e", "iu", "ia"};
    private static final char[] RU = new char[]{'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'};
    private static Map<Character, String> getTranslateMap() {
        Map<Character, String> trans = new TreeMap<>();
        for (int i = 0; i < RU.length; i++) {
            trans.put(RU[i], ENG[i]);
            trans.put(
                    Character.toUpperCase(RU[i]),
                    ENG[i].length() != 0 ? ENG[i].substring(0, 1).toUpperCase().concat(ENG[i].substring(1)) : ""
            );
        }
        return trans;
    }


    public static String translateWord(String in) {
        Map<Character, String> trans = getTranslateMap();
        return in.chars().mapToObj(c -> (char) c).map(trans::get).collect(Collectors.joining(""));
    }


    public static void translateText(String inputPath, String outputPath) {
        Map<Character, String> trans = getTranslateMap();

        StringBuilder out = new StringBuilder();
        try(
                Scanner scanner = new Scanner(new File(inputPath));
                PrintStream printStream = new PrintStream(outputPath, StandardCharsets.UTF_8)
        ) {
            while (scanner.hasNextLine()) {
                char[] line = scanner.nextLine().toCharArray();
                for(char c : line) {
                    out.append(trans.containsKey(c) ? trans.get(c) : c);
                }
                out.append('\n');
            }

            Stream.of(out.toString().split(" "))
                    .map(str ->
                            (str.length() -
                            str.chars().map(c -> (char) c).filter(Character::isUpperCase).toArray().length > 1)
                                    ? str
                                    : str.toUpperCase()
                    ).forEach(str -> printStream.print(str + " "));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static Map<Character, Integer> charFreq(String str) {
        Map<Character, Integer> outMap = new TreeMap<>();
        str.chars().mapToObj(c -> (char) c).forEach(c -> outMap.put(c, outMap.containsKey(c) ? outMap.get(c) + 1 : 1));
        return outMap;
    }


    public static Map<Character, List<Integer>> charIndexes(String str) {
        Map<Character, List<Integer>> outMap = new TreeMap<>();
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            outMap.put(c, outMap.containsKey(c) ? concatList(outMap.get(c), List.of(i)) : List.of(i));
        }
        return outMap;
    }


    public static List<Integer> concatList(List<Integer> list1, List<Integer> list2) {
        List<Integer> res = new ArrayList<>(list1);
        res.addAll(list2);
        return res;
    }


    public static Map<String, Integer> wordFreq(String inputPath) {
        Map<String, Integer> wordFreqMap = new TreeMap<>();
        try(Scanner scanner = new Scanner(new File(inputPath))) {
            scanner.useDelimiter("[, !?.()\"'\n\r]+");
            scanner.tokens()
                    .filter(str -> str.length() > 0)
                    .forEach(str -> wordFreqMap.put(str, wordFreqMap.containsKey(str) ? wordFreqMap.get(str) + 1 : 1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wordFreqMap;
    }

    public static void wordFreq2(String inputPath) {
        Map<String, Integer> wordFreqHashMap = new HashMap<>();
        Map<String, Integer> wordFreqLinkedHashMap = new LinkedHashMap<>();
        Map<String, Integer> wordFreqTreeMap = new TreeMap<>();
        try(Scanner scanner = new Scanner(new File(inputPath))) {
            scanner.useDelimiter("[, !?.()\"'\n\r]+");

            scanner.tokens()
                    .filter(str -> str.length() > 0)
                    .forEach(str -> {
                        wordFreqHashMap
                                .put(str, wordFreqHashMap.containsKey(str) ? wordFreqHashMap.get(str) + 1 : 1);
                        wordFreqLinkedHashMap
                                .put(str, wordFreqLinkedHashMap.containsKey(str) ? wordFreqLinkedHashMap.get(str) + 1 : 1);
                        wordFreqTreeMap
                                .put(str, wordFreqTreeMap.containsKey(str) ? wordFreqTreeMap.get(str) + 1 : 1);
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(wordFreqHashMap);
        System.out.println(wordFreqLinkedHashMap);
        System.out.println(wordFreqTreeMap);
    }


    public static void printSortedMap(Map<String, Integer> map) {
        var list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> - o1.getValue().compareTo(o2.getValue()));
        System.out.println(list);
    }


    public static void main(String[] args) {
        System.out.println(translateWord("привет"));
        translateText("in.txt", "out.txt");
        System.out.println(charFreq("banana"));
        System.out.println(charIndexes("banana"));
        wordFreq2("in.txt");
        printSortedMap(wordFreq("in.txt"));
    }
}
