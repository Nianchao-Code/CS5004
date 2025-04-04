package model;

/**
 * Interface for the Tic Tac Toe game model.
 */
public interface TTTModel {

  /**
   * Initializes or resets the game board to its starting state.
   */
  void initializeGame();

  /**
   * Places the current player's mark at the specified position.
   *
   * @throws IndexOutOfBoundsException if position is outside board boundaries
   * @throws IllegalStateException if position is occupied or game is over
   * <p>
   * // Row-column order is more common in 2D arrays than column-row.
   * // ***TTT Developers***: Using IndexOutOfBoundsException matches Java practices.
   */
  void move(int row, int col) throws IndexOutOfBoundsException, IllegalStateException;

  /**
   * Returns the mark at the specified position.
   *
   * @return Player at position, or null if empty
   * @throws IndexOutOfBoundsException if position is outside board boundaries
   * <p>
   * // Null for empty cells.
   * // ***TTT Developers***: Handle nulls consistently to avoid NullPointerExceptions.
   */
  Player getMarkAt(int row, int col) throws IndexOutOfBoundsException;

  /**
   * Returns the player whose turn is next.
   *
   * @throws IllegalStateException if game is over
   * <p>
   * // Using Player enum is type-safe.
   * // ***TTT Developers***: Named nextPlayer() to match assignment requirements.
   */
  Player nextPlayer() throws IllegalStateException;

  /**
   * Checks if the game is over.
   */
  boolean isGameOver();

  /**
   * Returns the winner of the game.
   *
   * @return winner Player, or null if game is a tie
   * @throws IllegalStateException if game isn't over
   * <p>
   * // Null specifically means a tie game, not an in-progress game.
   * // ***TTT Developers***: Always check isGameOver() first.
   */
  Player getWinner() throws IllegalStateException;

  /**
   * Checks if the game has ended in a draw.
   * <p>
   * // Convenience method to avoid checking both isGameOver() and getWinner() == null.
   */
  boolean isDraw();

  /**
   * Returns the number of rows in the game board.
   * <p>
   * // Supports potential variants beyond standard 3x3.
   */
  int getRows();

  /**
   * Returns the number of columns in the game board.
   */
  int getColumns();

  /**
   * Returns a copy of the game grid.
   * <p>
   * // Defensive copy prevents external modification of model state.
   * // ***TTT Developers***: Changes to returned array won't affect model.
   */
  Player[][] getGrid();

  /**
   * Checks if the specified position is empty.
   *
   * @throws IndexOutOfBoundsException if position is outside board boundaries
   */
  boolean isCellEmpty(int row, int col) throws IndexOutOfBoundsException;
}