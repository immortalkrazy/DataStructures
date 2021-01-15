import java.util.*;

public class MyLinkedList<E> implements MyList<E> {

    private static class DListNode<E> {
        private E data;
        private DListNode<E> previous;
        private DListNode<E> next;

        public DListNode(E data, DListNode<E> previous, DListNode<E> next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }
        public E getData() {
            return data;
        }
        public DListNode<E> getNext() {
            return next;
        }
        public DListNode<E> getPrevious() {
            return previous;
        }

        public void setData(E data) {
            this.data = data;
        }
        public void setPrevious(DListNode<E> previous) {
            this.previous = previous;
        }
        public void setNext(DListNode<E> next) {
            this.next = next;
        }
    }

    //we have to maintain a reference to the beginning and the end of the list.
    //we also have to keep track of the number of elements so that size() can run in O(1) time.
    private DListNode<E> head;
    private DListNode<E> tail;
    private int numElements;

    public MyLinkedList() {
        head = null;
        tail = null;
        numElements = 0;
    }

    public void addFirst(E e) {
        //create a new node whose data is "e" and whose next and previous are null.
        DListNode<E> temp = new DListNode<>(e, null, null);

        //if there are no elements, then set the head and tail of the list to the new node.
        if(head==null) {
            head = temp;
            tail = temp;

        //otherwise, set the new node's next to be the old head, and set the old head's previous to be the new node.
        }else {
            temp.setNext(head);
            head.setPrevious(temp);
            head = temp; //set the head of the list to be the new node.
        }
        numElements++;

    }
    //this is the symmetric case to the addFirst
    public void addLast(E e) {
        DListNode<E> temp = new DListNode<E>(e, null, null);

        if(head==null) {
            head =temp;
            tail = temp;
        }else {
            temp.setPrevious(tail);
            tail.setNext(temp);
            tail = temp;
        }
        numElements++;
    }

    public E getFirst() {
        if(head==null)
            throw new NoSuchElementException();

        return head.getData();
    }

    public E getLast() {
        if(head==null)
            throw new NoSuchElementException();

        return tail.getData();
    }

    public E removeFirst() {
        //if there are no elements, throw an exception
        if(head==null)
            throw new NoSuchElementException();

        //remember the data stored at the old head of the list
        E answer = head.getData();
        head = head.getNext(); //skip the head reference to the next element.

        if(head!=null)
            head.setPrevious(null); //set the new head's previous to null if it exists.

        numElements--;
        return answer;
    }


    public E removeLast() {
        if(head==null)
            throw new NoSuchElementException();
        E answer = tail.getData();
        tail = tail.getPrevious();

        if(tail!=null)
            tail.setNext(null);

        numElements--;
        return answer;
    }
    public boolean add(E e) {
        addLast(e);

        return true;
    }

    public void add(int index, E element) {
        if(isOutOfBounds(index))
            throw new IndexOutOfBoundsException();

        if(index==0)
            addFirst(element);
        else if(index==size()-1)
            addLast(element);
        else {
            DListNode<E> pointer = marchToIndex(index-1);

            DListNode<E> newNode = new DListNode<>(element, pointer, pointer.getNext());

            numElements++;
        }
    }

    public void clear() {
        head=null;
        tail=null;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public boolean equals(Object obj) {
        if(! (obj instanceof MyLinkedList))
            return false;
        MyLinkedList<E> another = (MyLinkedList<E>)obj;

        if(another.size() != size())
            return false;

        DListNode<E> iter = head;
        DListNode<E> anotherIter = another.head;
        while(iter!=null) {
            if(!(iter.getData().equals(anotherIter.getData())))
                return false;
            iter = iter.getNext();
            anotherIter = anotherIter.getNext();
        }
        return true;

    }

    public E get(int index) {
        if(isOutOfBounds(index))
            throw new IndexOutOfBoundsException();

        return marchToIndex(index).getData();
    }

    public E set(int index, E element) {
        if(isOutOfBounds(index))
            throw new IndexOutOfBoundsException();

        DListNode<E> iter = marchToIndex(index);
        E old = iter.getData();
        iter.setData(element);
        return old;
    }

    public int indexOf(Object obj) {

        int index=0;
        DListNode<E> iter = head;

        while(iter!=null) {
            if(iter.getData().equals(obj))
                return index;
            index++;
            iter=iter.getNext();
        }
        return -1;

    }

    public boolean isEmpty() {
        return size()==0;
    }

    public Iterator<E> iterator() {
        return new MyLinkedListIterator();
    }

    public int lastIndexOf(Object obj) {
        int index=size()-1;
        DListNode<E> iter = tail;

        while(iter!=null) {
            if(iter.getData().equals(obj))
                return index;
            index--;
            iter=iter.getPrevious();
        }
        return -1;

    }

    public E remove(int index) {
        if(isOutOfBounds(index))
            throw new IndexOutOfBoundsException();

        if(index==0)
            return removeFirst();
        else if(index==size()-1)
            return removeLast();
        else {
            DListNode<E> iter = marchToIndex(index);
            E old = iter.getData();
            iter.getPrevious().setNext(iter.getNext());
            iter.getNext().setPrevious(iter.getPrevious());

            numElements--;

            return old;
        }


    }

    public boolean remove(Object obj) {
        int index = indexOf(obj);
        if(index==-1)
            return false;
        else {
            remove(index);
            return true;
        }
    }

    public int size() {
        return numElements;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");

        for(E e: this)
            sb.append(e + " ");
        sb.append("]");
        return sb.toString();

    }

    private boolean isOutOfBounds(int index) {
        return index<0 || index>=size();
    }

    private DListNode<E> marchToIndex(int index) {
        if(isOutOfBounds(index))
            throw new IndexOutOfBoundsException();

        int count = 0;
        DListNode<E> temp = head;

        while(count<index) {
            count++;
            temp = temp.getNext();
        }
        return temp;
    }
    private class MyLinkedListIterator implements Iterator<E> {
        private DListNode<E> pointer;

        public MyLinkedListIterator() {
            pointer = head;
        }
        public E next() {
            E old = pointer.getData();
            pointer = pointer.getNext();
            return old;
        }
        public boolean hasNext() {
            return pointer!=null;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> aList = new MyLinkedList<>();

        for(int i=0; i<10; i++)
            aList.addFirst(i+1);

        System.out.println(aList);

    }


}
