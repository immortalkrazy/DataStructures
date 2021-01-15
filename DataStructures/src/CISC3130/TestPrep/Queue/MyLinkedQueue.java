import java.util.*;

public class MyLinkedQueue<E> implements MyQueue<E> {

    private LinkedList<E> list;

    public MyLinkedQueue() {
        list = new LinkedList<E>();
    }

    public boolean add(E item) {
        list.addLast(item);
        return true;
    }

    public E peek () {
        return list.getFirst();
    }
    //toDo
    public E remove() {
        return list.removeFirst();
    }
    //toDo
    public boolean isEmpty() {
        return list.isEmpty();
    }
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("LastIn ");
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i) + " ");
        }
        sb.append(" FirstOut");

        return sb.toString();
    }

}
