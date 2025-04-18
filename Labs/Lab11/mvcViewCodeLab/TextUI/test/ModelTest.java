import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the Model in the TextUI MVC Echo application.
 */
public class ModelTest {
  private IModel model;

  @BeforeEach
  public void setUp() {
    model = new Model();
  }

  @Test
  public void testGetStringBeforeSetting() {
    // Assertion 1
    assertEquals("", model.getString());

    // Assertion 2
    assertNotNull(model.getString());
  }

  @Test
  public void testSetAndGetString() {
    String testInput = "Hello World";
    model.setString(testInput);

    // Assertion 1
    assertEquals(testInput, model.getString());

    // Assertion 2
    String newInput = "New message";
    model.setString(newInput);
    assertEquals(newInput, model.getString());
    assertNotEquals(testInput, model.getString());
  }
}