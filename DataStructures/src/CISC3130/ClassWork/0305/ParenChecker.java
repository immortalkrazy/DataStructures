public class ParenChecker {

  private ArrayStack<Character>  stack;
  private String expr;

  public ParenChecker(String expr) {
    this.expr = expr;
    stack = new Stra
  }

  public boolean isMatched() {

    for (int i = 0; i < str.length(); i){
      char ch = expr.CharAt(i);
      if(isOpen(ch)) {
        stack.push(ch);
      }
      else if(isClose(ch)){
        if (stack.isEmpty()){
          return false;
        }
        if (isMatch(stack.peek(), ch)){
          stack.pop();
        }
        else return false;
      }
    }
    return
  }

  private static boolean isOpen(char ch) {
    return ch == '(' || ch == '{' || ch == '[';
  }

  private static boolean isClose(char ch) {
    return ch == ')' || ch == ']' || ch == ']';
  }

  private static
}
86<M?>
