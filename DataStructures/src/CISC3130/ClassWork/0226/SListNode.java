public class SListNode{ //S stands for Singly

  public String data;
  public SlistNode next;

  private static class DListNode<E> {
    public DListNode next;
    public DListNode prev;
    public E data;


  }



  public static SlistNode addFirst (SlistNode head, String data){
    SListNode temp = new SlistNode();
    temp.data = data;
    head = temp;
    return head;
  }

  // other way to do add

  public static SlistNode addFirstOneLiner (SlistNode head, String data){

    return new SListNode (data, head)
  }

  public static removeFirst (SlistNode head) {
    if (head == null) {
      throw new NoSuchElementException();
    }

    head = head.next;

    return head;
  }

  public static void PrintAll (SListNode head) {
    SListNode temp = head;
    // what is temp? ..... it reference to the head
    while (temp != null) {
      System.out.println(temp.data);
      temp = temp.next;
    }
  }
  // to print recursively forward
  public static void PrintAllRecursiveForward (SListNode head) {
    if (head == null){
      return;
    }
    System.out.println(head.data);
    PrintAllRecursiveForward(head.next);
  }
  // to print recursively backwards
  public static void PrintAllRecursiveBackward (SListNode head) {
    if (head == null){
      return;
    }
    PrintAllRecursiveBackward(head.next);
    System.out.println(head.data);
  }
}
