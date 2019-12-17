package SortSearchDerek;

public class ArrayStructures {

      private int[] theArray = new int[50];
      private int arraySize = 10;

      public void generateRandomArray() {

            for (int i = 0; i < arraySize; i++) {
                  theArray[i] = (int) (Math.random() * 10) + 10;
            }
      }

      public void printArray() {

            System.out.println("----------");
            for (int i = 0; i < arraySize; i++) {
                  System.out.print("| " + i + " | ");
                  System.out.println(theArray[i] + " |");
                  System.out.println("----------");
            }
      }

      public int getValueAtIndex(int index) {

            if (index < arraySize) {
                  return theArray[index];
            } else {
                  return 0;
            }
      }

      public boolean doesArrayContainsThisValue(int searchValue) {

            boolean valueInArray = false;

            for (int i = 0; i < arraySize; i++) {
                  if (theArray[i] == searchValue) {
                        valueInArray = true;
                  }
            }
            return valueInArray;
      }

      public void deleteIndex(int index) {

            if (index < arraySize) {

                  for (int i = index; i < (arraySize - 1); i++) {
                        theArray[i] = theArray[i + 1];
                  }
                  arraySize--;
            }
      }

      public void insertValue(int value) {

            if (arraySize < 50) {
                  theArray[arraySize] = value;
                  arraySize++;
            }
      }

      public String linearSearchForValueString(int value) {

            boolean valueInArray = false;
            String indexWithValue = "";

            for (int i = 0; i < arraySize; i++) {
                  if (theArray[i] == value) {
                        valueInArray = true;
                        indexWithValue += i + " ";
                  }
                  printHorizontalArray(i, -1);

            }
            if (!valueInArray) {
                  indexWithValue = "None";
            }
            System.out.print("The value was found at Index: " + indexWithValue);
            System.out.println();
            return indexWithValue;

      }

      private void printHorizontalArray(int i, int j) {

            // for loop for top ------------
            for (int n = 0; n < 51; n++) {
                  System.out.print("-");
            }
            System.out.println();

            // for loop for index numbers
            for (int n = 0; n < arraySize; n++) {
                  System.out.print("| " + n + "  ");
            }
            System.out.println("|");

            // for loop for middle -----------------
            for (int n = 0; n < 51; n++) {
                  System.out.print("-");
            }
            System.out.println();

            // for loop for index values
            for (int n = 0; n < arraySize; n++) {
                  System.out.print("| " + theArray[n] + " ");
            }
            System.out.println("|");

            // for loop for bottom ----------------
            for (int n = 0; n < 51; n++) {
                  System.out.print("-");
            }
            System.out.println();

            // -----for bubble sort------

            if (j != -1) {
                  // add the "+2" to fix spacing
                  for (int k = 0; k < ((j * 5) + 2); k++) {
                        System.out.print(" ");
                  }
                  System.out.print(j);
            }

            if (i != -1) {
                  // add the "-1" to fix spacing
                  for (int l = 0; l < (5 * (i - j) - 1); l++) {
                        System.out.print(" ");
                  }
                  System.out.print(i);
            }
            System.out.println();
      }

      public void bubbleSort() {
            for (int pass = arraySize - 1; pass > 1; pass--) {

                  for (int index = 0; index < pass; index++) {
                        if (theArray[index] > theArray[index + 1]) {
                              swapValues(index, index + 1);
                              printHorizontalArray(pass, index);
                        }
                  }

            }
      }

      public void swapValues(int indexOne, int indexTwo) {
            int temp = theArray[indexOne];
            theArray[indexOne] = theArray[indexTwo];
            theArray[indexTwo] = temp;
      }

      public void binarySearchForValue(int value) {

            int lowIndex = 0;
            int highIndex = arraySize - 1;

            while (lowIndex <= highIndex) {

                  int middleindex = (highIndex + lowIndex) / 2;
                  if (theArray[middleindex] < value) {
                        lowIndex = middleindex + 1;
                  } else if (theArray[middleindex] > value) {
                        highIndex = middleindex - 1;
                  } else {
                        System.out.println("\nFound a match for " + value + " at index " + middleindex);
                        lowIndex = highIndex + 1;
                  }
                  printHorizontalArray(middleindex, -1);
            }
      }

      public void selectionSort() {
            for (int pass = 0; pass < arraySize; pass++) {
                  int minimum = pass;

                  for (int index = pass; index < arraySize; index++) {

                        if (theArray[minimum] > theArray[index]) {
                              minimum = index;
                        }
                  }
                  swapValues(pass, minimum);
                  printHorizontalArray(pass, -1);
            }
      }

      public void insertionSort() {

            for (int i = 1; i < arraySize; i++) {

                  int j = i;
                  int toInsert = theArray[i];

                  while ((j > 0) && (theArray[j - 1] > toInsert)) {

                        theArray[j] = theArray[j - 1];
                        j--;
                        printHorizontalArray(i, j);
                  }
                  theArray[j] = toInsert;
                  printHorizontalArray(i, j);
                  System.out.println("\nArray[i] = " + theArray[i] + " Array[j] = " + theArray[j] + " toInsert = "
                              + toInsert + "\n");

            }

      }

      public static void main(String[] args) {

            ArrayStructures newArray = new ArrayStructures();
            newArray.generateRandomArray();
            // newArray.printArray();
            // System.out.println(newArray.doesArrayContainsThisValue(14));
            // newArray.linearSearchForValueString(14);
            newArray.bubbleSort();
            newArray.binarySearchForValue(14);
      }

}
