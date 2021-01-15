public class UsedContact {
  public static void main(String[] args) {
    Contact contact = new Contact("DArien", "Munchkin", "555-5555-5555", "Flatbush", "Brooklyn","NY");
    Contact contact2 = new Contact("Steve", "Zhuravel", "222-2222-2222");
    Contact c3 = new Contact();

    System.out.println(contact.toString());
    //  System.out.println();
    System.out.println(contact2.toString());
    System.out.println(c3.toString());

    contact.update("Daniel", "Blinder", "111-1111-1111", "Queens NY", "Brooklyn", "NY");
    System.out.println(contact.toString());

    contact2.update("Yureina", "Martinz", "888-8888-8888", "Bronx NY","Brooklyn" , "NY");
    System.out.println(contact2.toString());
    System.out.println("Return value of compareTo(): " + contact.compareTo(contact2));

    if(contact.equals(contact2))
      System.out.println("contacts are equal");
    else System.out.println("contacts are not equal");
  }
}
