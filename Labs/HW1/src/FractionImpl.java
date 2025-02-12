/**
 * The {@code FractionImpl} class implements the {@code Fraction} interface, representing a rational
 * number and providing operations such as arithmetic operations and comparisons. Note that if the
 * fraction is negative, then the numerator should be negative. The denominator should always be positive.
 */
public class FractionImpl implements Fraction {

  private int numerator;
  private int denominator;

  /**
   * Constructs a {@code FractionImpl} instance with the specified numerator and denominator. The
   * denominator must be positive.
   *
   * @param numerator   the numerator of the fraction.
   * @param denominator the denominator of the fraction, which must be greater than zero.
   * @throws IllegalArgumentException if the denominator is zero or negative.
   */
  public FractionImpl(int numerator, int denominator) {
    if (denominator <= 0) {
      throw new IllegalArgumentException("Denominator must be positive.");
    }
    this.numerator = numerator;
    this.denominator = denominator;
  }

  /**
   * Returns the numerator of this fraction.
   *
   * @return the numerator.
   */
  @Override
  public int getNumerator() {
    return numerator;
  }

  /**
   * Sets the numerator of this fraction.
   *
   * @param numerator the new numerator value.
   */
  @Override
  public void setNumerator(int numerator) {
    this.numerator = numerator;
  }

  /**
   * Returns the denominator of this fraction.
   *
   * @return the denominator.
   */
  @Override
  public int getDenominator() {
    return denominator;
  }

  /**
   * Sets the denominator of this fraction. The denominator must be positive.
   *
   * @param denominator the new denominator value.
   * @throws IllegalArgumentException if the denominator is zero or negative.
   */
  @Override
  public void setDenominator(int denominator) {
    if (denominator <= 0) {
      throw new IllegalArgumentException("Denominator must be positive.");
    }
    this.denominator = denominator;
  }

  /**
   * Converts this fraction to its decimal representation.
   *
   * @return the decimal value of the fraction.
   */
  @Override
  public double toDouble() {
    return (double) numerator / denominator;
  }

  /**
   * Computes the greatest common divisor (GCD) of two integers using Euclid's algorithm.
   *
   * @param a the first integer.
   * @param b the second integer.
   * @return the greatest common divisor of {@code a} and {@code b}.
   */
  private static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }

  /**
   * Returns the string representation of this fraction in its simplified form.
   *
   * @return a string representation of the fraction in the form "numerator / denominator".
   */
  @Override
  public String toString() {
    int gcd = gcd(Math.abs(numerator), denominator);
    numerator /= gcd;
    denominator /= gcd;
    return numerator + " / " + denominator;
  }

  /**
   * Returns the reciprocal of this fraction.
   *
   * @return a new {@code FractionImpl} instance representing the reciprocal of this fraction.
   * @throws ArithmeticException if the numerator is zero.
   */
  @Override
  public Fraction reciprocal() {
    if (numerator == 0) {
      throw new ArithmeticException("Cannot take reciprocal of zero.");
    }
    return new FractionImpl(denominator, numerator);
  }

  /**
   * Adds this fraction to another fraction and returns the result as a new fraction.
   *
   * @param other the fraction to be added.
   * @return a new {@code FractionImpl} representing the sum of the two fractions.
   * @throws IllegalArgumentException if adding a null fraction.
   */
  @Override
  public Fraction add(Fraction other) {
    if (other == null) {
      throw new NullPointerException("Null fraction cannot be added to a fraction.");
    }
    int newNumerator =
        this.numerator * other.getDenominator() + other.getNumerator() * this.denominator;
    int newDenominator = this.denominator * other.getDenominator();
    return new FractionImpl(newNumerator, newDenominator);
  }

  /**
   * Compares this fraction to another fraction.
   *
   * @param other the fraction to compare to.
   * @return a negative integer, zero, or a positive integer as this fraction is less than, equal
   * to, or greater than the specified fraction.
   * @throws IllegalArgumentException if comparing to a null fraction.
   */
  @Override
  public int compareTo(Fraction other) {
    if (other == null) {
      throw new NullPointerException("Cannot compare to a null fraction.");
    }
    int crossMulti1 = this.numerator * other.getDenominator();
    int crossMulti2 = other.getNumerator() * this.denominator;
    return Integer.compare(crossMulti1, crossMulti2);
  }
}