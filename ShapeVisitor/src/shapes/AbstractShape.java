package shapes;

/**
 * Created by ashesh on 1/26/2017.
 */
public abstract class AbstractShape implements Shape {
  protected Point2D reference;

  /**
   * Constructor.
   * 
   * @param reference the initial reference point for this shape
   */
  protected AbstractShape(Point2D reference) {
    this.reference = reference;
  }

  @Override
  public double distToOrigin() {
    return reference.dist(new Point2D(0, 0));
  }

  /**
   * Accessor for the x position of the reference point for this shape.
   * 
   * @return the x position
   */
  public double getX() {
    return reference.getX();
  }

  /**
   * Accessor for the y position of the reference point for this shape.
   * 
   * @return the y position
   */
  public double getY() {
    return reference.getY();
  }

}
