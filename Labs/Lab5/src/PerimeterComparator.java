import java.util.Comparator;

/**
 * A comparator that compares Shapes based on their perimeter. This provides an alternative
 * comparison strategy to the natural ordering (by area) defined in AbstractShape's compareTo
 * method.
 */
public class PerimeterComparator implements Comparator<Shape> {

  public PerimeterComparator() {
  }

  /**
   * Compares two Shape objects based on their perimeters.
   *
   * @param shape1 the first shape object to be compared.
   * @param shape2 the second shape object to be compared.
   * @return a negative integer if shape1's perimeter is less than shape2's perimeter, zero if their
   * perimeters are equal, a positive integer if shape1's perimeter is greater than shape2's
   * perimeter.
   */
  @Override
  public int compare(Shape shape1, Shape shape2) {
    double perimeter1 = shape1.perimeter();
    double perimeter2 = shape2.perimeter();
    if (perimeter1 < perimeter2) {
      return -1;
    } else if (perimeter1 == perimeter2) {
      return 0;
    } else {
      return 1;
    }
  }
}