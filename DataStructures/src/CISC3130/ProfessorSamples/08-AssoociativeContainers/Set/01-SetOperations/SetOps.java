import java.util.*;

public class SetOps {

    public static void main(String[] args) {
        Set<Integer> treeSet, hashSet;

        treeSet = new TreeSet<>();
        hashSet = new HashSet<>();

        for(String arg: args) {
            int value = Integer.parseInt(arg);
            treeSet.add(value);
            hashSet.add(value);
        }

        //print both out and notice the order.
        printSet(treeSet);

        printSet(hashSet);

        //do some checks on contains

        if(hashSet.contains(10))
            System.out.println(10 + " is in the set.");
        else
            System.out.println(10 + " is not in the set.");


        //do union and intersection

        Integer[] numbers = {2, 4, 6, 8, 10};

        List<Integer> numList = Arrays.asList(numbers);

        //hashSet = hashSet union numList
        hashSet.addAll(numList);

        //treeSet = treeSet intersect numList
        treeSet.retainAll(numList);

        printSet(hashSet);

        printSet(treeSet);
    }

    private static void printSet(Set<Integer> set) {
        for(int value: set)
            System.out.print(value + " ");
        System.out.println();
    }
}
