import java.util.*;

public class OurLinkedList<E> {

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
  }
}
