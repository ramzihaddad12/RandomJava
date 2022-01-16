package polynomial;

/**
 * This interface represents a list of terms (an abstract data type).
 * In this list, the terms are order based on the degree of the terms
 * with the highest degree being at the front.
 */

interface ListAdtTerm {
  /**
   * Add this ListADTTerm to another and return the result as another ListADTTerm.
   *
   * @param other the other ListADTTerm to be added
   * @return the resulting ListADTTerm
   * @throws IllegalArgumentException if parameter is not the same concrete type
   *                                  as the current object.
   */
  ListAdtTerm add(ListAdtTerm other) throws IllegalArgumentException;

  /**
   * Add a term to this ListADTTerm with the specified coefficient and power.
   * If the term to be added has a power already in the list, the term from the polynomial
   * and the term to be added are combined.
   *
   * @param coefficient the coefficient of the term to be added
   * @param power       the power of the term to be added
   * @throws IllegalArgumentException if the power is negative
   */
  ListAdtTerm addTerm(int coefficient, int power) throws IllegalArgumentException;

  /**
   * Determines if this ListADTTerm is the same as the parameter ListADTTerm.
   *
   * @param poly the ListADTTerm to use
   * @return true if this ListADTTerm is of the same concrete type and has the same
   *         terms as the parameter, false otherwise
   */
  boolean isSame(ListAdtTerm poly);

  /**
   * Evaluate the value of this ListADTTerm at the given value of the variable.
   *
   * @param x the value at which the ListADTTerm is to be evaluated.
   * @return the value of the ListADTTerm at x
   */
  double evaluate(double x);

  /**
   * Return the coefficient of the term with the given power.
   *
   * @param power the power whose coefficient is sought
   * @return the coefficient at the given power
   */
  int getCoefficient(int power);

  /**
   * Get the degree of this ListADTTerm.
   *
   * @return the degree of this ListADTTerm as a whole number
   */
  int getDegree();
}
