public class TestMyArrayStack<E> {

      public static void main(String[] args) {

            MyStack<Character> stack = new MyArrayStack<Character>();

            for (char ch = 'A'; ch <= 'Z'; ch++) {
                  stack.push(ch);
            }
            System.out.println(stack);

            for (int i = 0; i < 25; i++) {
                  stack.pop();
            }
            System.out.println(stack.peek());

            while(!stack.empty()) {
                  stack.pop();
            }
            System.out.println(stack);

      }
}
