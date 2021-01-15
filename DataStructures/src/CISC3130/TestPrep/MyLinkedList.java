import java.util.*;

public class MyLinkedList<E> implements MyList<E> {

  private DListNode<E> head;
  private DListNode<E> tail;
  private int numElements;

  public MyLinkedList(){
    head = null;
    tail = null;
    numElements = 0;
  }

  private static class DListNode<E> {

    private E data;
    private DListNode<E> previous;
    private DListNode<E> next;

    public DListNode(E data, DListNode<E> previous, DListNode<E> mext) {
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
    public DListNode<E> getNext(){
      return next;
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

  }// end of DListNode
  private class MyLinkedListIterator implements Iterator<E> {

    DListNode<E> pointer;

    public MyLinkedListIterator() {
      pointer = head;
    }
    public boolean hasNext() {
      return pointer != null;
    }
    public E next() {
      E old = pointer.getData();
      pointer = pointer.getNext();
      return old;
    }
    public void remove() {
      throw new UnsupportedOperationException();
    }

  }// end of Iterator

  public Iterator<E> iterator() {
    return new MyLinkedListIterator();
  }
  public void addFirst(E e){
    DListNode<E> temp = new DListNode<E> (e, null, null);
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
    DListNode<E> temp = new DListNode<E> (e, null, null);
    if (head == null) {
      head = temp;
      tail = temp;
    }
    else {
        temp.setPrevious(tail);
        tail.setNext(temp);
        numElements++;
    }
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
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[ ");
    for (E e: this) {
      sb.append(e + " ");
    }
    sb.append(" ]");
    return sb.toString();
  }
  public boolean equals(Object obj) {
    if (! (obj instanceof MyLinkedList)) {
      return false;
    }
    MyLinkedList<E> another = (MyLinkedList<E>)obj;
    if (size() != another.size()){
      return false;
    }
    DListNode<E> iter = head;
    DListNode<E> anotherIter = another.head;
    while(iter != null) {
      if (! (iter.getData().equals(anotherIter.getData()))){
        return false;
      }
      iter = iter.getNext();
      anotherIter = anotherIter.getNext();
    }
    return true;
  }



  // public boolean add(E e);
  // public void add(int index, E element);
  // public E remove (int index);
  // public boolean remove(Object obj);
  public int size() {
    return numElements;
  }
  // public int clear();
  // public boolean isEmpty();
  // public boolean contains(Object obj);
  // public E get(int index);
  // public E set(int index, E element);
  // public int indexOf(Object obj);
  // public int lastIndexOf(Object obj);
  // public boolean equals(Object obj);
  //














}
