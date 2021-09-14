import static org.junit.Assert.assertEquals;

import cs5010.lab0.Book;
import cs5010.lab0.Person;
import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test class for the Book class.
 */

public class BookTest {

  private Book book;
  private Person author;

  /**
   * A setup method that runs before any test and creates the objects needed for the tests.
   */

  @Before
  public void setUp() {
    author = new Person("Stephen", "Hawking", 1942);
    book = new Book("A Brief History of Time", author, 7.99f);
  }

  /**
   * A method that tests the title of the book.
   */

  @Test
  public void testTitle() {
    assertEquals("A Brief History of Time", book.getTitle());
  }

  /**
   * A method that tests the author of the book.
   */

  @Test
  public void testAuthor() {
    assertEquals(author.getFirstName(), book.getAuthor().getFirstName());
    assertEquals(author.getLastName(), book.getAuthor().getLastName());
    assertEquals(author.getYearOfBirth(), book.getAuthor().getYearOfBirth());
  }

  /**
   * A method that tests the price of the book.
   */

  @Test
  public void testPrice() {
    assertEquals(7.99f, book.getPrice(), 0.00);
  }
}