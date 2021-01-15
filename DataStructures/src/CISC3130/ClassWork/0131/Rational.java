import java.lang.ArithmeticException;

public class Rational implements Comparable<Rational> {

  private int numer;
  private int denom;

  //constructor
  public Rational(int numer, int denom){
    this.numer = numer;
    this.denom = denom;

    if (denom == 0)
      throw new ArithmeticException();

    simplify();
  }

  //constructor
  public Rational(int numer){
    this(numer, 1);
  }

  private void simplify(){
    int divisor = gcd(numer, denom);
    numer /= divisor;
    denom /= divisor;
  }

  // convert to decimal
  public double convertToDecimal(){
    return (double)numer/denom;
  }

  // greatest common divisor
  private static int gcd(int a, int b){
    // uclid alogrithm
    if (b == 0)
      return a;
    return gcd(b, a%b);
  }

  public Rational add(Rational another){
    /*  a/b + c/d
      = (ad + bc)/bd
    */
    int newNumer = numer * another.denom + another.numer * denom;
    int newDenom = denom * another.denom;

    return new Rational(newNumer , newDenom);
  }

  //@Override
  public String toString(){
    return numer + (denom!=1 ? " / " + denom: " ");
  }

  public int floor(){
    return numer / denom;
  }

  //@Override
  public boolean eaquals(Object obj){
    if (! (obj instanceof Rational))
      return false;
    Rational rat = (Rational)obj;
    return rat.compareTo(this) == 0;
  }

  @Override
  public int compareTo(Rational another){
    return numer * another.denom - another.numer * denom;
  }
}
