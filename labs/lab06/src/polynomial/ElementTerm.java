package polynomial;


/**
 * This is a non-empty term in a list of terms. It contains the 1st term and
 * the rest of the list. This class is package-private to hide its implementation
 * to others outside of the ListADTTerm implementation.
 *
 */

class ElementTerm implements ListAdtTerm {
  private ITerm term;
  private ListAdtTerm rest;

  /**
   * A constructor for the ElementTerm.
   *
   * @param term    the 1st term of this list.
   * @param rest the rest of the list
   */

  public ElementTerm(ITerm term, ListAdtTerm rest) {
    this.term = term;
    this.rest = rest;
  }

  /**
   * A copy constructor for the ElementTerm.
   *
   * @param elementTerm    the ElementTerm to be copied.
   */


  public ElementTerm(ElementTerm elementTerm) {
    this.term = elementTerm.term;
    this.rest = elementTerm.rest;
  }

  @Override
  public ListAdtTerm add(ListAdtTerm other) throws IllegalArgumentException {
    if (! (other instanceof ListAdtTerm)) {
      throw new IllegalArgumentException("Should be of the same type for addition");
    }

    if (other instanceof EmptyTerm) {
      return this;
    }

    ElementTerm otherList = (ElementTerm) other;

    ElementTerm newElementTerm = new ElementTerm(this);

    newElementTerm.addTerm(otherList.term.getCoefficient(), otherList.term.getDegree());
    newElementTerm.add(otherList.rest);

    return newElementTerm;
  }

  @Override
  public ListAdtTerm addTerm(int coefficient, int power) throws IllegalArgumentException {
    if (power < 0) {
      throw new IllegalArgumentException("Power can only be positive");
    }

    if (power > getDegree()) {
      this.rest = this.rest.addTerm(this.term.getCoefficient(), this.term.getDegree());
      this.term = new Term(coefficient, power);
      return this;
    }
    if (power == getDegree()) {
      this.term = new Term(term.getCoefficient() + coefficient, power);
      return this;
    }

    else {
      this.rest = this.rest.addTerm(coefficient, power);
      return this;
    }
  }

  @Override
  public boolean isSame(ListAdtTerm other) {
    if (! (other instanceof ListAdtTerm)) {
      return false;
    }

    if ((other instanceof EmptyTerm)) {
      return false;
    }
    ElementTerm otherList = (ElementTerm) other;

    return !this.term.equals(otherList.term) ? false : rest.isSame(otherList.rest) ;
  }

  @Override
  public double evaluate(double x) {
    return term.getCoefficient() * Math.pow(x, term.getDegree()) + this.rest.evaluate(x);
  }

  @Override
  public int getCoefficient(int power) {
    if (getDegree() == power) {
      return this.term.getCoefficient();
    }
    else {
      return this.rest.getCoefficient(power);
    }
  }

  @Override
  public int getDegree() {
    return this.term.getDegree();
  }

  @Override
  public String toString() {
    return this.term.toString() + " " + this.rest.toString();
  }
}
