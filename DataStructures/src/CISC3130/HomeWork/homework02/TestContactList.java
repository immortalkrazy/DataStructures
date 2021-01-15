import java.util.*;

public class TestContactList {

  public static void main (String []args){

    ContactList contactList = new ContactList();
    ContactList contactList2 = new ContactList();
    ContactList contactList3 = new ContactList();

    Contact c1 = new Contact("John", "Smith", "7180001234", "875 Coutelyou road", "Brooklyn", "NY");
    Contact c2 = new Contact("Harry", "Smith", "9171234567", "25 Broadway", "Hilton", "NJ");
    Contact c3 = new Contact("Nancy", "Smith", "7184593333", "58 broad street", "New York", "NY");
    Contact c4 = new Contact("John", "Doe", "3474587485", "2900 Bedford Ave", "Brooklyn", "NY");
    Contact c5 = new Contact("Harry", "Potter", "5164587458", "1300 Flatbush Ave", "Astoria", "NJ");
    Contact c6 = new Contact("Bob", "White", "9788573652", "765 Flatlands Street", "Brooklyn", "NY");
    Contact c7 = new Contact("Adam", "Gates", "9788573652", "547 Flatlands Ave", "Bronx", "KY");
    Contact c8 = new Contact("Frank", "Hong", "9788573652", "25 Ave C", "Carlton", "PA");


    contactList.addContact(c1);
    contactList.addContact(c2);
    contactList.addContact(c3);
    contactList.addContact(c4);
    contactList.addContact(c5);
    contactList.addContact(c6);
    //contactList.addContact(c7);
    //contactList.addContact(c8);

    contactList2.addContact(c7);
    contactList2.addContact(c3);
    contactList2.addContact(c1);
    contactList2.addContact(c5);

    contactList3.addContact(c1);
    contactList3.addContact(c3);
    contactList3.addContact(c5);
    contactList3.addContact(c7);

    System.out.println("\n-----Print out Contact list-----");
    printContactList(contactList);

    System.out.println("\n-----Search by last name-----");
    System.out.println("Search result:   " + contactList.searchByLastName("Potter"));
    System.out.println("Search result:   " + contactList.searchByLastName("Richard"));

    System.out.println("\n-----Search by Phone-----");
    System.out.println("Search result:   " + contactList.searchByPhone("7180001234"));
    System.out.println("Search result:   " + contactList.searchByPhone("5167185225"));

    System.out.println("\n-----Special chracter Contact list-----");
    printContactList(contactList.specialCharacterList('S'));

    System.out.println("\n-----City Contact list-----");
    printContactList(contactList.listByCity("Brooklyn"));

    System.out.println("\n-----Add Contact to the List-----");
    System.out.println("adding contact c7:        " + contactList.addContact(c7));
    System.out.println("adding contact c7 AGAIN:  " + contactList.addContact(c7));

    System.out.println("\n-----Size of the list-----");
    System.out.println("Size list 1: " + contactList.size());
    System.out.println("Size list 2: " + contactList2.size());
    System.out.println("Size list 3: " + contactList3.size());

    System.out.println("\n-----Remove a Contact-----");
    System.out.println("Remove c7 from list:         " + contactList.removeContact(c7));
    System.out.println("C8 which is not in the list: " + contactList.removeContact(c8));

    System.out.println("\n-----get Contact from list-----");
    System.out.println("Get index 3 from list: " + contactList.getContact(3));
    System.out.println("Get index 4 from list: " + contactList.getContact(4));

    System.out.println("\n-----Compare 2 list with contacts in different order-----");
    System.out.println("TWO ARRAYS: " + contactList2.equals(contactList3));
    System.out.println("TWO ARRAYS: " + contactList.equals(contactList2));

    System.out.println("-----Iterator-----");
    for(Contact c: contactList){
      System.out.println(c);
    }

    System.out.println(contactList.indexOfContact(c1));
    System.out.println(contactList.indexOfContact(c2));
    System.out.println(contactList.indexOfContact(c7));
    System.out.println(contactList.indexOfContact(c8));

  }

  public static void printContactList(ContactList list) {
    int count = 1;
    for (Contact c: list) {
      System.out.println("Contact# " + count + c);
      count++;
    }
  }

}
