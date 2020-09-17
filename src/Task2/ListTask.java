package Task2;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListTask {

    // 1
    // 1..100
    public static List<Integer> task1() {
        return Stream.iterate(1, x -> x + 1).limit(100).collect(Collectors.toList());
    }

    // 2
    // concat
    public static List<Object> task2(List<Object> list1, List<Object> list2) {
        List<Object> res = new ArrayList<>();
        res.addAll(list1);
        res.addAll(list2);
        return res;
    }

    // 4
    // reverse pure
    public static List<Object> task4_1(List<Object> list) {
        List<Object> res = new ArrayList<>(list);
        Collections.reverse(res);
        return res;
    }

    // 4
    // reverse
    public static void task4_2(List<Object> list) {
        Collections.reverse(list);
    }

    // 5
    // remove even 1 pure
    public static List<String> task5_1_1(List<String> list) {
        var res = new ArrayList<>(list);
        for (int i = 0; i < res.size(); i++) res.remove(i);
        return res;
    }

    // 5
    // remove even 1
    public static void task5_1_2(List<String> list) {
        for (int i = 0; i < list.size(); i++) list.remove(i);
    }

    // 5
    // remove even 2 pure
    public static List<String> task5_2_1(List<String> list) {
        return list.stream().filter(x -> x.chars().map(c -> (char) c).filter(Character::isDigit).toArray().length != x.chars().toArray().length || Integer.parseInt(x) % 2 == 1).collect(Collectors.toList());
    }

    // 5
    // remove even 2
    public static void task5_2_2(List<String> list) {
        var cloneList = new ArrayList<>(list);
        list.clear();
        list.addAll(cloneList.stream().filter(x -> x.chars().map(c -> (char) c).filter(Character::isDigit).toArray().length != x.chars().toArray().length || Integer.parseInt(x) % 2 == 1).collect(Collectors.toList()));
    }

    // 5
    // remove even 3 pure
    public static List<Integer> task5_3_1(List<Integer> list) {
        return list.stream().filter(x -> x % 2 == 1).collect(Collectors.toList());
    }

    // 5
    // remove even 3
    public static void task5_3_2(List<Integer> list) {
        var cloneList = new ArrayList<>(list);
        list.clear();
        list.addAll(cloneList.stream().filter(x -> x % 2 == 1).collect(Collectors.toList()));
    }

    public static void t6(String path) {
        HashSet<String> hashSet = new HashSet<>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();
        try(Scanner scanner = new Scanner(new File(path))) {
            for (String str : scanner.tokens().collect(Collectors.toList())) {
                hashSet.add(str);
                linkedHashSet.add(str);
                treeSet.add(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (String str: hashSet) {
            System.out.println(str);
        }
        System.out.println("##########################");
        for (String str: linkedHashSet) {
            System.out.println(str);
        }
        System.out.println("##########################");
        for (String str: treeSet) {
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        System.out.println(task1());
        System.out.println(task2(List.of(1,2,3), List.of(4,5,6)));
        System.out.println(task4_1(List.of(1,2,3,4,5)));

        List<Object> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        task4_2(l);
        System.out.println(l);

        List<String> l2 = new ArrayList<>();
        l2.add("0");
        l2.add("qq");
        l2.add("2");
        l2.add("3");
        l2.add("4");
        l2.add("5");
        System.out.println(task5_1_1(l2));
        System.out.println(l2);
        System.out.println(task5_2_1(l2));
        System.out.println(l2);
        task5_2_2(l2);
        System.out.println(l2);

        List<Integer> l3 = new ArrayList<>();
        l3.add(0);
        l3.add(1);
        l3.add(2);
        l3.add(3);
        l3.add(4);
        l3.add(5);
        System.out.println(task5_3_1(l3));
        task5_3_2(l3);
        System.out.println(l3);

        t6("task2text.txt");
    }
}
