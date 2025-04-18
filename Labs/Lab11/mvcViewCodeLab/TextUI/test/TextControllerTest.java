import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Test class for the TextController in the TextUI MVC Echo application.
 */
public class TextControllerTest {

  @Test
  public void testSingleInputAndQuit() {
    // Set up input with "E" (enter string), the string to enter, and "Q" (quit)
    String inputString = "E\nHello World\nQ\n";
    ByteArrayInputStream inputStream = new ByteArrayInputStream(inputString.getBytes());

    // Set up output stream to capture the output
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);

    // Create model and view
    IModel model = new Model();
    IView view = new TextView(printStream);

    // Create controller with our input and output
    IController controller = new TextController(model, inputStream, view);

    // Run the controller
    controller.go();

    // Get the output
    String output = outputStream.toString();

    // Assertion 1
    assertTrue(output.contains("String: Hello World"));

    // Assertion 2
    assertTrue(output.contains("E: Enter a string"));
    assertTrue(output.contains("Enter the string to be echoed:"));
  }

  @Test
  public void testMultipleInputsAndQuit() {
    // Set up input with multiple string entries
    String inputString = "E\nFirst String\nE\nSecond String\nQ\n";
    ByteArrayInputStream inputStream = new ByteArrayInputStream(inputString.getBytes());

    // Set up output stream
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);

    // Create model, view, and controller
    IModel model = new Model();
    IView view = new TextView(printStream);
    IController controller = new TextController(model, inputStream, view);

    // Run the controller
    controller.go();

    // Get the output
    String output = outputStream.toString();

    // Assertion 1
    assertTrue(output.contains("String: First String"));
    assertTrue(output.contains("String: Second String"));

    // Assertion 2
    int firstIndex = output.indexOf("String: First String");
    int secondIndex = output.lastIndexOf("String: Second String");
    assertTrue(firstIndex < secondIndex);
  }

  @Test
  public void testInvalidOption() {
    // Set up input with an invalid option
    String inputString = "X\nQ\n";
    ByteArrayInputStream inputStream = new ByteArrayInputStream(inputString.getBytes());

    // Set up output stream
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);

    // Create model, view, and controller
    IModel model = new Model();
    IView view = new TextView(printStream);
    IController controller = new TextController(model, inputStream, view);

    // Run the controller
    controller.go();

    // Get the output
    String output = outputStream.toString();

    // Assertion 1
    assertTrue(output.contains("Invalid option"));

    // Assertion 2
    int menuIndex = output.indexOf("Menu:");
    int errorIndex = output.indexOf("Invalid option");
    int secondMenuIndex = output.indexOf("Menu:", errorIndex);

    assertTrue(menuIndex < errorIndex);
    assertTrue(errorIndex < secondMenuIndex);
  }

  @Test
  public void testModelUpdatesCorrectly() {
    // Set up input
    String inputString = "E\nTest Model Update\nQ\n";
    ByteArrayInputStream inputStream = new ByteArrayInputStream(inputString.getBytes());

    // Set up output stream
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);

    // Create model with spy capabilities
    IModel model = new Model();
    IView view = new TextView(printStream);
    IController controller = new TextController(model, inputStream, view);

    // Assertion 1
    assertEquals("", model.getString());

    // Run the controller
    controller.go();

    // Assertion 2
    assertEquals("Test Model Update", model.getString());
  }
}