package shapes;

/**
 * Visitor for calculating the perimeter of the shapes.
 */
public class PerimeterVisitor implements ShapeVisitor {
  private double perimeter;

  /** Default constructor. */
  public PerimeterVisitor() {
    perimeter = -1;
  }

  /**
   * Accessor for the result of this visitor.
   * 
   * @return the perimeter
   */
  public double getPerimeter() {
    if (perimeter < 0) {
      throw new IllegalStateException("Visitor has not been used yet.");
    }
    return perimeter;
  }

  @Override
  public void visitCircle(Circle c) {
    perimeter = 2 * Math.PI * c.getRadius();
  }

  @Override
  public void visitRectangle(Rectangle r) {
    perimeter = 2 * (r.getWidth() + r.getHeight());
  }

  @Override
  public void visitSquare(Square s) {
    perimeter = 4 * s.getSide();
  }

  @Override
  public void visitShape(Shape shape) {
    throw new UnsupportedOperationException("Unknown shape");
  }
}
