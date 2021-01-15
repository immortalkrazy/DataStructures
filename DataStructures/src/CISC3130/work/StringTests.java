import java.util.*;

public class StringTests {
  public static void main(String[] args){

    Scanner kb = new Scanner (System.in);

    System.out.println("Plz eneter 4 Strings: ");
    String s1 = kb.nextLine();
    String s2 = kb.nextLine();
    String s3 = kb.nextLine();
    String s4 = kb.nextLine();

    System.out.println("Strings are equal with case: " + s1.equals(s2));
    System.out.println("Strings are equal with Ignorecase: " + s1.equalsIgnoreCase(s2));
    System.out.println("Strings are compare with case: " + s1.compareTo(s2));
    System.out.println("Strings are comapre ignore case with case: " + s1.compareToIgnoreCase(s2));

    int intValue1 = Integer.parseInt(s3);
    int intValue2 = Integer.parseInt(s4);
    int total = intValue1 + intValue2;
    System.out.println("String numeric value to int value:  " + total);

    System.out.println("Character at 3 in s2: " + s2.charAt(3));
    System.out.println( s2 + "subString:  " + s2.substring(0, 5));
  }
}
