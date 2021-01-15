import java.util.*;

public class MyArrayList<E> implements MyList<E> {

    private class ArrayListIterator implements Iterator<E> {
        private int index;

        public ArrayListIterator() {
            index=0;
        }

        public boolean hasNext() {
            return index < size();
        }
        public E next() {
            index++;
            return arr[index-1];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private E[] arr;
    private int logicalLength;

    public MyArrayList(int initCapacity) {
        arr = (E[]) new Object[initCapacity];
        logicalLength = 0;
    }

    public MyArrayList() {
        this(4);
    }

    public boolean add(E e) {
        if(isFull())
            grow();
        arr[logicalLength] = e;
        logicalLength++;
        return true;
    }

    public void add(int index, E element) {
        if(isOutOfBounds(index))
            throw new IndexOutOfBoundsException(index + " doesn't exist");
        if(isFull())
            grow();
        for(int i=arr.length-1; i>=index; i--)
            arr[i+1] = arr[i];
        arr[index] = element;
        logicalLength++;
    }


    public void clear() {
        logicalLength = 0;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public boolean equals(Object obj) {
        if(!(obj instanceof MyArrayList))
            return false;

        MyArrayList<E> another = (MyArrayList<E>)obj;
        if(size() != another.size())
            return false;

        for(int i=0; i<size(); i++)
            if(! (arr[i].equals(another.arr[i])))
                return false;

        return true;
    }

    public E get(int index) {
        if(isOutOfBounds(index))
            throw new IndexOutOfBoundsException(index + " doesn't exist");

        return arr[index];
    }

    public E set(int index, E element) {
        if(isOutOfBounds(index))
            throw new IndexOutOfBoundsException(index + " doesn't exist");

        E answer = arr[index];

        arr[index] = element;

        return answer;
    }

    public int indexOf(Object obj) {
        for(int i=0; i<size(); i++)
            if(arr[i].equals(obj))
                return i;
        return -1;
    }

    public boolean isEmpty() {
        return size()==0;
    }

    public int size() {
        return logicalLength;
    }

    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    public int lastIndexOf(Object obj) {
        for(int i=size()-1; i>=0; i--)
            if(arr[i].equals(obj))
                return i;
        return -1;

    }

    public E remove(int index) {
        if(isOutOfBounds(index))
            throw new IndexOutOfBoundsException(index + " doesn't exist");
        E data = arr[index];
        for(int i=index+1; i<size(); i++)
            arr[i-1] = arr[i];

        logicalLength--;
        return data;
    }

    public boolean remove(Object obj) {
        int index = indexOf(obj);

        if(index==-1)
            return false;

        remove(index);
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        for(int i=0; i<logicalLength; i++) {
            sb.append(arr[i]);
            if(i < logicalLength-1)
                sb.append(", ");
        }

        sb.append("]");

        return sb.toString();
    }

    private void grow() {
        int newCapacity = 2 * arr.length;
        E[] temp = (E[]) new Object[newCapacity];
        for(int i=0; i<logicalLength; i++)
            temp[i] = arr[i];
        arr = temp;
    }
    private boolean isFull() {
        return logicalLength == arr.length;
    }
    private boolean isOutOfBounds(int index) {
        return index<0 || index>=logicalLength;
    }

    public static void main(String[] args) {

        MyArrayList<Integer> list = new MyArrayList<Integer>();

        for(int i=0; i<10; i++)
            list.add(i+10);

        for(Iterator<Integer> it = list.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }

        for(int x: list)
            System.out.println(x);

        System.out.println(list);

        list.remove((Integer)10);


        System.out.println(list);
    }

}
