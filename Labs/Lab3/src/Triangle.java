/**
 * This class represents a triangle.  It offers all the operations mandated by the
 * Shape interface.
 */
public class Triangle extends AbstractShape {

  private final Point2D point2;
  private final Point2D point3;

  /**
   * Construct a triangle object using the coordinates of three points
   *
   * @param x1 x coordinate of the first point of this triangle (Reference point)
   * @param y1 y coordinate of the first point of this triangle (Reference point)
   * @param x2 x coordinate of the second point of this triangle
   * @param y2 y coordinate of the second point of this triangle
   * @param x3 x coordinate of the third point of this triangle
   * @param y3 y coordinate of the third point of this triangle
   * @throws IllegalArgumentException if two or more points are identical
   */
  public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
    super(new Point2D(x1, y1));
    point2 = new Point2D(x2, y2);
    point3 = new Point2D(x3, y3);

    if ((x1 == x2 && y1 == y2) || (x2 == x3 && y2 == y3) || (x3 == x1 && y3 == y1)) {
      throw new IllegalArgumentException(
          "A triangle with two (or three) identical points cannot be constructed.");
    }
  }

  /**
   * Computes the perimeter of the triangle.
   *
   * @return The perimeter of the triangle
   */
  @Override
  public double perimeter() {
    return distTo(reference, point2) + distTo(reference, point3) + distTo(point2, point3);
  }

  /**
   * Computes the area of the triangle using Heron's formula.
   *
   * @return The area of the triangle
   */
  @Override
  public double area() {
    double a = distTo(reference, point2);
    double b = distTo(point2, point3);
    double c = distTo(reference, point3);
    double s = (a + b + c) / 2;
    return Math.sqrt(s * (s - a) * (s - b) * (s - c));
  }

  /**
   * Returns a new Triangle resized by the given factor.
   *
   * @param factor The scaling factor
   * @return A resized triangle with the scaled dimensions
   */
  @Override
  public Shape resize(double factor) {
    double sqrtFactor = Math.sqrt(factor);

    double x2 = reference.getX() + sqrtFactor * (point2.getX() - reference.getX());
    double y2 = reference.getY() + sqrtFactor * (point2.getY() - reference.getY());
    double x3 = reference.getX() + sqrtFactor * (point3.getX() - reference.getX());
    double y3 = reference.getY() + sqrtFactor * (point3.getY() - reference.getY());

    return new Triangle(reference.getX(), reference.getY(), x2, y2, x3, y3);
  }

  /**
   * Returns a string representation of the triangle.
   *
   * @return A string describing the triangle's points
   */
  @Override
  public String toString() {
    return String.format("Triangle: [Reference point: (%.3f, %.3f), Point2: (%.3f, %.3f), "
            + "Point3: (%.3f, %.3f)]", reference.getX(), reference.getY(), point2.getX(),
        point2.getY(), point3.getX(), point3.getY());
  }

  /**
   * Computes the distance between two points.
   *
   * @param p1 First point
   * @param p2 Second point
   * @return The Euclidean distance between p1 and p2
   */
  public double distTo(Point2D p1, Point2D p2) {
    return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
  }
}