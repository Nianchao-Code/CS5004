package model;

/**
 * Represents a player in the Tic Tac Toe game.
 * <p>
 * // Enum provides type safety, semantic clarity, and enhanced functionality.
 * // ***TTT Developers***: More maintainable if player types need expansion.
 */
public enum Player {
  /**
   * Player X (first player)
   */
  X,

  /**
   * Player O (second player)
   */
  O;

  /**
   * Returns the other player.
   * <p>
   * // Simple toggling between players.
   */
  public Player getOpponent() {
    return this == X ? O : X;
  }

  /**
   * Returns string representation of the player.
   */
  @Override
  public String toString() {
    return name();
  }
}