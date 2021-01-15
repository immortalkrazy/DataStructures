/*********************************************************************************/
/* Faisal Ibrahim                                                      Home Work */
/* CISC 3130                                                                     */
/*                                                                               */
/*********************************************************************************/

public class TestMyMap {

    public static void main(String[] args) {

        MyMap map = new MyMap();

        System.out.println(map.size());
        map.put("Hello", 10);
        map.put("Hello", 11);
        map.put("Hello", 12);
        map.put("Hello", 13);
        System.out.println(map.containsKey("Hello"));
        System.out.println(map.conatinsValue(13));
        System.out.println(map.conatinsValue(14));
        System.out.println("Remove Jello:   " + map.remove("Jello"));
        System.out.println(map.containsKey("Hello"));
        System.out.println(map.sizeOfLinkedlist("Hello"));
        System.out.println("-----------------");
        map.printPairs();
        System.out.println("Print out of values:");
        System.out.println("Values:   \n" + map.values());
        System.out.println("Remove Hello:   " + map.remove("Hello"));
        map.put("Hello", 10);
        map.put("Hello", 11);
        map.put("Hello", 12);
        map.put("Hello", 13);
        map.put("World", 25);
        map.put("Java", 15);
        map.put("Game", 78);
        map.put("Time", 90);
        map.printPairs();
        System.out.println("Values:   \n" + map.values());
        System.out.println("Contains Game as Key? " + map.containsKey("Game"));
        System.out.println("Key Set: \n" + map.keySet());
        System.out.println("get the value of the key Hello:   "+ map.get("Hello"));
        System.out.println("get the value of the key Hello:   "+ map.get(3, "Hello"));
        System.out.println("Size of the map now:  " + map.size());
    }
}
