public class TestStringLengthComparator {

    public static void main(String[] args) {

        TestStringLengthComparator c = new TestStringLengthComparator();

        if (args.length < 2) {
            System.out.println("Error");
            System.exit(0);
        }

        System.out.println(args[0] + " is bigger in length than " + args[1] + "?");
        System.out.print(c.compare(args[0], args[1]));
    }
    // private static String check(String s1, String s2){
    //       if (c.compare(s1, s2) > 0) {
    //             return "true";
    //       }
    // }

}
