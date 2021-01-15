import java.util.LinkedList;

public class LinkedQueue<E> implements MyQueue<E> {

      private LinkedList<E> list;

      public LinkedQueue () {
            list = new LinkedList<E>();
      }

      public boolean add(E item) {
            list.addLast(item);
            return true;
      }

      public E remove() {
            return list.removeFirst();
      }

      public E peek() {
            return list.getFirst();
      }

      public boolean isEmpty() {
            return list.isEmpty();
      }

}
