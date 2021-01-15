import java.util.ArrayList;

public class MyArrayStack<E> implements MyStack<E> {

      private ArrayList<E> list;

      public MyArrayStack() {
            list = new ArrayList<E>();
      }

      public boolean empty() {
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
                  sb.append(list.get(i) + "\n");
            }
            sb.append("bottom\n");

            return sb.toString();
      }
}
