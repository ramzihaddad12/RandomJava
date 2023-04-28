package bst;

import java.util.List;

interface BstNode<T extends Comparable<T>> {

  BstNode<T> add(T data);

  int size();

  int height();

  boolean present(T data);

  T minimum();

  T maximum();

  List<T> preOrder();

  List<T> inOrder();

  List<T> postOrder();
}
