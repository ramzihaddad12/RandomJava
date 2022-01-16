package listadt;

import java.util.function.Function;

/**
 * This represents an empty node of the generic list implementation. This class
 * is package-private to hide its implementation to others outside of the
 * ListAdt implementation.
 * 
 * @param <T> the type of element in this node
 */
class GenericEmptyNode<T> implements GenericListAdtNode<T> {
  @Override
  public int count() {
    return 0;
  }

  @Override
  public GenericListAdtNode<T> addFront(T object) {
    return new GenericElementNode<>(object, this);
  }

  @Override
  public GenericListAdtNode<T> addBack(T object) {
    return addFront(object);
  }

  @Override
  public GenericListAdtNode<T> add(int index, T object) throws IllegalArgumentException {
    if (index == 0) {
      return addFront(object);
    }
    throw new IllegalArgumentException("Invalid index to add an element");
  }

  @Override
  public GenericListAdtNode<T> remove(T object) {
    return this; // cannot remove from nothing!
  }

  @Override
  public T get(int index) throws IllegalArgumentException {
    throw new IllegalArgumentException("Invalid index to get an element");
  }

  @Override
  public <R> GenericListAdtNode<R> map(Function<T, R> converter) {
    return new GenericEmptyNode<>();
  }

  @Override
  public String toString() {
    return "";
  }
}
