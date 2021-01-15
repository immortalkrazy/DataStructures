import java.util.*;

public class UseLinkedList {

  public static void main (String[] args) {

    LinkedList<String> list;
    list = new LinkedList<>();
    /*
    list.addAll(Arrays.asList(args));

    list.addFirst("Hello");
    // add ABCD
    for(char ch = 'A'; ch <= 'D'; ch++){
      list.addFirst(Character.toString(ch));
    }
    */
    for (int i = 0; i < 10000; i++){
      list.add(Integer.toString(i));
    }
    long start = System.currentTimeMillis();
    int count = numUpperGood(list);
    double seconds = (System.currentTimeMillis() - start) / 1000.0;
    System.out.println(seconds);

    start = System.currentTimeMillis();
    count = numUpper1(list);
    seconds = (System.currentTimeMillis() - start) / 1000.0;
    System.out.println(seconds);

    System.out.println(list);

    System.out.println(toLowerCase('A'));
  }
  // method to try
  public static char toLowerCase (char ch) {
    if (ch >= 'A' && ch <= 'Z'){
      return (char)(ch - 'A' + 'a');
    }
    return ch;
  }
  // bad style dont do it
  public static int numUpper1 (LinkedList<String> list){
    int count = 0;
    for(int i = 0; i < list.size(); i++){
      if(Character.isUpperCase(list.get(i).charAt(0))){
        count++;
      }
    }
    return count;
  }

  public static int numUpperGood(LinkedList<String> list){
    int count = 0;

    for (Iterator<String> it = list.iterator(); it.hasNext();){
      if(Character.isUpperCase(it.next().charAt(0))){
        count++;
      }
    }
    return count;
  }

  for(String str: list)
        if(Character.isUpperCase(str.charAt(0)))
            count++;
}
