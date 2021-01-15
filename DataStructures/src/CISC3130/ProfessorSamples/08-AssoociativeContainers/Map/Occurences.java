import java.util.*;
import java.io.*;

public class Occurrences {


    public static void main(String[] args) throws Exception {

        if(args.length!=1) {
            System.err.println("Error opening file.");
            System.exit(1);
        }

        Scanner keyboard = new Scanner(new File(args[0]));

        Map<Character, Integer> words = new TreeMap<>();

        while(keyboard.hasNext()) {
            String next = keyboard.next();

            process(next, words);
        }

        Map<Integer, List<Character>> occMap = new TreeMap<>(new Comparator<Integer>() {

                                                            public int compare(Integer i1, Integer i2) {

                                                                return i2-i1;
                                                            }

        });



        reverseMappings(words, occMap);


        printMap(occMap);



    }

    private static void process(String word, Map<Character, Integer> map) {

        for(int i=0; i<word.length(); i++)
            process(word.charAt(i), map);
    }

    private static void process(char ch, Map<Character, Integer> map) {

        if(map.containsKey(ch))
            map.put(ch, map.get(ch) + 1);
        else
            map.put(ch, 1);

    }

    private static void reverseMappings(Map<Character, Integer> words, Map<Integer, List<Character>> occMap) {

        for(Map.Entry<Character, Integer> entry : words.entrySet()) {
            if(!occMap.containsKey(entry.getValue()))
                occMap.put(entry.getValue(), new ArrayList<>());

            occMap.get(entry.getValue()).add(entry.getKey());
        }

    }
    private static <K, V> void printMap(Map<K, V> map) {
        for(Map.Entry<K, V> entry: map.entrySet())
            System.out.println(entry.getKey() + " -> " + entry.getValue());
    }



}
