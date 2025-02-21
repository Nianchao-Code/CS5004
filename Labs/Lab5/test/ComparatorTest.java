import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests PerimeterComparator and area-based comparisons. Ensures that each test includes one `1`,
 * one `-1`, and one `0` result.
 */
class ComparatorTest {

  private PerimeterComparator perimeterComparator;
  private Shape circle;
  private Shape rectangle;
  private Shape triangle;

  private LinkedList<Shape> shapes;

  /**
   * Sets up the test environment before each test method.
   */
  @BeforeEach
  void setUp() {
    perimeterComparator = new PerimeterComparator();

    circle = new Circle(2);
    rectangle = new Rectangle(0, 0, 4, 5);
    triangle = new Triangle(0, 0, 6, 0, 3, 4);

    shapes = new LinkedList<>();
    shapes.add(circle);
    shapes.add(rectangle);
    shapes.add(triangle);
  }

  /**
   * Tests area-based comparison outcomes: one `1`, one `-1`, one `0`.
   */
  @Test
  void testCompareArea() {
    assertEquals(1, circle.compareTo(triangle), "Circle area is greater than Triangle.");
    assertEquals(-1, triangle.compareTo(rectangle), "Triangle area is smaller than Rectangle.");
    assertEquals(0, rectangle.compareTo(rectangle),
        "Comparing the same rectangle should return 0.");
  }

  /**
   * Tests perimeter-based comparison outcomes: one `1`, one `-1`, one `0`.
   */
  @Test
  void testComparePerimeter() {
    assertEquals(1, perimeterComparator.compare(rectangle, triangle),
        "Rectangle perimeter is greater than Triangle.");
    assertEquals(-1, perimeterComparator.compare(circle, triangle),
        "Circle is smaller than Triangle perimeter.");
    assertEquals(0, perimeterComparator.compare(circle, circle),
        "Comparing the same Circle should return 0.");
  }

  /**
   * Tests natural ordering (area-based sorting).
   */
  @Test
  void testCompareAreaSort() {
    Collections.sort(shapes);

    System.out.println("Sorted by Area:");
    for (Shape shape : shapes) {
      System.out.println(shape.getClass().getSimpleName() + " Area: " + shape.area());
    }

    assertEquals(triangle, shapes.get(0), "Triangle should be first (smallest area).");
    assertEquals(circle, shapes.get(1), "Circle should be second.");
    assertEquals(rectangle, shapes.get(2), "Rectangle should be last (largest area).");
  }

  /**
   * Tests sorting using PerimeterComparator.
   */
  @Test
  void testComparePerimeterSort() {
    shapes.sort(perimeterComparator);

    System.out.println("Sorted by Perimeter:");
    for (Shape shape : shapes) {
      System.out.println(shape.getClass().getSimpleName() + " Perimeter: " + shape.perimeter());
    }

    assertEquals(circle, shapes.get(0), "Circle should be first (smallest perimeter).");
    assertEquals(triangle, shapes.get(1), "Triangle should be second.");
    assertEquals(rectangle, shapes.get(2), "Rectangle should be last (largest perimeter).");
  }
}

