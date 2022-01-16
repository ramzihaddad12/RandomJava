import org.junit.Before;
import org.junit.Test;

import shapes.AreaVisitor;
import shapes.Circle;
import shapes.PerimeterVisitor;
import shapes.Rectangle;
import shapes.ResizeVisitor;
import shapes.Shape;
import shapes.Square;

import static org.junit.Assert.*;

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

  @Test
  public void testDistanceFromOrigin() {
    assertEquals(Math.sqrt(3 * 3 + 4 * 4), circle1.distToOrigin(), 0.001);

    assertEquals(Math.sqrt(10.32 * 10.32 + 10.43 * 10.43), circle2.distToOrigin(), 0.001);

    assertEquals(0, circle3.distToOrigin(), 0.001);

    assertEquals(Math.sqrt(5 * 5 + 6 * 6), rect1.distToOrigin(), 0.001);

    assertEquals(Math.sqrt(2 * 2 + 3 * 3), rect2.distToOrigin(), 0.001);

    assertEquals(Math.sqrt(2 * 2 + 3 * 3), square1.distToOrigin(), 0.001);

    assertEquals(Math.sqrt(4 * 4 + 4 * 4), square2.distToOrigin(), 0.001);

    assertEquals(Math.sqrt(2 * 2 + 3 * 3), square3.distToOrigin(), 0.001);
  }

  /**
   * Tests whether the area methods work correctly for all shapes.
   */
  @Test
  public void testArea() {
    AreaVisitor aVisitor = new AreaVisitor();
    circle1.accept(aVisitor);
    assertEquals(Math.PI * 25, aVisitor.getArea(), 0.001);

    circle2.accept(aVisitor);
    assertEquals(Math.PI * 100, aVisitor.getArea(), 0.001);

    circle3.accept(aVisitor);
    assertEquals(Math.PI * 400, aVisitor.getArea(), 0.001);

    rect1.accept(aVisitor);
    assertEquals(5, aVisitor.getArea(), 0.001);

    rect2.accept(aVisitor);
    assertEquals(100, aVisitor.getArea(), 0.001);

    square1.accept(aVisitor);
    assertEquals(100, aVisitor.getArea(), 0.001);

    square2.accept(aVisitor);
    assertEquals(400, aVisitor.getArea(), 0.001);

    square3.accept(aVisitor);
    assertEquals(100, aVisitor.getArea(), 0.001);

  }

  /**
   * Tests whether the perimeter methods work correctly for all shapes.
   */
  @Test
  public void testPerimeters() {
    PerimeterVisitor pVisitor = new PerimeterVisitor();

    circle1.accept(pVisitor);
    assertEquals(2 * Math.PI * 5, pVisitor.getPerimeter(), 0.001);

    circle2.accept(pVisitor);
    assertEquals(2 * Math.PI * 10, pVisitor.getPerimeter(), 0.001);

    circle3.accept(pVisitor);
    assertEquals(2 * Math.PI * 20, pVisitor.getPerimeter(), 0.001);

    rect1.accept(pVisitor);
    assertEquals(9, pVisitor.getPerimeter(), 0.001);

    rect2.accept(pVisitor);
    assertEquals(40, pVisitor.getPerimeter(), 0.001);

    square1.accept(pVisitor);
    assertEquals(40, pVisitor.getPerimeter(), 0.001);

    square2.accept(pVisitor);
    assertEquals(80, pVisitor.getPerimeter(), 0.001);

    square3.accept(pVisitor);
    assertEquals(40, pVisitor.getPerimeter(), 0.001);
  }

  @Test
  public void testResizes() {
    AreaVisitor aVisitor = new AreaVisitor();

    ResizeVisitor rVisitor = new ResizeVisitor(2.5);
    circle1.accept(rVisitor);
    Shape resizedCircle1 = rVisitor.getResizedShape();
    circle1.accept(aVisitor);
    double before = aVisitor.getArea();
    resizedCircle1.accept(aVisitor);
    double after = aVisitor.getArea();
    assertEquals(2.5 * before, after, 0.001);

    rVisitor = new ResizeVisitor(0);
    circle2.accept(rVisitor);
    Shape resizedCircle2 = rVisitor.getResizedShape();
    circle2.accept(aVisitor);
    before = aVisitor.getArea();
    resizedCircle2.accept(aVisitor);
    after = aVisitor.getArea();
    assertEquals(0, after, 0.001);

    rVisitor = new ResizeVisitor(10);
    circle3.accept(rVisitor);
    Shape resizedCircle3 = rVisitor.getResizedShape();
    circle3.accept(aVisitor);
    before = aVisitor.getArea();
    resizedCircle3.accept(aVisitor);
    after = aVisitor.getArea();
    assertEquals(10 * before, after, 0.001);

    rVisitor = new ResizeVisitor(12.5);
    rect1.accept(rVisitor);
    Shape resizedRect1 = rVisitor.getResizedShape();
    rect1.accept(aVisitor);
    before = aVisitor.getArea();
    resizedRect1.accept(aVisitor);
    after = aVisitor.getArea();
    assertEquals(12.5 * before, after, 0.001);

    rVisitor = new ResizeVisitor(0.001);
    rect2.accept(rVisitor);
    Shape resizedRect2 = rVisitor.getResizedShape();
    rect2.accept(aVisitor);
    before = aVisitor.getArea();
    resizedRect2.accept(aVisitor);
    after = aVisitor.getArea();
    assertEquals(0.001 * before, after, 0.001);

    rVisitor = new ResizeVisitor(2);
    square1.accept(rVisitor);
    Shape resizedSquare1 = rVisitor.getResizedShape();
    square1.accept(aVisitor);
    before = aVisitor.getArea();
    resizedSquare1.accept(aVisitor);
    after = aVisitor.getArea();
    assertEquals(2 * before, after, 0.001);

    rVisitor = new ResizeVisitor(0.001);
    square2.accept(rVisitor);
    Shape resizedSquare2 = rVisitor.getResizedShape();
    square2.accept(aVisitor);
    before = aVisitor.getArea();
    resizedSquare2.accept(aVisitor);
    after = aVisitor.getArea();
    assertEquals(0.001 * before, after, 0.001);

    rVisitor = new ResizeVisitor(10);
    square3.accept(rVisitor);
    Shape resizedSquare3 = rVisitor.getResizedShape();
    square3.accept(aVisitor);
    before = aVisitor.getArea();
    resizedSquare3.accept(aVisitor);
    after = aVisitor.getArea();
    assertEquals(10 * before, after, 0.001);
  }

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