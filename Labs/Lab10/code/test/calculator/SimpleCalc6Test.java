package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.StringReader;

public class SimpleCalc6Test {

  private Calculator calculator;
  private StringBuffer output;
  private StringReader input;

  @BeforeEach
  public void setUp() {
    calculator = new Calculator();
    output = new StringBuffer();
    input = new StringReader("+ 3 4 + 8 9 q");
  }

  @Test
  public void testCalculatorAddition() throws IOException {
    // Create controller with prepared input and output
    Controller6 controller = new Controller6(input, output);

    // Run the controller with the calculator
    controller.go(calculator);

    // Verify the output
    assertEquals("7\n17\n", output.toString());
  }
}