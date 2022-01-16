package geometry;

public class Point {
  private final float x;
  private final float y;

  public Point(float x, float y) {
    this.x = x;
    this.y = y;
  }

  public float getX() {
    return x;
  }

  public float getY() {
    return y;
  }

  @Override
  public String toString() {
    return "" + x + "," + y;
  }
}
