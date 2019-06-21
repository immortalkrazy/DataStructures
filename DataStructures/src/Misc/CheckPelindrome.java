package Misc;

public class CheckPelindrome {

      public static void main(String[] args) {

            System.out.println(args[0] + "is a Palindrome" + isPalindrome(args[0]));

      }

      private static boolean isPalindrome(String str) {

            if (str.length() <= 1) {
                  return true;
            } else if (str.charAt(0) != str.charAt(str.length() - 1)) {
                  return false;
            } else {
                  return isPalindrome(str.substring(1, str.length() - 1));
            }

      }
}
