import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Test class for the TextView in the TextUI MVC Echo application.
 */
public class TextViewTest {
  private IView view;
  private ByteArrayOutputStream outContent;
  private PrintStream printStream;

  @BeforeEach
  public void setUp() {
    outContent = new ByteArrayOutputStream();
    printStream = new PrintStream(outContent);
    view = new TextView(printStream);
  }

  @Test
  public void testShowString() {
    String testString = "Test String";
    view.showString(testString);

    // Assertion 1
    String output = outContent.toString();
    assertTrue(output.contains(testString));

    // Assertion 2
    assertEquals("String: " + testString + System.lineSeparator(), output);
  }

  @Test
  public void testShowOptions() {
    view.showOptions();

    String output = outContent.toString();

    // Assertion 1
    assertTrue(output.contains("E: Enter a string"));
    assertTrue(output.contains("Q: Quit the program"));

    // Assertion 2
    assertTrue(output.trim().endsWith("Enter your choice:"));
  }

  @Test
  public void testShowStringEntry() {
    view.showStringEntry();

    String output = outContent.toString();

    // Assertion 1
    assertTrue(output.contains("Enter the string to be echoed:"));

    // Assertion 2
    assertEquals("\nEnter the string to be echoed: ", output);
  }

  @Test
  public void testShowOptionError() {
    view.showOptionError();

    String output = outContent.toString();

    // Assertion 1
    assertTrue(output.contains("Invalid option"));

    // Assertion 2
    assertEquals("\nInvalid option.\n", output);
  }
}