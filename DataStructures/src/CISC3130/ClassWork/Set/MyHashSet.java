import java.util.*;

public class MyHashSet<E> implements Iterable<E> {

    private ArrayList<LinkedList<E>> theTable;
    private int numElements;

    public MyHashSet() {
        theTable = new ArrayList<>();
        numElements = 0;
        for (int i = 0; i < 20; i++) {
            theTable.add(new LinkedList<>());
        }
    }

    public boolean add(E item) {

        if (contains(item))
            return false;

        int index = item.hashCode();
        index% = theTable.size();

        theTable.get(index).addFirst(item);

        numElements++;
        return true;

    }

    public boolean contains (Object obj) {
        int index = obj.hashCode();
        index % = theTable.size();

        return theTable.get(index).contains(obj);
    }

    public Iterator<E> iterator() {
        return new SetIterator();
    }

    private class SetIterator implements Iterator<E>  {

    return new SetIterator();

    }

    public int size() {
        return numElements;
    }

    public boolean isEmpty() {
        return numElements == 0;
    }

    public boolean remove(Object obj) {

        int index = item.hashCode();
        index %= theTable.size();

        theTable.get(index).
    }

    public String toString() {

        String result = " ";

        for( E e : this) {
            result += e + "\n";
        }

        return result;
    }

    private class SetIterator implements Iterator<E> {
        Deque<E> keys
    }
}
