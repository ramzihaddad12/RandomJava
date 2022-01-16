package geometry;

public interface Shape extends Comparable<Shape> {
  float area();
  float perimeter();
  Point getPosition();
  //int compareTo(Shape s);
}

// a.compareTo(b)
// a < b ====> negative
// a = b ====> zero
// a > b ====> positive

//public interface Comparable<T> {
//  int compareTo(T t);
//}
