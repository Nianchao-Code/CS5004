import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TriangleTest {

  private Triangle tri1;
  private Triangle tri2;
  private Triangle tri3;

  @BeforeEach
  void setUp() {
    tri1 = new Triangle(0, 0, 3, 0, 0, 4);
    tri2 = new Triangle(2, 3, 6, 3, 5, 8);
    tri3 = new Triangle(0, 0, 6, 0, 0, 8);
  }

  @Test
  void testInvalidTriangle(){
    assertThrows(IllegalArgumentException.class, () -> new Triangle(2,5,2,5,3,6));
  }

  @Test
  void testArea() {
    assertEquals(6.0, tri1.area(), 0.001);
    assertEquals(10.0, tri2.area(), 0.001);
  }

  @Test
  void testPerimeter() {
    assertEquals(12.0, tri1.perimeter(), 0.001);
    assertEquals(14.930, tri2.perimeter(), 0.001);
  }

  @Test
  void testResize() {
    Shape resizedTri1 = tri1.resize(4.0);
    Shape resizedTri2 = tri2.resize(0.25);

    // Check if the area scales correctly
    assertEquals(24.0, resizedTri1.area(), 0.001);
    assertEquals(2.5, resizedTri2.area(), 0.001);

    // Check if the perimeter scales correctly
    assertEquals(tri1.perimeter() * Math.sqrt(4.0), resizedTri1.perimeter(), 0.001);  // Perimeter should double
    assertEquals(tri2.perimeter() * Math.sqrt(0.25), resizedTri2.perimeter(), 0.001); // Perimeter should halve
  }

  @Test
  void testToString() {
    assertEquals("Triangle: [Reference point: (0.000, 0.000), Point2: (3.000, 0.000), Point3: (0.000, 4.000)]", tri1.toString());
    assertEquals("Triangle: [Reference point: (2.000, 3.000), Point2: (6.000, 3.000), Point3: (5.000, 8.000)]", tri2.toString());
  }
}