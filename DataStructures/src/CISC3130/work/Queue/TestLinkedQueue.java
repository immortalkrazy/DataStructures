public class TestLinkedQueue<E> {

      public static void main(String[] args) {

            LinkedQueue<Integer> queue = new LinkedQueue<Integer>();

            for (int i = 0; i < 10; i++) {
                  queue.add(i);
            }
            System.out.println(queue.peek());

            for (int i = 0; i < 3; i++) {
                  queue.remove();
            }
            System.out.println(queue.peek());

      }
}
