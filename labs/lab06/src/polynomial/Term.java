package polynomial;

import java.util.Objects;

/**
 * This is a class that represents a term in a polynomial.
 * It is made up of a coefficient and a degree.
 */

public class Term implements ITerm {
  private int coefficient;
  private int degree;

  /**
   * A constructor for a Term.
   *
   * @param coefficient the coefficient of the term
   * @param degree the degree of the term
   *
   */

  public Term(int coefficient, int degree) {
    this.coefficient = coefficient;
    this.degree = degree;
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof Term) {
      Term otherTerm = (Term) other;
      return this.degree == otherTerm.degree && this.coefficient == otherTerm.coefficient;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(coefficient, degree);
  }

  @Override
  public int getCoefficient() {
    return coefficient;
  }

  @Override
  public int getDegree() {
    return degree;
  }

  @Override
  public String toString() {
    if (coefficient == 0) {
      return "0";
    }

    if (degree == 0) {
      if (coefficient > 0) {
        return "+" + String.valueOf(coefficient);
      }
      else {
        return String.valueOf(coefficient);
      }
    }

    if (coefficient > 0) {
      return String.format("+%dx^%d", coefficient, degree);
    }
    return String.format("%dx^%d", coefficient, degree);
  }

}
