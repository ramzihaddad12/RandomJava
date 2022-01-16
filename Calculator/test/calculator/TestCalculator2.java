package calculator;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import calculator.Calculator;


/** Test class for the Simple Calculator V2. */
public class TestCalculator2 {
  @Test
  public void testAdd() {
    assertEquals(7, new Calculator().add(3, 4));
  }
}
