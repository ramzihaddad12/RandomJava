package bookutil;

import java.util.Objects;

/**
 * This class represents a book. A book has a title, an author and a price
 */
public class Book {
  private String title;
  private String author;
  private int year;
  private double price;

  /**
   * Construct a Book object that has the provided title, author and price.
   *
   * @param title  the title to be given to this book
   * @param author the author of this book
   * @param year   year in which the book was published
   * @param price  the price to be assigned to this book
   * @throws IllegalArgumentException if author is null
   */
  public Book(String title, String author, int year, double price) {
    if (author == null) {
      throw new IllegalArgumentException("author cannot be null");
    }
    this.title = title;
    this.author = author;
    this.year = year;
    this.price = price;
  }

  /**
   * Return the title of this book.
   *
   * @return the title of this book
   */

  public String getTitle() {
    return this.title;
  }

  /**
   * Return the author of this book.
   *
   * @return the author of this book
   */
  public String getAuthor() {
    return this.author;
  }

  /**
   * Return the price of this book.
   *
   * @return the price of this book
   */
  public double getPrice() {
    return this.price;
  }

  /**
   * Return the year in which this book was published.
   *
   * @return the year of publication
   */
  public int getYear() {
    return this.year;
  }

  @Override
  public String toString() {
    return String.format("Title: %s Author: %s Year: %d Price: %.2f", this.title, this.author,
        this.year, this.price);
  }

  /**
   * Determine if this book was published before the given year.
   *
   * @param year the year to test against
   * @return true if this book was published before the provided year, false
   *         otherwise
   */
  public boolean before(int year) {
    return this.year < year;
  }

  /**
   * Determine if this book is cheaper than the book passed to it.
   *
   * @param book the book whose price should be compared to this book
   * @return true if this book is cheaper than the other book, false otherwise
   * @throws IllegalArgumentException if the book parameter is null
   */
  public boolean cheaperThan(Book book) {
    if (book == null) {
      throw new IllegalArgumentException("cheaperThan: book cannot be null");
    }
    return this.price < book.getPrice();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof Book)) {
      return false;
    }
    Book other = (Book) o;
    return this.title.equals(other.getTitle()) && (this.year == other.getYear());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.title, this.year);
  }
}