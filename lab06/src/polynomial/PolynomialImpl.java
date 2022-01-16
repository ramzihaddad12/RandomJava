package polynomial;

/**
 * This class is an implementation of the Polynomial
 * interface.
 */

public class PolynomialImpl implements Polynomial {
  private ListAdtTerm head;

  /**
   * A private constructor that is used internally (see map).
   *
   * @param head the head of this list
   */

  private PolynomialImpl(ListAdtTerm head) {
    this.head = head;
  }

  /**
   * A default constructor, creating an empty
   * PolynomialImpl object.
   */

  public PolynomialImpl() {
    this.head = new EmptyTerm();
  }


  /**
   * A constructor for a PolynomialImpl that parses a string
   * to a polynomial.
   *
   * @param stringToParse the string that represents the polynomial
   * @throws IllegalArgumentException if the string is empty or null
   */

  public PolynomialImpl(String stringToParse) {
    if (stringToParse == null || stringToParse.length() == 0 || stringToParse.isEmpty()) {
      throw new IllegalArgumentException("String cannot be empty or null");
    }
    String[] parts = stringToParse.split(" ");//x\^\d+\+?

    head = new EmptyTerm();
    for (String term : parts) {
      int index = -1;
      for (int i = 0; i < term.length(); i++) {
        if (term.charAt(i) == 'x') {
          index = i;
        }
      }
      int coeff = 1;
      int pow;
      try {
        if (index == -1) {
          coeff = Integer.parseInt(term);
          pow = 0;
        }

        else {
          if (term.substring(0, index).equals("+")) {
            coeff = 1;
          }

          else if (term.substring(0, index).equals("-")) {
            coeff = -1;
          }
          else {
            coeff = Integer.parseInt(term.substring(0, index));

          }
          pow = Integer.parseInt(term.substring(index + 2, term.length()));
        }

        if (coeff != 0) {
          this.head = this.head.addTerm(coeff, pow);
        }
      }
      catch (Exception e) {
        throw new IllegalArgumentException(e);
      }


    }
  }

  @Override
  public Polynomial add(Polynomial other) throws IllegalArgumentException {
    if (!(other instanceof PolynomialImpl)) {
      throw new IllegalArgumentException("Should be of the same type");
    }
    PolynomialImpl otherP = (PolynomialImpl) other;
    return new PolynomialImpl(head.add(otherP.head));
  }

  @Override
  public void addTerm(int coefficient, int power) throws IllegalArgumentException {
    head = head.addTerm(coefficient, power);
  }

  @Override
  public boolean isSame(Polynomial poly) {
    if (! (poly instanceof PolynomialImpl)) {
      return false;
    }
    PolynomialImpl otherP = (PolynomialImpl) poly;
    return head.isSame(otherP.head);
  }

  @Override
  public double evaluate(double x) {
    return this.head.evaluate(x);
  }

  @Override
  public int getCoefficient(int power) {
    if (power < 0 || power > getDegree()) {
      return 0;
    }
    return this.head.getCoefficient(power);
  }

  @Override
  public int getDegree() {
    return this.head.getDegree();
  }

  @Override
  public String toString() {
    if (this.head.toString().length() == 0) {
      return "0";
    }
    if (this.head.toString().charAt(0) == '+') {
      return this.head.toString().trim().substring(1);
    }
    return this.head.toString().trim();
  }
}
