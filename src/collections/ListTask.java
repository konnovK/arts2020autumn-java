package collections;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListTask {

    public static void printList(List<Object> list) {
        System.out.println("элементов в списке: " + list.size());

        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static void printListWithIndices(List<Object> list) {
        System.out.println("элементов в списке: " + list.size());

        int i = 1;
        for (Object o : list) {
            System.out.println(i++ + ": " + o);
        }
    }


    public static List<Integer> list1to100() {
        return Stream.iterate(1, x -> x + 1).limit(100).collect(Collectors.toList());
    }


    public static List<Object> concat(List<Object> list1, List<Object> list2) {
        List<Object> res = new ArrayList<>(list1);
        res.addAll(list2);
        return res;
    }

    public static List<Object> reverse(List<Object> list) {
        List<Object> res = new ArrayList<>(list);
        Collections.reverse(res);
        return res;
    }

    public static void reverse_(List<Object> list) {
        Collections.reverse(list);
    }

    public static List<String> removeEven1(List<String> list) {
        var res = new ArrayList<>(list);
        for (int i = 0; i < res.size(); i++) {
            res.remove(i);
        }
        return res;
    }

    public static void removeEven1_(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            list.remove(i);
        }
    }

    public static List<String> removeEven2(List<String> list) {
        return list.stream()
                .filter(x ->
                        (
                            x.chars()
                                .map(c -> (char) c)
                                .filter(Character::isDigit)
                                .toArray()
                                .length
                        !=
                            x.chars()
                                .toArray()
                                .length
                        ) || Integer.parseInt(x) % 2 == 1
                )
                .collect(Collectors.toList());
    }

    public static void removeEven2_(List<String> list) {
        var cloneList = new ArrayList<>(list);
        list.clear();
        list.addAll(
                cloneList.stream()
                        .filter(x ->
                                (
                                    x.chars()
                                        .map(c -> (char) c)
                                        .filter(Character::isDigit)
                                        .toArray()
                                        .length
                                !=
                                    x.chars()
                                        .toArray()
                                        .length
                                ) || Integer.parseInt(x) % 2 == 1
                        )
                        .collect(Collectors.toList())
        );
    }

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
        printListWithIndices(List.of("abc", "xyz", "ooo"));

        System.out.println("###\nTASK 1:");
        System.out.println(list1to100());
        System.out.println("###\nTASK 2:");
        System.out.println(concat(List.of(1,2,3), List.of(4,5,6)));
        System.out.println("###\nTASK 4:");
        System.out.println("-- 4_1:");
        System.out.println(reverse(List.of(1,2,3,4,5)));

        List<Object> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        System.out.println("-- 4_2:");
        reverse_(l);
        System.out.println(l);

        List<String> l2 = new ArrayList<>();
        l2.add("0");
        l2.add("qq");
        l2.add("2");
        l2.add("3");
        l2.add("4");
        l2.add("5");
        System.out.println("###\nTASK 5:");
        System.out.println("-- 5_1_1\nafter:");
        System.out.println(removeEven1(l2));
        System.out.println("before:");
        System.out.println(l2);
        System.out.println("-- 5_2_1\nafter:");
        System.out.println(removeEven2(l2));
        System.out.println("before:");
        System.out.println(l2);
        System.out.println("-- 5_2_2");
        removeEven2_(l2);
        System.out.println(l2);

        List<Integer> l3 = new ArrayList<>();
        l3.add(0);
        l3.add(1);
        l3.add(2);
        l3.add(3);
        l3.add(4);
        l3.add(5);
        System.out.println("-- 5_3_1\nafter:");
        System.out.println(removeEven3(l3));
        System.out.println("before:");
        System.out.println(l3);
        System.out.println("-- 5_3_2");
        removeEven3_(l3);
        System.out.println(l3);

//        System.out.println("###\nTASK 6:");
//        files("task2text.txt");
    }
}
