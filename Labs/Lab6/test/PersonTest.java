import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for the Person implementation. Tests equals and hashCode methods.
 */
public class PersonTest {

  private Person person1;
  private Person person2;
  private Person person3;
  private Person person4;
  private Person person5;

  @BeforeEach
  public void setUp() {
    // Create person objects for testing
    person1 = new Person("Michael", "Jordan", 1990);
    person2 = new Person("Michael", "Jordan", 1990);  // Same as person1
    person3 = new Person("Kobe", "Jordan", 1990);     // Different first name
    person4 = new Person("Michael", "Bryant", 1990);  // Different last name
    person5 = new Person("Michael", "Jordan", 1995);  // Different birth year
  }

  /**
   * Tests the equals method.
   */
  @Test
  public void testEquals() {
    // Test reflexivity
    assertEquals(person1, person1);

    // Test equals for identical people
    assertEquals(person1, person2);
    assertEquals(person2, person1);

    // Test not equals for different first names
    assertNotEquals(person1, person3);

    // Test not equals for different last names
    assertNotEquals(person1, person4);

    // Test not equals for different birth years
    assertNotEquals(person1, person5);

    // Test equals with null and different class
    assertNotEquals(null, person1);
    assertNotEquals("Not a person", person1);
  }

  /**
   * Tests the hashCode method.
   */
  @Test
  public void testHashCode() {
    // Test that equal people have the same hash code
    assertEquals(person1.hashCode(), person2.hashCode());

    // Test that different people likely have different hash codes
    assertNotEquals(person1.hashCode(), person3.hashCode());
    assertNotEquals(person1.hashCode(), person4.hashCode());
    assertNotEquals(person1.hashCode(), person5.hashCode());
  }
}