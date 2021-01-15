import java.util.*;

public class LinkedListProgram {

    public static void main(String[] args) {

        //creates an empty linked list.
        LinkedList<Character> list = new LinkedList<>();

        for(char ch = 'A'; ch<='E'; ch++)
            list.addLast(ch); //same as list.add(ch);

        System.out.println(list);

        for(char ch= 'F'; ch<='K'; ch++)
            list.addFirst(ch);

        System.out.println(list);

        //NOTE: ArrayList doesn't have addFirst, removeFirst. why?

        char firstChar  = list.removeFirst();

        System.out.println("The character that was removed was " + firstChar);





        printAllElementsBad(list);

        printAllElementsGood(list);

        experiment();

    }

    public static void experiment() {
        LinkedList<Long> list = new LinkedList<>();

        for(long i = 0L; i<=1000000L; i++)
            list.add(i);

        long startTime = System.currentTimeMillis();

        printAllElementsGood(list);

        long endTime = System.currentTimeMillis();

        System.err.println("The good algorithm took " + (endTime - startTime) / 1000.0 + " seconds");

        startTime = System.currentTimeMillis();

        printAllElementsBad(list);

        endTime = System.currentTimeMillis();

        System.err.println("The bad algorithm took " + (endTime - startTime) / 1000.0 + " seconds");


    }

    public static <E> void printAllElementsBad(LinkedList<E> list) {
        for(int i=0; i<list.size(); i++)
            System.out.println(list.get(i));

    }

    public static <E> void printAllElementsGood(LinkedList<E> list) {

        for(Iterator<E> it = list.iterator(); it.hasNext(); )
            System.out.println(it.next());
    }



}
