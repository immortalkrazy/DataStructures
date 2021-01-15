public class Contact implements Comparable {
 private String first;
 private String lastname;
 private String phonenumber;
 private String streetaddress;
 private String city;
 private String state;

 public Contact() {
 }

 public Contact(String first, String lastname,String phonenumber,String streetaddress,String city, String state ) {
  this.first = first;
  this.lastname = lastname;
  this.phonenumber = phonenumber;
  this.streetaddress= streetaddress;
  this.city= city;
  this.state= state;
 }

 public Contact(String first, String lastname, String phonenumber) {
  this.first= first;
  this.lastname=lastname;
  this.phonenumber=phonenumber;
 }

 public String getfirst() {
  return first;
 }

 public String getlastname() {
  return lastname;
 }

 public String getphonenumber() {
  return phonenumber;
 }

 public String getstreetaddress() {
  return streetaddress;
 }

 public String getcity() {
  return city;
 }

 public String getstate() {
  return state;
 }

 public void update(String first, String lastname,String phonenumber,String streetaddress,String city, String state) {
  this.first = first;
  this.lastname = lastname;
  this.phonenumber = phonenumber;
  this.streetaddress= streetaddress;
  this.city= city;
  this.state= state;
 }

 @Override
 public int compareTo(Object c) {
  int resultLast = lastname.compareTo( ((Contact) c).lastname );
  int resultFirst = first.compareTo( ((Contact) c).first);
  // checks if the last name are equal and if they are it returns 0
  if(resultLast ==0 && resultFirst==0)
   return 0;
  /*if the last name and the first name are not equal it returns first name
   * otherwise it returns the last name
   */
  else if(resultLast==0 && resultFirst!=0)
   return resultFirst;
  return resultLast;
 }

 public boolean equals(Object obj){

  if(obj instanceof Contact) {
   if(first == ((Contact) obj).getfirst() && lastname == ((Contact) obj).getlastname())
    return true;
   else return false;
  }
  return false;

 }

 public String toString() {

  String s = new String(first + " " + lastname + "\t" + phonenumber + "\n" +
    streetaddress + "\n" + city + ", " + state +"\n");
  return s;
 }

}
