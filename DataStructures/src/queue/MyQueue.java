package queue;

public interface MyQueue<E> {

      public boolean isEmpty();

      public boolean add(E item);

      public E remove();

      public E peek();

}
