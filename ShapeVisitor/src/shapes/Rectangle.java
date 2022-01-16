package shapes;

/**
 * This class represents a rectangle. It defines all the operations mandated by
 * the Shape interface
 */
public class Rectangle extends AbstractShape {
  protected double width;
  protected double height;

  /**
   * Constructs a rectangle object with the given location of its lower-left
   * corner and dimensions.
   *
   * @param x      x coordinate of the lower-left corner of this rectangle
   * @param y      y coordinate of the lower-left corner of this rectangle
   * @param width  width of this rectangle
   * @param height height of this rectangle
   */
  public Rectangle(double x, double y, double width, double height) {
    super(new Point2D(x, y));
    this.width = width;
    this.height = height;
  }

  /**
   * Accessor for the width of this rectangle.
   * 
   * @return the width
   */
  public double getWidth() {
    return width;
  }

  /**
   * Accessor for the height of this rectangle.
   * 
   * @return the height
   */
  public double getHeight() {
    return height;
  }

  @Override
  public String toString() {
    return String.format("Rectangle: LL corner (%.3f,%.3f) width %.3f height " + "%.3f",
        this.reference.getX(), this.reference.getY(), this.width, this.height);
  }

  @Override
  public void accept(ShapeVisitor visitor) {
    visitor.visitRectangle(this);
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof Shape)) {
      return false;
    }
    RectangleEqualityVisitor visitor = new RectangleEqualityVisitor(this);
    ((Shape) other).accept(visitor);
    return visitor.getResult();
  }

  /**
   * Visitor for determining the equality between shapes.
   */
  private class RectangleEqualityVisitor implements ShapeVisitor {
    private boolean result;
    private Rectangle rect;

    /**
     * Constructor.
     * 
     * @param rect the rectangle
     */
    public RectangleEqualityVisitor(Rectangle rect) {
      this.rect = rect;
      result = false;
    }

    /**
     * Accessor for the result of the visitation.
     * 
     * @return whether the shapes are equal
     */
    public boolean getResult() {
      return result;
    }

    @Override
    public void visitCircle(Circle c) {
      result = false;
    }

    @Override
    public void visitRectangle(Rectangle r) {
      result = r.reference.dist(rect.reference) < 0.001
          && Math.abs(r.getHeight() - rect.getHeight()) < 0.001
          && Math.abs(r.getWidth() - rect.getWidth()) < 0.001;

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
