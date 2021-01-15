public class TestMyArraystack {

    public static void main (String[] args) {

        MyArrayStack<Character> stk = new MyArrayStack<Character>();

        for (char ch = 'A'; ch <= 'Z'; ch++) {
            stk.push(ch);
        }
        System.out.println(stk.peek());

        System.out.println(stk);

        while(!stk.isEmpty()) {
            stk.pop();
        }

        System.out.println(stk);
    }
}
