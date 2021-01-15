import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class TestContactList {

  public static void main (String []args){

    ContactList<Contact> contactList = new ContactList<Contact>();

    Contact c1 = new Contact("John", "Smith", "718-000-1234");
    Contact c2 = new Contact("Harry", "Smith", "917-123-4567");
    Contact c3 = new Contact("Nancy", "Smith", "718-459-3333");
    Contact c4 = new Contact("John", "Doe", "347-458-7485", "2900 Bedford Ave", "Brooklyn", "NY");
    Contact c5 = new Contact("Harry", "Potter", "516-458-7458", "1300 Flatbush Ave", "Astoria", "NJ");
    Contact c6 = new Contact("Bob", "White", "978-857-3652", "765 Flatlands Street", "Brooklyn", "NY");
    Contact c7 = new Contact("Adam", "Gates", "978-857-3652", "547 Flatlands Ave", "Bronx", "KY");
    Contact c8 = new Contact("Frank", "Hong", "978-857-3652", "25 Ave C", "Carlton", "PA");


    contactList.addContact(c1);
    contactList.addContact(c2);
    contactList.addContact(c3);
    contactList.addContact(c4);
    contactList.addContact(c5);
    contactList.addContact(c6);
    contactList.addContact(c7);
    contactList.addContact(c8);

    // printContactList(contactList);
    //
    // System.out.println(contactList.getContact(3));
    //
    // System.out.println(c1.getLastName());
    //
    // //System.out.println(contactList.addContact(c8));
    //
    // System.out.println(contactList.removeContact(c8));
    System.out.println(contactList.indexOfContact(c1));
    System.out.println(contactList.indexOfContact(c2));
    System.out.println(contactList.indexOfContact(c3));
    System.out.println(contactList.indexOfContact(c4));
    System.out.println(contactList.indexOfContact(c5));
    System.out.println(contactList.indexOfContact(c6));
    System.out.println(contactList.indexOfContact(c7));
    System.out.println(contactList.indexOfContact(c8));

    contactList.searchByLastName("hello");

  }

  public static void printContactList(ContactList<Contact> list) {
    int count = 1;
    for (Contact c: list) {
      System.out.println("Contact# " + count + c);
      count++;
    }
  }



}
