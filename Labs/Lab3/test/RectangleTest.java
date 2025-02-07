import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RectangleTest {

  private Rectangle rect1;
  private Rectangle rect2;
  private Rectangle rect3;

  @BeforeEach
  void setUp() {
    rect1 = new Rectangle(5,6,2.5,2);
    rect2 = new Rectangle(2,3,10,10);
    rect3 = new Rectangle(1,1,4,5);
  }

  @Test
  void area() {
    assertEquals(5,rect1.area(),0.001);
    assertEquals(100,rect2.area(),0.001);
    assertEquals(20, rect3.area(), 0.001);
  }

  @Test
  void perimeter() {
    assertEquals(9,rect1.perimeter(),0.001);
    assertEquals(40,rect2.perimeter(),0.001);
    assertEquals(18, rect3.perimeter(), 0.001);
  }

  @Test
  void resize() {
    Shape resizedRect1, resizedRect2, resizedRect3;
    resizedRect1 = rect1.resize(12.5);
    resizedRect2 = rect2.resize(0.001);
    resizedRect3 = rect3.resize(2.0);

    assertEquals(12.5 * rect1.area(), resizedRect1.area(), 0.001);
    assertEquals(0.001 * rect2.area(), resizedRect2.area(), 0.001);
    assertEquals(2.0 * rect3.area(), resizedRect3.area(), 0.001);

    assertEquals(Math.sqrt(12.5) * rect1.perimeter(), resizedRect1.perimeter(), 0.001);
    assertEquals(Math.sqrt(0.001) * rect2.perimeter(), resizedRect2.perimeter(), 0.001);
    assertEquals(Math.sqrt(2.0) * rect3.perimeter(), resizedRect3.perimeter(), 0.001);
  }

  @Test
  void testToString() {
    assertEquals("Rectangle: LL corner (5.000,6.000) width 2.500 height 2.000", rect1.toString());
    assertEquals("Rectangle: LL corner (2.000,3.000) width 10.000 height 10.000", rect2.toString());
    assertEquals("Rectangle: LL corner (1.000,1.000) width 4.000 height 5.000", rect3.toString());
  }
}