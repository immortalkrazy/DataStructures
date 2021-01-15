import java.util.*;

public class ArrayListProgram {

    public static void main(String[] args) {
        //arrList is the empty list
        ArrayList<Integer> arrList = new ArrayList<>();

        //arrList2 starts out with initial capacity of 10, but with nothing in it
        ArrayList<Integer> arrList2 = new ArrayList<>(25);

        //append the numbers 10 to 19 to the end of the ArrayList
        for(int i=0; i<10; i++)
            arrList2.add(i+10);

        System.out.println(arrList2);

        arrList2.remove(arrList2.size()-1);

        System.out.println(arrList2);

        //This remove method removes an Object rather than an index.  Because this method expects an Object
        //and not an int, passing it an int will assume you want to remove by index.

        arrList2.remove(new Integer(12));

        System.out.println(arrList2);

        incrementAllElements(arrList2);

        incrementAllElements2(arrList2);

        System.out.println(arrList2);

        printAllElementsReverse(arrList2);
    }

    public static void incrementAllElements(ArrayList<Integer> arrList) {

        for(int i=0; i<arrList.size(); i++)
            arrList.set(i, arrList.get(i) + 1);

    }

    public static void incrementAllElements2(ArrayList<Integer> arrList) {
        ListIterator<Integer> it = arrList.listIterator();

        while(it.hasNext()) {
            int number = it.next();

            it.set(number + 1);
        }
    }

    public static <E> void printAllElementsReverse(ArrayList<E> arr) {
        ListIterator<E> it = arr.listIterator(arr.size());

        while(it.hasPrevious())
            System.out.print(it.previous() + " ");

        System.out.println();

    }


}
