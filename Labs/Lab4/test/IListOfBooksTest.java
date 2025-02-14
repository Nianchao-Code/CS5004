/**
 * This class tests both EmptyNode and ElementNode implementations of IListOfBooks interface. It
 * verifies all methods (count, totalPrice, allBefore, addAtEnd, toString) for both empty and
 * non-empty list scenarios.
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IListOfBooksTest {

  private Book book1;
  private Book book2;
  private IListOfBooks emptyList;
  private IListOfBooks oneBookList;
  private IListOfBooks twoBookList;

  /**
   * Sets up test data with sample books and list configurations.
   */
  @BeforeEach
  void setUp() {
    book1 = new Book("Molecular Biology of the Cell", "Bruce Alberts", 2008, 85.50f);
    book2 = new Book("Essential Cell Biology", "Bruce Alberts", 2013, 75.99f);

    emptyList = new EmptyNode();
    oneBookList = new ElementNode(book1, emptyList);
    twoBookList = new ElementNode(book1, new ElementNode(book2, emptyList));
  }

  /**
   * Tests the count method for EmptyNode.
   */
  @Test
  void testEmptyNodeCount() {
    assertEquals(0, emptyList.count(), "Empty list has 0 books");
    IListOfBooks newEmpty = new EmptyNode();
    assertEquals(emptyList.count(), newEmpty.count(), "Different empty lists have same count");
  }

  /**
   * Tests the totalPrice method for EmptyNode.
   */
  @Test
  void testEmptyNodeTotalPrice() {
    assertEquals(0.0f, emptyList.totalPrice(), "Empty list has 0 total price");
    IListOfBooks newEmpty = new EmptyNode();
    assertEquals(emptyList.totalPrice(), newEmpty.totalPrice(),
        "Different empty lists have same price");
  }

  /**
   * Tests the allBefore method to filter books published before a given year (for EmptyNode).
   */
  @Test
  void testEmptyNodeAllBefore() {
    assertEquals(0, emptyList.allBefore(1999).count(),
        "Empty list contains no books before given year");
    assertEquals(0, emptyList.allBefore(2000).count(),
        "Empty list contains no books before given year");
  }

  /**
   * Tests the addAtEnd method by adding a book to an empty list.
   */
  @Test
  void testEmptyNodeAddAtEnd() {
    assertEquals(1, emptyList.addAtEnd(book1).count(),
        "Adding book to empty list creates list of size 1");
    assertEquals(book1.getPrice(), emptyList.addAtEnd(book1).totalPrice(),
        "Adding book to empty list sets correct total price");
  }

  /**
   * Tests the toString method for EmptyNode.
   */
  @Test
  void testEmptyNodeToString() {
    assertEquals("", emptyList.toString(), "Empty list toString is empty");
    assertEquals(emptyList.toString(), new EmptyNode().toString(),
        "Different empty lists have same toString");
  }

  /**
   * Tests the count method for ElementNode.
   */
  @Test
  void testElementNodeCount() {
    assertEquals(1, oneBookList.count(), "One book list has count of 1");
    assertEquals(2, twoBookList.count(), "Two book list has count of 2");
  }

  /**
   * Tests the totalPrice method for ElementNode.
   */
  @Test
  void testElementNodeTotalPrice() {
    assertEquals(85.50f, oneBookList.totalPrice(), "One book list has correct price");
    float expected_totalPrice = book1.getPrice() + book2.getPrice();
    assertEquals(expected_totalPrice, twoBookList.totalPrice(), 0.01f,
        "Two book list has correct total price");
  }

  /**
   * Tests the allBefore method for filtering books published before a given year (for ElementNode).
   */
  @Test
  void testElementNodeAllBefore() {
    assertEquals(2, twoBookList.allBefore(2020).count(), "All books before 2020 included");
    assertEquals(1, twoBookList.allBefore(2013).count(), "Only one book before 2013");
  }

  /**
   * Tests the addAtEnd method for ElementNode.
   */
  @Test
  void testElementNodeAddAtEnd() {
    assertEquals(2, oneBookList.addAtEnd(book2).count(), "Adding book increases count by 1");
    assertEquals(1, emptyList.addAtEnd(book1).count(), "Adding first book creates list of size 1");
  }

  /**
   * Tests the toString method for ElementNode.
   */
  @Test
  void testElementNodeToString() {
    assertEquals(
        "Title: Molecular Biology of the Cell Author: Bruce Alberts Year: 2008 Price: 85.50",
        oneBookList.toString(), "String includes book details");
    assertTrue(twoBookList.toString().contains(book1.getAuthor()) && twoBookList.toString()
        .contains(book2.getAuthor()), "String contains both authors");
  }
}

