package shapes;

/**
 * This interface represents a visitor for shapes. It has a visit method for
 * each kind of shape, and an optional "none of the above" option.
 *
 * <p>If the visitor computes a value and must return it, then it is handled by a
 * get method in the specific visitor
 */

public interface ShapeVisitor {
  /**
   * Visit a circle.
   * 
   * @param c the Circle object to be visited
   */
  void visitCircle(Circle c);

  /**
   * Visit a rectangle.
   * 
   * @param r the Rectangle object to be visited
   */
  void visitRectangle(Rectangle r);

  /**
   * Visit a square.
   * 
   * @param s the Square object to be visited
   */
  void visitSquare(Square s);

  /**
   * Visit a generic shape. This is a none-of-the-above option. It may be useful
   * if we wish to add support for newer shapes in specific visitors.
   * 
   * @param shape the Shape object to be visited
   */
  void visitShape(Shape shape);
}
