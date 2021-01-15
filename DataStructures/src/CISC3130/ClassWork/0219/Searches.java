import java.util.Scanner;

public class Searches {

  // binary search method
  public static int loopBinarySearch (int[] arr, int target){
    int n = arr.length;
    int start = 0;
    int end = n-1;

    while (start <= end){
      int mid = (start + end) / 2;
      if (target == arr[mid]){
        return mid;
      }
      else if (target < arr[mid]){
        end = mid - 1;
      }

      else {
        start = mid + 1;
      }
    }// end of while
    return -1;
  }// end of binarySearch method

  // Linear search method
  public int linearSearch (int[] arr, int target) {

    for (int i = 0; i < arr.length; i++){
        if (arr[i] == target) {
          return i;
        }
    }
    return -1;
  }// end of linear Searches

  public static int sumTwoDimensionalArray (int[][] mat) {
    int sum = 0;
    for (int row = 0; row < mat.length; row++) {
      for (int col = 0; col < mat[row].length; col++){
        sum += mat[row][col];
      }
    }
    return sum;
  }

  public static void main (String[] args) {

    int[][] matrix;
    matrix = new int[2][2];

    initTwoDimensionalArrayUserInput(matrix);
    printTwoDimensionalArray(matrix);
    System.out.println(sumTwoDimensionalArray(matrix));
  }

  public static void initTwoDimensionalArrayUserInput(int[][] mat) {
    try (Scanner sc = new Scanner(System.in)) {

      System.out.println("Enter " + mat.length +  " rows and " +
                          mat[0].length + " columns:  ");
      for (int row = 0; row < mat.length; row++) {
        for(int col = 0; col < mat[row].length; col++){
          mat[row][col] = sc.nextInt();
        }
      }
    }catch(Exception e){
      System.out.println("Something went wrong");
    }
  }// end of initializeArrayUserInput method

  // method for printing matrix array
  public static void printTwoDimensionalArray(int[][] mat){
    for (int row = 0; row < mat.length; row++){
      for (int col = 0; col < mat[row].length; col++){
        System.out.print(mat[row][col] + " ");
      }
    }
    System.out.println();
  }

  public static int recursiveBinarySearch (int[] arr, int key) {

    int lhs = 0;
    int rhs = arr.length;
    return recursiveBinarySearch (arr, key, lhs, rhs);

  }

  private static int recursiveBinarySearch (int[] arr, int key, int lhs, int rhs) {
    if (lhs > rhs) {
      return -lhs -1;
    }
    int mid = (lhs + rhs) / 2;
    if (key < arr[mid]) {
      return recursiveBinarySearch (arr, key, lhs, rhs -1);
    }
    else if (mid == key) {
      return mid;
    }
    else {
      return recursiveBinarySearch(arr, key, lhs + 1, rhs);
    }
  }
}// end of class
