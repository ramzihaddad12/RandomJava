package shapes;

/**
 * Implementation of a resize visitor.
 */
public class ResizeVisitor implements ShapeVisitor {
  private Shape resizedShape;
  private double factor;

  /**
   * Constructor for resizing.
   * 
   * @param factor the resizing factor
   */
  public ResizeVisitor(double factor) {
    resizedShape = null;
    this.factor = factor;
  }

  /**
   * The shape that has been resized.
   * 
   * @return the resized shape
   */
  public Shape getResizedShape() {
    if (resizedShape == null) {
      throw new IllegalStateException("This visitor has not been used yet.");
    }
    return resizedShape;
  }

  @Override
  public void visitCircle(Circle c) {
    resizedShape = new Circle(c.getX(), c.getY(), Math.sqrt(factor) * c.getRadius());
  }

  @Override
  public void visitRectangle(Rectangle r) {
    resizedShape = new Rectangle(r.getX(), r.getY(), Math.sqrt(factor) * r.getWidth(),
        Math.sqrt(factor) * r.getHeight());
  }

  @Override
  public void visitSquare(Square s) {
    resizedShape = new Square(s.getX(), s.getY(), Math.sqrt(factor) * s.getSide());

  }

  @Override
  public void visitShape(Shape shape) {
    throw new UnsupportedOperationException("Unknown shape");
  }
}
