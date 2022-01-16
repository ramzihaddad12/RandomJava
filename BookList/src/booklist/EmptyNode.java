package booklist;

import bookutil.Book;

import java.util.function.Predicate;

/**
 * This represents an empty node in the list.
 */
public class EmptyNode implements IListOfBooks {

  @Override
  public int count() {
    return 0;
  }

  @Override
  public int countHelp(int acc) {
    return acc;
  }

  @Override
  public double totalPrice() {
    return 0.0;
  }

  @Override
  public IListOfBooks allBefore(int year) {
    return new EmptyNode();
  }

  @Override
  public IListOfBooks getList(Predicate<Book> test) {
    return new EmptyNode();
  }

  @Override
  public IListOfBooks sortByPrice() {
    return new EmptyNode();
  }

  @Override
  public IListOfBooks insert(Book book) {
    return new ElementNode(book, this);
  }

  @Override
  public String toString() {
    return "";
  }
}
