package bst;

import java.util.List;

/**
 * A class that implements the BinarySearchTree interface.
 * This class represents a binary search tree.
 * @param <T> the type of the element in the tree.
 */

public class BinarySearchTreeImpl<T extends Comparable<T>> implements BinarySearchTree<T> {

  private BstNode<T> root;

  /**
   * A default constructor for the BinarySearchTreeImpl
   * which constructor an empty tree.
   */

  public BinarySearchTreeImpl() {
    root = new BstLeafNode<>();
  }

  @Override
  public void add(T data) {
    root = root.add(data);
  }

  @Override
  public int size() {
    return root.size();
  }

  @Override
  public int height() {
    return root.height();
  }

  @Override
  public boolean present(T data) {
    return root.present(data);
  }

  @Override
  public T minimum() {
    return root.minimum();
  }

  @Override
  public T maximum() {
    return root.maximum();
  }

  @Override
  public String preOrder() {
    List<T> list = root.preOrder();
    return list.toString().replaceAll(",", "");
  }

  @Override
  public String inOrder() {
    List<T> list = root.inOrder();
    return list.toString().replaceAll(",", "");
  }

  @Override
  public String postOrder() {
    List<T> list = root.postOrder();
    return list.toString().replaceAll(",", "");
  }

  /**
   * Displays the binary search tree in inorder traversal.
   * @return a string that represents the binary search tree in inorder traversal.
   */

  @Override
  public String toString() {
    return this.inOrder();
  }
}
