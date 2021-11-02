package stack;

import java.util.ArrayList;

public class MyArrayStack<E> implements MyStack<E> {

      private ArrayList<E> list = new ArrayList<E>();

      @Override
      public void push(E item) {
            list.add(item);
      }

      @Override
      public E peek() {
            return list.get(list.size() - 1);
      }

      @Override
      public E pop() {
            return list.remove(list.size() - 1);
      }

      @Override
      public boolean empty() {
            return list.size() == 0;
      }

      @Override
      public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("top\n");
            for (int i = list.size() - 1; i >= 0; i--) {
                  sb.append(list.get(i) + "\n");
            }
            sb.append("bottom");

            return sb.toString();
      }

}
