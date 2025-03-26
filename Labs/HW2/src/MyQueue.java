import java.util.ArrayList;
import java.util.NoSuchElementException;

// Question A: Frequent dequeue operations in an arrayList-based queue cause performance degradation
// because each dequeue operation requires shifting all remaining elements in the array,
// resulting in O(n) time complexity rather than the O(1) expected from an efficient queue implementation.

// Question B: We could use a LinkedList as the underlying data structure
// to achieve O(1) time complexity for dequeue operations.

/**
 * A generic queue implementation using ArrayList as the underlying data structure.
 * This queue follows the FIFO (First In, First Out) principle where elements
 * are added to the tail and removed from the head of the queue.
 *
 * @param <T> the type of elements stored in this queue
 */
public class MyQueue<T> {
  private ArrayList<T> elements;

  /**
   * Constructs an empty queue.
   */
  public MyQueue() {
    elements = new ArrayList<>();
  }

  /**
   * Adds an element to the tail of the queue.
   *
   * @param e the element to be added
   */
  public void enqueue(T e) {
    elements.add(e);
  }

  /**
   * Removes and returns the head element of the queue.
   *
   * @return the head element of the queue
   * @throws NoSuchElementException if the queue is empty
   */
  public T dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException("Cannot dequeue from an empty queue");
    }
    return elements.remove(0);
  }

  /**
   * Returns the head element of the queue without removing it.
   *
   * @return the head element of the queue
   * @throws NoSuchElementException if the queue is empty
   */
  public T peek() {
    if (isEmpty()) {
      throw new NoSuchElementException("Cannot peek an empty queue");
    }
    return elements.get(0);
  }

  /**
   * Checks if the queue is empty.
   *
   * @return true if the queue is empty, false otherwise
   */
  public boolean isEmpty() {
    return elements.isEmpty();
  }

  /**
   * Returns a string representation of the queue.
   *
   * @return a string with format "Queue: " followed by each element's toString,
   *         separated by a single space
   */
  @Override
  public String toString() {
    return "Queue: " + String.join(" ", elements.stream()
        .map(Object::toString)
        .toList());
  }

  /**
   * Compares this queue with the specified object for equality.
   *
   * @param other the object to compare with
   * @return true if the objects are equal, false otherwise
   */
  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null || getClass() != other.getClass()){
      return false;
    }
    MyQueue<?> o = (MyQueue<?>) other;
    return elements.equals(o.elements);
  }

  /**
   * Returns the hash code value for this queue.
   *
   * @return the hash code value for this queue
   */
  @Override
  public int hashCode() {
    return elements.hashCode();
  }
}