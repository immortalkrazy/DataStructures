import java.util.*;

public class TreeSetDemo {
    public static void main(String[] args) {
        // Providing custom compartor
        Set<String> citySet = new TreeSet<String>(
          new CityComparator());

        citySet.add("Delhi");
        citySet.add("Mumbai");
        citySet.add("Bangalore");
        citySet.add("Chennai");
        citySet.add("Hyderabad");

        // Iterating the Set
        for(String str : citySet){
            System.out.println("City Name - " + str);
        }
    }
}

// Comparator class
class CityComparator implements Comparator<String>{
    @Override
    public int compare(String str1, String str2) {
        return str2.compareTo(str1);
    }
}
