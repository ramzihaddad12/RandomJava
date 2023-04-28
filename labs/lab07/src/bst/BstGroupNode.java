package bst;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the non-empty node for the binary search tree.
 *
 * @param <T> the type of the element in the tree.
 */

class BstGroupNode<T extends Comparable<T>> implements BstNode<T> {
  private T data;
  private BstNode<T> left;
  private BstNode<T> right;

  BstGroupNode(T data, BstNode<T> left, BstNode<T> right) {
    if (data == null) {
      throw new IllegalArgumentException("Data in non-empty node cannot be null");
    }
    this.data = data;
    this.left = left;
    this.right = right;
  }

  @Override
  public BstNode<T> add(T data) {
    if (this.data.compareTo(data) == 0) {
      return this;
    }
    else if (this.data.compareTo(data) > 0) {
      this.left = this.left.add(data);
      return this;
    }

    else {
      this.right = this.right.add(data);
      return this;
    }
  }

  @Override
  public int size() {
    return 1 + this.left.size() + this.right.size();
  }

  @Override
  public int height() {
    return 1 + Math.max(left.height(), right.height());
  }

  @Override
  public boolean present(T data) {
    if (this.data.equals(data)) {
      return true;
    }
    return this.left.present(data) || this.right.present(data);
  }

  @Override
  public T minimum() {
    if (this.left instanceof BstLeafNode) {
      return this.data;
    }

    return this.left.minimum();
  }

  @Override
  public T maximum() {
    if (this.right instanceof BstLeafNode) {
      return this.data;
    }

    return this.right.maximum();
  }

  @Override
  public List<T> preOrder() {
    List<T> result = new ArrayList<T>();
    result.add(this.data);
    result.addAll(this.left.preOrder());
    result.addAll(this.right.preOrder());
    return result;
  }

  @Override
  public List<T> inOrder() {
    List<T> result = new ArrayList<T>();
    result.addAll(this.left.inOrder());
    result.add(this.data);
    result.addAll(this.right.inOrder());
    return result;
  }

  @Override
  public List<T> postOrder() {
    List<T> result = new ArrayList<T>();
    result.addAll(this.left.postOrder());
    result.addAll(this.right.postOrder());
    result.add(this.data);
    return result;
  }
}
