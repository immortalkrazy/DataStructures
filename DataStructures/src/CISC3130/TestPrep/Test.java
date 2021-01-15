public class Test {

    public String str;

    public static void main(String[] args) {

        String s1 = "World";
        String s2 = "Game";
        String s3 = "Time";
        String s4 = "bc";
        final int initialCapacity = 79;
        //System.out.println(s1.compareTo(s2));

        //System.out.println(75 % 15);

        String str = "defs";


    //    System.out.println(getIndex(str));
    //    System.out.println(index(str));
          // System.out.println("------------------");
          // System.out.println(s3.hashCode());
    //    System.out.println(s3.getIndex());
        System.out.println(index(s3));
        System.out.println(index(s1));
        System.out.println(index(s2));
        System.out.println(index(s4));

    }
    //
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((str == null) ? 0 : str.hashCode());
        return result;
    }


    private static int getIndex(String key) {

        return key.hashCode() % 15;

    }
    private static int index (String str) {

        int total = 0;
        for (int i = 0; i < str.length(); i++) {
            total += (str.charAt(i) - 'A');
        }
        return total % 79;
    }


}
