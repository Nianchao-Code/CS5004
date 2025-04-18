import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.InputStream;

/**
 * Integration test for the TextUI MVC Echo application.
 * Tests the complete system including the main method.
 */
public class IntegrationTest {

  @Test
  public void testMainMethodWithSystemIO() {
    // Redirect System.in and System.out
    String inputString = "E\nIntegration Test\nQ\n";
    ByteArrayInputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    // Save the original System.in and System.out
    InputStream originalIn = System.in;
    PrintStream originalOut = System.out;

    try {
      // Redirect standard input and output
      System.setIn(inputStream);
      System.setOut(new PrintStream(outputStream));

      // Run the main method
      MVCExampleTextUI.main(new String[]{});

      // Get the output
      String output = outputStream.toString();

      // Assertion 1
      assertTrue(output.contains("String: Integration Test"));

      // Assertion 2
      assertTrue(output.contains("Menu:"));
      assertTrue(output.contains("Enter the string to be echoed:"));
    } finally {
      // Restore original System.in and System.out
      System.setIn(originalIn);
      System.setOut(originalOut);
    }
  }

  @Test
  public void testComponentIntegration() {
    // Set up model, view, controller directly as in main method
    String inputString = "E\nDirect Component Test\nQ\n";
    ByteArrayInputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);

    IModel model = new Model();
    IView view = new TextView(printStream);
    IController controller = new TextController(model, inputStream, view);

    // Run the controller
    controller.go();

    // Get the output
    String output = outputStream.toString();

    // Assertion 1
    assertTrue(output.contains("String: Direct Component Test"));

    // Assertion 2
    assertEquals("Direct Component Test", model.getString());
  }

  @Test
  public void testFullUserInteractionFlow() {
    // Simulate a more complex user interaction
    String inputString = "E\nFirst\nE\nSecond\nX\nE\nThird\nQ\n";
    ByteArrayInputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);

    // Create all components
    IModel model = new Model();
    IView view = new TextView(printStream);
    IController controller = new TextController(model, inputStream, view);

    // Run the application
    controller.go();

    // Get the output
    String output = outputStream.toString();

    // Assertion 1
    assertTrue(output.contains("String: First"));
    assertTrue(output.contains("String: Second"));
    assertTrue(output.contains("Invalid option"));
    assertTrue(output.contains("String: Third"));

    // Assertion 2
    assertEquals("Third", model.getString());
  }

  @Test
  public void testModelViewControllerDataFlow() {
    // Test data flow from input through controller to model to view
    String inputString = "E\nTest Data Flow\nQ\n";
    ByteArrayInputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);

    // Create components and manually track the data flow
    IModel model = new Model();
    IView view = new TextView(printStream);

    // Pre-condition: model starts empty
    assertEquals("", model.getString());

    // Create and run the controller
    IController controller = new TextController(model, inputStream, view);
    controller.go();

    // Post-condition 1: model contains the input data
    assertEquals("Test Data Flow", model.getString());

    // Post-condition 2: view displayed the model data
    String output = outputStream.toString();
    assertTrue(output.contains("String: Test Data Flow"));
  }
}