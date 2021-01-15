import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class App{
  public static void main (String []args){

    // default constructor object with no data fields
    Contact c = new Contact();
    // use of second constructor
    // create 2 contacts with the same data fiels
    Contact c1 = new Contact("John", "Smith", "718-000-1234");
    Contact c2 = new Contact("John", "Smith", "917-123-4567");
    // contact with the same last name
    Contact c3 = new Contact("Nancy", "Smith", "718-459-3333");
    // contact with all the data fileds
    Contact c4 = new Contact("John", "Doe", "347-458-7485", "2900 Bedford Ave", "Brooklyn", "NY");
    Contact c5 = new Contact("Harry", "Potter", "516-458-7458", "1300 Flatbush Ave", "Astoria", "NJ");
    Contact c6 = new Contact("Bob", "White", "978-857-3652", "765 Flatlands Street", "Brooklyn", "NY");
    Contact c7 = new Contact("Adam", "Gates", "978-857-3652", "547 Flatlands Ave", "Bronx", "KY");
    Contact c8 = new Contact("Frank", "Hong", "978-857-3652", "25 Ave C", "Carlton", "PA");

    // create ArrayList to use Collection sort
    List <Contact> contactArrayList = new ArrayList<Contact>();
    // add all the contacts in the ArrayList
    contactArrayList.add(c1);
    contactArrayList.add(c2);
    contactArrayList.add(c3);
    contactArrayList.add(c4);
    contactArrayList.add(c5);
    contactArrayList.add(c6);
    contactArrayList.add(c7);
    contactArrayList.add(c8);

    // TESTINGS
    System.out.println("---------------Before sort----------------");
    printArrayList(contactArrayList);
    // collection sort
    Collections.sort(contactArrayList);
    System.out.println("----------------After sort----------------");
    printArrayList(contactArrayList);
    System.out.println("------------------------------------------");

    // -------------Test of equal method-------------------
    System.out.println("\n ---Test of equals method--- \n");
    // same first and last name
    System.out.println("Is " + c1.getFirstName() + " " + c1.getLastName() + " is equal to " +
                       c2.getFirstName() + " " + c2.getLastName() + "?  " + c1.equals(c2));
    // same last name but different first name
    System.out.println("Is " + c2.getFirstName() + " " + c2.getLastName() + " is equal to " +
                       c3.getFirstName() + " " + c3.getLastName() + "?  " + c2.equals(c3));
    // same first name but diffrent last name
    System.out.println("Is " + c1.getFirstName() + " " + c1.getLastName() + " is equal to " +
                       c4.getFirstName() + " " + c4.getLastName() + "?  " + c1.equals(c4));

    // ------------Test of compareTo method-----------------
    System.out.println("\n ---Test of equals method--- \n");
    // same last name and first name
    System.out.println("Result of comparing " + c1.getFirstName() + " " + c1.getLastName() +
                       " with " + c2.getFirstName() + " " + c2.getLastName() + " is: " + c1.compareTo(c2));
    // same last name and different first name
    System.out.println("Result of comparing " + c1.getFirstName() + " " + c1.getLastName() +
                       " with " + c3.getFirstName() + " " + c3.getLastName() + " is: " + c1.compareTo(c3));
    // different last name but same first name
    System.out.println("Result of comparing " + c1.getFirstName() + " " + c1.getLastName() +
                       " with " + c4.getFirstName() + " " + c4.getLastName() + " is: " + c1.compareTo(c4));
    // both last and first name different
    System.out.println("Result of comparing " + c1.getFirstName() + " " + c1.getLastName() +
                       " with " + c5.getFirstName() + " " + c5.getLastName() + " is: " + c1.compareTo(c5));

    //Test of updateInfo method
    System.out.println("\n ---Test of updateInfo method--- \n");
    System.out.println("Contact info BEFORE update by user: \n" + c5);
    // update info by the user input
    updateInfo(c5);
    System.out.println("Contact info AFTER  update by user: \n" + c5);

    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    System.out.print("\n\n---------------------TWO----------------------\n\n");
    ContactList<Contact> list = new ContactList<Contact>();
    list.add(c1);
    list.add(c2);
    list.add(c3);
    list.add(c4);
    list.add(c5);
    list.add(c6);

    //System.out.println(list);
    for (Contact k: list) {
      System.out.println("name: " + k.getFirstName());
    }

  }// end of main

  // update information of the Object with user input
  public static void updateInfo(Contact c){
    // try with resourses
    try(Scanner sc = new Scanner(System.in)){
      System.out.print("Please enter the First Name: ");
      String fN = sc.nextLine();
      c.setFirstName(fN);
      System.out.print("Please enter the Last  Name: ");
      String lN = sc.nextLine();
      c.setLastName(lN);
      System.out.print("Please enter Phone Number: ");
      String ph = sc.nextLine();
      c.setPhoneNumber(ph);
      System.out.print("Please enter sreeet Address: ");
      String ad = sc.nextLine();
      c.setAddress(ad);
      System.out.print("Please enter the City: ");
      String ct = sc.nextLine();
      c.setCity(ct);
      System.out.print("Please enter the State: ");
      String st = sc.nextLine();
      c.setState(st);
      System.out.println();
    }// end of try
    catch(InputMismatchException e){
      System.out.println(e.getMessage());
    }
  }// end of update
  // method to print ArrayList
  public static void printArrayList(List list){
    for (int i = 0; i < list.size(); i++){
      System.out.println(list.get(i));
    }
  }// end of print

}// end of class
