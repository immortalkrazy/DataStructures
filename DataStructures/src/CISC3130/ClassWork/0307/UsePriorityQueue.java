import java.util.*;

public class UsePriorityQueue {
  public static void main (String[]args){

    PriorityQueue<Integer> pQueue;
    pQueue = new PriorityQueue<>(10, new Comparator<Integer>(){
                                public int compare(Integer i1, Integer i2){
                                  return i2-i1;
                                }
                              });

  for (String arg: args){
    pQueue.add(Integer.parseInt(arg));
  }

  while (!pQueue.isEmpty()){
    System.out.println(pQueue.poll());
  }



  }
}
