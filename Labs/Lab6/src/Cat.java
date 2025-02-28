import java.util.Objects;

/**
 * Represents a Cat with unique attributes. This class provides functionality to manage and compare
 * cat instances.
 */
public class Cat {

  private final String name;
  private int age;
  private final color color;
  private Person owner;

  /**
   * Constructs a new Cat instance with the specified attributes.
   *
   * @param name  the name of the cat
   * @param age   the age of the cat in years
   * @param color the color of the cat
   * @param owner the person who owns the cat
   */
  public Cat(String name, int age, color color, Person owner) {
    this.name = name;
    this.age = age;
    this.color = color;
    this.owner = owner;
  }

  /**
   * Returns the name of the cat.
   *
   * @return the cat's name
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the age of the cat in years.
   *
   * @return the cat's age
   */
  public int getAge() {
    return age;
  }

  /**
   * Sets the cat's age to a new value.
   *
   * @param age the new age of the cat
   */
  public void setAge(int age) {
    this.age = age;
  }

  /**
   * Returns the color of the cat.
   *
   * @return the cat's color
   */
  public color getColor() {
    return color;
  }

  /**
   * Returns the person who owns the cat.
   *
   * @return the cat's owner
   */
  public Person getOwner() {
    return owner;
  }

  /**
   * Sets the cat's owner to a new person.
   *
   * @param owner the new owner of the cat
   */
  public void setOwner(Person owner) {
    this.owner = owner;
  }

  /**
   * Returns a string representation of the cat.
   *
   * @return a string containing the cat's name, age, color, and owner
   */
  @Override
  public String toString() {
    return "Cat{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", color=" + color +
        ", owner=" + owner.getFullName() +
        '}';
  }

  /**
   * Determines whether this cat is equal to another object. Two cats are considered equal if they
   * have the same name, age, color, and owner.
   *
   * @param other the object to compare with
   * @return true if the objects are equal, false otherwise
   */
  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    Cat cat = (Cat) other;
    return age == cat.age &&
        Objects.equals(name, cat.name) &&
        Objects.equals(color, cat.color) &&
        Objects.equals(owner, cat.owner);
  }

  /**
   * Returns a hash code value for the cat.
   *
   * @return a hash code value for this cat
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, age, color, owner);
  }
}
