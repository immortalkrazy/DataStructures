package search;

import java.util.Random;

public class BinarySearch {

      public static void main(String[] args) {

            int num = 100000;
            int[] array = new int[num];

            populateArray(array);

//            System.out.println(Arrays.toString(array));
            printArray(array);
            bubbleSort(array);
            printArray(array);
//            System.out.println(Arrays.toString(array));

//            System.out.println(binarySearch(array, 99));

      }

      public static int binarySearch(int[] arr, int target) {

            int start = 0;
            int end = arr.length - 1;

            while (start <= end) {

                  int mid = (start + end) / 2;

                  if (arr[mid] == target) {

                        return mid;

                  } else if (target < arr[mid]) {

                        end = mid - 1;

                  } else {
                        start = mid + 1;
                  }
            }

            return -1;
      }

      private static void populateArray(int[] arr) {

            Random random = new Random();

            for (int i = 0; i < arr.length; i++) {

                  arr[i] = random.nextInt(1000000);
            }
      }

      private static void bubbleSort(int[] arr) {

            boolean isSorted = false;
            int nPasses = arr.length - 1;

            for (int pass = 0; pass < nPasses && !isSorted; pass++) {
                  isSorted = true;
                  for (int index = 0; index < nPasses - pass; index++) {
                        if (arr[index] > arr[index + 1]) {
                              isSorted = false;
                              swap(arr, index, index + 1);
                        }
                  }
            }

      }

      private static void swap(int[] arr, int index1, int index2) {

            int temp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = temp;

      }

      private static void printArray(int[] arr) {

            System.out.print("[ ");
            for (int i = 0; i < arr.length; i++) {
                  System.out.println(arr[i]);
            }
            System.out.print("]");
      }

}
