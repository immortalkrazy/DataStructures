/*               Clonable (I)                           Iterable (I) 
 *                                                         |
 *                                                         |
 *                                                         |                                                                                                                              
 *                                                      Collection (I) 1.2
 *                                                         |
 *                                                         |
 *                                                         |
 *                 ------------------------------------------------------------------------------------
 *                |                                        |                                          |
 *                |                                        |                                          |
 *              List (I)                                Set (I) 1.2                               Queue (I) 1.5
 *              - Duplicates are Allowed                - Duplicates are NOT Allowed              - Represent objects before processing
 *              - Insertion Order Preserved             - Insertion Order NOT Preserved           - FIFO                                                         
 *                |                                        |                                          |
 *                |                                        |                                          |
 *    -------------------------                 -------------------------                 -------------------------                              
 *    |           |           |                 |                       |                 |                       |                       
 *    |           |           |                 |                       |                 |                       |
 * ArrayList LinkedList    Vector 1.0        HashSet 1.2          SortedSet (I) 1.2   PriorityQueue 1.5        BlockingQueue 1.5
 *   1.2        1.2           |                 |                       |                                         |
 *                            |                 |                       |                                         |
 *                          Stack 1.0     LinkedHashSet 1.4      NavigableSet (I) 1.6                             |- ProrityBlockingQueue 1.5
 *                                                                      |                                         |
 *                                                                      |                                         |
 *                                                                   TreeSet 1.2                                  |- LinkedPriorityQueue 1.5
 
 * 
 * 
 *                                                      Map (I) 1.2 P830
 *                                                          |
 *                                                          |                                                       Dictionary (AC) 1.0
 *                                                          |                                                           |
 *          -------------------------------------------------------------------------------------------------           |
 *          |                       |                       |                       |                       |           |              
 *          |                       |                       |                       |                       |------------                                                                                     
 *          |                       |                       |                       |                       | 
 *       HashMap 1.2           WeakHashMap 1.2        IdentityHashMap 1.4      SortedMap (I) 1.2       Hashtable 1.0
 *          |                                                                       |                       |                         
 *          |                                                                       |                       |
 *    LinkedHashMap 1.4                                                       NavigableMap (I) 1.6     Properties 1.0
 *                                                                                  |
 *                                                                                  |
 *                                                                               TreeMap 1.2     
 *                                                                                               
 *                                                      Sorting                                                            
 *                                                         |
 *                                                         |
 *                                                         |
 *                 ------------------------------------------------------------------------------------
 *                |                                                                                   |
 *                |                                                                                   |
 *           Comparable (I)                                                                    Comparator (I)
 *
 *                                                     
 *                                                      Cursors
 *                                                         |
 *                                                         |
 *                                                         |
 *                 ------------------------------------------------------------------------------------
 *                |                                        |                                          |
 *                |                                        |                                          |
 *          Enumeration (I)                             Iterator (I)                            ListIterator (I)
 *                                                                                  
 
 *                                                  Utility Classes                                                            
 *                                                         |
 *                                                         |
 *                                                         |
 *                 ------------------------------------------------------------------------------------
 *                |                                                                                   |
 *                |                                                                                   |
 *           Collections                                                                            Arrays
 *                                                                                  
 *                                                                                  
 */

/*
 *    Collection: 
 *          - Represent group of individual objects as a single identity 
 *          - root interface of collection interface 
 *          - Methods: 
 *                - boolean add (Object o); 
 *                - boolean addAll(Collection c); 
 *                - boolean remove (Object o); 
 *                - boolean removeAll(Collection c); 
 *                - boolean retainAll(Collection c); 
 *                - void clear(); 
 *                - boolean contains(Object o); 
 *                - boolean containsAll(Collection c); 
 *                - boolean isEmpty(); 
 *                - int size(); 
 *                - Object[] toArray(); 
 *                - Iterator iterator(); 
 *                - T[] toArray(T[] a); 
 *                - boolean equals(Object o)
 * 
 *    List: 
 *          - Duplicates are allowed 
 *          - Insertion order is preserved 
 *          - Differentiate duplicates by index 
 *          - Methods: 
 *                - boolean add (Object o); 
 *                - boolean addAll(Collection c); 
 *                - boolean remove (Object o); 
 *                - boolean removeAll(Collection c); 
 *                - boolean retainAll(Collection c); 
 *                - void clear(); 
 *                - boolean contains(Object o); 
 *                - boolean containsAll(Collection c); 
 *                - boolean isEmpty(); 
 *                - int size(); 
 *                - Object[] toArray(); 
 *                - Iterator iterator(); 
 *                - T[] toArray(T[] a); 
 *                - boolean equals(Object o);
 * 
 *                - void add (int index, Object o); 
 *                - boolean addAll(int index, Collection c);
 *                - Object get(int index); 
 *                - int indexOf(Object o); 
 *                - int lastIndexOf(Object o); 
 *                - ListIterator listIterator(); 
 *                - ListIterator listIterator(int startIndex); 
 *                - Object remove(int index); 
 *                - List subList(int fromIndex, int toIndex); 
 *                - Object set (int index, Object o);
 *  
 * 
 * 
 */

package javaCollections;

import java.util.ArrayList;
import java.util.List;

public class Structure {

      public static void main(String[] args) {

            List<String> list1 = new ArrayList<>();
            List<String> list2 = new ArrayList<>();

            list1.add("Harry");
            list1.add("Potter");
            list1.add("James");
            list1.add("Bond");
            System.out.println(list1);

            list2.add("1");
            list2.add("2");
            list2.add("3");
            list2.add("4");
            list2.addAll(3, list1);

            System.out.println(list2);
            System.out.println(list2.set(3, "Tom"));
            System.out.println(list2.subList(3, 5));

            list2.clear();
            System.out.println(list2);
      }
}
