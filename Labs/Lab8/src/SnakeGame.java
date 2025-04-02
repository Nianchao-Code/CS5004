import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * Main class for the Snake game application.
 */
public class SnakeGame {
  /**
   * Creates the game window, initializes the game panel, and displays the UI.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    JPanel panel = new MyPanel();
    panel.setPreferredSize(new Dimension(400, 400));
    frame.add(panel);
    frame.pack();
    frame.setVisible(true);
  }
}