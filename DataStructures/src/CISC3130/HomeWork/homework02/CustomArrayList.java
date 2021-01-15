import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomArrayList <T> implements Iterable<T> {

  List<T> myList = new ArrayList<T>();

  @Override
  public Iterator<T> iterator() {
    return new CustomIterator<T>(myList);
  }

  public class CustomIterator<E> implements Iterator<E> {

    private int indexPosition = 0;
    List<E> internalList;

    public CustomIterator(List<E> internalList) {
      this.internalList = internalList;
    }

    @Override
    public boolean hasNext() {
      if(internalList.size() >= indexPosition + 1){
        return true;
      }
      return false;
    }

    @Override
    public E next() {
      E val = internalList.get(indexPosition);
      indexPosition++;
      return val;
    }

  } // end of custom iterator class


}// end of custom array clss
