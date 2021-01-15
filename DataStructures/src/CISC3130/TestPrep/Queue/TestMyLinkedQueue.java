public class TestMyLinkedQueue {

    public static void main(String[] args) {

        MyQueue<Integer> queue = new MyLinkedQueue<Integer>();

        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }
        System.out.println(queue);

        for (int i = 0; i < 10; i++) {
            System.out.println(queue.remove());
        }
    }
}
