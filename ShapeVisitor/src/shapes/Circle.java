package shapes;

/**
 * This class represents a circle. It offers all the operations mandated by the
 * Shape interface.
 */
public class Circle extends AbstractShape {
  private double radius;

  /**
   * Construct a circle object using the given center and radius.
   *
   * @param x      x coordinate of the center of this circle
   * @param y      y coordinate of the center of this circle
   * @param radius the radius of this circle
   */
  public Circle(double x, double y, double radius) {
    super(new Point2D(x, y));
    this.radius = radius;
  }

  /**
   * Construct a circle object with the given radius. It is centered at (0,0)
   *
   * @param radius the radius of this circle
   */
  public Circle(double radius) {
    super(new Point2D(0, 0));
    this.radius = radius;
  }

  @Override
  public String toString() {
    return String.format("Circle: center (%.3f,%.3f) radius %.3f", this.reference.getX(),
        this.reference.getY(), this.radius);
  }

  /**
   * Accessor for the radius of this circle.
   * 
   * @return the radius
   */
  public double getRadius() {
    return radius;
  }

  @Override
  public void accept(ShapeVisitor visitor) {
    visitor.visitCircle(this);
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof Shape)) {
      return false;
    }
    CircleEqualityVisitor visitor = new CircleEqualityVisitor(this);
    ((Shape) other).accept(visitor);
    return visitor.getResult();
  }

  /**
   * Private implementation of the shape visitor for circle equality.
   */
  private class CircleEqualityVisitor implements ShapeVisitor {
    private boolean result;
    private Circle circle;

    /**
     * Constructor for the circle equality visitor.
     * 
     * @param obj the circle object
     */
    public CircleEqualityVisitor(Circle obj) {
      circle = obj;
      result = false;
    }

    /**
     * Accessor for the result of this vistor.
     * 
     * @return the result of the visitation
     */
    public boolean getResult() {
      return result;
    }

    @Override
    public void visitCircle(Circle c) {
      result = c.reference.dist(circle.reference) < 0.001
          && Math.abs(c.getRadius() - circle.getRadius()) < 0.001;
    }

    @Override
    public void visitRectangle(Rectangle r) {
      result = false;
    }

    @Override
    public void visitSquare(Square s) {
      result = false;
    }

    @Override
    public void visitShape(Shape shape) {
      result = false;
    }
  }
}
