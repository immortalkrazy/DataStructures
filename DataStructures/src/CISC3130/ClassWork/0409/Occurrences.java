import java.util.*;
import java.io.*;

public class Occurrences {

    public staic void main(String[] args) {

        Scanner s = new Scanner(new File(Occurrences.java));

        Map<Character, Integer> occ;
        occ = new TreeMap<>();

        while (s.hasNext()) {
            String next = s.next();

            for (int i = 0; i < next.length(); i++) {

                char curr = next.charAt(i);

                if (occ.containsKey(curr)) {
                    occ.put(curr.occ.get(curr) + 1);
                }
                else {
                    occ.put(curr, 1);
                }
                /*
                Integer value = occ.get(curr);
                if(value == null)
                    occ.put(curr, 1);
                else
                    occ.put(curr, value + 1);
                */
            }
        }
    }





    private static <K, V> void printMap (Map<K,V> map) {

        for (K key: map.keySet()) {
            V value = map.get(key);
            System.out.println(key + " : " + value);
        }

        /*
        for (Map.Entry<K, V> entry: map.entrySet()) {

            System.out.println(entry.getKey() + " : " + entry.getValue());

        }
        */
    }

    Map<Integer, List<Character>> sorted;
    sorted = new TreeMap<>();

    invertPap(occ, sorted);




}
