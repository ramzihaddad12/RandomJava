package calculator;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Scanner;

/**
 * Demonstrates a simple command-line-based calculator.
 */
public class SimpleCalc6 {
  /**
   * The starting point of this example.
   * 
   * @param args Not used.
   */
  public static void main(String[] args) {
    try {
      new Controller6(new InputStreamReader(System.in), System.out).start(new Calculator());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

/**
 * A controller for the calculator. This controller works with a Readable and
 * Appendable object. It has been designed to accept a sequence of multiple
 * inputs from the Readable object. See TestController6.
 */

class Controller6 implements CalcController {
  private final Readable in;
  private final Appendable out;

  /**
   * Constructor.
   * 
   * @param in  the input stream
   * @param out the output stream
   * @throws IllegalArgumentException if either parameter is null
   */
  Controller6(Readable in, Appendable out) {
    if (in == null || out == null) {
      throw new IllegalArgumentException("parameters cannot be null");
    }
    this.in = in;
    this.out = out;
  }

  @Override
  public void start(Calculator calc) throws IOException {
    if (calc == null) {
      throw new IllegalArgumentException("calc cannot be null");
    }
    Objects.requireNonNull(calc);
    int num1;
    int num2;
    try (Scanner scan = new Scanner(this.in)) {
      while (true) {
        switch (scan.next()) {
          case "+":
            num1 = scan.nextInt();
            num2 = scan.nextInt();
            this.out.append(String.format("%d\n", calc.add(num1, num2)));
            break;
            
          case "q":
            return;
            
          default:
            throw new IllegalStateException("ERROR: should not get here");
        }
      }
    }
  }
}
