/**
 * Based on instructions in CS5004, the class represents a shoe with attributes: type, color, brand, and size.
 * Provides methods to access the attributes and a string representation of the shoe.
 */
public class Shoe {
  private String type;
  private String color;
  private String brand;
  private double size;

  /**
   * Constructs a Shoe object with a specific type, color, brand, and size.
   *
   * @param type  the type of shoe
   * @param color the color of the shoe
   * @param brand the brand of the shoe
   * @param size  the size of the shoe
   */
  public Shoe(String type, String color, String brand, double size) {
    this.type = type;
    this.color = color;
    this.brand = brand;
    this.size = size;
  }

  /**
   * Returns the type of the shoe.
   * @return the type of the shoe
   */
  public String getType() {
    return type;
  }

  /**
   * Returns the color of the shoe.
   * @return the color of the shoe
   */
  public String getColor() {
    return color;
  }

  /**
   * Returns the brand of the shoe.
   * @return the brand of the shoe
   */
  public String getBrand() {
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
    return "Shoe{type=" + type + ", color=" + color + ", brand=" + brand + ", size=" + size + "}";
  }

  /**
   * Demonstrates the creation of a Shoe object and printing the attributes
   */
  public static void main(String[] args) {
    Shoe shoe = new Shoe("basketball", "black", "Nike", 12.5);
    System.out.println(shoe);
  }
}