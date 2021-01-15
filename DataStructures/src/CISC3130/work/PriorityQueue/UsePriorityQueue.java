import java.util.*;

public class UsePriorityQueue {

    public static void main(String[] args) {

        PriorityQueue<Integer> pQueue;
        pQueue = new PriorityQueue<Integer>();

        for (String arg: args) {
            pQueue.add(Integer.parseInt(arg));
        }
        while (!pQueue.isEmpty()) {
            System.out.println(pQueue.poll());
        }
    }
}
