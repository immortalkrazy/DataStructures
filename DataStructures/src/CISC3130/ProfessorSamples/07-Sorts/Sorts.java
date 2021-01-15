import java.util.*;
public class Sorts {

    //swap method to be used in all sorting algorithms
    private static void swap(int[] arr,  int num1, int num2) {
        int temp = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = temp;
    }




    //Adapted from Professor Langsam's notes.

    //Plan: Pass through the array, and swap any pair of elements that is out of order.

    public static void bubbleSort(int[] arr) {
        boolean isSorted = false;  //we will keep track of whether or not the array is sorted as we go through. At first, we assume that the array is unsorted.
        for(int pass = 0; pass < arr.length-1 && !isSorted; pass++) // we only have to make n-1 passes since if the first n-1 numbers are sorted, the array is sorted.
            {
                isSorted = true; //we make the hopeful assumption that the array will be sorted.
                for(int i = 0 ; i<arr.length-pass-1; i++) { // on pass i, we know that the last i elements are in place.
                    if(arr[i] > arr[i+1]) {
                        isSorted = false;            //if a swap is performed, we know that the array is still unsorted.
                        swap(arr, i, i+1);

                    }
                }
            }
    }



    //Adapted from McConnell (2008)
    //Plan: On any arbitrary pass i through the for loop, all of the elements arr[0..i-1] is in sorted order.
    //      Repeatedly copy elements over one by one until you find where the new element, arr[i] should go.

    public static void insertionSort(int[] arr) {
        for(int i=1; i<arr.length; i++) {
            int newElement = arr[i];
            int location = i-1;

            while(location >=0 && arr[location] > newElement) {       //while location is still in bounds, and newElement is still out of order
                arr[location+1] = arr[location];                      // copy the elements over one by one to make space for "newElement"
                location--;
            }
            arr[location+1] = newElement;
        }
    }





    //findMinimumIndex() is a subroutine to selectionSort. It finds the index of minimum element in the array from arr[start..end-1].

    private static int findMinimumIndex (int[] arr, int start, int end) {

    int minIndex = start;
    int minValue = arr[start];

    for(int i=start+1; i<end; i++) {
        if(arr[i] < minValue) {
            minValue = arr[i];
            minIndex = i;
        }
    }

    return minIndex;
}



    //Plan: for each i from 0 to n-2, find the minimum element from arr[i..n-1] and swap it with arr[i].
    //if you find all n-1 minima in order, you will sort the array.

    public static void selectionSort(int[] arr) {


    for(int i=0; i<arr.length-1; i++) {

        int minIndex = findMinimumIndex(arr, i, arr.length);

        swap(arr, minIndex, i);
    }
}


    //merge() is a subroutine to mergeSort(). it takes "2 sorted arrays" and merges then into a "bigger, sorted array."
    //these 2 separate sorted arrays will always be next to each other in memory.


    private static void merge(int[] arr, int start, int mid, int end) {

        int[] temp = new int[end-start];

        int tempIndex = 0;
        int index1 = start;
        int index2 = mid;

        while(index1 < mid && index2 < end) { //while both subarrays still have elements left to check

            if(arr[index1] < arr[index2]) { //if element in the left subarray is smaller than the one in the right subarray

                temp[tempIndex] = arr[index1]; //copy over the element in the left subarray, and increment the index of the left subarray.
                index1++;
            }else {
                temp[tempIndex] = arr[index2]; //copy over the element in the right subarray, and increment the index of the right subarray
                index2++;
            }

            tempIndex++; //no matter what, increment the index of the whole temporary array.
        }



        //if the left subarray ran out of elements, copy them into the array
        while(index1 < mid) {
            temp[tempIndex] = arr[index1];
            index1++;
            tempIndex++;
        }


        //if the right subarray ran out of elements, copy them into the array

        while(index2 < end) {
            temp[tempIndex] = arr[index2];
            index2++;
            tempIndex++;
        }




        //copy of the contents of the temp array into the whole array.


        for(int i=0; i<end-start; i++)
            arr[i+start] = temp[i];

    }




    //mergesort works by recursively sorting the left half of the array and the left part of the array, and then merging these 2 arrays together



    private static void mergeSort(int[] arr, int start, int end) {

        //the base case is if the array is 0 or 1 elements in size, it is already sorted.
        if(end-start<=1)
            return;

        //otherwise, calculate the midpoint n/2 (technically floor(n/2) of the array.
        int midPoint = (end+start)/2;


        mergeSort(arr, start, midPoint);
        mergeSort(arr, midPoint, end);


        merge(arr, start, midPoint, end);
    }

    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length);
    }


    //Partition() is a subrountine to quicksort. It picks (in this case) the first element (but in reality, you should pick a random index), arr[0] as the pivot.
    //It then splits the array into 2 parts: The numbers <=the pivot and the numbers >=pivot.
    //This function returns the index of the pivot.

    //This version of partition() is adapted from CLRS(2009), but there are other ways of doing this.



    private static int partition(int[] arr, int start, int end) {

        int pivot = arr[start];

        int boundaryIndex = start; //on an arbitrary iteration of this loop, all elements in arr[start..boundaryIndex] are <=pivot
                                //                                      and all elements in arr[boundaryIndex+1..newElement-1] are >=pivot.

        for(int newElementIndex = start+1; newElementIndex<end; newElementIndex++) {

            //if arr[newElementIndex] >=pivot, we are happy, since we can just move the boundary of >= by one element and do no extra work.
            //Now, if arr[newElementIndex] <=pivot, we must swap the new element we encounter with the element on the boundary, thus maintaining the invariant.

            if(arr[newElementIndex] <= pivot) {
                boundaryIndex++;
                swap(arr, boundaryIndex, newElementIndex);
            }
        }

        swap(arr, boundaryIndex, start);

        return boundaryIndex;
}



    //Quicksort works by partitioning the array into 2 subarrays around a pivot.
    //if the pivot is at index x, then all numbers in arr[0..x-1] <=x
    //                                  and all elements in arr[x+1..n-1] >=x.
    //Because of this property, if we recursively sort each subarray, we will get an overall
    //sorted array.

    private static void quicksort(int[] arr, int start, int end) {

        if((end-start)<=1)
            return;

        int pivotIndex = partition(arr, start, end);
        quicksort(arr, start, pivotIndex);
        quicksort(arr, pivotIndex+1, end);
    }

    public static void quicksort(int[] arr) {
        quicksort(arr, 0, arr.length);
    }

    public static void shuffle(int[] arr) {
        Random r = new Random();

        for(int i=0; i<arr.length; i++)
            swap(arr, i, r.nextInt(arr.length));
    }


    public static void main(String[] args) {

        final int LENGTH = 10;
        int[] arr = new int[LENGTH];


        for(int i=0; i<LENGTH; i++)
            arr[i] = i;

        shuffle(arr);
		System.out.println(Arrays.toString(arr));

        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        shuffle(arr);
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
        shuffle(arr);
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
        shuffle(arr);
        quicksort(arr);
        System.out.println(Arrays.toString(arr));
		
        shuffle(arr);
		System.out.println(Arrays.toString(arr));
    }
}
