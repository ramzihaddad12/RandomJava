package polynomial;

/**
 * This represents an empty term of a list of terms. This class
 * is package-private to hide its implementation to others outside of the
 * ListADTTerm implementation.
 *
 */

class EmptyTerm implements ListAdtTerm {

  @Override
  public ListAdtTerm add(ListAdtTerm other) throws IllegalArgumentException {

    if (! (other instanceof ListAdtTerm)) {
      throw new IllegalArgumentException("Should be of the same type for addition");
    }

    if (other instanceof EmptyTerm) {
      return new EmptyTerm();
    }

    ElementTerm otherList = (ElementTerm) other;
    return new ElementTerm(otherList);
  }

  @Override
  public ListAdtTerm addTerm(int coefficient, int power) throws IllegalArgumentException {
    if (power < 0) {
      throw new IllegalArgumentException("Power can only be positive");
    }

    return new ElementTerm(new Term(coefficient, power), this);
  }

  @Override
  public boolean isSame(ListAdtTerm poly) {
    if (! (poly instanceof ListAdtTerm)) {
      return false;
    }

    return poly instanceof EmptyTerm;
  }

  @Override
  public double evaluate(double x) {
    return 0;
  }

  @Override
  public int getCoefficient(int power) {
    return 0;
  }

  @Override
  public int getDegree() {
    return 0;
  }

  @Override
  public String toString() {
    return "";
  }
}
