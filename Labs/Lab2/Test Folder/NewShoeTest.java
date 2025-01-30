import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NewShoeTest {

  private NewShoe basketball;
  private NewShoe dress;

  @BeforeEach
  public void setUp() {
    basketball = new NewShoe(ShoeType.BASKETBALL, ShoeColor.BLACK, ShoeBrand.ADIDAS, 12.0);
    dress = new NewShoe(ShoeType.DRESS, ShoeColor.RED, ShoeBrand.KAPPA, 12.0);
  }

  @Test
  public void testGetType() {
    assertEquals(ShoeType.BASKETBALL, basketball.getType(), "The type should be BASKETBALL");
    assertNotEquals(ShoeType.DRESS, basketball.getType(), "The type should not be DRESS");
  }

  @Test
  public void testGetColor() {
    assertEquals(ShoeColor.BLACK, basketball.getColor(), "The color should be BLACK");
    assertNotEquals(ShoeColor.WHITE, basketball.getColor(), "The color should not be WHITE");
  }

  @Test
  public void testGetBrand() {
    assertEquals(ShoeBrand.KAPPA, dress.getBrand(), "The brand should be KAPPA");
    assertNotEquals(ShoeBrand.NIKE, dress.getBrand(), "The brand should not be NIKE");
  }

  @Test
  public void testGetSize() {
    assertEquals(12.0, basketball.getSize(), "The size should be 12.0");
    assertNotEquals(10.0, basketball.getSize(), "The size should not be 10.0");
  }

  @Test
  public void testToString() {
    String expectedBasketball = """
        Shoe [Type: Basketball, Color: Black, Brand: Adidas, Size: 12.0]""";
    assertEquals(expectedBasketball, basketball.toString());

    String expectedDress = """
        Shoe [Type: Dress, Color: Neutral, Brand: Kappa, Size: 12.0]""";
    assertEquals(expectedDress, dress.toString());
  }

  /**
   * Using a lambda expression in the test to cause the exception to be thrown.
   */
  @Test
  public void testInvalidNikeDressShoe() {
    assertThrows(IllegalArgumentException.class,
        () -> new NewShoe(ShoeType.DRESS, ShoeColor.BROWN, ShoeBrand.NIKE, 9)
    );
  }
}

