import java.util.Scanner;

public class ArrayProcessing {

  public static void main (String[] args){

    double[] arrDouble = new double [10];
    //initialize array with user Input
    userInput(arrDouble);
    printArray(arrDouble);

  } // end on main


  public static void userInput(double[] arr){
    try(Scanner sc = new Scanner(System.in)){
      System.out.println("Please eneter " + arr.length + " Values: ");
      for(int i = 0; i < arr.length; i++){
        arr[i] = sc.nextDouble();
      }
    }catch(Exception e){
        System.out.println(e.getMessage());
    }
  }

  public static void printArray(double[] arr){
    System.out.println("Your Array is:  ");
    for (int i =0; i < arr.length; i++){
      System.out.print(arr[i] + " ");
    }
  }

}// end of class
