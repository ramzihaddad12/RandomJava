package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import shapes.Circle;
import shapes.Rectangle;
import shapes.Shape;
import shapes.Square;

/**
 * This class contains all the unit tests for various kinds of shapes.
 */
public class ShapeTest {

  private Shape circle1;
  private Shape circle2;
  private Shape circle3;

  private Shape rect1;
  private Shape rect2;

  private Shape square1;
  private Shape square2;
  private Shape square3;

  /** Setting up objects for all of the tests. */
  @Before
  public void setup() {
    circle1 = new Circle(3, 4, 5);
    circle2 = new Circle(10.32, 10.43, 10);
    circle3 = new Circle(20);

    rect1 = new Rectangle(5, 6, 2.5, 2);
    rect2 = new Rectangle(2, 3, 10, 10);
    square1 = new Square(2, 3, 10);
    square2 = new Square(4, 4, 20);
    square3 = new Square(2, 3, 10);
  }

  /**
   * Tests whether objects have been created with the correct numbers or not. It
   * does this by using their toString methods
   */
  @Test
  public void testObjectData() {
    assertEquals("Circle: center (3.000,4.000) radius 5.000", circle1.toString());
    assertEquals("Circle: center (10.320,10.430) radius 10.000", circle2.toString());
    assertEquals("Circle: center (0.000,0.000) radius 20.000", circle3.toString());
    assertEquals("Rectangle: LL corner (5.000,6.000) width 2.500 height 2.000", rect1.toString());
    assertEquals("Rectangle: LL corner (2.000,3.000) width 10.000 height 10" + ".000",
        rect2.toString());

    assertEquals("Square: LL corner (2.000,3.000) side 10.000", square1.toString());

    assertEquals("Square: LL corner (4.000,4.000) side 20.000", square2.toString());

    assertEquals("Square: LL corner (2.000,3.000) side 10.000", square3.toString());

  }

  /**
   * Tests the distance from origin calculation.
   */
  @Test
  public void testDistanceFromOrigin() {
    assertEquals(Math.sqrt(3 * 3 + 4 * 4), circle1.distToOrigin(), 0.001);

    assertEquals(Math.sqrt(10.32 * 10.32 + 10.43 * 10.43), circle2.distToOrigin(), 0.001);

    assertEquals(0, circle3.distToOrigin(), 0.001);

    assertEquals(Math.sqrt(5.0 * 5.0 + 6.0 * 6.0), rect1.distToOrigin(), 0.001);

    assertEquals(Math.sqrt(2.0 * 2.0 + 3.0 * 3.0), rect2.distToOrigin(), 0.001);

    assertEquals(Math.sqrt(2.0 * 2.0 + 3.0 * 3.0), square1.distToOrigin(), 0.001);

    assertEquals(Math.sqrt(4.0 * 4.0 + 4.0 * 4.0), square2.distToOrigin(), 0.001);

    assertEquals(Math.sqrt(2.0 * 2.0 + 3.0 * 3.0), square3.distToOrigin(), 0.001);
  }

  /**
   * Tests whether the area methods work correctly for all shapes.
   */
  @Test
  public void testArea() {
    assertEquals(Math.PI * 25, circle1.area(), 0.001);
    assertEquals(Math.PI * 100, circle2.area(), 0.001);
    assertEquals(Math.PI * 400, circle3.area(), 0.001);
    assertEquals(5, rect1.area(), 0.001);
    assertEquals(100, rect2.area(), 0.001);

    assertEquals(100, square1.area(), 0.001);
    assertEquals(400, square2.area(), 0.001);
    assertEquals(100, square3.area(), 0.001);

  }

  /**
   * Tests whether the perimeter methods work correctly for all shapes.
   */
  @Test
  public void testPerimeter() {
    testAreasOfOriginalObjects();
  }

  /**
   * Helper method for testing original objects.
   */
  private void testAreasOfOriginalObjects() {
    assertEquals(2 * Math.PI * 5, circle1.perimeter(), 0.001);
    assertEquals(2 * Math.PI * 10, circle2.perimeter(), 0.001);
    assertEquals(2 * Math.PI * 20, circle3.perimeter(), 0.001);
    assertEquals(9, rect1.perimeter(), 0.001);
    assertEquals(40, rect2.perimeter(), 0.001);

    assertEquals(40, square1.perimeter(), 0.001);
    assertEquals(80, square2.perimeter(), 0.001);
    assertEquals(40, square3.perimeter(), 0.001);
  }

  /**
   * Tests the resize method for Circle.
   */
  @Test
  public void testResizeForCircle() {
    Shape resizedCircle1 = circle1.resize(2.5);
    Shape resizedCircle2 = circle2.resize(0);
    Shape resizedCircle3 = circle3.resize(10);

    assertEquals(2.5 * circle1.area(), resizedCircle1.area(), 0.001);
    assertEquals(0 * circle2.area(), resizedCircle2.area(), 0.001);
    assertEquals(10 * circle3.area(), resizedCircle3.area(), 0.001);

    // verify that resize did not have any side effects on the calling objects
    testAreasOfOriginalObjects();
  }

  /**
   * Tests the resize method for Rectangles.
   */
  @Test
  public void testResizeForRectangle() {
    Shape resizedRect1 = rect1.resize(12.5);
    Shape resizedRect2 = rect2.resize(0.001);

    assertEquals(12.5 * rect1.area(), resizedRect1.area(), 0.001);
    assertEquals(0.001 * rect2.area(), resizedRect2.area(), 0.001);

    // verify that resize did not have any side effects on the calling objects
    testAreasOfOriginalObjects();
  }

  /**
   * Tests the resize method for Square.
   */
  @Test
  public void testResizeForSquare() {
    Shape resizedSquare1 = square1.resize(2);
    Shape resizedSquare2 = square2.resize(0.001);
    Shape resizedSquare3 = square3.resize(10);

    assertEquals(2 * square1.area(), resizedSquare1.area(), 0.001);
    assertEquals(0.001 * square2.area(), resizedSquare2.area(), 0.001);
    assertEquals(10 * square3.area(), resizedSquare3.area(), 0.001);

    // verify that resize did not have any side effects on the calling objects
    testAreasOfOriginalObjects();

  }

  /**
   * Test equality.
   */
  @Test
  public void testEquality() {
    // test self equality
    assertTrue(circle1.equals(circle1));
    assertTrue(circle2.equals(circle2));
    assertTrue(circle3.equals(circle3));
    assertTrue(rect1.equals(rect1));
    assertTrue(rect2.equals(rect2));
    assertTrue(square1.equals(square1));
    assertTrue(square2.equals(square2));
    assertTrue(square3.equals(square3));

    // check that shapes that are not equal should not be
    assertFalse(circle1.equals(circle2));
    assertFalse(circle2.equals(circle1));
    assertFalse(circle1.equals(circle3));
    assertFalse(circle3.equals(circle1));
    assertFalse(circle3.equals(circle2));
    assertFalse(circle2.equals(circle3));

    assertFalse(rect1.equals(rect2));
    assertFalse(rect2.equals(rect1));

    assertFalse(square1.equals(square2));
    assertFalse(square2.equals(square1));
    assertFalse(square2.equals(square3));
    assertFalse(square3.equals(square2));

    // test that a square is not equal to a rectangle
    assertFalse(rect2.equals(square1));

    // test that two different squares are equals
    assertTrue(square1.equals(square3));
  }
}