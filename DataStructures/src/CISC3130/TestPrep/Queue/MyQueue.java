public interface MyQueue<E> {

    public boolean add(E item);
    public E peek();
    public E remove();
    public boolean isEmpty();
    
}
