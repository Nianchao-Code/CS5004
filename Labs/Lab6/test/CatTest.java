import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for the Cat implementation. Tests setters, equals, and hashCode methods.
 */
public class CatTest {

  private Person owner1;
  private Person owner2;
  private Cat cat1;
  private Cat cat2;
  private Cat cat3;
  private Cat cat4;
  private Cat cat5;
  private Cat cat6;

  @BeforeEach
  public void setUp() {
    // Create person objects for testing
    owner1 = new Person("Michael", "Jordan", 1990);
    owner2 = new Person("Kobe", "Bryant", 1995);

    // Create cat objects for testing
    cat1 = new Cat("Mimi", 3, color.Brown, owner1);
    cat2 = new Cat("Mimi", 3, color.Brown, owner1);  // Same as cat1
    cat3 = new Cat("Mittens", 3, color.Brown, owner1);  // Different name
    cat4 = new Cat("Mimi", 5, color.Brown, owner1);  // Different age
    cat5 = new Cat("Mimi", 3, color.Black, owner1);  // Different color
    cat6 = new Cat("Mimi", 3, color.Brown, owner2);  // Different owner
  }

  /**
   * Tests the setter methods.
   */
  @Test
  public void testSetters() {
    // Test setAge
    assertEquals(3, cat1.getAge());
    cat1.setAge(5);
    assertEquals(5, cat1.getAge());
    cat1.setAge(7);
    assertEquals(7, cat1.getAge());

    // Test setOwner
    assertEquals(owner1, cat1.getOwner());
    cat1.setOwner(owner2);
    assertEquals(owner2, cat1.getOwner());
    cat1.setOwner(owner1);
    assertEquals(owner1, cat1.getOwner());
  }

  /**
   * Tests the equals method.
   */
  @Test
  public void testEquals() {
    // Test reflexivity
    assertEquals(cat1, cat1);

    // Test equals for identical cats
    assertEquals(cat1, cat2);
    assertEquals(cat2, cat1);

    // Test not equals for different names
    assertNotEquals(cat1, cat3);

    // Test not equals for different ages
    assertNotEquals(cat1, cat4);

    // Test not equals for different colors
    assertNotEquals(cat1, cat5);

    // Test not equals for different owners
    assertNotEquals(cat1, cat6);

    // Test equals with null and different class
    assertNotEquals(null, cat1);
    assertNotEquals("Not a cat", cat1);
  }

  /**
   * Tests the hashCode method.
   */
  @Test
  public void testHashCode() {
    // Test that equal cats have the same hash code
    assertEquals(cat1.hashCode(), cat2.hashCode());

    // Test that different cats likely have different hash codes
    assertNotEquals(cat1.hashCode(), cat3.hashCode());
    assertNotEquals(cat1.hashCode(), cat4.hashCode());
    assertNotEquals(cat1.hashCode(), cat5.hashCode());
    assertNotEquals(cat1.hashCode(), cat6.hashCode());
  }
}