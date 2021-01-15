import java.util.*;

public class Factorial {

  public static void main (String[] args) {

    if (args.length < 1) {
      System.out.println("Usage is java Factorial **");
    }

    // Scanner sc = new Scanner(System.in);

    // System.out.println("Please eneter the number: ");
    // int n = sc.nextInt();

    System.out.println("Factorial of the Number " + args[0] + " is " + factorial(Integer.parseInt(args[0])));
  }

  public static long factorial(int n) {
    if (n == 0) {
      return 1;
    }
    else {

    } return n * factorial (n - 1);
  }


}
