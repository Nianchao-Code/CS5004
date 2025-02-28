import java.util.Objects;

/**
 * This class represents a person with a first name, last name and a year of birth
 */
public class Person {

  private String firstName;
  private String lastName;
  private int yearOfBirth;

  /**
   * Constructs a Person object and initializes it to the given first name, last name and year of
   * birth
   *
   * @param firstName   the first name of this person
   * @param lastName    the last name of this person
   * @param yearOfBirth the year of birth of this person
   */
  public Person(String firstName, String lastName, int yearOfBirth) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.yearOfBirth = yearOfBirth;
  }

  /**
   * Get the first name of this person
   *
   * @return the first name of this person
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Return the last name of this person
   *
   * @return the last name of this person
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * Return the year of birth of this person
   *
   * @return the year of birth of this person
   */
  public int getYearOfBirth() {
    return this.yearOfBirth;
  }

  /**
   * Return the full name of this person
   *
   * @return the full name of this person
   */
  public String getFullName() {
    return this.firstName + " " + this.lastName;
  }

  /**
   * Determines whether this person is equal to another object. Two people are considered equal if
   * they have the same first name, last name, and year of birth.
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
    Person person = (Person) other;
    return yearOfBirth == person.yearOfBirth &&
        Objects.equals(firstName, person.firstName) &&
        Objects.equals(lastName, person.lastName);
  }

  /**
   * Returns a hash code value for the person.
   *
   * @return a hash code value for this person
   */
  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, yearOfBirth);
  }
}