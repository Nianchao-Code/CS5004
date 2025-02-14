/**
 * Represents an element node in a recursive list of books. Each node contains a {@link Book} and a
 * reference to the rest of the list.
 */
public class ElementNode implements IListOfBooks {

  private Book book;
  private IListOfBooks rest;

  /**
   * Constructs an {@code ElementNode} with the given book and the rest of the list.
   *
   * @param book the book contained in this node.
   * @param rest the rest of the list.
   */
  public ElementNode(Book book, IListOfBooks rest) {
    this.book = book;
    this.rest = rest;
  }

  /**
   * Returns the number of books in the list. This includes the current book and the count from the
   * rest of the list.
   *
   * @return the total number of books in the list.
   */
  @Override
  public int count() {
    return 1 + rest.count();
  }

  /**
   * Returns the total price of all books in the list. This includes the price of the current book
   * and the total price of the rest.
   *
   * @return the sum of prices of all books in the list.
   */
  @Override
  public float totalPrice() {
    return book.getPrice() + rest.totalPrice();
  }

  /**
   * Returns a sublist containing only the books published before the given year.
   *
   * @param year the year before which all returned books were published.
   * @return a new {@link IListOfBooks} containing only books published before the given year.
   */
  @Override
  public IListOfBooks allBefore(int year) {
    if (book.getYear() < year) {
      return new ElementNode(book, rest.allBefore(year));
    } else {
      return rest.allBefore(year);
    }
  }

  /**
   * Returns a new list with the given book appended at the end.
   *
   * @param book the book to be added.
   * @return a new {@link IListOfBooks} with the given book added at the end.
   */
  @Override
  public IListOfBooks addAtEnd(Book book) {
    return new ElementNode(this.book, rest.addAtEnd(book));
  }

  /**
   * Returns a string representation of the list, where each book appears on a new line.
   *
   * @return a formatted string listing all books in the list.
   */
  @Override
  public String toString() {
    String restString = this.rest.toString();
    if (restString.isEmpty()) {
      return this.book.toString();
    }
    return this.book.toString() + "\n" + restString;
  }
}


