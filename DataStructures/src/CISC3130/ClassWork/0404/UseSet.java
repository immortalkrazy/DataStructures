import java.util.*;

public class UseSet {

      private static <E> void print(Set<E> set){
            for (E e: set) {
                  System.out.print(e + " ");
            }
            System.out.println();
      }
      public static void main(String[] args) {
            Set<Integer> tSet, hSet;
            tSet = new TreeSet<>();
            hSet = new HashSet<>();

            Random rand = new Random();

            for (int i = 0; i < 5; i++) {
                  tSet.add(rand.nextInt(50) + 1);
            }

            for (int i = 0; i < 5; i++) {
                  hSet.add(rand.nextInt(100) + 1);
            }

            print(tSet);
            print(hSet);
            hSet.addAll(tSet);
            print(hSet);

            public static boolean containsSum(int[] arr, int k) {
                  Set<Integer> set;
                  set = new HashSet<>();

                  for(int x: arr) {
                        if(set.contains(x)){
                              return true;
                        }
                        else{
                              set.add(k-x);
                        }
                  }
                  return false;

            }


      }
}
