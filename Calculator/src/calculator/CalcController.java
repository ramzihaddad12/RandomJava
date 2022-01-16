package calculator;

import java.io.IOException;

/**
 * This serves as the controller for the simple calculator example in the
 * Controller module of CS 5010.
 */
public interface CalcController {
  /**
   * Method that starts the run of the calculator.
   * 
   * @param calc the calculator that should be run
   * @throws IOException if an I/O error occurs
   * @throws IllegalArgumentException if calc is null
   */
  void start(Calculator calc) throws IOException;
}
