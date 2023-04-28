package bst;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the base case for the binary search tree.
 * The leaf node does not contain any data.
 *
 * @param <T> the type of the element in the tree.
 */

public class BstLeafNode<T extends Comparable<T>> implements BstNode<T> {

  @Override
  public BstNode<T> add(T data) {
    BstGroupNode<T> newNode = new BstGroupNode<T>(data, new BstLeafNode<>(), new BstLeafNode<>());
    return newNode;
  }

  @Override
  public int size() {
    return 0;
  }

  @Override
  public int height() {
    return 0;
  }

  @Override
  public boolean present(T data) {
    return false;
  }

  @Override
  public T minimum() {
    return null;
  }

  @Override
  public T maximum() {
    return null;
  }

  @Override
  public List<T> preOrder() {
    return new ArrayList<>();
  }

  @Override
  public List<T> inOrder() {
    return new ArrayList<>();
  }

  @Override
  public List<T> postOrder() {
    return new ArrayList<>();
  }
}
