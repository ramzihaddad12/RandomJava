package calculator;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Objects;
import java.util.Scanner;

/**
 * Demonstrates a simple command-line-based calculator. The calculator is
 * factored out into a model and controller.
 */
public class SimpleCalc4 {
  /**
   * The starting point of this example.
   * 
   * @param args Not used
   */
  public static void main(String[] args) {
    new Controller4(System.in, System.out).start(new Calculator());
  }
}

/**
 * A controller for the calculator. The controller receives all its inputs from
 * an InputStream object and transmits all outputs to a PrintStream object. The
 * PrintStream object would be provided by a view (not shown in this example).
 * This design allows us to test. See TestController4.
 */
class Controller4 implements CalcController {
  private final InputStream in;
  private final PrintStream out;

  /**
   * Constructor.
   * 
   * @param in  the input stream
   * @param out the output stream
   * @throws IllegalArgumentException if either parameter is null
   */
  Controller4(InputStream in, PrintStream out) {
    if (in == null || out == null) {
      throw new IllegalArgumentException("parameters cannot be null");
    }
    this.in = in;
    this.out = out;
  }

  @Override
  public void start(Calculator calc) {
    Objects.requireNonNull(calc);
    int num1;
    int num2;
    Scanner scan = new Scanner(this.in);
    num1 = scan.nextInt();
    num2 = scan.nextInt();
    this.out.printf("%d", calc.add(num1, num2));
    scan.close();
  }
}
