package calculator;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Scanner;

/**
 * Demonstrates a simple command-line-based calculator.
 */
public class SimpleCalc5 {
  /**
   * The starting point of this example.
   * @param args Not used
   */
  public static void main(String[] args) {
    try {
      new Controller5(new InputStreamReader(System.in), System.out)
          .start(new Calculator());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

/**
 * A controller for the calculator. The controller receives all its inputs from
 * a Readable object and transmits all outputs to an Appendable object. The
 * Appendable object would be provided by a view (not shown in this example).
 * This design allows us to test. See TestController5.
 */
class Controller5 implements CalcController {
  private final Readable in;
  private final Appendable out;

  /**
   * Constructor.
   * 
   * @param in  the input stream
   * @param out the output stream
   * @throws IllegalArgumentException if either parameter is null
   */
  Controller5(Readable in, Appendable out) {
    if (in == null || out == null) {
      throw new IllegalArgumentException("parameters cannot be null");
    }
    this.in = in;
    this.out = out;
  }

  @Override
  public void start(Calculator calc) throws IOException {
    if (calc == null) {
      throw new IllegalArgumentException("parameter cannot be null");
    }
    int num1;
    int num2;
    Scanner scan = new Scanner(this.in);
    num1 = scan.nextInt();
    num2 = scan.nextInt();
    this.out.append(String.format("%d\n", calc.add(num1, num2)));
    scan.close();
  }
}
