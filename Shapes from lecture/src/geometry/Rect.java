package geometry;

public class Rect extends AbstractShape {
  private int length;
  private int width;

  public Rect(Point position, int length, int width) {
    super(position);
    this.length = length;
    this.width = width;
  }

  @Override
  public float area() {
    return length * width;
  }

  @Override
  public float perimeter() {
    return 2 * length + 2 * width;
  }
}
