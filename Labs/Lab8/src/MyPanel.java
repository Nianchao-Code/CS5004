import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Main panel for the Snake game.
 */
public class MyPanel extends JPanel implements ActionListener, KeyListener {

  public MyPanel() {
    // make the panel focusable so that it can react to keyboard inputs
    this.setFocusable(true);

    // Load the image from the internet
    try {
      apple_image = ImageIO.read(new URL(
          "https://cdn-uploads.piazza.com/paste/k53ka6172ie4ll/10addac51ca9ba16a3cc46fcb64ca250e5fb15c58c78530c2096bf2e4b503b7b/apple.png"));
      snake_head_image = ImageIO.read(new URL(
          "https://cdn-uploads.piazza.com/paste/k53ka6172ie4ll/32956f1c46253cf2ebb9a9c6519df3116fe8c4ca7167444c1312168fbb96873c/head.png"));
      snake_body_image = ImageIO.read(new URL(
          "https://cdn-uploads.piazza.com/paste/k53ka6172ie4ll/08b035cfbd798f6bb0e0f7eb680979285a2df1d51f9066d53707a4a0f79f88ac/dot.png"));
    } catch (Exception e) {
      System.out.println("url doesn't work");
    }

    rnd = new Random();
    // Init the location of the apple
    apple_loc = new Coordinate(200, 200);
    // Init the location of the snake.
    // It starts with head only
    // The list head is the snake head.
    // Assume the radius of each dot is 10.
    snake_loc = new ArrayList<>();
    snake_loc.add(new Coordinate(50, 50));
    snake_loc.add(new Coordinate(50 + dot_size, 50));
    snake_loc.add(new Coordinate(50 + 2 * dot_size, 50));

    // Initialize with UP direction
    direction = Direction.UP;

    // set up the alarm, which fires periodically (16 ms == 60fps).
    // Every time it fires, we update the apple's location and repaint it.
    new Timer(200, this).start();

    // register self as the keyboard event listener.
    this.addKeyListener(this);
  }

  /**
   * Paints the game components on the panel.
   * Renders the apple, snake head, and snake body segments.
   *
   * @param g the Graphics object used for painting
   */
  @Override
  protected void paintComponent(Graphics g) {
    System.out.println("repainting");

    super.paintComponent(g);

    // paint the apple
    g.drawImage(apple_image, apple_loc.x, apple_loc.y, this);
    // paint the snake head
    g.drawImage(snake_head_image, snake_loc.get(0).x, snake_loc.get(0).y, this);
    // paint the snake body
    for (int i = 1; i < snake_loc.size(); i++) {
      g.drawImage(snake_body_image, snake_loc.get(i).x, snake_loc.get(i).y, this);
    }
  }

  /**
   * Handles timer events to update the game state.
   * Updates snake position, implements wrap-around behavior, and handles apple collision.
   *
   * @param e the ActionEvent object
   */
 @Override
  public void actionPerformed(ActionEvent e) {
    System.out.println("alarm fired");
    // We reach here every time the alarm fires.

    // We update the snake's location.
    // Make it look like the snake is moving forward
    // Trick: move the tail to become the new head,
    // and keep other nodes the same
    // 1. chop off the tail
    Coordinate old_tail = snake_loc.remove(snake_loc.size()-1);
    // TODO: what if size is 1
    // 2. get the loc of the old head
    int old_head_x = snake_loc.get(0).x;
    int old_head_y = snake_loc.get(0).y;
    // 3. add a new head. The loc of the new head
    // depends on the direction of movement
    int new_head_x = old_head_x;
    int new_head_y = old_head_y;
    if (direction == Direction.UP) {
      // up
      new_head_y -= dot_size;
    } else if (direction == Direction.DOWN) {
      // down
      new_head_y += dot_size;
    } else if (direction == Direction.LEFT) {
      // left
      new_head_x -= dot_size;
    } else if (direction == Direction.RIGHT) {
      // right
      new_head_x += dot_size;
    }

     // Implement wrap-around behavior
     int panel_width = this.getWidth();
     int panel_height = this.getHeight();

     if (new_head_y < 0) {
       new_head_y = panel_height - dot_size;
     }
     else if (new_head_y >= panel_height) {
       new_head_y = 0;
     }

     if (new_head_x < 0) {
       new_head_x = panel_width - dot_size;
     }
     else if (new_head_x >= panel_width) {
       new_head_x = 0;
     }

    snake_loc.add(0, new Coordinate(new_head_x, new_head_y));

    // check whether the head overlaps with the apple
    if (snake_loc.get(0).equals(apple_loc)) {
      // eating the apple.
      // Increase size by 1.
      // Added the removed tail back.
      snake_loc.add(old_tail);

      // also need to regenerate the apple's location
      regenApple();
    }

    // Call repaint, which further invokes `paintComponent`.
    repaint();
  }

  /**
   * Regenerates the apple at a random location within the panel.
   * The location is aligned to the dot_size grid.
   */
  private void regenApple() {
    // Random location within the panel.
    int new_x = rnd.nextInt(400);
    int new_y = rnd.nextInt(400);
    // Round the location to dot_size.
    apple_loc = new Coordinate((new_x / dot_size) * dot_size, (new_y / dot_size) * dot_size);
  }

  @Override
  public void keyTyped(KeyEvent e) {
    // do nothing
  }

  /**
   * Handles keyboard key press events.
   * Updates the snake's direction based on arrow key inputs.
   *
   * @param e the KeyEvent object
   */
  @Override
  public void keyPressed(KeyEvent e) {
    int keyCode = e.getKeyCode();
    if (keyCode == KeyEvent.VK_UP) {
      // up key is pressed
      //Use the Direction enum class instead of int
      direction = Direction.UP;
    } else if (keyCode == KeyEvent.VK_DOWN) {
      // down
      direction = Direction.DOWN;
    } else if (keyCode == KeyEvent.VK_LEFT) {
      // left
      direction = Direction.LEFT;
    } else if (keyCode == KeyEvent.VK_RIGHT) {
      // right
      direction = Direction.RIGHT;
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
    // do nothing
  }

  private Coordinate apple_loc;
  private Image apple_image;
  private Image snake_head_image;
  private Image snake_body_image;
  private int dot_size = 10;
  private Direction direction;
  private Random rnd;
  List<Coordinate> snake_loc;
}

/*
 * Approach for wrap-around behavior:
 *
 * 1. After calculating the new head position based on the current direction,
 *    check if the new position would be outside the game board boundaries.
 *
 * 2. If the snake moves off the top of the board (new_head_y < 0),
 *    it reappears at the bottom of the same column (new_head_y = panel_height - dot_size).
 *
 * 3. If the snake moves off the bottom (new_head_y >= panel_height),
 *    it reappears at the top of the same column (new_head_y = 0).
 *
 * 4. Similarly, if the snake moves off the left side (new_head_x < 0),
 *    it reappears on the right side in the same row (new_head_x = panel_width - dot_size).
 *
 * 5. And if it moves off the right side (new_head_x >= panel_width),
 *    it reappears on the left side in the same row (new_head_x = 0).
 *
 * The snake continues in the same direction after wrapping around, which maintains
 * the continuity of movement.
 */
