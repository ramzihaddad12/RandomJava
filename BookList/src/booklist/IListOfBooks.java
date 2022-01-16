package booklist;

import bookutil.Book;

import java.util.function.Predicate;

/**
 * This interface represents all the operations to be supported by a list of
 * books.
 */
public interface IListOfBooks {
  /**
   * Return the number of books in this list.
   * 
   * @return the size of this list
   */
  int count();

  /**
   * Helper for the count method.
   * 
   * @param acc the accumulator
   * @return the count from here
   */
  int countHelp(int acc);

  /**
   * Return the total price of all books in this list.
   * 
   * @return the total price of all books
   */
  double totalPrice();

  /**
   * Return a list of all books within this list that are published before the
   * given year.
   * 
   * @param year the year before which all the returned books are published
   * @return the list of all books published before the given year
   */
  IListOfBooks allBefore(int year);

  /**
   * Return a sorted list of books in increasing order of price.
   * 
   * @return a sorted list of book
   */
  IListOfBooks sortByPrice();

  /**
   * Return a list obtained by adding the specified book.
   * 
   * @param book the book to add
   * @return the new list
   */
  IListOfBooks insert(Book book);

  /**
   * Create and return a string that can be used to print this list.
   * 
   * @return a string representing this list.
   */
  String toString();

  /**
   * General filter function on list of books.
   * 
   * @param test the predicate to be tested for filtering
   * @return a list of books that pass the provided test
   * @throws IllegalArgumentException if the parameter is null.
   */
  IListOfBooks getList(Predicate<Book> test);

}
