package shapes;

/**
 * Visitor for calculating the areas of shapes.
 */
public class AreaVisitor implements ShapeVisitor {
  private double area;

  /**
   * Default constructor.
   */
  public AreaVisitor() {
    area = -1;
  }

  /**
   * Get the area calculated by this visitor.
   * 
   * @return the area
   */
  public double getArea() {
    if (area < 0) {
      throw new IllegalStateException("This visitor has not been used yet.");
    }
    return area;
  }

  @Override
  public void visitCircle(Circle c) {
    area = Math.PI * c.getRadius() * c.getRadius();
  }

  @Override
  public void visitRectangle(Rectangle r) {
    area = r.getHeight() * r.getWidth();
  }

  @Override
  public void visitSquare(Square s) {
    area = s.getSide() * s.getSide();
  }

  @Override
  public void visitShape(Shape shape) {
    throw new UnsupportedOperationException("Unknown shape");
  }
}
