import java.util.*;

public class MyArrayListTester {

  public static void main(String[] args) {

    MyArrayList<Integer> list = new MyArrayList<Integer>();

    for(int i=0; i<10; i++)
        list.add(i+10);

    for(Iterator<Integer> it = list.iterator(); it.hasNext(); ) {
        System.out.println(it.next());
    }

    for(int x: list)
        System.out.println(x);

    System.out.println(list);

    list.remove((Integer)10);


    System.out.println(list);
  }

}
