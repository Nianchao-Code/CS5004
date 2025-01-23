import static org.junit.jupiter.api.Assertions.*;

class ShoeTest {
  private Shoe shoe; // Declare the shoe object

  @org.junit.jupiter.api.BeforeEach
  void setUp() {
    shoe = new Shoe("Basketball", "Black", "Nike", 12.5);
  }

  @org.junit.jupiter.api.Test
  void getType() {
    assertEquals("Basketball", shoe.getType(), "The type should be 'Basketball'.");
  }

  @org.junit.jupiter.api.Test
  void getColor() {
    assertEquals("Black", shoe.getColor(), "The color should be 'Black'.");
  }

  @org.junit.jupiter.api.Test
  void getBrand() {
    assertEquals("Nike", shoe.getBrand(), "The brand should be 'Nike'.");
  }

  @org.junit.jupiter.api.Test
  void getSize() {
    assertEquals(12.5, shoe.getSize(), "The size should be 12.5.");
  }

  @org.junit.jupiter.api.Test
  void testToString() {
    String expected = "Shoe{type=Basketball, color=Black, brand=Nike, size=12.5}";
    assertEquals(expected, shoe.toString(), "The toString output is incorrect.");
  }

  @org.junit.jupiter.api.Test
  void testMain() {
    Shoe shoe = new Shoe("Basketball", "Black", "Nike", 12.5);
  }
}