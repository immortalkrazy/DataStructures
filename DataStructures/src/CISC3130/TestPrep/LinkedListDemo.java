import java.io.*;
import java.util.LinkedList;

public class LinkedListDemo {
   public static void main(String args[]) {

      // Creating an empty LinkedList
      LinkedList<String> list = new LinkedList<String>();

      // Using add() method to add elements in the list
      list.add("Geeks");
      list.add("for");
      list.add("Geeks");
      list.add("10");
      list.add("20");

      // Displaying the list
      System.out.println("LinkedList:" + list);

      // Fetching first element from the list
      System.out.println("The first element is: " + list.getFirst());

      System.out.println("LinkedList:" + list);
   }
}
