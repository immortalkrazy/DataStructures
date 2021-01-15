
public class MyArrayList<E> implements MyList<E> {

  private E[] arr;
  private int logicalLength;

  public MyArrayList() {
    this(4);
  }

  public MyArrayList(int initialCapacity){
    arr = (E[]) new Object[initialCapacity];
    logicalLength = 0;
  }

  private MyArrayListIterator implements Iterator<E> {

    private int index;

    public MyArrayListIterator(){
      index = 0;
    }
    public boolean hasNext() {
      return index < logicalLength;
    }
    public E next() {
      index++;
      return arr[index - 1];
    }
    public void remove() {
      throw new UnsupportedOperationException();
    }

  } // end of iterator

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[ ");
    for (int i = 0; i < logicalLength(); i++){
      sb.append(arr[i]);
      if (i < logicalLength - 1) {
        sb.append(", ");
      }
    }
    sb.append(" ]");
    return sb.toString
  }

  public boolean equals(Object obj) {
    if (! (obj instanceof(MyArrayList))){
      return false;
    }
    MyArrayList<E> another = (MyArrayList<E>)obj;
    if (size() != another.size()){
      return false;
    }
    for (int i = 0; i < another.size(); i++) {
      if (! (arr[i].equals(another.arr[i]))){
        return false;
      }
    }
    return true;
  }
  public Iterator<E> iterator() {
    return new MyArrayListIterator();
  }
  public boolean add(E e) {
    if (isFull()) {
      grow();
    }
    arr[logicalLength] = e;
    logicalLength++;
    return true;
  }
  public void add(int index, E element){
    if (isOutOfBounds()) {

    }
  }
  public E remove (int index);
  public boolean remove(Object obj);
  public int size();
  public int clear();
  public boolean isEmpty();
  public boolean contains(Object obj);
  public E get(int index);
  public E set(int index, E element);
  public int indexOf(Object obj);
  public int lastIndexOf(Object obj);
  public boolean equals(Object obj);

  private boolean isFull() {
    return logicalLength == arr.length;
  }
  private grow() {
    int newCapacity = 2 * arr.length;
    E[] temp = (E[]) new Object[newCapacity];
    for (int i = 0; i < logicalLength; i++) {
      temp[i] = arr[i];
    }
    arr = temp;
  }
  private boolean isOutOfBounds(int index){

  }


}
