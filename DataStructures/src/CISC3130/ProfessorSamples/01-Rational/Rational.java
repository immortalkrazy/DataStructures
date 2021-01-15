public class Rational implements Comparable<Rational> {

	private int numer;
	private int denom;

	public Rational(int numer, int denom) {
		this.numer = numer;
		this.denom = denom;

		int divisor = Rational.gcd(numer, denom);
		this.numer /= divisor;
		this.denom /= divisor;
	}

	public Rational(int numer) {
		this(numer, 1);
	}

	public int getNumer() {
		return numer;
	}

	public int getDenom() {
		return denom;
	}

	public String toString() {
		return numer +(denom==1?"" :  "/" + denom);
	}

	public Rational multiply(Rational another) {

		int newNumer = this.numer * another.numer;
		int newDenom = this.denom * another.denom;

		return new Rational(newNumer, newDenom);
	}

	public boolean equals(Object obj) {

		if( ! (obj instanceof Rational))
			return false;
		Rational another = (Rational)obj;

		return this.compareTo(another)==0;
	}
	public int compareTo(Rational another) {

		 int numer1 = this.numer * another.denom;
		int numer2 = another.numer * this.denom;

		return numer1 - numer2;
	}


	private static int gcd(int a, int b) {
		return b==0? a : gcd(b, a%b);
	}

	public static void main(String[] args) {

		Rational r1 = new Rational(2,4);
		System.out.println(r1);

		Rational r2 = new Rational(50,10);

		System.out.println(r2);

		Rational r3 = new Rational(2);

		System.out.println(r3.compareTo(r1));

		Comparable<Rational> comp= new Rational(1);

		Rational r4 = ((Rational)comp).multiply(r1);
		System.out.println(r4);
	}

}
