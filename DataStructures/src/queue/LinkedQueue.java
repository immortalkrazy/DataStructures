package queue;

import java.util.LinkedList;

public class LinkedQueue<E> implements MyQueue<E> {

      private LinkedList<E> list;

      public LinkedQueue() {
            list = new LinkedList<E>();
      }

      @Override
      public boolean isEmpty() {

            return list.isEmpty();
      }

      @Override
      public boolean add(E item) {

            list.addLast(item);
            return true;
      }

      @Override
      public E remove() {

            return list.removeFirst();
      }

      @Override
      public E peek() {

            return list.getFirst();
      }

}
