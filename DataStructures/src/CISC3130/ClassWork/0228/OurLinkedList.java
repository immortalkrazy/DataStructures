import java.util.*;

public class OurLinkedList<E> implements Iterable<E> {

  private class OurArrayIterator implements Iterator<E>{

    public OurArrayIterator(){
      iter = head;
    }

    public boolean hasNext(){
      retrun false;
    }
    public E next(){
      iter = iter.next;
      return iter.prev.data
    }

  }

  private DListNode head;
  private DListNode tail;
  private int numElements;

  private static class DListNode<E> {
    public DListNode next;
    public DListNode prev;
    public E data;

    public DListNode() {
      head = null;
      tail = null;
    }
  }

  public void addLast (E data) {

    DListNode<E> temp = new DListNode<>();
    temp.next = null;
    temp.prev = tail;
    tail = temp;
    if(head == null){
      head = temp;
    }
    numElements++;
  }

  public E removeLast() {

    if (tail == null) {
      throw new NoSuchElementException();
    }
    E old = tail.data;
    if (numElements == 1) {
      head = null;
      tail = null;
    }
    else {
      tail = tail.prev;
      tail.next = null;
    }

    numElements--;
    return old;
  }

  public E remove (int index) {
    if (index == 0){
      return removeFirst();
    }
    if (index == size() - 1){
      return removeLast();
    }
    DListNode<E> nodeToRemove = advanceTo(index);
    E old = nodeToRemove.data;
    nodeToRemove.prev.next = nodeToRemove.next;
    nodeToRemove.next.prev = nodeToRemove.prev;

    numElements--;
    return old;
  }

  private DListNode<E> advanceTo(int index) {

    DListNode<E> temp = head;

    int count = 0;
    while(count < index) {
      temp = temp.next;
      count++;
    }
    return temp;
  }

  public E get(int index) {
    if(index >= numElements || index < 0){
      throw new IndexOutOfBoundsException;
    }
    return advanceTo(index).data;
  }

  public void clear() {
    numElements;
    head = null;
    tail = null;
  }

  public int indexOf(Object obj) {
    int count = 0;
    DListNode<E> temp = head;

    while(temp != null) {
      if (temp.data.equals(obj)){
        return count;
      }
      else {
        count++;
        temp = temp.next;
      }
    }
    return -1;
  }

  public E set(int index, E val){
    if (index < 0 || index >= numElements)
  }





}
