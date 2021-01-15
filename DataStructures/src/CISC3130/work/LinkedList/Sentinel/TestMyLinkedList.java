public class TestMyLinkedList {

    public static void main(String[] args) {

        MyLinkedList<Integer> aList = new MyLinkedList<>();
        MyLinkedList<Integer> bList = new MyLinkedList<>();
        // for(int i=0; i<10; i++) {
        //
        //     aList.addFirst(i+1);
        //
        // }
        // print(aList);
        aList.addFirst(10);
        //System.out.println(aList.getLast());
        aList.addFirst(15);
        //System.out.println(aList.getLast());
        //System.out.println(aList.getFirst());

        // for(int i=0; i<10; i++)
        //     aList.addFirst(i+1);
        bList.addFirst(10);
        bList.addFirst(15);
        bList.addFirst(20);
        bList.removeLast();
        System.out.println(aList.equals(bList));

    }

    public static void print(MyLinkedList<Integer> list) {

        for (Integer e: list) {

            System.out.println(e + " ");

        }

    }


}
