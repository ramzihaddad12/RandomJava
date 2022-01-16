package calculator;

import java.util.Scanner;

/**
 * Demonstrates a simple command-line-based calculator.
 */
public class SimpleCalc1 {

  /**
   * The starting point of our program.
   * 
   * @param args Not used
   */
  public static void main(String[] args) {
    int num1;
    int num2;
    Scanner scan = new Scanner(System.in);
    num1 = scan.nextInt();
    num2 = scan.nextInt();
    System.out.printf("%d", num1 + num2);
    scan.close();
  }
}
