/**
 * The Fraction interface represents a rational number with a numerator and denominator. It provides
 * methods to perform arithmetic operations, comparisons, and conversions.
 */
public interface Fraction extends Comparable<Fraction> {

  /**
   * Gets the numerator of the fraction.
   *
   * @return the numerator.
   */
  int getNumerator();

  /**
   * Sets the numerator of the fraction.
   *
   * @param numerator the new numerator.
   */
  void setNumerator(int numerator);

  /**
   * Gets the denominator of the fraction.
   *
   * @return the denominator.
   */
  int getDenominator();

  /**
   * Sets the denominator of the fraction.
   *
   * @param denominator the new denominator.
   * @throws IllegalArgumentException if denominator is not positive.
   */
  void setDenominator(int denominator);

  /**
   * Returns the decimal representation of the fraction.
   *
   * @return the fraction as a double.
   */
  double toDouble();

  /**
   * Returns the reciprocal of the fraction.
   *
   * @return the reciprocal of the fraction.
   * @throws ArithmeticException if the numerator is zero.
   */
  Fraction reciprocal();

  /**
   * Adds another fraction to this fraction.
   *
   * @param other the fraction to be added.
   * @return the sum as a simplified fraction.
   * @throws IllegalArgumentException if adding a null fraction.
   */
  Fraction add(Fraction other);
}
