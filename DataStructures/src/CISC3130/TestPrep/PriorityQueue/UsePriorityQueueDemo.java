import java.util.*;

public class UsePriorityQueueDemo {

    public static int findKthLargest(int[] nums, int k) {
        int p = 0;
        int numElements = nums.length;
        // create priority queue where all the elements of nums will be stored
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        // place all the elements of the array to this priority queue
        for (int n : nums){
            pq.add(n);
        }

        // extract the kth largest element
        while (numElements-k+1 > 0){
            p = pq.poll();
            k++;
        }

        return p;
    }

    public static void main (String[] args) {

        int[] arr = {8, 2, 5, 8, 2, 45, 9, 42, 25, 8, 36, 5, 75, 12, 82};

        System.out.println(findKthLargest(arr, 3));
        
    }
}
