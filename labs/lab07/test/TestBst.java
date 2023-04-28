import static org.junit.Assert.assertEquals;

import bst.BinarySearchTree;
import bst.BinarySearchTreeImpl;
import org.junit.Before;
import org.junit.Test;


/**
 * A test that tests all the different methods
 * of the BinarySearchTree interface.
 */

public class TestBst {

  private BinarySearchTree<Integer> bst;

  /**
   * Sets up all the variables needed before testing.
   */

  @Before
  public void setUp() {
    bst = new BinarySearchTreeImpl<>();
  }

  /**
   * Tests the default constructor which should create an empty tree.
   */

  @Test
  public void testDefaultConstructorWhichShouldCreateEmptyTree() {
    BinarySearchTree<Integer> emptyTree = new BinarySearchTreeImpl<>();

    int expectedSize = 0;
    assertEquals(expectedSize, emptyTree.size());
    int expectedHeight =  0;
    assertEquals(expectedHeight, emptyTree.height());
    String expectedString = "[]";
    assertEquals(expectedString, emptyTree.preOrder());
    Integer expectedMinimum = null;
    assertEquals(expectedMinimum, emptyTree.minimum());
    Integer expectedMaximum = null;
    assertEquals(expectedMaximum, emptyTree.maximum());
  }

  /**
   * Tests the add for a non-empty Bst.
   */

  @Test
  public void testAddForNonEmptyBst() {
    bst.add(7);
    bst.add(3);
    bst.add(10);
    bst.add(8);
    bst.add(9);

    int expectedSize = 5;
    assertEquals(expectedSize, bst.size());
    int expectedHeight =  4;
    assertEquals(expectedHeight, bst.height());
    String expectedString = "[7 3 10 8 9]";
    assertEquals(expectedString, bst.preOrder());
    Integer expectedMinimum = 3;
    assertEquals(expectedMinimum, bst.minimum());
    Integer expectedMaximum = 10;
    assertEquals(expectedMaximum, bst.maximum());

    bst.add(1);
    bst.add(12);

    expectedSize = 7;
    assertEquals(expectedSize, bst.size());
    expectedHeight =  4;
    assertEquals(expectedHeight, bst.height());
    expectedString = "[7 3 1 10 8 9 12]";
    assertEquals(expectedString, bst.preOrder());
    expectedMinimum = 1;
    assertEquals(expectedMinimum, bst.minimum());
    expectedMaximum = 12;
    assertEquals(expectedMaximum, bst.maximum());

  }

  /**
   * Tests the add for an empty Bst.
   */

  @Test
  public void testAddForEmptyBst() {
    BinarySearchTree<Integer> emptyTree = new BinarySearchTreeImpl<>();
    emptyTree.add(7);
    emptyTree.add(3);
    emptyTree.add(10);
    emptyTree.add(8);
    emptyTree.add(9);

    int expectedSize = 5;
    assertEquals(expectedSize, emptyTree.size());
    int expectedHeight =  4;
    assertEquals(expectedHeight, emptyTree.height());
    String expectedString = "[7 3 10 8 9]";
    assertEquals(expectedString, emptyTree.preOrder());
    Integer expectedMinimum = 3;
    assertEquals(expectedMinimum, emptyTree.minimum());
    Integer expectedMaximum = 10;
    assertEquals(expectedMaximum, emptyTree.maximum());
  }

  /**
   * Tests the add method when adding an element that is already in the tree.
   */

  @Test
  public void testAddWhenAddingAnElementAlreadyInTree() {
    bst.add(7);
    bst.add(3);
    bst.add(10);
    bst.add(8);
    bst.add(9);
    bst.add(8);

    int expectedSize = 5;
    assertEquals(expectedSize, bst.size());
    int expectedHeight =  4;
    assertEquals(expectedHeight, bst.height());
    String expectedString = "[7 3 10 8 9]";
    assertEquals(expectedString, bst.preOrder());
    Integer expectedMinimum = 3;
    assertEquals(expectedMinimum, bst.minimum());
    Integer expectedMaximum = 10;
    assertEquals(expectedMaximum, bst.maximum());
  }

  /**
   * Tests the add method when adding null data.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testAddWhenAddingNullData() {
    bst.add(null);
  }

  /**
   * Tests the size for a non-empty Bst.
   */

  @Test
  public void testSizeForNonEmptyBst() {
    bst.add(7);
    bst.add(3);
    bst.add(1);
    bst.add(10);
    bst.add(8);
    bst.add(12);
    bst.add(9);

    int expectedSize = 7;
    assertEquals(expectedSize, bst.size());
  }

  /**
   * Tests the size for an empty Bst.
   */

  @Test
  public void testSizeForEmptyBst() {
    BinarySearchTree<Integer> emptyTree = new BinarySearchTreeImpl<>();
    int expectedSize = 0;
    assertEquals(expectedSize, emptyTree.size());
  }


  /**
   * Tests the height for a non-empty Bst when left and right
   * subtrees have different heights.
   */

  @Test
  public void testHeightForNonEmptyBstWhenLeftAndRightSubTreeHaveDifferentHeights() {
    bst.add(7);
    bst.add(3);
    bst.add(1);
    bst.add(10);
    bst.add(8);
    bst.add(12);
    bst.add(9);
    bst.add(-1);
    bst.add(-2);

    int expectedHeight = 5;
    assertEquals(expectedHeight, bst.height());
  }

  /**
   * Tests the height for an empty Bst.
   */

  @Test
  public void testHeightForEmptyBst() {
    BinarySearchTree<Integer> emptyTree = new BinarySearchTreeImpl<>();
    int expectedHeight = 0;
    assertEquals(expectedHeight, emptyTree.height());
  }

  /**
   * Tests the height for a non-empty Bst when left and right
   * subtrees have same heights.
   */

  @Test
  public void testHeightForNonEmptyBstWhenLeftAndRightSubTreeHaveSameHeight() {
    bst.add(7);
    bst.add(3);
    bst.add(1);
    bst.add(10);
    bst.add(8);
    bst.add(12);
    bst.add(9);
    bst.add(-1);

    int expectedHeight = 4;
    assertEquals(expectedHeight, bst.height());
  }

  /**
   * Tests the minimum for a non-empty Bst.
   */

  @Test
  public void testMinimumForNonEmptyBst() {
    bst.add(7);
    bst.add(3);
    bst.add(1);
    bst.add(10);
    bst.add(8);
    bst.add(12);
    bst.add(9);

    Integer expectedMinimum = 1;
    assertEquals(expectedMinimum, bst.minimum());
  }

  /**
   * Tests the minimum for an empty Bst.
   */

  @Test
  public void testMinimumForEmptyBst() {
    BinarySearchTree<Integer> emptyTree = new BinarySearchTreeImpl<>();
    Integer expectedMinimum = null;
    assertEquals(expectedMinimum, emptyTree.minimum());
  }

  /**
   * Tests the maximum for a non-empty Bst.
   */

  @Test
  public void testMaximumForNonEmptyBst() {
    bst.add(7);
    bst.add(3);
    bst.add(1);
    bst.add(10);
    bst.add(8);
    bst.add(12);
    bst.add(9);

    Integer expectedMaximum = 12;
    assertEquals(expectedMaximum, bst.maximum());
  }

  /**
   * Tests the maximum for an empty Bst.
   */

  @Test
  public void testMaximumForEmptyBst() {
    BinarySearchTree<Integer> emptyTree = new BinarySearchTreeImpl<>();
    Integer expectedMaximum = null;
    assertEquals(expectedMaximum, emptyTree.maximum());
  }

  /**
   * Tests the present method for a non-empty Bst when object is present.
   */

  @Test
  public void testPresentForNonEmptyBstWhenObjectIsPresent() {
    bst.add(7);
    bst.add(3);
    bst.add(1);
    bst.add(10);
    bst.add(8);
    bst.add(12);
    bst.add(9);

    boolean expected = true;
    assertEquals(expected, bst.present(1));
    assertEquals(expected, bst.present(3));
    assertEquals(expected, bst.present(7));
    assertEquals(expected, bst.present(8));
    assertEquals(expected, bst.present(9));
    assertEquals(expected, bst.present(10));
    assertEquals(expected, bst.present(12));

  }

  /**
   * Tests the present method for a non-empty Bst when object is not present.
   */

  @Test
  public void testPresentForNonEmptyBstWhenObjectIsNotPresent() {
    bst.add(7);
    bst.add(3);
    bst.add(1);
    bst.add(10);
    bst.add(8);
    bst.add(12);
    bst.add(9);

    boolean expected = false;
    assertEquals(expected, bst.present(2));
    assertEquals(expected, bst.present(4));
    assertEquals(expected, bst.present(-1));
    assertEquals(expected, bst.present(11));
    assertEquals(expected, bst.present(14));

  }

  /**
   * Tests the present method for an empty Bst.
   */

  @Test
  public void testPresentForEmptyBst() {
    BinarySearchTree<Integer> emptyTree = new BinarySearchTreeImpl<>();
    boolean expected = false;
    assertEquals(expected, emptyTree.present(1));
  }

  /**
   * Tests the preOrder method for a non-empty Bst.
   */

  @Test
  public void testPreOrderForNonEmptyBst() {
    bst.add(7);
    bst.add(3);
    bst.add(1);
    bst.add(10);
    bst.add(8);
    bst.add(12);
    bst.add(9);
    String expectedString = "[7 3 1 10 8 9 12]";
    assertEquals(expectedString, bst.preOrder());
  }

  /**
   * Tests the preOrder method for an empty Bst.
   */

  @Test
  public void testPreOrderForEmptyBst() {
    BinarySearchTree<Integer> emptyTree = new BinarySearchTreeImpl<>();
    String expectedString = "[]";
    assertEquals(expectedString, emptyTree.preOrder());
  }

  /**
   * Tests the postOrder method for a non-empty Bst.
   */

  @Test
  public void testPostOrderForNonEmptyBst() {
    bst.add(7);
    bst.add(3);
    bst.add(1);
    bst.add(10);
    bst.add(8);
    bst.add(12);
    bst.add(9);
    String expectedString = "[1 3 9 8 12 10 7]";
    assertEquals(expectedString, bst.postOrder());
  }

  /**
   * Tests the postOrder method for an empty Bst.
   */

  @Test
  public void testPostOrderForEmptyBst() {
    BinarySearchTree<Integer> emptyTree = new BinarySearchTreeImpl<>();
    String expectedString = "[]";
    assertEquals(expectedString, emptyTree.postOrder());
  }

  /**
   * Tests the inOrder method for a non-empty Bst.
   */

  @Test
  public void testInOrderForNonEmptyBst() {
    bst.add(7);
    bst.add(3);
    bst.add(1);
    bst.add(10);
    bst.add(8);
    bst.add(12);
    bst.add(9);
    String expectedString = "[1 3 7 8 9 10 12]";
    assertEquals(expectedString, bst.inOrder());
  }

  /**
   * Tests the inOrder method for an empty Bst.
   */

  @Test
  public void testInOrderForEmptyBst() {
    BinarySearchTree<Integer> emptyTree = new BinarySearchTreeImpl<>();
    String expectedString = "[]";
    assertEquals(expectedString, emptyTree.inOrder());
  }

  /**
   * Tests the toString method for a non-empty Bst.
   */

  @Test
  public void testToStringForNonEmptyBst() {
    bst.add(7);
    bst.add(3);
    bst.add(1);
    bst.add(10);
    bst.add(8);
    bst.add(12);
    bst.add(9);
    String expectedString = "[1 3 7 8 9 10 12]";
    assertEquals(expectedString, bst.toString());
  }

  /**
   * Tests the toString method for an empty Bst.
   */

  @Test
  public void testToStringForEmptyBst() {
    BinarySearchTree<Integer> emptyTree = new BinarySearchTreeImpl<>();
    String expectedString = "[]";
    assertEquals(expectedString, emptyTree.toString());
  }


}
