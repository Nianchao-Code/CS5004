/**
 * Created by ashesh on 1/26/2017.
 */
public abstract class AbstractShape implements Shape {

  protected Point2D reference;

  /**
   * Constructs an AbstractShape with a given reference point.
   *
   * @param reference the reference point of the shape.
   */
  public AbstractShape(Point2D reference) {
    this.reference = reference;
  }

  /**
   * Computes the distance of the shape's reference point from the origin.
   *
   * @return the distance from the origin.
   */
  @Override
  public double distanceFromOrigin() {
    return reference.distToOrigin();
  }

  // Answers to Q1:
  // 1. Which parts of which files would have needed to be modified
  // if you were asked to provide a different ordering of Shape,
  // where comparisons would be based on perimeter rather than area?
  // Ans: To change comparison from area to perimeter:
  // only this AbstractShape class needs to be modified (change this.area()
  // to this.perimeter()). In conclusion: only 1 change needed.
  //
  // 2. If it had not been for sharing code via AbstractShape.java,
  // how many files would have required modification?
  // Ans: Each concrete class (Rectangle, Circle, Triangle) would need its own compareTo
  // implementation. Total 3 files would need changes, each implementing the same comparison.
  // In conclusion: 3 concrete classes need modification.
  // This demonstrates the benefit of having the abstract class handle shared behaviors.

  /**
   * Compares shapes based on their area.
   *
   * @param s the shape to compare against.
   * @return -1 if this shape has a smaller area, 1 if larger, or 0 if equal.
   */
  @Override
  public int compareTo(Shape s) {
    double areaThis = this.area();
    double areaOther = s.area();

    if (areaThis < areaOther) {
      return -1;
    } else if (areaOther < areaThis) {
      return 1;
    } else {
      return 0;
    }
  }
}