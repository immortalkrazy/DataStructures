public class Compare{
  public int compareTo(Contact another){
    int lastComp = lastName.comapreTo(another.lastName);
      if(lastComp == 0){
        return firstName.compareTo(another.firstName);
      }
      else return lastComp;
  }
}
