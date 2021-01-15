import java.util.*;

public class StringLengthComparator implements Comparator<String> {

      public int compare(String str1, String str2) {

            int value = str1.length() - str2.length();

            if (value == 0) {
                  return str.compareTo(str2);
            }

            else {
                  return value;
            }
      }
}
