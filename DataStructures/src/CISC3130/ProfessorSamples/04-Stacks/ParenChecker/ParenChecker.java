import java.util.*;

public class ParenChecker {

    private String str;

    private static boolean isOpenParen(char ch) {
        return ch=='(' || ch=='[' || ch=='{';
    }

    private static boolean isCloseParen(char ch) {
        return ch==')' || ch==']' || ch=='}';
    }

    private static boolean isMatch(char opener, char closer) {
        return opener=='(' && closer==')'
        ||     opener=='[' && closer==']'
        ||     opener=='{' && closer=='}';
    }


    public ParenChecker(String str) {
        this.str = str;
    }






    public boolean isProperlyNested() {


        MyArrayStack<Character> charStack = new MyArrayStack<>();

        for(int i=0; i<str.length(); i++) {
            char currentChar = str.charAt(i);

            if(isOpenParen(currentChar)) {
                charStack.push(currentChar);
            }
            if(isCloseParen(currentChar)) {
                if(charStack.empty()) {
                    return false;           //if the stack is empty and I'm looking at a close parentheses
                }else {
                    char topChar = charStack.pop();

                    if(!isMatch(topChar, currentChar)) {
                        return false;   //if the char I'm looking at is not the closer for the opener on top of the stack.
                    }
                }
            }
        }

        return charStack.empty(); //if I go through the whole string and the stack is empty, then my string is balanced.
                                // however, if the stack still has data on it, the string isn't balanced.
    }


    public static void main(String[] args) {

        if(args.length != 1) {
            System.err.println("Error: Correct Usage is \"java ParenChecker string\"");
            System.exit(1);
        }

        ParenChecker pChecker = new ParenChecker(args[0]);

        System.out.println(pChecker.isProperlyNested());




    }





}
