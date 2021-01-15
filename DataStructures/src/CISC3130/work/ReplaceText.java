import java.util.*;
import java.io.*;

public class ReplaceText{
  public static void main(String[] args) throws Exception {
    if (args.length != 4){
      System.out.println("Usage: java ReplaceText sourceFile targetFile oldStr newStr");
      System.exit(1);
    }
    // check if source file exists
    File sourceFile = new File(args[0]);
    if (!sourceFile.exists()){
      System.out.println("Source File " + args[0] + " does not exist");
      System.exit(2);
    }
    // check if target file exists
    File targetFile = new File(args[1]);
    if (targetFile.exists()){
      System.out.println("Target File " + args[1] + " alreas=dy exist");
      System.exit(3);
    }

    try (
      Scanner input = new Scanner(sourceFile);
      PrintWriter output = new PrintWriter(targetFile);
    ) {
      while (input.hasNext()) {
        String s1 = input.nextLine();
        String s2 = s1.replaceAll(args[2], args[3]);
        output.println(s2);
      }
    }

  }// end of main
}
