import java.util.Scanner;
import java.util.*;

public class ArithmaticException {
    public static void main(String... args){

      try(Scanner sc = new Scanner(System.in)){
        System.out.println("Please Enter 2 integers:  ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        System.out.println("Result: " + num1/num2);
      }catch(ArithmeticException e){
        System.out.println("Exception: " + e.getMessage());
      }catch(InputMismatchException e){
        System.out.println("Exception: " + e.getMessage());
      }
    }// end of main
}
