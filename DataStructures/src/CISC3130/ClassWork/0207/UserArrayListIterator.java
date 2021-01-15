import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class UserArrayListIterator{
  public static void main(String[] args){
    Integer[] arr = {3, 7, 10, 13};
    ArrayList<Integer> list = new ArrayList<Integer>();

    list.addAll(Arrays.asList(arr));

    System.out.println(list);
    System.out.println(list.contains(33));
    System.out.println(list.get(1));
    // System.out.println(list.get(100)); IndexOutOfBoundsException
    list.set(0, 100);
    System.out.println(list.get(0));
    System.out.println(list);
    for (int i = 0; i < 10; i++){
      list.add(i*2);
    }
    System.out.println("List is as: " + list);
    System.out.println("Sum using for loop: " + sumAll(list));
    System.out.println("Sum using Iterator: " + sumAllIter(list));
    System.out.println("Sum using forEach : " + sumAllForEach(list));
  }
  // use of for loop to go through the arraylist and get the total
  private static int sumAll(ArrayList<Integer> list){
    int total = 0;
    for (int i = 0; i < list.size(); i++){
      //int b = (int)list.get(i);
      total+= list.get(i);
    }
    return total;
  }
  // use of iterator to go through the array list and get total
  private static int sumAllIter(ArrayList<Integer> list){
    int total = 0;
    Iterator<Integer> iter = list.iterator(); // iter is reference variable
    while (iter.hasNext()) {
      int data = iter.next();
      total += data;
    }// end of while
    return total;
  }

  public static int sumAllForEach(ArrayList<Integer> list){
    int total = 0;

    for(int x: list){
      total +=x;
    }
    return total;
  }

}// end of class
