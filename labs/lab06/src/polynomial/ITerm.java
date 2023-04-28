package polynomial;

/**
 * This is an interface that represents a term in a polynomial.
 */

public interface ITerm {

  /**
   * A getter method that gets the coefficient
   * of a term.
   *
   * @return the coefficient of the term
   */

  public int getCoefficient();

  /**
   * A getter method that gets the degree
   * of a term.
   *
   * @return the degree of the term
   */

  public int getDegree();
}
