import java.util.*;

public class UseSet {

    private static <E> void print(Set<E> set) {

        for (E e: set) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    public static void main (String[] args) {

        Set<Integer> tSet;
        Set<Integer> hSet;

        tSet = new TreeSet<>();
        hSet = new HashSet<>();

        Random rnd = new Random();

        // for (int i = 0; i < 5; i++) {
        //     tSet.add(rnd.nextInt(50) + 1);
        // }
        //
        // for (int i = 0; i < 5; i++) {
        //     hSet.add(rnd.nextInt(50) + 1);
        // }

        tSet.add(2);
        tSet.add(4);
        tSet.add(6);
        tSet.add(9);
        tSet.add(10);
        tSet.insert(55);

        hSet.add(1);
        hSet.add(3);
        hSet.add(5);
        hSet.add(7);
        hSet.add(9);



        print(tSet);
        print(hSet);
        tSet.addAll(hSet);
        print(tSet);
    }
}
