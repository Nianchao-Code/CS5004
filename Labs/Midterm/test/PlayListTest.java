
// STUDENTS TO COMPLETE ONLY PORTIONS OF THIS FILE:
// setUp, as needed; sortByTitle; and sortByTempo.
// The other methds needing tests may be skipped for this midterm.

// PROVIDE TWO ASSERTIONS PER METHOD (THREE FOR COMPARISON TESTS).

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class PlayListTest {

  private PlayList playList;
  private Tune tune1, tune2, tune3;
  private Person artist1, artist2;

  private static class TestTune implements Tune, Comparable<Tune> {

    private String title;
    private Person artist;
    private Genre genre;
    private int tempo;
    private String filePath;

    public TestTune(String title, Person artist, Genre genre, int tempo, String filePath) {
      this.title = title;
      this.artist = artist;
      this.genre = genre;
      this.tempo = tempo;
      this.filePath = filePath;
    }

    @Override
    public String getTitle() {
      return title;
    }

    @Override
    public Person getArtist() {
      return artist;
    }

    @Override
    public Genre getGenre() {
      return genre;
    }

    @Override
    public int getTempo() {
      return tempo;
    }

    @Override
    public String getFilePath() {
      return filePath;
    }

    @Override
    public boolean playTune() {
      return false;
    }

    @Override
    public boolean equals(Tune other) {
      return false;
    }


    @Override
    public int compareTo(Tune other) {
      return this.title.compareToIgnoreCase(other.getTitle());
    }
  }

  @BeforeEach
  void setUp() {
    playList = new PlayList();
    artist1 = new Person("Michael", 1994);
    artist2 = new Person("Eris", 1997);
    tune1 = new TestTune("B Test Song", artist1, Genre.POP, 100, "/nianchao/music/test1.mp3");
    tune2 = new TestTune("A Test Song", artist2, Genre.ROCK, 90, "/nianchao/music/test2.mp3");
    tune3 = new TestTune("C Test Song", artist1, Genre.POP, 110, "/nianchao/music/test1.mp3");

    playList.addTune(tune1);  // Title: "B Test Song", Tempo: 100
    playList.addTune(tune2);  // Title: "A Test Song", Tempo: 90
    playList.addTune(tune3);  // Title: "C Test Song", Tempo: 110
  }

  @Test
  void addItem() {
  }

  @Test
  void getItem() {
  }

  @Test
  void remove() {
  }

  @Test
  void size() {
  }

  @Test
  void sortByTitle() {
    playList.sortByTitle();
    // correct order: A, B, C
    assertEquals(tune2, playList.getTune(0), "A Test Song should be first.");
    assertEquals(tune1, playList.getTune(1), "B Test Song should be second.");
    assertEquals(tune3, playList.getTune(2), "C Test Song should be third.");
  }

  @Test
  void sortByTempo() {
    playList.sortByTempo();
    // correct order: 90, 100, 110
    assertEquals(tune2, playList.getTune(0), "A Test Song should be first.");
    assertEquals(tune1, playList.getTune(1), "B Test Song should be second.");
    assertEquals(tune3, playList.getTune(2), "C Test Song should be third.");
  }

  @Test
  void testToString() {
  }
}
