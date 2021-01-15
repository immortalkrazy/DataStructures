public class ProfSorts {

    /*method used in bubble sort*/
    private static void swap (int[] arr, int num1, int num2) {

        int temp = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = temp;

    }

    public static void bubbleSorts (int[] arr) {

        boolean isSorted = false;
        int nPass = arr.length -1;

        for (int pass = 0; pass < nPass && !isSorted; pass++) {

            isSorted = true;
            for (int ind = 0; ind < nPass; ind++) {
                if (arr[ind] > arr[ind + 1]) {
                    isSorted = false;
                    swap (arr, ind , ind + 1);
                }
            }
        }
    }

    public static void insertionSort (int[] arr) {

        int n = arr.length;
        for (int i = 1; i < arr.length; i++) {

            int key = arr[i];
            int loc = i - 1;

            while (loc >= 0 && arr[loc] > key) {

                arr[loc + 1] = arr[loc];
                loc--;
            }

            arr[loc + 1] = key;

        }
    }

    /*method used in Selection Sort
    findMinimumIndex() is subroutine to selection sort
    it finds the minimum element in the array*/

    private static int findMinimumIndex (int[] arr, int start, int end) {

        int minIndex = start;
        int minValue = arr[start];

        for (int i = start + 1; i < end; i++) {

            if (arr[i] < minValue) {
                minValue = arr[i];
                minIndex = i;
            }

        }
        return minIndex;
    }

    public static void selectionSort (int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            int minIndex = findMinimumIndex(arr, i , arr.length);
            swap(arr, minIndex, i);

        }
    }

    private staic void merge (int[] arr, int start, int mid, int end) {

        int[] temp = new int[end - start];

        int tempIndex = 0;
        int index1 = start;
        int index2 = mid;

    }
















}/*end od class*/
