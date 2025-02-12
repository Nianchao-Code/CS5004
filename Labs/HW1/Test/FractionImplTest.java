import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the {@code FractionImpl} class.
 */
class FractionImplTest {

  private FractionImpl fraction1;
  private FractionImpl fraction2;
  private FractionImpl fraction3;

  /**
   * Sets up test fractions before each test.
   */
  @BeforeEach
  void setUp() {
    fraction1 = new FractionImpl(3, 4);
    fraction2 = new FractionImpl(1, 2);
    fraction3 = new FractionImpl(5, 4);
  }

  /**
   * Tests exception handling with an invalid denominator in constructor.
   */
  @Test
  void testFractionConstructorException() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> new FractionImpl(3, 0),
        "Creating a fraction with denominator 0 should throw an IllegalArgumentException.");
    assertEquals("Denominator must be positive.", exception.getMessage());

    exception = assertThrows(IllegalArgumentException.class,
        () -> new FractionImpl(3, -2),
        "Creating a fraction with a negative denominator should throw an IllegalArgumentException.");
    assertEquals("Denominator must be positive.", exception.getMessage());
  }

  /**
   * Tests getting the numerator.
   */
  @Test
  void testGetNumerator() {
    assertEquals(3, fraction1.getNumerator());
    assertEquals(1, fraction2.getNumerator());
  }

  /**
   * Tests setting the numerator.
   */
  @Test
  void testSetNumerator() {
    fraction1.setNumerator(7);
    assertEquals(7, fraction1.getNumerator());

    fraction2.setNumerator(-2);
    assertEquals(-2, fraction2.getNumerator());
  }

  /**
   * Tests getting the denominator.
   */
  @Test
  void testGetDenominator() {
    assertEquals(4, fraction1.getDenominator());
    assertEquals(2, fraction2.getDenominator());
  }

  /**
   * Tests setting the denominator.
   */
  @Test
  void testSetDenominator() {
    fraction1.setDenominator(8);
    assertEquals(8, fraction1.getDenominator());

    fraction2.setDenominator(5);
    assertEquals(5, fraction2.getDenominator());
  }

  /**
   * Tests setting an invalid denominator.
   */
  @Test
  void testSetDenominatorException() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> fraction1.setDenominator(0),
        "Setting the denominator to 0 should throw an IllegalArgumentException.");
    assertEquals("Denominator must be positive.", exception.getMessage());

    exception = assertThrows(IllegalArgumentException.class,
        () -> fraction1.setDenominator(-3),
        "Setting a negative denominator should throw an IllegalArgumentException.");
    assertEquals("Denominator must be positive.", exception.getMessage());
  }

  /**
   * Tests converting the fraction to a double.
   */
  @Test
  void testToDouble() {
    assertEquals(0.75, fraction1.toDouble(), 0.0001);
    assertEquals(0.5, fraction2.toDouble(), 0.0001);
  }

  /**
   * Tests the string representation of the fraction.
   */
  @Test
  void testToString() {
    assertEquals("3 / 4", fraction1.toString());
    FractionImpl fraction4 = new FractionImpl(4, 8);
    assertEquals("1 / 2", fraction4.toString());
  }

  /**
   * Tests the reciprocal of a fraction.
   */
  @Test
  void testReciprocal() {
    Fraction reciprocal1 = fraction1.reciprocal();
    assertEquals("4 / 3", reciprocal1.toString());

    Fraction reciprocal2 = fraction2.reciprocal();
    assertEquals("2 / 1", reciprocal2.toString());
  }

  /**
   * Tests the reciprocal of zero, which should throw an exception.
   */
  @Test
  void testReciprocalOfZero() {
    ArithmeticException exception = assertThrows(ArithmeticException.class,
        () -> new FractionImpl(0, 1).reciprocal(),
        "Reciprocal of zero should throw an ArithmeticException.");
    assertEquals("Cannot take reciprocal of zero.", exception.getMessage());
  }

  /**
   * Tests adding two fractions.
   */
  @Test
  void testAdd() {
    Fraction result = fraction1.add(fraction2);
    assertEquals("5 / 4", result.toString());

    result = fraction2.add(fraction3);
    assertEquals("7 / 4", result.toString());
  }

  /**
   * Tests adding a null fraction, which should throw a NullPointerException.
   */
  @Test
  void testAddNullFraction() {
    NullPointerException exception = assertThrows(NullPointerException.class,
        () -> fraction1.add(null),
        "Adding a null fraction should throw a NullPointerException.");
  }

  /**
   * Tests comparing fractions.
   */
  @Test
  void testCompareTo() {
    assertEquals(1, fraction1.compareTo(fraction2),
        "Fraction 3/4 should be greater than 1/2, returning 1.");

    assertEquals(-1, fraction1.compareTo(fraction3),
        "Fraction 3/4 should be less than 5/4, returning -1.");

    assertEquals(0, fraction1.compareTo(new FractionImpl(3, 4)),
        "Fraction 3/4 should be equal to 3/4, returning 0.");
  }

  /**
   * Tests comparing to a null fraction, which should throw a NullPointerException.
   */
  @Test
  void testCompareToNullFraction() {
    NullPointerException exception = assertThrows(NullPointerException.class,
        () -> fraction1.compareTo(null),
        "Comparing to a null fraction should throw a NullPointerException.");

    assertEquals("Cannot compare to a null fraction.", exception.getMessage());
  }
}


