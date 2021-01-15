public class MergeSort {

    public static void mergeSort(int[] list) {

        if (list.length > 1) {
            // merge sort the first half
            int firstHalfLength = list.length / 2;
            // create the new first half array
            int[] firstHalf = new int[firstHalfLength];
            // make another array which is half in length of the original one
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            // recursive call
            mergeSort(firstHalf);

            // merge sort the second half
            int secondHalfLength = list.length - (list.length / 2);
            // create the second half array
            int[] secondHalf = new int[secondHalfLength];
            // make the second half new array
            System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
            // recursive call
            mergeSort(secondHalf);

            // merge firstHalf with secondHalf into list
            merge(firstHalf, secondHalf, list);

        }
    }

    public static void merge (int[] list1, int[] list2, int[] temp) {

        int indexOfList1 = 0; // current index in list1
        int indexOfList2 = 0; // current index in list2
        int indexOfTemp = 0; // current index in temp

        while (indexOfList1 < list1.length && indexOfList2 < list2.length) {

            if (list1[indexOfList1] < list2[indexOfList2]) {
                temp[indexOfTemp] = list1[indexOfList1];
                indexOfList1++;
            }
            else {
                temp[indexOfTemp] = list2[indexOfList2];
                indexOfList2++;
            }
            indexOfTemp++;
        }

        while (indexOfList1 < list1.length) {
            temp[indexOfTemp] = list1[indexOfList1];
            indexOfTemp++;
            indexOfList1++;
        }
        while (indexOfList2 < list2.length) {
            temp[indexOfTemp] = list2[indexOfList2];
            indexOfTemp++;
            indexOfList2++;
        }
    }

    public static void main(String[] args) {

        int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};

        mergeSort(list);

        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
    }
}
