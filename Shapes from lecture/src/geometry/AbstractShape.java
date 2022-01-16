package geometry;

abstract class AbstractShape implements Shape {
  Point position;

  AbstractShape(Point position) {
    this.position = position;
  }

  @Override
  public int compareTo(Shape b) {
    return Float.compare(this.area(), b.area());
  }

  @Override
  public Point getPosition() {
    return position;
  }

  @Override
  public String toString() {
    return "This is a shape at location " + position.toString();
  }
}
