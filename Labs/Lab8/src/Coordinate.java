/**
 * A class that represents a 2D coordinate with x and y values.
 */
public class Coordinate {
  int x;
  int y;

  /**
   * Constructs a new Coordinate with x and y values.
   *
   * @param x the x-coordinate
   * @param y the y-coordinate
   */
  public Coordinate(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Compares this coordinate with another object for equality.
   *
   * @param obj the object to compare with
   * @return true if the objects are equal, false otherwise
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Coordinate) {
      Coordinate other = (Coordinate) obj;
      return other.x == this.x && other.y == this.y;
    }
    return false;
  }

  /**
   * Implements hashCode to match the equal method.
   *
   * @return a hash code value for this coordinate
   */
  @Override
  public int hashCode() {
    return java.util.Objects.hash(x, y);
  }
}
