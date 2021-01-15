import java.util.Iterator;

public class MyArrayList<E> implements Iterable<E> {

  private class MyArrayListIterator implements Iterator<E> {
    private int index;
    // construcort for MyArrayListIterator
    public MyArrayListIterator() {
      index = 0;
    }

    public boolean hasNext() {
      return index < size();
    }

    public E next() {
      index++;
      return arr[index - 1];
    }

    public void remove() {
      throw new UnsupportedOperationException();
    }

  }// end of MyArrayListIterator class

  private E[] arr;
  private int logicalLength;

  // constructor for MyArrayList
  public MyArrayList(int initialCapacity) {
    logicalLength = 0;
    arr = (E[]) new Object[initialCapacity];
  }

  public MyArrayList() {
    this(10);
  }

  public Iterator<E> iterator() {
    return new MyArrayListIterator();
  }

  // add elements to the array
  public boolean add (E e) {
    // first check if space is available
    if (logicalLength == arr.length) {
    // method to change the size of array
      grow();
    }
    arr[logicalLength] = e;
    logicalLength++;
    // return true if element is added
    return true;
  }

  public void add (int index, E element) {

    if (isOutOfBounds(index)) {
      throw new IndexOutOfBoundsException(index + " doesn't exist");
    }
    if (isFull()) {
      grow();
    }
    for (int i = arr.length - 1; i >= index; i--) {
      arr[i+1] = arr[i];
    }
    arr[index] = element;
    logicalLength++;
  }

  public void clear() {
    logicalLength = 0;
  }

  // give the size of arraylist
  public int size() {
    return logicalLength;
  }

  // check if the arraylist is empty
  public boolean empty() {
    return logicalLength == 0;
  }

  // get the index of a specific elements
  public int indexOf(Object obj) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].equals(obj)) {
        return i;
      }
    }
    return -1;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder("[ ");
    for (int i = 0; i < logicalLength; i++) {
      sb.append(arr[i]);
      if (i < logicalLength - 1){
        sb.append(", ");
      }
    }
    sb.append(" ]");
    return sb.toString();
  }

  public boolean remove(Object obj) {
    int index = indexOf(obj);
    if (index == -1) {
      return false;
    }
    remove (index);
    return true;
  }

  public E remove (int index) {
    if (isOutOfBounds(index)) {
      throw new IndexOutOfBoundsException(index + " doesn't exist");
    }
    E data = arr[index];
    for (int i = index + 1; i < size(); i++) {
      arr[i-1] = arr[i];
    }

    logicalLength--;
    return data;
  }

  public int lastIndexOf(Object obj) {
    for (int i = size() - 1; i >= 0; i--) {
      if (arr[i].equals(obj)) {
        return i;
      }
    }
    return -1;
  }

  public E get(int index) {
    if (isOutOfBounds(index)) {
      throw new IndexOutOfBoundsException(index + " doesn't exist");
    }
    return arr[index];
  }

  public E set(int index, E element) {
    if (isOutOfBounds(index)) {
      throw new IndexOutOfBoundsException(index + " doesn't exist");
    }

    E answer = arr[index];
    arr[index] = element;

    return answer;
  }

  public boolean contains(Object obj) {
    return indexOf(obj) != -1;
  }

  public boolean equals(Object obj) {
    if (!(obj instanceof MyArrayList)) {
      return false;
    }
    MyArrayList<E> another = (MyArrayList<E>)obj;
    if (size() != another.size()) {
      return false;
    }
    for (int i = 0; i < size(); i++) {
      if (!(arr[i].equals(another.arr[i]))) {
        return false;
      }
    }
    return true;
  }

  // private helper methods
  private boolean isFull() {
    return logicalLength == arr.length;
  }

  private void grow () {
    // create a new array but double the size
    E[] temp = (E[]) new Object[2 * arr.length];
    // put each elemt from arr into temp
    for (int i = 0; i < arr.length; i++){
      temp[i] = arr[i];
    }
    // make ref of arr to temp
    arr = temp;
  }

  private boolean isOutOfBounds(int index) {
    return index < 0 || index > logicalLength;
  }

}// end of class
