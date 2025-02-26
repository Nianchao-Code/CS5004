import java.util.Comparator;

/**
 * A comparator that compares Tunes based on their tempo. This provides an alternative
 * comparison strategy to the natural ordering (by title) defined in AbstractTune's compareTo
 * method.
 */
public class TempoComparator implements Comparator<Tune> {

  /**
   * Compares two Tunes based on their tempo in BPM (an integer)
   * <p></p>
   *
   * @param tune1 the first object to be compared.
   * @param tune2 the second object to be compared.
   * @return int according to Java conventions
   */
  @Override
  public int compare(Tune tune1, Tune tune2) {
    int tune1Tempo = tune1.getTempo();
    int tune2Tempo = tune2.getTempo();
    if (tune1Tempo < tune2Tempo) {
      return -1;
    } else if (tune1Tempo == tune2Tempo) {
      return 0;
    } else {
      return 1;
    }
  }
}
