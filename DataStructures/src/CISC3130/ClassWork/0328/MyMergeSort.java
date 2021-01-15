import java.util.*;
public class MyMergeSort {

    private static void merge (int[] arr, int start, int mid, int end) {
        /* create a new temperary array of int
        *  which has   the length equal to the length of original array
        */
        int[] temp = new int[end - start];
        /*
        index of the new array starts from 0 to the end
        we divide array into two arrays, one is from 0 to mid and the
        2nd one is from mid to end. index 0 of 1st part is indexL and
        start of the 2nd array is indexR
        */
        int index = 0;
        int indexL = start;
        int indexR = mid;

        /* we go through the two arrays based upon the end of the length

        */
        while (indexL < mid && indexR < end) {

            if (arr[indexL] < arr[indexR]) {

                temp[index] = arr[indexL];
                indexL++;
            }
            else {
                temp[index] = arr[indexR];
                indexR++;
            }
            index++;
        }// end of 1st while loop

        while (indexL < mid) {

            temp[index] = arr[indexL];
            indexL++;
            index++;

        }// end of 2nd while loop

        while (indexR < end) {

            temp[index] = arr[indexR];
            indexR++;
            index++;

        }// end of 3rd while loop

        // copy the contents of the temp array into the whole array

        for (int i = 0; i < end - start; i++) {
             arr[i + start] = temp[i];
       }

    } // end of merge method

    private static void mergeSort(int[] arr, int start, int end) {

        // base case
        if (end - start <= 1) {
            return;
        }

        int mid = (start + end) / 2;
        // recursive calls
        // 1st from start to mid
        mergeSort(arr, start, mid);
        // 2nd from mid to end
        mergeSort(arr, mid, end);
        // merge call which joins them together
        merge(arr, start, mid, end);

    }

    public static void mergeSort(int[] arr) {

        mergeSort(arr, 0, arr.length);

    }

    public static void main(String[] args) {

        int[] arr = {0, 2, 4, 6, 1, 3, 5, 7};
        int[] arr1 = {3, 8, 9, 5, 7, 3, 0, 10, 4};

        // Integer[] arr = new Integer[args.length];
        //
        // for (int i=0; i<args.length; i++) {
        //
        //     arr[i] = Integer.parseInt(args[i]);
        //
        // }

        mergeSort(arr1);

        System.out.println(Arrays.toString(arr1));

    }

}
