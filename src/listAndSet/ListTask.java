package listAndSet;

import java.io.File;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListTask {

    public static void printList(List<?> list) {
        System.out.println("элементов в списке: " + list.size());
        list.forEach(System.out::println);
    }


    public static void printListWithIndices(List<?> list) {
        System.out.println("элементов в списке: " + list.size());
        AtomicInteger i = new AtomicInteger();
        list.forEach((e) -> System.out.println(i.getAndIncrement() + ": " + e));
    }


    public static List<Integer> list1to100() {
        return Stream.iterate(1, x -> x + 1).limit(100).collect(Collectors.toList());
    }


    public static <T> List<T> concat(List<T> list1, List<T> list2) {
        List<T> res = new ArrayList<>(list1);
        res.addAll(list2);
        return res;
    }


    public static <T> List<T> reverse(List<T> list) {
        List<T> res = new ArrayList<>(list);
        Collections.reverse(res);
        return res;
    }


    public static void reverse_(List<?> list) {
        Collections.reverse(list);
    }


    public static List<String> removeEven1(List<String> list) {
        var res = new ArrayList<>(list);
        Stream.iterate(0, x -> x + 1).limit((res.size() / 2) + 1).forEach(i -> {
            if (i < res.size()) res.remove((int) i);
        });
        return res;
    }


    public static void removeEven1_(List<String> list) {
        Stream.iterate(0, x -> x + 1).limit((list.size() / 2) + 1).forEach(i -> {
            if (i < list.size()) list.remove((int) i);
        });
    }


    public static List<String> removeEven2(List<String> list) {
        return list.stream().filter(isNotEvenNumber).collect(Collectors.toList());
    }


    public static void removeEven2_(List<String> list) {
        var cloneList = new ArrayList<>(list);
        list.clear();
        list.addAll(cloneList.stream().filter(isNotEvenNumber).collect(Collectors.toList()));
    }


    // тот порядок размещения полей и методов в классе нарушен, чтобы поле было ближе к методам, в которых используется
    private static final Predicate<String> isNotEvenNumber = str -> {
        Predicate<String> isNumber = str1 -> str1.chars().map(c -> (char) c).filter(Character::isDigit).toArray().length == str1.length();
        return !isNumber.test(str) || Integer.parseInt(str) % 2 == 1;
    };


    public static List<Integer> removeEven3(List<Integer> list) {
        return list.stream().filter(x -> x % 2 == 1).collect(Collectors.toList());
    }


    public static void removeEven3_(List<Integer> list) {
        var cloneList = new ArrayList<>(list);
        list.clear();
        list.addAll(cloneList.stream().filter(x -> x % 2 == 1).collect(Collectors.toList()));
    }


    public static void files(String path) {
        HashSet<String> hashSet = new HashSet<>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();
        try(Scanner scanner = new Scanner(new File(path))) {
            scanner.tokens().forEach((str) -> {
                hashSet.add(str);
                linkedHashSet.add(str);
                treeSet.add(str);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        hashSet.forEach(System.out::println);
        System.out.println();
        linkedHashSet.forEach(System.out::println);
        System.out.println();
        treeSet.forEach(System.out::println);
    }


    public static void main(String[] args) {
        printList(List.of("abc", "xyz", "ooo"));
        System.out.println("###");
        printListWithIndices(List.of("abc", "xyz", "ooo"));

        System.out.println("###\nlist 1 to 100:");
        System.out.println(list1to100());

        System.out.println("###\nconcat:");
        var concatList = concat(List.of(1,2,3), List.of(4,5,6));
        var concatList2 = concat(List.of("qq", "ww", "ee"), List.of(2));
        System.out.println(concatList);
        System.out.println(concatList.get(0).getClass());
        System.out.println(concatList2);
        System.out.println(concatList2.get(0).getClass());

        System.out.println("###\nreverse:");
        System.out.println("- pure f:");
        System.out.println(reverse(List.of(1,2,3,4,5)));
        System.out.println("- in place f:");
        List<String> l = new ArrayList<>();
        l.add("1");
        l.add("2");
        l.add("3");
        l.add("4");
        l.add("5");
        reverse_(l);
        System.out.println(l);

        List<String> l2 = new ArrayList<>();
        l2.add("0");
        l2.add("qq");
        l2.add("2");
        l2.add("3");
        l2.add("4");
        l2.add("5");
        System.out.println("###\nkill even:");
        System.out.println("- 1 pure f\nafter:");
        System.out.println(removeEven1(l2));
        System.out.println("before:");
        System.out.println(l2);
        System.out.println("- 2 pure f\nafter:");
        System.out.println(removeEven2(l2));
        System.out.println("before:");
        System.out.println(l2);
        System.out.println("- 2 in place f");
        removeEven2_(l2);
        System.out.println(l2);

        List<Integer> l3 = new ArrayList<>();
        l3.add(0);
        l3.add(1);
        l3.add(2);
        l3.add(3);
        l3.add(4);
        l3.add(5);
        System.out.println("- 3 pure f\nafter:");
        System.out.println(removeEven3(l3));
        System.out.println("before:");
        System.out.println(l3);
        System.out.println("- 3 in place f");
        removeEven3_(l3);
        System.out.println(l3);

        System.out.println("###\nset of words:");
        files("task2text.txt");
    }
}
