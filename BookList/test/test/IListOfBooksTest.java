package test;

import static org.junit.Assert.assertEquals;

import booklist.ElementNode;
import booklist.EmptyNode;
import booklist.IListOfBooks;
import bookutil.Book;
import org.junit.Before;
import org.junit.Test;

import java.util.function.Predicate;

/**
 * Class that tests the book list.
 */
public class IListOfBooksTest {

  private IListOfBooks listOfBooks;
  private IListOfBooks partialListOfBooks;
  private IListOfBooks emptyListOfBooks;

  /** Setting up the list of books for each of the tests. */
  @Before
  public void setup() {
    emptyListOfBooks = new EmptyNode();

    partialListOfBooks = new ElementNode(
        new Book("HP 1", "J.K. Rowling", 1997, 19.99f),
        new ElementNode(new Book("HP 2", "J.K. Rowling", 1999, 29.99f),
            new ElementNode(new Book("HP 3", "J.K. Rowling", 2001, 10.99f),
                new EmptyNode())));

    listOfBooks = new ElementNode(
        new Book("HP 4", "J.K. Rowling", 2004, 15.49f),
        new ElementNode(new Book("HP 5", "J.K. Rowling", 2006, 12.99f),
            new ElementNode(new Book("HP 6", "J.K. Rowling", 2007, 7.99f),
                partialListOfBooks)));

  }

  /** Testing count(). */
  @Test
  public void testCounts() {
    assertEquals(0, emptyListOfBooks.count());
    assertEquals(3, partialListOfBooks.count());
    assertEquals(6, listOfBooks.count());
  }

  /** Testing toString(). */
  @Test
  public void testToString() {
    String expected = "(Title: HP 4 Author: J.K. Rowling Year: 2004 Price: "
        + "15.49)" + "(Title: HP 5 Author: J.K. Rowling Year: 2006 "
        + "Price: 12.99)"
        + "(Title: HP 6 Author: J.K. Rowling Year: 2007 Price: 7.99)"
        + "(Title: HP 1 Author: J.K. Rowling Year: 1997 Price: 19.99)"
        + "(Title: HP 2 Author: J.K. Rowling Year: 1999 Price: 29.99)"
        + "(Title: HP 3 Author: J.K. Rowling Year: 2001 Price: 10.99)";
    assertEquals(expected, listOfBooks.toString());
  }

  /** Testing totalPrice(). */
  @Test
  public void testTotalPrice() {
    assertEquals(0, emptyListOfBooks.totalPrice(), 0.001);
    assertEquals(60.97, partialListOfBooks.totalPrice(), 0.001);
    assertEquals(97.44, listOfBooks.totalPrice(), 0.001);
  }

  /** Testing allBefore(). */
  @Test
  public void testAllBefore() {
    IListOfBooks lastCentury = listOfBooks.allBefore(2000);
    String expected = "(Title: HP 1 Author: J.K. Rowling Year: 1997 Price: 19.99)"
        + "(Title: HP 2 Author: J.K. Rowling Year: 1999 Price: 29.99)";
    assertEquals(expected, lastCentury.toString());
  }

  /** Testing sortByPrice(). */
  @Test
  public void testSortByPrice() {
    IListOfBooks sortedByPrice = listOfBooks.sortByPrice();
    String expected = "(Title: HP 6 Author: J.K. Rowling Year: 2007 Price: 7.99)"
        + "(Title: HP 3 Author: J.K. Rowling Year: 2001 Price: 10.99)"
        + "(Title: HP 5 Author: J.K. Rowling Year: 2006 Price: 12.99)"
        + "(Title: HP 4 Author: J.K. Rowling Year: 2004 Price: 15.49)"
        + "(Title: HP 1 Author: J.K. Rowling Year: 1997 Price: 19.99)"
        + "(Title: HP 2 Author: J.K. Rowling Year: 1999 Price: 29.99)";
    assertEquals(expected, sortedByPrice.toString());
  }

  /** Testing using predicate class to get list of book published before a specific date. */
  @Test
  public void testAllBeforeWithPredicateClass() {

    IListOfBooks lastCentury = listOfBooks.getList(new BookBefore(2000));
    String expected = "(Title: HP 1 Author: J.K. Rowling Year: 1997 Price: 19.99)"
        + "(Title: HP 2 Author: J.K. Rowling Year: 1999 Price: 29.99)";
    assertEquals(expected, lastCentury.toString());
  }

  /** Testing using anonymous predicate to get list of books published before a specific date. */
  @Test
  public void testAllBeforeWithAnonymousPredicate() {
    int year = 2000;
    IListOfBooks lastCentury = listOfBooks.getList(new Predicate<Book>() {
      public boolean test(Book b) {
        return b.getYear() < year;
      }
    });
    String expected = "(Title: HP 1 Author: J.K. Rowling Year: 1997 Price: 19.99)"
        + "(Title: HP 2 Author: J.K. Rowling Year: 1999 Price: 29.99)";
    assertEquals(expected, lastCentury.toString());
  }

  /** Testing using lambda predicate to get list of books published before a specific date. */
  @Test
  public void testAllBeforeWithLambdaPredicate() {
    int year = 2000;
    IListOfBooks lastCentury = listOfBooks
        .getList((Book b) -> b.getYear() < year);
    String expected = "(Title: HP 1 Author: J.K. Rowling Year: 1997 Price: 19.99)"
        + "(Title: HP 2 Author: J.K. Rowling Year: 1999 Price: 29.99)";
    assertEquals(expected, lastCentury.toString());
  }

  /**
   * Predicate class for determining if books were published before a particular
   * year.
   */
  private class BookBefore implements Predicate<Book> {
    private int year;

    /**
     * Constructor.
     * 
     * @param year the year
     */
    public BookBefore(int year) {
      this.year = year;
    }

    @Test
    public boolean test(Book b) {
      return b.getYear() < year;
    }
  }
}