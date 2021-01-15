import java.util.*;

public class MyArrayStack<E> implements MyStack<E> {

    private ArrayList<E> list;

    public MyArrayStack() {
        list = new ArrayList<E>();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public void push(E item) {
        list.add(item);
    }

    public E peek() {
        return list.get(list.size() - 1);
    }

    public E pop() {
        return list.remove(list.size() - 1);
    }

    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("top\n");
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i) + " ");
        }
        sb.append("bottom");

        return sb.toString();
    }


}
