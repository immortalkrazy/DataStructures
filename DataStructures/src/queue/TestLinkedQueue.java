package queue;

public class TestLinkedQueue {

      public static void main(String[] args) {

            MyQueue<Integer> queue = new LinkedQueue<>();

            for (int i = 0; i < 10; i++) {
                  queue.add(i);
            }

            for (int i = 0; i < 4; i++) {
                  System.out.println(queue.remove());
            }

            System.out.println(queue.peek());
      }

}
