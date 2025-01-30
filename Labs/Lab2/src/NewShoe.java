/**
 * Based on instructions in CS5004, the class represents a shoe with attributes: type, color, brand, and size.
 * Provides methods to access the attributes and a string representation of the shoe.
 */
public class NewShoe {
  private ShoeType type;
  private ShoeColor color;
  private ShoeBrand brand;
  private double size;

  /**
   * Constructs a Shoe object with a specific type, color, brand, and size.
   *
   * @param type  the type of shoe
   * @param color the color of the shoe
   * @param brand the brand of the shoe
   * @param size  the size of the shoe
   */
  public NewShoe(ShoeType type, ShoeColor color, ShoeBrand brand, double size) {
    if (brand == ShoeBrand.NIKE && type == ShoeType.DRESS) {
      throw new IllegalArgumentException("NIKE brand does not sell dress shoes.");
    }
    this.type = type;
    this.color = color;
    this.brand = brand;
    this.size = size;
  }

  /**
   * Returns the type of the shoe.
   * @return the type of the shoe
   */
  public ShoeType getType() {
    return type;
  }

  /**
   * Returns the color of the shoe.
   * @return the color of the shoe
   */
  public ShoeColor getColor() {
    return color;
  }

  /**
   * Returns the brand of the shoe.
   * @return the brand of the shoe
   */
  public ShoeBrand getBrand() {
    return brand;
  }

  /**
   * Returns the size of the shoe.
   * @return the size of the shoe
   */
  public double getSize() {
    return size;
  }

  /**
   * Provides a string representation of the shoe object.
   * @return a string including the shoe's type, color, brand, and size
   */
  public String toString() {
    String typeString = "";
    switch (type) {
      case RUNNING -> typeString = "Running";
      case DRESS -> typeString = "Dress";
      case SNEAKER -> typeString = "Sneaker";
      case BASKETBALL -> typeString = "Basketball";
    }

    String colorString = "";
    switch (color) {
      case BLACK -> colorString = "Black";
      case WHITE -> colorString = "White";
      default -> colorString = "Neutral";
    }

    String brandString = "";
    switch (brand) {
      case NIKE -> brandString = "Nike";
      case KAPPA -> brandString = "Kappa";
      case LINING -> brandString = "Lining";
      case ADIDAS -> brandString = "Adidas";
    }

    return String.format("Shoe [Type: %s, Color: %s, Brand: %s, Size: %s]", typeString, colorString, brandString, size);
  }

  /**
   * Demonstrates the creation of a Shoe object and printing the attributes
   */
  public static void main(String[] args) {
    NewShoe shoe1 = new NewShoe(ShoeType.SNEAKER, ShoeColor.RED, ShoeBrand.ADIDAS, 12.0);
    System.out.println(shoe1);
  }
}