package shapes;

/**
 * This class represents a square shape. Since a square is a special instance of
 * rectangle, this class extends the {@link Rectangle} class. However in the
 * context of the application, a square is a separate kind of shape, and
 * therefore a square may not be deemed as equal to a rectangle of identical
 * dimensions.
 */
public class Square extends Rectangle {

  /**
   * Constructor.
   * 
   * @param x    the x position for this Square
   * @param y    the y position for this Square
   * @param side the length of the size for this Square
   */
  public Square(double x, double y, double side) {
    super(x, y, side, side);
  }

  @Override
  public String toString() {
    return String.format("Square: LL corner (%.3f,%.3f) side %.3f",
        this.reference.getX(), this.reference.getY(), this.width);
  }

  /**
   * Accessor for the length of the side for this Square.
   * 
   * @return the length of the side
   */
  public double getSide() {
    return getWidth();
  }

  @Override
  public void accept(ShapeVisitor visitor) {
    visitor.visitSquare(this);
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof Shape)) {
      return false;
    }
    SquareEqualityVisitor visitor = new SquareEqualityVisitor(this);
    ((Shape) other).accept(visitor);
    return visitor.getResult();
  }

  /**
   * Implementation of a visitor for square equality.
   */
  private class SquareEqualityVisitor implements ShapeVisitor {
    private boolean result;
    private Square square;

    /**
     * Constructor.
     * 
     * @param s this square
     */
    public SquareEqualityVisitor(Square s) {
      this.square = s;
      result = false;
    }

    /**
     * The result of the visitation.
     * 
     * @return true if this square is equal to the other one
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
      result = false;

    }

    @Override
    public void visitSquare(Square s) {
      result = s.reference.dist(square.reference) < 0.001
          && Math.abs(s.getSide() - square.getSide()) < 0.001;
    }

    @Override
    public void visitShape(Shape shape) {
      result = false;
    }
  }
}
