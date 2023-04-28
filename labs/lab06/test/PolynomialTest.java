import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import polynomial.Polynomial;
import polynomial.PolynomialImpl;


/**
 * This class tests different functionalities for a polynomial.
 */
public class PolynomialTest {
  private Polynomial polynomial;

  /**
   * Creating the objects needed in the other tests.
   * */

  @Before
  public void setUp() {
    polynomial = new PolynomialImpl("4x^3 +3x^1 -5");
  }

  /**
   * Tests the default constructor of the PolynomialImpl.
   * */

  @Test
  public void testDefaultConstructorOfPolynomialImpl() {
    Polynomial p1 = new PolynomialImpl();
    int expectedCoefficient = 0;
    int expectedDegree = 0;
    double expectedEvaluation = 0;
    assertEquals(expectedCoefficient, p1.getCoefficient(0));
    assertEquals(expectedDegree, p1.getDegree());
    assertEquals(expectedEvaluation, p1.evaluate(1), 0.1);
  }

  /**
   * Tests the constructor of the PolynomialImpl when spaces are incorrectly
   * placed.
   * */

  @Test(expected = IllegalArgumentException.class)
  public void testStringArgumentConstructorWhenStringIsInvalid() {
    Polynomial p1 = new PolynomialImpl("4x^3+ 3x^1 -5");
  }

  /**
   * Tests the string argument constructor for a non empty polynomial
   * with more than one term with unique powers.
   * */

  @Test
  public void testStringArgumentConstructorWithMoreThanOneTermWithUniquePowers() {
    Polynomial samePolynomial = new PolynomialImpl("-5 +3x^1 +4x^3");
    String expectedString = "4x^3 +3x^1 -5";
    assertEquals(expectedString, polynomial.toString());
    assertEquals(expectedString, samePolynomial.toString());
    int expectedCoefficient = -5;
    int expectedDegree = 3;
    double expectedEvaluation = 2;
    assertEquals(expectedCoefficient, samePolynomial.getCoefficient(0));
    assertEquals(expectedDegree, samePolynomial.getDegree());
    assertEquals(expectedEvaluation, samePolynomial.evaluate(1), 0.1);
  }

  /**
   * Tests the string argument constructor method for a non empty polynomial
   * with more than one term with multiple terms having the same power.
   * */

  @Test
  public void testStringArgumentConstructorWithMoreThan1TermWithMultipleTermsHavingTheSamePower() {
    Polynomial somePolynomial = new PolynomialImpl("-5 +3x^1 +4x^3 +2x^1 +x^3");
    String expectedString = "5x^3 +5x^1 -5";
    assertEquals(expectedString, somePolynomial.toString());
    int expectedCoefficient = 5;
    int expectedDegree = 3;
    double expectedEvaluation = 5;
    assertEquals(expectedCoefficient, somePolynomial.getCoefficient(1));
    assertEquals(expectedDegree, somePolynomial.getDegree());
    assertEquals(expectedEvaluation, somePolynomial.evaluate(1), 0.1);
  }

  /**
   * Tests the string argument constructor method for a constant polynomial.
   * */

  @Test
  public void testTheStringArgumentConstructorForAConstantPolynomial() {
    Polynomial somePositiveConstantPolynomial = new PolynomialImpl("5");
    String expectedString = "5";
    assertEquals(expectedString, somePositiveConstantPolynomial.toString());
    int expectedCoefficient = 5;
    int expectedDegree = 0;
    double expectedEvaluation = 5;
    assertEquals(expectedCoefficient, somePositiveConstantPolynomial.getCoefficient(0));
    assertEquals(expectedDegree, somePositiveConstantPolynomial.getDegree());
    assertEquals(expectedEvaluation, somePositiveConstantPolynomial.evaluate(1), 0.1);

    Polynomial someNegativeConstantPolynomial = new PolynomialImpl("-5");
    expectedString = "-5";
    assertEquals(expectedString, someNegativeConstantPolynomial.toString());
    expectedCoefficient = -5;
    expectedEvaluation = -5;
    assertEquals(expectedCoefficient, someNegativeConstantPolynomial.getCoefficient(0));
    assertEquals(expectedDegree, someNegativeConstantPolynomial.getDegree());
    assertEquals(expectedEvaluation, someNegativeConstantPolynomial.evaluate(1), 0.1);
  }

  /**
   * Tests the string argument constructor for an empty string argument.
   * */

  @Test(expected = IllegalArgumentException.class)
  public void testTheStringArgumentConstructorForAnEmptyStringArgument() {
    Polynomial somePolynomial = new PolynomialImpl("");
  }

  /**
   * Tests the string argument constructor for a null string argument.
   * */

  @Test(expected = IllegalArgumentException.class)
  public void testTheStringArgumentConstructorForANullStringArgument() {
    Polynomial somePolynomial = new PolynomialImpl(null);
  }

  /**
   * Tests the string argument constructor for an empty polynomial.
   * */

  @Test
  public void testTheStringArgumentConstructorForAnEmptyPolynomial() {
    Polynomial emptyPolynomial = new PolynomialImpl();
    String expectedString = "0";
    assertEquals(expectedString, emptyPolynomial.toString());
    int expectedCoefficient = 0;
    int expectedDegree = 0;
    int expectedEvaluation = 0;
    assertEquals(expectedCoefficient, emptyPolynomial.getCoefficient(0));
    assertEquals(expectedDegree, emptyPolynomial.getDegree());
    assertEquals(expectedEvaluation, emptyPolynomial.evaluate(1), 0.1);
  }

  /**
   * Tests the getCoefficient method when power exists in the polynomial.
   * */

  @Test
  public void testGetCoefficientWhenTheDegreeExistsInPolynomial() {
    int expectedCoefficientForDegree3 = 4;
    assertEquals(expectedCoefficientForDegree3, polynomial.getCoefficient(3));
    int expectedCoefficientForDegree1 = 3;
    assertEquals(expectedCoefficientForDegree1, polynomial.getCoefficient(1));
    int expectedCoefficientForDegree0 = -5;
    assertEquals(expectedCoefficientForDegree0, polynomial.getCoefficient(0));
  }

  /**
   * Tests the getCoefficient method when power does not exist in the polynomial.
   * */

  @Test
  public void testGetCoefficientWhenTheDegreeDoesNotExistInPolynomial() {
    int expectedCoefficientForDegree2 = 0;
    assertEquals(expectedCoefficientForDegree2, polynomial.getCoefficient(2));
  }

  /**
   * Tests the getDegree method for a constant polynomial.
   * */

  @Test
  public void testGetDegreeForAConstantPolynomial() {
    Polynomial constantPolynomial = new PolynomialImpl("5");
    int expectedDegree = 0;
    assertEquals(expectedDegree, constantPolynomial.getDegree());
  }

  /**
   * Tests the getDegree method when degree is positive.
   * */

  @Test
  public void testGetDegreeWhenDegreeIsPositive() {
    int expectedDegree = 3;
    assertEquals(expectedDegree, polynomial.getDegree());
  }

  /**
   * Tests the evaluate method for a positive x.
   * */

  @Test
  public void testEvaluateForAPositiveX() {
    int x = 1;
    int expectedEvaluation = 2;
    assertEquals(expectedEvaluation, polynomial.evaluate(x), 0.1);
  }

  /**
   * Tests the evaluate method for a negative x.
   * */

  @Test
  public void testEvaluateForANegativeX() {
    int x = -1;
    int expectedEvaluation = -12;
    assertEquals(expectedEvaluation, polynomial.evaluate(x), 0.1);
  }

  /**
   * Tests the isSame method when the
   * two polynomials have multiple terms and unique powers.
   * */

  @Test
  public void testIsSameWhen2PolynomialsWithMultipleTermsAndUniquePowers() {
    Polynomial samePolynomial = new PolynomialImpl("-5 +3x^1 +4x^3");
    assertTrue(polynomial.isSame(samePolynomial));
    assertTrue(samePolynomial.isSame(polynomial));

    Polynomial diffPolynomial = new PolynomialImpl("-5 +2x^2 +4x^3");
    assertFalse(polynomial.isSame(diffPolynomial));
    assertFalse(samePolynomial.isSame(diffPolynomial));
  }

  /**
   * Tests the isSame method when the
   * two polynomials have multiple terms and common power.
   * */

  @Test
  public void testIsSameWhen2PolynomialsWithMultipleTermsAndCommonPowers() {
    Polynomial samePolynomial1 = new PolynomialImpl("-5 +3x^1 +4x^3 +6x^1");
    Polynomial samePolynomial2 = new PolynomialImpl("3x^3 -5 +3x^1 +x^3 +6x^1");

    assertTrue(samePolynomial2.isSame(samePolynomial1));
    assertTrue(samePolynomial1.isSame(samePolynomial2));

    Polynomial diffPolynomial = new PolynomialImpl("3x^3 -5 +2x^1 +x^3 +6x^1");
    assertFalse(samePolynomial1.isSame(diffPolynomial));
    assertFalse(diffPolynomial.isSame(samePolynomial1));
  }

  /**
   * Tests the isSame method when the
   * one of the  polynomials is zero.
   * */

  @Test
  public void testIsSameWhen1PolynomialsIsZero() {
    Polynomial zeroPolynomial1 = new PolynomialImpl("0");
    assertFalse(zeroPolynomial1.isSame(polynomial));
    assertFalse(polynomial.isSame(zeroPolynomial1));
  }

  /**
   * Tests the isSame method when the
   * two polynomials are zero.
   * */

  @Test
  public void testIsSameWhen2PolynomialsAreZero() {
    Polynomial zeroPolynomial1 = new PolynomialImpl("0");
    Polynomial zeroPolynomial2 = new PolynomialImpl("0");
    assertTrue(zeroPolynomial1.isSame(zeroPolynomial2));
    assertTrue(zeroPolynomial2.isSame(zeroPolynomial1));
  }

  /**
   * Tests the addTerm method when the
   * degree of the added term is negative.
   * */

  @Test(expected = IllegalArgumentException.class)
  public void testTheAddTermWhenTermDegreeIsNegative() {
    int coefficient = 2;
    int degree = -1;
    polynomial.addTerm(coefficient, degree);
  }

  /**
   * Tests the addTerm method when the
   * degree of the added term is one of
   * polynomial degrees.
   * */

  @Test
  public void testTheAddTermWhenTermDegreeIsOneOfPolynomialDegrees() {
    int coefficient = 2;
    int degree = 1;
    polynomial.addTerm(coefficient, degree);

    int expectedCoefficient = 5;
    assertEquals(expectedCoefficient, polynomial.getCoefficient(degree));

    int anotherCoefficient = -2;
    int anotherDegree = 0;
    polynomial.addTerm(anotherCoefficient, anotherDegree);

    int anotherExpectedCoefficient = -7;
    assertEquals(anotherExpectedCoefficient, polynomial.getCoefficient(anotherDegree));
  }


  /**
   * Tests the addTerm method when the
   * degree of the added term is not one of
   * polynomial degrees.
   * */

  @Test
  public void testTheAddTermWhenTermDegreeIsNotOneOfPolynomialDegrees() {
    int coefficient = 5;
    int degree = 2;
    polynomial.addTerm(coefficient, degree);

    int expectedCoefficient = coefficient;
    assertEquals(expectedCoefficient, polynomial.getCoefficient(degree));
  }

  /**
   * Tests the addTerm method when the
   * degree of the added term is greater than
   * the polynomial degree.
   * */

  @Test
  public void testTheAddTermWhenTermDegreeIsGreaterThanPolynomialDegree() {
    int coefficient = 9;
    int degree = 5;
    polynomial.addTerm(coefficient, degree);

    int expectedCoefficient = coefficient;
    assertEquals(expectedCoefficient, polynomial.getCoefficient(degree));

    int expectedDegreeOfPolynomial = degree;
    assertEquals(expectedDegreeOfPolynomial, polynomial.getDegree());
  }

  /**
   * Tests the add method when the two polynomials have multiple terms
   * and unique powers for both.
   * */

  @Test
  public void testAddPolynomialWhenTwoPolynomialsHaveMultipleTermsAndUniquePowers() {
    Polynomial polynomial1 = new PolynomialImpl("2x^5 +2x^2");
    Polynomial sumPolynomial = polynomial.add(polynomial1);

    int expectedDegreeOfPolynomial = 5;
    assertEquals(expectedDegreeOfPolynomial, sumPolynomial.getDegree());

    int expectedCoefficientForDegree5 = 2;
    assertEquals(expectedCoefficientForDegree5, sumPolynomial.getCoefficient(5));
    int expectedCoefficientForDegree4 = 0;
    assertEquals(expectedCoefficientForDegree4, sumPolynomial.getCoefficient(4));
    int expectedCoefficientForDegree3 = 4;
    assertEquals(expectedCoefficientForDegree3, sumPolynomial.getCoefficient(3));
    int expectedCoefficientForDegree2 = 2;
    assertEquals(expectedCoefficientForDegree2, sumPolynomial.getCoefficient(2));
    int expectedCoefficientForDegree1 = 3;
    assertEquals(expectedCoefficientForDegree1, sumPolynomial.getCoefficient(1));
    int expectedCoefficientForDegree0 = -5;
    assertEquals(expectedCoefficientForDegree0, sumPolynomial.getCoefficient(0));
  }

  /**
   * Tests the add method when the two polynomials have multiple terms
   * and common powers in both.
   * */

  @Test
  public void testAddPolynomialWhenTwoPolynomialsHaveMultipleTermsAndCommonPowers() {
    Polynomial polynomial1 = new PolynomialImpl("2x^5 +2x^1 +6x^5");
    Polynomial polynomial2 = new PolynomialImpl("3x^2 +5 +6");

    Polynomial sumPolynomial = polynomial2.add(polynomial1);

    int expectedDegreeOfPolynomial = 5;
    assertEquals(expectedDegreeOfPolynomial, sumPolynomial.getDegree());

    int expectedCoefficientForDegree5 = 8;
    assertEquals(expectedCoefficientForDegree5, sumPolynomial.getCoefficient(5));
    int expectedCoefficientForDegree4 = 0;
    assertEquals(expectedCoefficientForDegree4, sumPolynomial.getCoefficient(4));
    int expectedCoefficientForDegree3 = 0;
    assertEquals(expectedCoefficientForDegree3, sumPolynomial.getCoefficient(3));
    int expectedCoefficientForDegree2 = 3;
    assertEquals(expectedCoefficientForDegree2, sumPolynomial.getCoefficient(2));
    int expectedCoefficientForDegree1 = 2;
    assertEquals(expectedCoefficientForDegree1, sumPolynomial.getCoefficient(1));
    int expectedCoefficientForDegree0 = 11;
    assertEquals(expectedCoefficientForDegree0, sumPolynomial.getCoefficient(0));
  }

  /**
   * Tests the add method when the two polynomials have multiple terms
   * and common powers between the two.
   * */

  @Test
  public void testAddPolynomialWhenTwoPolynomialsHaveMultipleTermsAndCommonPowersBetweenThem() {
    Polynomial polynomial1 = new PolynomialImpl("2x^5 +2x^1 -2");
    Polynomial sumPolynomial = polynomial.add(polynomial1);

    int expectedDegreeOfPolynomial = 5;
    assertEquals(expectedDegreeOfPolynomial, sumPolynomial.getDegree());

    int expectedCoefficientForDegree5 = 2;
    assertEquals(expectedCoefficientForDegree5, sumPolynomial.getCoefficient(5));
    int expectedCoefficientForDegree4 = 0;
    assertEquals(expectedCoefficientForDegree4, sumPolynomial.getCoefficient(4));
    int expectedCoefficientForDegree3 = 4;
    assertEquals(expectedCoefficientForDegree3, sumPolynomial.getCoefficient(3));
    int expectedCoefficientForDegree2 = 0;
    assertEquals(expectedCoefficientForDegree2, sumPolynomial.getCoefficient(2));
    int expectedCoefficientForDegree1 = 5;
    assertEquals(expectedCoefficientForDegree1, sumPolynomial.getCoefficient(1));
    int expectedCoefficientForDegree0 = -7;
    assertEquals(expectedCoefficientForDegree0, sumPolynomial.getCoefficient(0));
  }

  /**
   * Tests the add method when one polynomial is zero.
   * */

  @Test
  public void testAddPolynomialWhenOnePolynomialsIsZero() {
    Polynomial polynomial1 = new PolynomialImpl("0");
    Polynomial sumPolynomial = polynomial.add(polynomial1);

    int expectedDegreeOfPolynomial = 3;
    assertEquals(expectedDegreeOfPolynomial, sumPolynomial.getDegree());

    int expectedCoefficientForDegree3 = 4;
    assertEquals(expectedCoefficientForDegree3, sumPolynomial.getCoefficient(3));
    int expectedCoefficientForDegree2 = 0;
    assertEquals(expectedCoefficientForDegree2, sumPolynomial.getCoefficient(2));
    int expectedCoefficientForDegree1 = 3;
    assertEquals(expectedCoefficientForDegree1, sumPolynomial.getCoefficient(1));
    int expectedCoefficientForDegree0 = -5;
    assertEquals(expectedCoefficientForDegree0, sumPolynomial.getCoefficient(0));
  }

  /**
   * Tests the add method when both polynomials are zero.
   * */

  @Test
  public void testAddPolynomialWhenBothPolynomialsAreZero() {
    Polynomial polynomial1 = new PolynomialImpl("0");
    Polynomial polynomial2 = new PolynomialImpl("0");

    Polynomial sumPolynomial = polynomial1.add(polynomial2);

    int expectedDegreeOfPolynomial = 0;
    assertEquals(expectedDegreeOfPolynomial, sumPolynomial.getDegree());

    int expectedCoefficientForDegree1 = 0;
    assertEquals(expectedCoefficientForDegree1, sumPolynomial.getCoefficient(1));
    int expectedCoefficientForDegree0 = 0;
    assertEquals(expectedCoefficientForDegree0, sumPolynomial.getCoefficient(0));
  }

  /**
   * Tests the toString method for a non empty polynomial
   * with more than one term with unique powers.
   * */

  @Test
  public void testTheToStringMethodForANonEmptyPolynomialWithMoreThanOneTermWithUniquePowers() {
    Polynomial samePolynomial = new PolynomialImpl("-5 +3x^1 +4x^3");
    String expectedString = "4x^3 +3x^1 -5";
    assertEquals(expectedString, polynomial.toString());
    assertEquals(expectedString, samePolynomial.toString());

    Polynomial somePolynomial = new PolynomialImpl("-5 +x^1 +4x^3");
    expectedString = "4x^3 +1x^1 -5";
    assertEquals(expectedString, somePolynomial.toString());
  }

  /**
   * Tests the toString method for an empty polynomial.
   * */

  @Test
  public void testTheToStringMethodForAnEmptyPolynomial() {
    Polynomial zeroPolynomial = new PolynomialImpl();
    String expectedString = "0";
    assertEquals(expectedString, zeroPolynomial.toString());
  }
}
