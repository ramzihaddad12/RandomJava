import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import geometry.Circle;
import geometry.Point;
import geometry.Rect;
import geometry.Shape;
import org.junit.Test;

public class ShapeTest {

  @Test
  public void testShapes() {
    Shape c = new Circle(new Point(1.2f, 3.4f), 3);
    Shape r = new Rect(new Point(3.4f, 5.6f), 5, 10);
    System.out.println(c.toString());
    assertEquals(9 * Math.PI, c.area(), 0.01);
    //c = r;
    assertEquals(50, r.area(), 0.01);
    assertTrue(c.compareTo(r) < 0);
  }

}
