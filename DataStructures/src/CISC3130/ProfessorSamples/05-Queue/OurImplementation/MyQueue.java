public interface MyQueue<E> {

	public boolean add(E item);

	public E remove();

	public E peek();

	public boolean isEmpty();
}
