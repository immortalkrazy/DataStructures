import java.util.*;

public class MySet<E> implements Iterable<E> {

    private class SetIterator implements Iterator<E> {
        private ArrayList<E> elems;
        private int index;

        SetIterator() {
            elems = scrapeTable();
            index = 0;
        }

        public E next() {
            index++;
            return elems.get(index-1);
        }
        public boolean hasNext() {
            return index < elems.size();
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    private ArrayList<E> scrapeTable() {
        ArrayList<E> elems = new ArrayList<>();

        for(LinkedList<E> list : theTable)
            for(E item: list)
                elems.add(item);
        return elems;
    }
    private ArrayList<LinkedList<E>> theTable;
    private int numElements;

    public MySet(int numBuckets) {
        theTable = new ArrayList<>();

        for(int i=0; i<numBuckets; i++)
            theTable.add(new LinkedList<>());

        numElements = 0;


    }

    public MySet() {
        this(10);
    }

    private int whichBucket(Object data) {
        return data.hashCode() % theTable.size();
    }

    public boolean add(E data) {
        if(contains(data))
            return false;

        int bucketNo = whichBucket(data);

        theTable.get(bucketNo).add(data);
        numElements++;
        return true;
    }


    public boolean remove(Object obj) {
        if(!contains(obj))
            return false;

        int bucketNo = whichBucket(obj);
        LinkedList<E> listToSearch = theTable.get(bucketNo);

        listToSearch.remove(obj);
        numElements--;
        return true;
    }

    public boolean contains(Object obj) {
        int bucketNo = whichBucket(obj);
        LinkedList<E> listToSearch = theTable.get(bucketNo);
        return listToSearch.contains(obj);
    }

    public void clear() {
        for(LinkedList<E> list:theTable)
            list.clear();
        numElements=0;
    }

    public Iterator<E> iterator() {
        return new SetIterator();
    }


    public int size() {
        return numElements;
    }

    public boolean isEmpty() {
        return size()==0;
    }

    public static void main(String[] args) {

        MySet<Integer> set = new MySet<>();
        Random r = new Random();
        for(int i=0; i<50; i++)
            set.add(r.nextInt(100));

        for(int x: set)
            System.out.print(x + " ");
        System.out.println();
        System.out.println(set.size());


    }


}
