/*********************************************************************************/
/* Faisal Ibrahim                                                      Home Work */
/* CISC 3130                                                                     */
/*                                                                               */
/*********************************************************************************/

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

public class MyMap {

    private ArrayList<LinkedList<Pair>> theTable;
    private int numElements;
    private int initialCapacity = 79;
    private int currentCapacity;

    // constructor for the map
    public MyMap(int capacity) {
        theTable = new ArrayList<LinkedList<Pair>>(capacity);
        numElements = 0;
        for (int i = 0; i < capacity; i++) {
            theTable.add(new LinkedList<Pair>());
        }
    }
    public MyMap() {

        this(79);
    }

    public void put(String key, Integer value) {

        Pair temp = new Pair(key, value);
        int index = index(key);

        if (!itExist(key)) {
            theTable.get(index).add(temp);
        }
        else {
            theTable.get(index).add(temp);
        }
        numElements++;

    }

    public boolean containsKey(String key) {
        // get the index location in the table
        int indexToLook = index(key);
        // create a temp list to use
        LinkedList<Pair> tempList = theTable.get(indexToLook);

        if (tempList.size()== 0)
        return false;
        for (Pair pair: tempList) {
            if(pair.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public boolean conatinsValue(Integer value) {

        for(LinkedList<Pair> list : theTable) {
            for (int i = 0; i < list.size(); i++) {
                if ((list.get(i).getValue()).equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean remove(String key) {

        if (itExist((String)key)) {
            System.out.println("Key does not exist");
            return false;
        }
        else {
            theTable.get(index((String)key)).clear();
        }
        return true;
    }

    public Integer get(String key) {
        // go to the first pair in the linked list and
        // get the value of that pair
        return theTable.get(index(key)).getFirst().getValue();
    }

    public Integer get (int index, String key) {
        int returnValue = 0000;
        LinkedList<Pair> bucket = theTable.get(index(key));
        for (int i = 0; i <= index; i++) {
            returnValue = bucket.get(i).getValue();
        }
        return (Integer)returnValue;
    }

    public Set<Pair> entrySet(){
        // create a tree set to have
        Set<Pair> set = new TreeSet<Pair>();
        for (LinkedList<Pair> list : theTable) {
            for (Pair pair : list) {
                set.add(pair);
            }
        }
        return set;
    }

    public Collection<Integer> values() {
        // collection arraylist
        Collection<Integer> col = new ArrayList<Integer>();
        for (LinkedList<Pair> list : theTable) {
            for (Pair pair : list) {
                col.add(pair.getValue());
            }
        }
        return col;
    }

    public Set<String> keySet() {
        /*go through arraylist and for every linked list go through it and
        * add all pairs in there into a se
        * */
        Set<String> set = new TreeSet<String>();
        for (LinkedList<Pair> list : theTable) {
            for (Pair pair : list) {
                set.add(pair.getKey());
            }
        }
        return set;
    }

    public int size() {
        // size of the table is equal to number of elements
        return numElements;
    }

    public boolean isEmpty() {
        // check if there is any element in table
        return numElements == 0;
    }

    private static class Pair {

        // private data fields for pair object
        private String str;
        private Integer value;

        // constructor which takes the string and a value
        public Pair(String str, Integer value) {

            this.str = str;
            this.value = value;
        }
        // Default constructor
        // just created it to test something
        public Pair() {
            this(null, null);
        }
        // returns the String key stored in the pair object
        public String getKey() {
            return str;
        }
        // returns the value stored pair object
        public Integer getValue() {
            return value;
        }

        public Integer setValue(Integer val) {
            // get the old value from the object
            Integer oldValue = this.value;
            // change value of the object with the given value
            this.value = val;
            // return old value
            return oldValue;
        }
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            // generate kind of unique hash code
            result = prime * result + ((str == null) ? 0 : str.hashCode());
            return result;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
            return true;
            if (obj == null)
            return false;
            if (getClass() != obj.getClass())
            return false;
            Pair other = (Pair) obj;
            if (str == null) {
                if (other.str != null)
                return false;
            } else if (!str.equals(other.str))
            return false;
            if (value == null) {
                if (other.value != null)
                return false;
            } else if (!value.equals(other.value))
            return false;
            return true;
        }

        @Override
        public String toString() {
            return "Pair [Key=" + str + ", Value=" + value + "]";
        }


    }// end of private static inner pair class

    // useless for me
    private int getIndex(String key) {

        return (new Pair(key, 0)).hashCode();

    }

    // helper method to get the index of arraylist
    // means the location of the key
    private int index (String key) {

        int total = 0;
        for (int i = 0; i < key.length(); i++) {
            total += (key.charAt(i) - 'A');
        }
        return total % theTable.size();
    }
    // tells me if there is any element in that particular index(bucket)
    private boolean itExist (String key) {

        return theTable.get(index(key)).size() < 0;

    }
    // tester method
    public int sizeOfLinkedlist(String key) {
        int indexToGo = index(key);
        return theTable.get(indexToGo).size();
    }
    // tester method
    public void printPairs() {
        for (LinkedList<Pair> list: theTable ) {
            for (Pair pair : list) {
                System.out.println(pair);
            }
        }
    }
    // toDo
    private void grow () {

    }


} // end of MyMap class
