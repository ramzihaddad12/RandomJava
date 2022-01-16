package booklist;

import bookutil.Book;

import java.util.function.Predicate;

/**
 * This represents a non-empty node of the list. It contains a piece of data
 * along with the rest of the list
 */
public class ElementNode implements IListOfBooks {
  private Book element;
  private IListOfBooks rest;

  /**
   * Constructor.
   * 
   * @param p    the book at this node.
   * @param rest the rest of the list
   */
  public ElementNode(Book p, IListOfBooks rest) {
    this.element = p;
    this.rest = rest;
  }

  @Override
  // public int count() {
  // return 1 + this.rest.count();
  // }
  public int count() {
    return countHelp(0);
  }

  @Override
  public int countHelp(int acc) {
    return this.rest.countHelp(1 + acc);
  }

  @Override
  public double totalPrice() {
    return this.element.getPrice() + this.rest.totalPrice();
  }

  @Override
  public IListOfBooks allBefore(int year) {
    if (element.before(year)) {
      return new ElementNode(this.element, this.rest.allBefore(year));
    } else {
      return this.rest.allBefore(year);
    }
  }

  @Override
  public IListOfBooks getList(Predicate<Book> test) {
    if (test == null) {
      throw new IllegalArgumentException("predicate cannot be null");
    }
    if (test.test(element)) {
      return new ElementNode(this.element, this.rest.getList(test));
    } else {
      return this.rest.getList(test);
    }
  }

  @Override
  public IListOfBooks sortByPrice() {
    return this.rest.sortByPrice().insert(this.element);
  }

  @Override
  public IListOfBooks insert(Book book) {
    if (this.element.cheaperThan(book)) {
      return new ElementNode(this.element, this.rest.insert(book));
    } else {
      return new ElementNode(book, this);
    }
  }

  @Override
  public String toString() {
    return "(" + this.element.toString() + ")" + this.rest.toString();
  }
}
