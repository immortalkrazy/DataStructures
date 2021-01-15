import java.util.*;

public class ContactList implements Iterable<Contact> {

  private ContactList contactList;

  @Override
  public Iterator<Contact> iterator() {
    return new ContactIterator();
  }
  /*
  An iterator() method that allows you to iterate through a ContactList.
  */
  private class ContactIterator implements Iterator<Contact> {

    private int indexPosition;

    public ContactIterator() {
      indexPosition = 0;
    }

    @Override
    public boolean hasNext() {
      return indexPosition < size();
    }

    @Override
    public Contact next() {
            indexPosition++;
            return arr[indexPosition - 1];
    }

  } // end of custom iterator class

  private Contact[] arr;
  private int logicalLength;

  // ContactList constructors
  public ContactList() {
    this(10);
  }

  public ContactList(int initialCapacity) {
    arr = new Contact[initialCapacity];
    logicalLength = 0;
  }



  public ContactList(Contact[] array) {
    contactList = new ContactList();
    for (int i = 0; i < array.length; i++) {
      contactList.addContact(arr[i]);
    }
  }
  /*
  A method that allows you to add a Contact to the ContactList.
  You should only add a Contact to the list if it is not there already.
  */

  public boolean addContact (Contact contact) {
    if(isFull()) {
      grow();
    }
    if (! (isThere(contact))) {
      arr[logicalLength] = contact;
      logicalLength++;
      return true;
    }
    return false;
  }

  // add contact at a particular index

  public void addContactAtIndex (int index, Contact contact) {
    if (isOutOfBounds(index)) {
      throw new IndexOutOfBoundsException(index + " does not exist");
    }
    if (isFull()) {
      grow();
    }
    for (int i = arr.length - 1; i >= index; i-- ) {
      arr[i+1] = arr[i];
    }
    arr[index] = contact;
    logicalLength++;
  }

  // delete the whole contact list
  // or that's what the user thinks

  public void clearConatctList () {
    logicalLength = 0;
  }
  /*
  A method that returns the size of the ContactList
  */
  public Contact getContact (int index) {
    if (isOutOfBounds(index)) {
      throw new IndexOutOfBoundsException(index + " does not exist");
    }
    return arr[index];
  }

  // set a particular contact at a particular index

  public Contact setContact (int index, Contact newContact) {
    if (isOutOfBounds(index)) {
      throw new IndexOutOfBoundsException(index + " does not exist");
    }
    Contact oldContact = arr[index];
    arr[index] = newContact;
    return oldContact;
  }

  public int indexOfContact (Contact contact) {

    for (int i = 0; i < size(); i++) {
      if (arr[i].equals(contact)) {
        return i;
      }
    }
    return -1;
  }

  public int size() {
    return logicalLength;
  }
  /*
  An overridden equals() method. Let’s define one ContactList being equal to another
  if they contain the same Contacts (but not necessarily in the same order.)
  */
  public boolean equals(Object obj) {
    if (! (obj instanceof ContactList)) {
      return false;
    }
    ContactList another = (ContactList)obj;
    if (size() != another.size()) {
      return false;
    }
    for (int i = 0; i < another.size(); i++) {
      if (! (isThere(getContact(i)))) {
        return false;
      }
    }
    return true;
  }

  // some private helper methods

  // method to check if the contact exists in array
  private boolean isThere(Contact contact) {
    for (int i = 0; i < size(); i++) {
      if(arr[i].equals(contact)) {
        return true;
      }
    }
    return false;
  }
  // grow the array in case array is full
  private void grow() {
    int newCapacity = 2 * arr.length;
    Contact[] temp = new Contact[newCapacity];
    for (int i = 0; i < arr.length; i++) {
      temp[i] = arr[i];
    }
    arr = temp;
    logicalLength = newCapacity;
  }
  // to check if the array is full
  private boolean isFull() {
    return logicalLength == arr.length;
  }
  // to check if the index os out of bounds
  private boolean isOutOfBounds(int index) {
    return index < 0 || index >= logicalLength;
  }

  public boolean compareNumbers(String s1, String s2 ) {
    if (s1.length() != s2.length()) {
      return false;
    }
    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i)){
        return false;
      }
    }
    return true;
  }
  /*
  An overridden toString() method that creates a representation for a ContactList.
  You should use StringBuilder and not String to synthesize your representation.
  */

  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < logicalLength; i++) {
      sb.append(arr[i]);
    }
    return sb.toString();
  }

  /*
  A method that allows the client to get a Contact from the ContactList by index.
  An IndexOutOfBoundsException should be thrown if that index doesn’t exist.
  */
  public Contact removeContact (int index) {
    if(isOutOfBounds(index)) {
      throw new IndexOutOfBoundsException(index + " doesn't exist");
    }
    Contact oldContact = arr[index];
    for (int i = index + 1; i < size(); i++) {
      arr[i-1] = arr[i];
    }
    logicalLength--;
    return oldContact;
  }

  // remove a particular contact

  public boolean removeContact (Contact contact) {
    int index = indexOfContact(contact);
    if(index == -1) {
      return false;
    }
    removeContact(index);
    return true;
  }
  /*
  - A method that searches for a particular contact by last name, and returns a reference
    to the Contact. If there is no such Contact, a sentinel value should be returned.
  */
  public int searchByLastName (String lastName) {

    for (int i = 0; i < logicalLength; i++) {
      if (arr[i].getLastName().equals(lastName)){
        return i;
      }
    }
    return -1;
  }

  /*
  A method that searches for a Contact by phone number, and returns a reference to
  the Contact. If there is no such Contact, a sentinel value should be returned.
  */

  public int searchByPhone(String phoneNumber) {
    for (int i = 0; i < logicalLength; i++) {
      if (compareNumbers(arr[i].getPhoneNumber(), phoneNumber)){
        return 1;
      }
    }
    return -1;
  }

  /*
  A function that searches for and returns a ContactList containing all Contacts with a
  last name starting with a particular letter. If there are no such Contacts, you should
  return the empty ContactList.
  */

  public ContactList specialCharacterList(char c) {
    ContactList special = new ContactList();
    for (int i = 0; i < logicalLength; i++) {
      char temp = arr[i].getLastName().charAt(0);
      if (temp == c) {
        Contact tempC = getContact(i);
        special.addContact(tempC);
      }
    }
    return special;
  }
  /*
  A method that searches for and returns a ContactList containing all Contacts
  that live in a particular city. If there are no such Contacts, you should
  return the empty ContactList.
  */
  public ContactList listByCity(String city) {
    ContactList cityList = new ContactList();
    for (int i = 0; i < logicalLength; i++) {
      if (arr[i].getCity().equals(city)) {
        Contact tempC = getContact(i);
        cityList.addContact(tempC);
      }
    }
    return cityList;
  }

}// end of Contactlist class
