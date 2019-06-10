package Sorts;

public class MySorts {

      /*-------------------------BUBBLE SORT-------------------------*/

      public static void bubbleSort(int[] arr) {

            // isSorted is the variable to check if arr is sorted
            // we start at false
            boolean isSorted = false;
            int nPass = arr.length - 1;
            // 1st for loop to go number of times as the length of the array
            for (int pass = 0; pass < nPass && !isSorted; pass++) {
                  isSorted = true;
                  // 2nd for loop for the indices
                  for (int ind = 0; ind < nPass; ind++) {
                        if (arr[ind] > arr[ind + 1]) {
                              isSorted = false;
                              // swap private method swaps the bigger and smaller indices
                              swap(arr, ind, ind + 1);
                        }
                  }
            }
      }

      private static void swap(int[] arr, int index1, int index2) {

            int temp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = temp;
      }

      /*-------------------------INSERTION SORT-------------------------*/

      public static void insertionSort(int[] arr) {
            // for loop to go through the whole array
            for (int i = 1; i < arr.length; i++) {
                  // key element is the 2nd element in the array at start
                  int key = arr[i];
                  // location loc is the 1st element at start
                  int loc = i - 1;
                  /*
                   * while loop which goes back and forth taking one element at a time and
                   * shifting it to its right spot. it starts from the location and goes
                   * backwards, until reaching the first element
                   */

                  while (loc >= 0 && key < arr[loc]) {
                        arr[loc + 1] = arr[loc];
                        loc--;
                  }
                  arr[loc + 1] = key;
            }
      }

      /*-------------------------SELECTION SORT-------------------------*/

      public static void selectionSort(int[] arr) {

            // go through the whole arry
            for (int i = 0; i < arr.length; i++) {
                  // find the index of minimum emlement in the array
                  int minIndex = findMinIndex(arr, i, arr.length);
                  // swap it with the element at index i
                  // swap method is written in bubble sort
                  swap(arr, minIndex, i);
            }
      }

      private static int findMinIndex(int[] arr, int start, int end) {
            // we start at the start index and consider it the min enelemnt

            int minIndex = start;
            int minValue = arr[start];

            // in that arrray start from the strat point and go upto the end
            for (int i = start + 1; i < end; i++) {

                  if (arr[i] < minValue) {

                        minValue = arr[i];
                        minIndex = i;
                  }
            }
            return minIndex;
      }

      /*-------------------------MERGE SORT-------------------------*/

      public static void mergeSort(int[] arr) {

            mergeSort(arr, 0, arr.length);

      }

      private static void mergeSort(int[] arr, int start, int end) {

            // base case
            if (end - start <= 1) {
                  return;
            }
            // divide array into two arrays
            int mid = (end + start) / 2;
            // apply merge sort method onto the first divided array
            mergeSort(arr, start, mid);
            // apply mergeSort method onto the 2nd divided part of the array
            mergeSort(arr, mid, end);
            // merge two parts together in the method merge
            merge(arr, start, mid, end);
      }

      private static void merge(int[] arr, int start, int mid, int end) {

            // create a new temporary array
            int[] temp = new int[end - start];
            int tempIndex = 0;
            // index1 starts from start and index2 starts from mid
            // so both elements are compared and then added into the temporary array
            int index1 = start;
            int index2 = mid;

            // this while loop goes until one of the arrays is done
            while (index1 < mid && index2 < end) {

                  if (arr[index1] < arr[index2]) {

                        temp[tempIndex] = arr[index1];
                        index1++;
                  } else {
                        temp[tempIndex] = arr[index2];
                        index2++;
                  }
                  tempIndex++;
            }
            // 2nd while loop if there are remaining elements in array part 1
            while (index1 < mid) {
                  temp[tempIndex] = arr[index1];
                  index1++;
                  tempIndex++;

            }
            // 3rd while loop if there are more elements left in the array part 2
            while (index2 < end) {
                  temp[tempIndex] = arr[index2];
                  index2++;
                  tempIndex++;
            }
            // now we transfer all the elements into arr from temp
            for (int i = 0; i < end - start; i++) {

                  arr[i + start] = temp[i];
            }

      }

      /*-------------------------QUICK SORT-------------------------*/

      /*-------------------------MAIN METHOD-------------------------*/

      public static void main(String[] args) {

            System.out.println("Hello");
            int[] arr = { 5, 4, 8, 9, 0, 3, 7 };
            mergeSort(arr);
            printArray(arr);
      }

      public static void printArray(int[] arr) {

            System.out.print("[ ");
            for (int i = 0; i < arr.length; i++) {
                  System.out.print(arr[i] + " ");
            }
            System.out.print("]");
      }

}// end of class
