import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Contact implements Comparable<Contact>, Serializable{
  // private data fields
  private String firstName;
  private String lastName;
  private String phoneNumber;
  private String address;
  private String city;
  private String state;

  // default constructor
  public Contact(){

  }

  // constructor with all the data fields (information)
  public Contact (String firstName, String lastName, String phoneNumber,
                  String address, String city, String state){

    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.address = address;
    this.city = city;
    this.state = state;
  }

  //constructor with onliy name and phoneNumber
  public Contact(String firstName, String lastName, String phoneNumber){

    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;

  }
  // setter methods for the data fields
  public void setFirstName(String firstName){
    this.firstName = firstName;
  }

  public void setLastName(String lastName){
    this.lastName = lastName;
  }

  public void setPhoneNumber(String phoneNumber){
    this.phoneNumber = phoneNumber;
  }

  public void setAddress(String address){
    this.address = address;
  }

  public void setCity(String city){
    this.city = city;
  }

  public void setState(String state){
    this.state = state;
  }

  // getter methods for all the data fields
  public String getFirstName(){
    return firstName;
  }

  public String getLastName(){
    return lastName;
  }

  public String getPhoneNumber(){
    return phoneNumber;
  }

  public String getAddress(){
    return address;
  }

  public String getCity(){
    return city;
  }

  public String getState(){
    return state;
  }

  @Override
  // Override the Object class equals method
  public boolean equals(Object obj){
    // if comparing with the same object
    if (this == obj)
      return true;
    // if object is not properly created
    if (obj == null)
      return false;
    // in case, not the class member
    if (this.getClass() != obj.getClass())
      return false;
    // casting
    Contact other = (Contact)obj;
    // check against the last name
    if(!this.lastName.equals(other.lastName))
      return false;
    // check against the first name
    else if(!this.firstName.equals(other.firstName))
      return false;
    // if gone through all the tests
    return true;
  }

  @Override
  // Override compareTo method from interface Comparable
  public int compareTo(Contact other){
    // compare last names
    if (getLastName().compareTo(other.getLastName()) > 0)
      return 1;
    else if (getLastName().compareTo(other.getLastName()) < 0)
      return -1;
    // compare first names
    else if (getFirstName().compareTo(other.getFirstName()) > 0)
      return 2;
    else if (getFirstName().compareTo(other.getFirstName()) < 0)
      return -2;
    // if both match
    else
      return 0;
  }
  // override the toString method
  @Override
  public String toString(){
    return "\n" + getLastName() + ", " + getFirstName() + " \t Phone number: " +
    getPhoneNumber() + "\n" + getAddress() + "\n" + getCity() + ", " + getState() + "\n";
  }

}
