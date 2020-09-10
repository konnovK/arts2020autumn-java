package Task2;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListTask {

    // 1
    public static List<Integer> t1() {
        return Stream.iterate(1, x -> x + 1).limit(100).collect(Collectors.toList());
    }

    // 2
    public static List<Object> t2(List<Object> list1, List<Object> list2) {
        List<Object> res = new ArrayList<>();
        res.addAll(list1);
        res.addAll(list2);
        return res;
    }

    // 4
    public static List<Object> t4_1(List<Object> list) {
        List<Object> res = new ArrayList<>(list);
        Collections.reverse(res);
        return res;
    }

    // 4
    public static void t4_2(List<Object> list) {
        Collections.reverse(list);
    }

    // 5
    public static List<String> t5_1_1(List<String> list) {
        var res = new ArrayList<>(list);
        for (int i = 0; i < res.size(); i++) res.remove(i);
        return res;
    }

    // 5
    public static List<String> t5_2_1(List<String> list) {
        return list.stream().filter(x -> Integer.parseInt(x) % 2 == 1).collect(Collectors.toList());
    }

    // 5
    public static List<Integer> t5_3_1(List<Integer> list) {
        return list.stream().filter(x -> x % 2 == 1).collect(Collectors.toList());
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
        System.out.println(t1());
        System.out.println(t2(List.of(1,2,3), List.of(4,5,6)));
        System.out.println(t4_1(List.of(1,2,3,4,5)));

        List<Object> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        t4_2(l);
        System.out.println(l);

        List<String> l2 = new ArrayList<>();
        l2.add("0");
        l2.add("1");
        l2.add("2");
        l2.add("3");
        l2.add("4");
        l2.add("5");
        System.out.println(t5_1_1(l2));
        System.out.println(l2);
        System.out.println(t5_2_1(l2));
        System.out.println(l2);

        List<Integer> l3 = new ArrayList<>();
        l3.add(0);
        l3.add(1);
        l3.add(2);
        l3.add(3);
        l3.add(4);
        l3.add(5);
        System.out.println(t5_3_1(l3));
        
        t6("task2text.txt");
    }
}
