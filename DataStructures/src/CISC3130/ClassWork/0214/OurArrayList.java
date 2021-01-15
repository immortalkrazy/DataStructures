import java.util.*;

public class OurArrayList <E> implements Iterable<E> {

  private class OurArrayIterator implements Iterator<E> {
    // private class variable
    private int index;

    public OurArrayIterator() {
      index = 0;
    }
    // iterator to check if there is next element
    public boolean hasNext() {
      return index < numElements;
    }

    public E next() {
      index ++;
      return get(index - 1);
    }

    public void remove(){
      throw new UnsupportedOperationException();
      //remove(index - 1);
    }
  }// end Iterator of class

  // private data fields for OurArrayList class
  private E[] arr;
  private int numElements;

  public Iterator<E> iterator() {
    return new OurArrayIterator();
  }

  public OurArrayList(){
      numElements  = 0;
      arr = (E[])new Object[20];
  }
  // add an element to the array
  public boolean add (E e){
    // check if the size is avaialable
    if (numElements == arr.length) {
      grow();
    }
    //add the element to array
    arr[numElements] = e;
    numElements++;

    return true;
  }

  private void grow(){
    // create a new array of double the length
    E[] temp = (E[]) new Object[2 * arr.length];
    // now copy the old array into the new array
    for (int i = 0; i < arr.length; i++){
      temp[i] = arr[i];
    }
    // now rename temp array to the actual arraylist
    arr = temp;
  }
  // get the size of the current array
  public int size(){
      return numElements;
  }
  // check if array is empty
  public boolean empty(){
    return numElements == 0;
  }

  public E remove(int index) {
    E value = arr[index];
    for(int i = index+1; i < numElements; i++){
      arr[i - 1] = arr[i];
    }
    numElements--;
    return value;
  }

  public boolean remove(Object obj){
    // use indexOf method
    int index = indexOf(obj);
    if (index == -1){
      return false;
    }
    // use other remove method
    remove(index);

    return true;
  }

  // get the element in the array from a specific index
  public E get(int index){
    if(index >= numElements || index < 0){
      throw new IndexOutOfBoundsException();
    }
    return arr[index];
  }
  // set a certain value at a certain index
  public E set(int index, E value){
    if (index < 0 || index >= numElements){
      throw new IndexOutOfBoundsException();
    }
    E old = arr[index];
    arr[index] = value;

    return old;
  }
  //
  public void clear(){
    numElements = 0;
  }
  // check if the elemnts exists
  public boolean contains(Object obj){
  //use inedxOf method in our own implentation
    return indexOf(obj)!= -1;
  }
  //
  // public boolean equals(Object obj);
  //
  public int indexOf(Object obj){

    for (int i = 0; i < numElements; i++){
      if(arr[i].equals(obj)){
        return i;
      }
    }
    return -1;
  }


  // set with the new array
  public void add(int index, E value){
    // check if there is enough room
    if (numElements == arr.length){
      grow();
    }
    // move backwards and add elements
    /* 2 3 4 5 6
       2 3 1 4 5 6 */
    for (int i = numElements-1; i >= index; i--){
      arr[i+1] = arr[i];
    }
    // put the element at the index
    arr[index] = value;
    numElements++;
  }

  public String toString() {
    String result = "";

    for(E e: this){
      result += e + " ";
    }
    return result;
  }


  // tests for our arraylist
  public static void main(String[] args) {

    OurArrayList<Integer> list;
    list = new OurArrayList<>();

    OurArrayList<String> listS = new OurArrayList<>();

    listS.add("hello");
    listS.add("World");
    listS.add("!");

    for (int i = 0; i < 10; i++){
      list.add(i);
    }
    list.printList(list);

    list.add(3, 5);
    list.printList(list);

    list.add(32);
    list.printList(list);

    System.out.println("if the arraylist contains 5: " + list.contains(5));
    System.out.println("if the arraylist contains 45: " + list.contains(45));

    list.clear();
    list.printList(list);

    list.printList(listS);

    list.remove(10);
    list.printList(list);


  }// end of main

  public void printList(OurArrayList list){
    if (list.size() == 0){
      System.out.println("Arraylist is empty");
    }
    System.out.println();
    for (int i = 0; i < list.size(); i++){
      System.out.print(list.get(i) + " ");
    }
    System.out.println();
  }

}// end of class
