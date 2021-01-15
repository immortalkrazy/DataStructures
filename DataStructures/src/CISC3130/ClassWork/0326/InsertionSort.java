import java.util.*;

public class InsertionSort {

      public static void insertionSort(int[] arr) {

            for (int i = 1; i < arr.length; i++) {

                  int key = arr[i];
                  int loc = i - 1;

                  while (loc >= 0 && key < arr[loc]) {

                        arr[loc + 1] = arr[loc];
                        loc--;
                  }

                  arr[loc + 1] = key;
            }
      }

      public static void main(String[] args) {

            int[] array = {20, 8, 3, 42, 13, 10};

            int[] array2 = generateRandonArray(10, 5, 50);

            printArray(array2);

            insertionSort(array2);

            printArray(array2);
      }

      public static void printArray(int[] arr) {

            System.out.println();
            System.out.print("{ ");
            for(int i: arr) {
                  System.out.print( i + " ");
            }
            System.out.print("} ");

      }

      public static int[] generateRandonArray(int n, int low, int high) {

            int[] arr = new int[n];
            Random rd = new Random();

            for (int i = 0; i < arr.length; i++ ) {

                  arr[i] = rd.nextInt(high - low);
            }
            return arr;
      }

}
