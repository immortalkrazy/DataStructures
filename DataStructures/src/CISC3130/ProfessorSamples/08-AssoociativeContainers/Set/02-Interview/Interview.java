import java.util.*;

public class Interview {

    public static class Pair {
        private int first;
        private int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
        public int getFirst() {
            return first;
        }
        public int getSecond() {
            return second;
        }
        public String toString() {
            return "(" + first + ", "  +second+")";
        }
    }

    //The question we wish to answer is:
    //Given an array of integers "arr" and an integer "k", are there 2 numbers in the array that sum to k?
    //If so, what are they?
    public static Pair addUpTo(int[] arr, int k) {
        Set<Integer> values = new HashSet<>();

        for(int x: arr) {
            //calculate the complement, k-x

            int complement = k-x;

            //if the complement is in the set, we're done

            if(values.contains(complement))
                return new Pair(x, complement);

            //if not, put x into the set so that we can match it up later.

            else
                values.add(x);
        }
        //if no matches are found, return null

        return null;
    }

    public static void main(String[] args) {

        int[] arr = {0, -4, 6, 8, 9, 10};

        int target = 5;

        Pair answer = addUpTo(arr, target);

        if(answer==null)
            System.out.println("The array" + Arrays.toString(arr) + " has no two numbers that sum"
                               + " to " + target+".");
        else
            System.out.println("Within the array " + Arrays.toString(arr) + " the pair of numbers "
                               + answer + " sum up to " + target+ ".");
    }


}
