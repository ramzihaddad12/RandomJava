package calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import calculator.CalcController;
import calculator.Calculator;
import calculator.Controller6;

import java.io.Reader;
import java.io.StringReader;


/** Tests the SimpleCalc6. */
public class TestController6 {
  @Test
  public void testStart() throws Exception {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("+ 3 4 + 8 9 q");
    CalcController controller6 = new Controller6(in, out);
    controller6.start(new Calculator());
    assertEquals("7\n17\n", out.toString());
  }
}
