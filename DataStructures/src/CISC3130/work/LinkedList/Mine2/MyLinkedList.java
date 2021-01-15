import java.util.*;

public class MyLinkedList<E>  implements MyList<E> {

      private static class DListNode<E> {

            private E data;
            private DListNode<E> previous;
            private DListNode<E> next;

            public DListNode (E data, DListNode<E> previous, DListNode<E> next) {
                  this.data = data;
                  this.previous = previous;
                  this.next = next;
            }

            public E getData() {
                  return data;
            }
            public DListNode<E> getPrevious() {
                  return previous;
            }
            public DListNode<E> getNext() {
                  return next;
            }

            public void setData (E data) {
                  this.data = data;
            }
            public void setPrevious(DListNode<E> previous) {
                  this.previous = previous;
            }
            public void setNext (DListNode<E> next) {
                  this.next = next;
            }

      }// end of node class

      private DListNode<E> head;
      private DListNode<E> tail;
      private int numElements;

      public MyLinkedList () {
            head = null;
            tail = null;
            numElements = 0;
      }

      public void addFirst (E e) {

            DListNode<E> temp = new DListNode<E>(e, null, null);
            if (head == null) {
                  head = temp;
                  tail = temp;
            }
            else {
                  temp.setNext(head);
                  head.setPrevious(temp);
                  head = temp;
            }
            numElements++;
      }

      public void addLast(E e) {
            DListNode<E> temp = new DListNode<E>(e, null, null);
            if(head == null) {
                  head = temp;
                  tail = temp;
            }
            else {
                  temp.setPrevious(tail);
                  tail.setNext(temp);
                  tail = temp;
            }
            numElements++;
      }

      public E getFirst() {
            if (head == null) {
                  throw new NoSuchElementException();
            }
            return head.getData();
      }

      public E getLast() {
            if (head == null) {
                  throw new NoSuchElementException();
            }
            return tail.getData();
      }

      public E removeFirst() {

            if (head == null) {
                  throw new NoSuchElementException();
            }

            E answer = head.getData();
            head = head.getNext();

            if (head != null) {
                  head.setPrevious(null);
            }
            numElements--;
            return answer;
      }

      public E removeLast() {
            if (head == null) {
                  throw new NoSuchElementException();
            }
            E answer = tail.getData();
            tail = tail.getPrevious();

            if (tail != null) {
                  tail.setNext(null);
            }
            numElements--;
            return answer;
      }

      private class MyLinkedListIterator implements Iterator<E> {

            private DListNode<E> pointer;

            public MyLinkedListIterator() {
                  pointer = head;
            }

            public boolean hasNext() {
                  return pointer != null;
            }

            public E next() {
                  E old = head.getData();
                  pointer = pointer.getNext();
                  return old;
            }

            public void remove() {
                  throw new UnsupportedOperationException();
            }
      }// end of iterator;

      public Iterator<E> iterator() {
            return new MyLinkedListIterator();
      }







      // public boolean add(E e);
      // public boolean add(int index, E Element);
      // public void clear();
      // public boolean contains(Object obj);
      // public boolean equals(Object obj);
      // public E get(int index);
      // public E set(int index, E element);
      // public int indexOf(Object obj);
      // public boolean isEmpty();

      // public int lastIndexOf(Object obj);
      // public E remove(int index);
      // public boolean remove(Object obj);
      // public int size();


}// end of my linked list class
