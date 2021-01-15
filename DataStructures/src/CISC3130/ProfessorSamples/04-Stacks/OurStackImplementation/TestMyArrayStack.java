public class TestMyArrayStack {

  public static void main( String[] args) {

      MyArrayStack<Character> stk = new MyArrayStack<Character>();

      for(char ch = 'A'; ch<='Z'; ch++)
           stk.push(ch);

       System.out.println(stk);

       for(int i=0; i<10; i++)
           stk.pop();

       System.out.println(stk.peek());

       System.out.println(stk);

       while(!stk.empty())
           stk.pop();

       System.out.println(stk);
  }
}
