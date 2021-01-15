import java.util.ArrayList;
import java.util.Arrays;

public class UserArrayList{
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
    System.out.println(list);
    System.out.println(sumAll(list));

  }

  private static int sumAll(ArrayList<Integer> list){
    int total = 0;
    for (int i = 0; i < list.size(); i++){
      //int b = (int)list.get(i);
      total+= list.get(i);
    }
    return total;
  }
}
