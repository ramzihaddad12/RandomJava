package calculator;

import java.util.Scanner;

/**
 * Demonstrates a simple command-line-based calculator with a separate model.
 */
public class SimpleCalc2 {
  /**
   * The starting point of our example. 
   * @param args Not used
   */
  public static void main(String[] args) {
    int num1;
    int num2;
    Scanner scan = new Scanner(System.in);
    num1 = scan.nextInt();
    num2 = scan.nextInt();
    System.out.printf("%d", new Calculator().add(num1, num2));
    scan.close();
  }  
}

/**
 * The model of the calculator.
 */
class Calculator {
  /**
   * Add two numbers together.
   * 
   * @param num1 the first number
   * @param num2 the second number
   * @return the sum of the num1 and num2
   */
  public int add(int num1, int num2) {
    return num1 + num2;
  }
}
