import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

/**
 * Unit tests for the MyQueue class using JUnit 5.
 * Tests are performed with String and Book data types to ensure
 * the generic implementation works correctly with different reference types.
 */
class MyQueueTest {
  private MyQueue<String> stringQueue;
  private MyQueue<Book> bookQueue;

  // Sample Book objects for testing
  private Book book1;
  private Book book2;

  /**
   * Sets up the test environment before each test method.
   * Initializes empty queues and sample Book objects for testing.
   */
  @BeforeEach
  void setUp() {
    stringQueue = new MyQueue<>();
    bookQueue = new MyQueue<>();

    // Initialize sample Book objects
    book1 = new Book("Test1", "Author1", 1995, 12.99f);
    book2 = new Book("Test2", "Author2", 1990, 14.95f);
  }

  /**
   * Tests the enqueue method with different data types.
   */
  @Test
  void enqueue() {
    // Test with String type (Assertion1)
    stringQueue.enqueue("HelloWorld");
    assertFalse(stringQueue.isEmpty());

    // Test with Book type (Assertion2)
    bookQueue.enqueue(book1);
    assertEquals(book1, bookQueue.peek());
  }

  /**
   * Tests the dequeue method with different data types.
   */
  @Test
  void dequeue() {
    // Test with String type (Assertion1)
    stringQueue.enqueue("1");
    stringQueue.enqueue("2");
    assertEquals("1", stringQueue.dequeue());

    // Test with Book type (Assertion2)
    bookQueue.enqueue(book1);
    bookQueue.enqueue(book2);
    assertEquals(book1, bookQueue.dequeue());

    // Verify queue becomes empty after all elements are dequeued
    stringQueue.dequeue();
    assertTrue(stringQueue.isEmpty());
  }

  /**
   * Tests that the dequeue method throws NoSuchElementException when called on an empty queue.
   */
  @Test
  void dequeueEmpty() {
    // Test that dequeue throws NoSuchElementException on empty string queue (Assertion1)
    assertThrows(NoSuchElementException.class, () -> {
      stringQueue.dequeue();
    });

    // Test that dequeue throws NoSuchElementException on empty book queue (Assertion2)
    assertThrows(NoSuchElementException.class, () -> {
      bookQueue.dequeue();
    });
  }

  /**
   * Tests the peek method with different data types.
   */
  @Test
  void peek() {
    // Test with String type (Assertion1)
    stringQueue.enqueue("1");
    stringQueue.enqueue("2");
    assertEquals("1", stringQueue.peek());

    // Test with Book type (Assertion2)
    bookQueue.enqueue(book1);
    assertEquals(book1, bookQueue.peek());
  }

  /**
   * Tests that the peek method throws NoSuchElementException when called on an empty queue.
   */
  @Test
  void peekEmpty() {
    // Test that peek throws NoSuchElementException on empty string queue (Assertion1)
    assertThrows(NoSuchElementException.class, () -> {
      stringQueue.peek();
    });

    // Test that peek throws NoSuchElementException on empty book queue (Assertion2)
    assertThrows(NoSuchElementException.class, () -> {
      bookQueue.peek();
    });
  }

  /**
   * Tests the isEmpty method with different queue states.
   */
  @Test
  void isEmpty() {
    // Assertion 1: New queue should be empty
    assertTrue(stringQueue.isEmpty());

    // Add elements and test non-emptiness
    stringQueue.enqueue("Test");
    assertFalse(stringQueue.isEmpty());

    // Assertion 2: Book queue should be empty initially and non-empty after enqueue
    assertTrue(bookQueue.isEmpty());
    bookQueue.enqueue(book1);
    assertFalse(bookQueue.isEmpty());
  }

  /**
   * Tests the toString method with different queue states and data types.
   */
  @Test
  void testToString() {
    // Empty queue (Assertion1)
    assertEquals("Queue: ", stringQueue.toString());

    // Queue with elements (Assertion2)
    stringQueue.enqueue("A");
    stringQueue.enqueue("B");
    assertEquals("Queue: A B", stringQueue.toString());

    // Test toString with Book objects (Assertion3)
    bookQueue.enqueue(book1);
    String expected = "Queue: " + book1.toString();
    assertEquals(expected, bookQueue.toString());
  }

  /**
   * Tests the equals method to verify proper equality comparison.
   */
  @Test
  void testEquals() {
    MyQueue<String> queue1 = new MyQueue<>();
    MyQueue<String> queue2 = new MyQueue<>();

    // Assertion 1: Empty queues should be equal
    assertEquals(queue1, queue2);

    // Add same elements to both queues
    queue1.enqueue("X");
    queue2.enqueue("X");
    assertEquals(queue1, queue2);

    // Assertion 2: Test with Book queues
    MyQueue<Book> bookQueue1 = new MyQueue<>();
    MyQueue<Book> bookQueue2 = new MyQueue<>();

    bookQueue1.enqueue(book1);
    bookQueue2.enqueue(book1);
    assertEquals(bookQueue1, bookQueue2);

    // Add different element to one queue
    queue1.enqueue("Z");
    assertNotEquals(queue1, queue2);
  }

  /**
   * Tests the hashCode method to verify consistent hashing.
   */
  @Test
  void testHashCode() {
    MyQueue<String> queue1 = new MyQueue<>();
    MyQueue<String> queue2 = new MyQueue<>();

    // Empty queues should have same hashCode (Assertion1)
    assertEquals(queue1.hashCode(), queue2.hashCode());

    // Add same elements to both queues
    queue1.enqueue("HelloWorld");
    queue2.enqueue("HelloWorld");
    assertEquals(queue1.hashCode(), queue2.hashCode());

    // Test hashCode with Book queues (Assertion2)
    MyQueue<Book> bookQueue1 = new MyQueue<>();
    MyQueue<Book> bookQueue2 = new MyQueue<>();

    bookQueue1.enqueue(book1);
    bookQueue2.enqueue(book1);
    assertEquals(bookQueue1.hashCode(), bookQueue2.hashCode());
  }
}