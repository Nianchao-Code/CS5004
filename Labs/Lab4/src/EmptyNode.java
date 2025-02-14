/**
 * Represents an empty node in a recursive list of books. This serves as the base case in the
 * recursive implementation of {@link IListOfBooks}.
 */
public class EmptyNode implements IListOfBooks {

  /**
   * Returns the number of books in the list. Since this is an empty node, the count is always 0.
   *
   * @return 0, as there are no books in an empty list.
   */
  @Override
  public int count() {
    return 0;
  }

  /**
   * Returns the total price of books in the list. Since this is an empty node, the total price is
   * always 0.0.
   *
   * @return 0.0f, as there are no books to sum.
   */
  @Override
  public float totalPrice() {
    return 0.0f;
  }

  /**
   * Returns a sublist containing books published before the given year. Since this is an empty
   * node, it simply returns itself.
   *
   * @param year the year before which all returned books were published.
   * @return an empty node, as no books exist.
   */
  @Override
  public IListOfBooks allBefore(int year) {
    return this;
  }

  /**
   * Returns a new list with the given book appended at the end. Since this is an empty node, the
   * new list will contain only this book.
   *
   * @param book the book to be added.
   * @return a new {@link ElementNode} containing the given book.
   */
  @Override
  public IListOfBooks addAtEnd(Book book) {
    return new ElementNode(book, this);
  }

  /**
   * Returns a string representation of the list. An empty node returns an empty string.
   *
   * @return an empty string, since there are no books.
   */
  @Override
  public String toString() {
    return "";
  }
}

