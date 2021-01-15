/*********************************************************************************/
/* Faisal Ibrahim                                                   Extra Credit */
/* CISC 3130                                                                     */
/*                                                                               */
/*********************************************************************************/

package Lists.LinkedList;

import java.util.*;

public class MyLinkedList <E> implements MyList<E> {

    private class MyLinkedListIterator implements Iterator<E> {

        private DListNode<E> pointer;

        public MyLinkedListIterator () {

            pointer = sentinel.getNext();

        }
        public E next() {

            E old = pointer.getData();
            pointer = pointer.getNext();
            return old;

        }
        public boolean hasNext() {

            return pointer != sentinel;

        }

        public void remove() {
            throw new UnsupportedOperationException();
        }


    }// end of Iterator class

    private class DListNode<E> {

        private E data;
        private DListNode<E> previous;
        private DListNode<E> next;

        public DListNode() {
            this(null, null, null);
        }

        public DListNode(E data) {
            this (data, null, null);
        }

        public DListNode(E data, DListNode<E> previous, DListNode<E> next) {
            this. data = data;
            this.previous = previous;
            this.next = next;
        }

        public E getData() {
            return data;
        }
        public DListNode<E> getPrevious(){
            return previous;
        }
        public DListNode<E> getNext(){
            return next;
        }
        public void setData(E data){
            this.data = data;
        }
        public void setPrevious(DListNode<E> previous){
            this.previous = previous;
        }
        public void setNext(DListNode<E> next){
            this.next = next;
        }

    } // end of node class

    // data fields for Linkedlist class
    private DListNode<E> sentinel;
    private int numElements;

    public MyLinkedList() {

        numElements = 0;
        sentinel = new DListNode<E>();
        sentinel.setData(null);
        sentinel.setNext(sentinel);
        sentinel.setPrevious(sentinel);

    }

    public void addFirst(E value) {

        DListNode<E> temp = new DListNode<>(value, null, null);
        temp.data = value;

        if (sentinel.next == sentinel) {

            sentinel.setNext(temp);
            sentinel.setPrevious(temp);
            temp.setPrevious(sentinel);
            temp.setNext(sentinel);

        }
        else {

            sentinel.next.setPrevious(temp);
            sentinel.setNext(temp);
            temp.setPrevious(sentinel);
        }
        numElements++;

    }

    public void addLast(E e) {

        DListNode<E> temp = new DListNode<>(e, null, null);

        if (sentinel.next == sentinel) {

            sentinel.setNext(temp);
            sentinel.setPrevious(temp);
            temp.setPrevious(sentinel);
            temp.setNext(sentinel);

        }
        else {

            temp.setPrevious(sentinel.previous);
            sentinel.previous.setNext(temp);
            temp.setNext(sentinel);
        }
        numElements++;
    }

    // still needs to be fixed

    public E removeFirst() {

        if (sentinel.next == sentinel) {
            throw new NoSuchElementException();
        }

        E answer = sentinel.next.getData();

        if (sentinel.next.getNext() != sentinel) {
            sentinel.setNext(sentinel.next.getNext());
            sentinel.next.next.setPrevious(sentinel);
        }
        else {
            sentinel.setNext(sentinel);
            sentinel.setPrevious(sentinel);
        }
        return answer;
    }

    // toDo
    public E removeLast() {

        if (sentinel.next == sentinel) {
            throw new NoSuchElementException();
        }
        return null;
    }


    public E getFirst() {
       if(sentinel.next == null){
           throw new NoSuchElementException();
        }

        return sentinel.next.getData();
    }
    public E getLast() {
        if(sentinel.next == null){
           throw new NoSuchElementException();
        }
        return sentinel.previous.getData();
    }

    public boolean add(E e) {

        addLast(e);
        return true;
    }

    public boolean add(int index, E Element) {
        return false;
    }

    public void clear() {
        sentinel.next = sentinel;
        sentinel.previous = sentinel;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public boolean equals(Object obj) {

        if (! (obj instanceof MyLinkedList)) {
            return false;
        }
        MyLinkedList<E> another = (MyLinkedList<E>)obj;

        if (another.size() != size()) {
            return false;
        }
        DListNode<E> iter = sentinel.getNext();
        DListNode<E> anotherIter = another.sentinel.getNext();
        while (iter != null) {
            if (! (iter.getData().equals(anotherIter.getData()))) {
                return false;
            }
            iter = iter.getNext();
            anotherIter = anotherIter.getNext();
        }
        return true;
    }

    public E get(int index) {

        if(isOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }

        return marchToIndex(index).getData();
    }

    public E set(int index, E element) {

        if(isOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }

        DListNode<E> iter = marchToIndex(index);
        E old = iter.getData();
        iter.setData(element);

        return old;
    }

    public int indexOf(Object obj) {

        int index = 0;
        DListNode<E> iter = sentinel.getNext();

        while (iter != null) {
            if (iter.getData().equals(obj)) {
                return index;
            }
            index++;
            iter = iter.getNext();
        }
        return -1;
    }

    public boolean isEmpty() {
        return size() == 0;

    }

    public Iterator<E> iterator() {
        return new MyLinkedListIterator();
    }

    public int lastIndexOf(Object obj) {

        int index = size() - 1;
        DListNode<E> iter = sentinel;

        while (iter != null) {
            if (iter.getData().equals(obj)) {
                return index;
            }
            index--;
            iter = iter.getPrevious();
        }
        return -1;
    }
    // toDo
    public E remove(int index){
        return null;
    }
    // toDo
    public boolean remove(Object obj){
        return false;
    }

    public int size() {
        return numElements;
    }

    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("[ ");

        for(E e: this) {
            sb.append(e + " ");
        }

        sb.append("]");

        return sb.toString();

    }

    private boolean isOutOfBounds(int index) {
        return index < 0 || index > size();
    }

    private DListNode<E> marchToIndex(int index) {

        if (isOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }

        int count = 0;
        DListNode<E> temp = sentinel;

        while(count < index) {
            count ++;
            temp = temp.getNext();
        }
        return temp;
    }


}
