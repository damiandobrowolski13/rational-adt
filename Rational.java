/**
   This class provides common arithmetic operations for a rational
   numbers (integer numerator and denominator) ADT.

   All rational numbers are maintained in lowest terms, with a
   denominator that is a positive integer.

   @see java.lang.Object
   @author DAMIAN DOBROWOLSKI
   @date 08.08.2023
*/


public class Rational {
  private int numerator;
  private int denominator;

    /**
       Default constructor initializes rational to 0.
    */

  public Rational() {
   numerator = 0;
   denominator = 1;
}


    /**
       <code>Rational</code> constructor
       @param num the numerator
       @param den the denominator
       @throws NumberFormatException if den is zero
    */

public Rational(int num, int den) {
   if (den == 0){
      System.out.println("Rational cannot have zero denominator.");
      numerator = 0;
      denominator = 1;
   }
/*if denominator is negative, changes rational to equivalent one with negative numerator 
(or both positive if both were negative)*/
   
//divides numerator and denominator by GCD to simplify rational
   numerator = num / GCD(num, den);
   denominator = den / GCD(num, den);
   if (denominator < 0){
      denominator /= -1;
      numerator /= -1;
   }
}

    /** 
	private function GCD, not provided to clients
	finds the greatest common divisor of M and N
	Pre: M and N are defined
	Post: returns the GCD of M and N, by Euclid's Algorithm
    */

private int GCD(int m, int n) {
	//TODO
   int r = m % n;
   while (r != 0){
      m = n;
      n = r;
      r = m % n;
   }
return n;
}

    /** 
	@param R a rational
	@return true iff rational object < R.
    */

public boolean lt(Rational R) {
//cross multiplies to compare rationals
   return this.numerator * R.denominator < R.numerator * this.denominator;
}

public boolean gt(Rational R) {
//cross multiplies to compare rationals
   return this.numerator * R.denominator > R.numerator * this.denominator;
}

public boolean equals(Rational R) {
   return (this.numerator == R.numerator && this.denominator == R.denominator);
}

    /** 
	@param r
	@param s
	@return Rational corresponding to sum of r + s.
    */

public static Rational add(Rational r, Rational s) {
//if denominators are not equal, multiplies each by fraction (equal to 1) that makes denominators equal
   if (r.denominator != s.denominator){
      r.numerator *= s.denominator;
      r.denominator *= s.denominator;
      s.numerator *= r.denominator;
      s.denominator *= r.denominator;
   }
   Rational sum = new Rational(r.numerator + s.numerator, r.denominator);
   return sum;
}

public static Rational subtract(Rational r, Rational s) {
//if denominators are not equal, multiplies each by fraction (equal to 1) that makes denominators equal
   if (r.denominator != s.denominator){
      r.numerator *= s.denominator;
      r.denominator *= s.denominator;
      s.numerator *= r.denominator;
      s.denominator *= r.denominator;
   }
   Rational sub = new Rational(r.numerator - s.numerator, r.denominator);
   return sub;
}

public static Rational multiply(Rational r, Rational s) {
   Rational mult = new Rational(r.numerator * s.numerator, r.denominator * s.denominator);
   return mult;
}

    /** 
	Convert to String in standard format (i.e., numerator/denominator)
	@ return a <code>String</code> representation of
	the item.
    */

public String toString() {
	//TODO
   return numerator + "/" + denominator;
}
}

 // end of Rational class
