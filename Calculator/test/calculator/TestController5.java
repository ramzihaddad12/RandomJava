package calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import calculator.CalcController;
import calculator.Calculator;
import calculator.Controller5;

import java.io.Reader;
import java.io.StringReader;


/** Tests the SimpleCalc5. */
public class TestController5 {
  @Test
  public void testStart() throws Exception {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("3 4");
    CalcController controller5 = new Controller5(in, out);
    controller5.start(new Calculator());
    assertEquals("7\n", out.toString());
  }
}
