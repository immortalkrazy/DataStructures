import java.util.*;

class A{}
public class InsertionSort {


      public static <E extends Comparable<E>> void insertionSort (E[] e) {

            for (int i = 1; i < e.length; i++) {

                  E key = e[i];
                  int loc = i - 1;

                  while (loc >= 0 && key.compareTo(e[loc]) < 0) {

                        e[loc + 1] = e[loc];
                        loc--;
                  }

                  e[loc + 1] = key;
            }

      }

      public static <E> void insertionSort (E[] e, Comparator<E> comp) {

            for (int i = 1; i < e.length; i++) {

                  E key = e[i];
                  int loc = i - 1;

                  while (loc >= 0 && comp.compare(key, e[loc]) < 0) {

                        e[loc + 1] = e[loc];
                        loc--;
                  }

                  e[loc + 1] = key;
            }
      }

      public static void main(String[]args) {
            Integer[] arr = new Integer[args.length];
            for(int i=0; i<args.length; i++)
                  arr[i] = Integer.parseInt(args[i]);

            /*
            new InsertionSort().insertionSort(arr,
                                    new Comparator<Integer>() {

                                          public int compare(Integer i, Integer j)
                                          {
                                                return j-i;

                                          }
                                    }
            );
            */

            new InsertionSort().insertionSort(arr, (Integer i, Integer j) -> j-i);


            System.out.println(Arrays.toString(arr));

            A[] error = {new A(), new A(), new A()};

            new InsertionSort().insertionSort(error,
                        (A a, A b) -> a.toString().compareTo(b.toString()));
      }
}
