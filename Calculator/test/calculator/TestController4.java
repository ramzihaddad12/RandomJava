package calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import calculator.CalcController;
import calculator.Calculator;
import calculator.Controller4;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;


/**
 * Tests the SimpleCalc4.
 */
public class TestController4 {
  @Test
  public void testStart() throws Exception {
    InputStream in = new ByteArrayInputStream("3 4".getBytes());
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bytes);
    CalcController controller4 = new Controller4(in, out);
    controller4.start(new Calculator());
    assertEquals("7", new String(bytes.toByteArray()));
  }
}
