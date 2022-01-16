package geometry;

public class Circle extends AbstractShape {
  private float radius;

  public Circle(Point pos, float radius) {
    super(pos);
    if (radius < 0) {
      throw new IllegalArgumentException("Radius can't be < 0");
    }
    this.radius = radius;
  }

  @Override
  public float area() {
    return (float) Math.PI * radius * radius;
  }

  @Override
  public float perimeter() {
    return 2 * (float) Math.PI * radius;
  }

//
//  @Override
//  public Point getPosition() {
//    return new Point(super.getPosition().getX() + 0.1f, super.getPosition().getY() + 0.1f);
//  }

  @Override
  public String toString() {
    return "This is a circle. " + super.toString();
  }

  public float getRadius() {
    return radius;
  }
}
