package calculator;

import java.util.Objects;
import java.util.Scanner;

/**
 * Demonstrates a simple command-line-based calculator. In this example, the
 * model and controller are factored out.
 */
public class SimpleCalc3 {
  /**
   * Starting point of our example.
   * 
   * @param args not used.
   */
  public static void main(String[] args) {
    new Controller3().start(new Calculator());
  }
}

/**
 * A controller for our calculator. This calculator is still hardwired to
 * System.in, making it difficult to test through JUnit
 */
class Controller3 implements CalcController {
  @Override
  public void start(Calculator calc) {
    if (calc == null) {
      throw new IllegalArgumentException("calculator cannot be null");
    }
    int num1;
    int num2;
    Scanner scan = new Scanner(System.in);
    num1 = scan.nextInt();
    num2 = scan.nextInt();
    System.out.printf("%d", calc.add(num1, num2));
    scan.close();
  }
}
