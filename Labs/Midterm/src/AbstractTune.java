import java.util.Objects;

/**
 * Abstract Tune class helps implement the Tune interface
 * <p></p>
 * This class offers an implementation of the Tune interface with functions of all types of tune See
 * AbstractTuneTest as well
 */

// Bug1: should be implements Tune, Comparable, not extends
// public abstract class AbstractTune extends Tune, Comparable<Tune> {
public abstract class AbstractTune implements Tune, Comparable<Tune> {

  private String title;
  private Person artist;
  private Genre genre;
  private int tempo;
  private String filePath;

  /**
   * Constructs a new AbstractTune with the specified attributes (title, artist, genre, tempo,
   * filePath) Throw exceptions if any parameter is null or tempo is not positive
   *
   * @param title    the title of the tune
   * @param artist   the artist of the tune
   * @param genre    the genre of the tune
   * @param tempo    the tempo of the tune
   * @param filePath the file path where the tune is stored
   * @throws IllegalArgumentException if any parameter is null or if tempo is not positive
   */
  public AbstractTune(String title, Person artist, Genre genre, int tempo, String filePath)
  // Bug2: The constructor doesn't check for null parameters or validate that tempo is positive.
      throws IllegalArgumentException {
    if (title == null || artist == null || genre == null || filePath == null) {
      throw new IllegalArgumentException("The Arguments cannot be null!");
    }
    if (tempo <= 0) {
      throw new IllegalArgumentException("The tempo must stay positive!");
    }
    this.title = title;
    this.artist = artist;
    this.genre = genre;
    this.tempo = tempo;
    // Bug3: lack this.filepath = filePath;
    this.filePath = filePath;
  }

  /**
   * Returns the title of this tune
   *
   * @return the title as a String
   */
  //Bug4: lack an override for the getTitle method
  @Override
  public String getTitle() {
    return title;
  }

  /**
   * Returns the artist of this tune
   *
   * @return the Person object representing the artist
   */
  @Override
  public Person getArtist() {
    return artist;
  }

  /**
   * Returns the genre of this tune
   *
   * @return the Genre enum value
   */
  @Override
  public Genre getGenre() {
    return genre;
  }

  /**
   * Returns the tempo of this tune in beats per minute
   *
   * @return the tempo as an integer
   */
  @Override
  public int getTempo() {
    return tempo;
  }

  /**
   * Returns the file path where this tune is stored
   *
   * @return the file path as a String
   */
  @Override
  public String getFilePath() {
    return filePath;
  }

  /*
   There is one required method that is NOT to be implemented here:
   the method for playing a tune from a file. That is left to each concrete
   class that extends AbstractTune, based on the type of file that
   contains the music. See the two concrete classes for details.
  */

  /**
   * Overriding equals for Tunes to examine all attributes
   *
   * @param obj the object to compare with this tune
   * @return true if the objects are equal, false otherwise
   */
  // Bug5: The parameter should be Object, so it properly overrides Object.equals().
//  public boolean equals(Tune other) {
  @Override
  // Bug6: Method does not override method from its superclass, should pull equals to tune
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Tune)) {
      return false;
    }
    Tune other = (Tune) obj;
    return this.tempo == other.getTempo() &&
        this.title.equals(other.getTitle()) &&
        this.artist.equals(other.getArtist()) &&
        this.genre == other.getGenre() &&
        this.filePath.equals(other.getFilePath());
  }

  /**
   * Overriding hashCode for Tunes to match equals
   *
   * @return a hash code value for this tune
   */
  @Override
  public int hashCode() {
    return Objects.hash(title, artist, genre, tempo, filePath);
  }

  /**
   * Overriding toString for Tunes to include all attributes
   *
   * @return a string representation of this tune
   */
  @Override
  public String toString() {
    return "Tune{title='" + title + "', artist=" + artist +
        ", genre=" + genre + ", tempo=" + tempo +
        ", filePath='" + filePath + "'}";
  }

  /**
   * Comparable Interface for comparing based on Title
   * <p></p>
   *
   * @param other -- a Tune
   * @return negative, 0, or positive int based on Title Comparison should ignore case (so A equals
   * a)
   */
  @Override
  public int compareTo(Tune other) {
    return this.title.compareToIgnoreCase(other.getTitle());
  }
}