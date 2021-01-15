public class RecursivePalindrome{

  public static boolean isPalindrome(String s){
    return isPalindrome(s, 0, s.length()-1);
  }
  // helper method
  private static boolean isPalindrome(String s, int low, int high){
    if (high <= low){
      return true;
    }
    else if (s.charAt(low) != s.charAt(high)){
      return false;
    }
    else {
      return isPalindrome(s, low + 1, high - 1);
    }
  }

  public static void main (String[] args){
    System.out.println("Is moon a palindrome: " + isPalindrome("moon"));
    System.out.println("Is racecar a palindrome: " + isPalindrome("racecar"));
    System.out.println("Is aba a palindrome: " + isPalindrome("aba"));
    System.out.println("Is c a palindrome: " + isPalindrome("c"));
  }

}
