package shapes;

/**
 * This interface contains all operations that all types of shapes should
 * support.
 */
public interface Shape {

  /**
   * Returns the distance of this shape from the origin. The distance is
   * measured from whatever reference position a shape is (e.g. a center for a
   * circle)
   *
   * @return the distance from the origin
   */
  double distToOrigin();

  /**
   * Method for applying visitors to this shape.
   * 
   * <p>NOTE: we removed area(), perimeter() and resize(...) and implemented them
   * as visitors
   * 
   * @param visitor the visitor to use
   */
  void accept(ShapeVisitor visitor);

}
