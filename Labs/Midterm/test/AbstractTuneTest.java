import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// STUDENT TO TEST ALL METHODS IN AbstractTune
// TWO ASSERTIONS PER METHOD, THREE FOR COMPARISONS

class AbstractTuneTest {
  private static class TestTune extends AbstractTune {
    public TestTune(String title, Person artist, Genre genre, int tempo, String filePath) {
      super(title, artist, genre, tempo, filePath);
    }

    @Override
    public boolean playTune() {
      return false;
    }

    @Override
    public boolean equals(Tune other) {
      return false;
    }
  }

  private Person artist1;
  private Person artist2;
  private AbstractTune tune1;
  private AbstractTune tune2;
  private AbstractTune tune3;

  @BeforeEach
  void setUp() {
    artist1 = new Person("Michael", 1994);
    artist2 = new Person("Eris", 1997);
    tune1 = new TestTune("A Test Song", artist1, Genre.POP, 90, "/nianchao/music/test1.mp3");
    tune2 = new TestTune("B Test Song", artist2, Genre.ROCK, 80, "/nianchao/music/test2.mp3");
    tune3 = new TestTune("A Test Song", artist1, Genre.POP, 90, "/nianchao/music/test1.mp3");
  }

  // SOME EXAMPLES OF STUBBED OUT TESTS (ALL METHODS REQUIRE TESTING, NOT JUST
  // THE ONES SHOWN HERE)
  @Test
  void testConstructorValidInput() {
    assertEquals("A Test Song", tune1.getTitle());
    assertEquals(artist1, tune1.getArtist());
  }

  @Test
  void testConstructorNullTitle() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      new TestTune(null, artist1, Genre.JAZZ, 90, "/path/file.mp3");
    });
    assertTrue(exception.getMessage().contains("cannot be null"));
  }

  @Test
  void testConstructorNullArtist() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      new TestTune("Title", null, Genre.JAZZ, 90, "/path/file.mp3");
    });
    assertTrue(exception.getMessage().contains("cannot be null"));
  }

  @Test
  void testConstructorNullGenre() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      new TestTune("Title", artist1, null, 90, "/path/file.mp3");
    });
    assertTrue(exception.getMessage().contains("cannot be null"));
  }

  @Test
  void testConstructorNullFilePath() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      new TestTune("Title", artist1, Genre.JAZZ, 90, null);
    });
    assertTrue(exception.getMessage().contains("cannot be null"));
  }

  @Test
  void testConstructorNotPositiveTempo() {
    Exception exception1 = assertThrows(IllegalArgumentException.class, () -> {
      new TestTune("Title", artist1, Genre.JAZZ, -90, "/path/file.mp3");
    });
    assertTrue(exception1.getMessage().contains("tempo must stay positive"));

    Exception exception2 = assertThrows(IllegalArgumentException.class, () -> {
      new TestTune("Title", artist1, Genre.JAZZ, 0, "/path/file.mp3");
    });
    assertTrue(exception2.getMessage().contains("tempo must stay positive"));
  }

  @Test
  void testGetTitle() {
    assertEquals("A Test Song", tune1.getTitle());
    assertEquals("B Test Song", tune2.getTitle());
  }

  @Test
  void testGetArtist() {
    assertEquals(artist1, tune1.getArtist());
    assertEquals(artist2, tune2.getArtist());
  }

  @Test
  void testGetGenre() {
    assertEquals(Genre.POP, tune1.getGenre());
    assertEquals(Genre.ROCK, tune2.getGenre());
  }

  @Test
  void testGetTempo() {
    assertEquals(90, tune1.getTempo());
    assertEquals(80, tune2.getTempo());
  }

  @Test
  void testGetFilePath() {
    assertEquals("/nianchao/music/test1.mp3", tune1.getFilePath());
    assertEquals("/nianchao/music/test2.mp3", tune2.getFilePath());
  }

  @Test
  void testEquals() {
    assertFalse(tune2.equals(tune1));
    assertFalse(tune1.equals(tune2));
  }

  @Test
  void testHashCode() {
    assertEquals(tune1.hashCode(), tune3.hashCode());
    assertNotEquals(tune1.hashCode(), tune2.hashCode());
  }

  @Test
  void testToString() {
    String expected = "Tune{title='A Test Song', artist=" + artist1 +
        ", genre=" + Genre.POP + ", tempo=90, filePath='/nianchao/music/test1.mp3'}";
    assertEquals(expected, tune1.toString());
    assertTrue(tune1.toString().contains("A Test Song"));
  }

  @Test
  void testCompareTo_Equal() {
    assertEquals(0, tune1.compareTo(tune3));
    assertEquals(1, tune2.compareTo(tune1));
    assertEquals(-1, tune1.compareTo(tune2));
  }
}
