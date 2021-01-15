import java.util.*;

public class LinkedQueue<E>  implements MyQueue<E>{

	private LinkedList<E> list;

	public LinkedQueue() {
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

	public static void main(String[] args) {

		MyQueue<Integer> queue = new LinkedQueue<>();

		for(int i=0; i<10; i++)
			queue.add(i);

		for(int i=0; i<3; i++)
			queue.remove();

		System.out.println(queue.peek());
	}
}
