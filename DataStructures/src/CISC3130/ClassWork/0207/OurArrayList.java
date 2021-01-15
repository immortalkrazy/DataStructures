import java.util.*;

public class OurArrayList <E> {

  private E[] arr;
  private int numElements;

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

  //public boolean remove(Object obj);

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
  //
  // public boolean contains(Object obj);
  //
  // public boolean equals(Object obj);
  //
  // public int indexOF(Object obj);

}// end of class
