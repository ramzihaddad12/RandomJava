package dungeon;

import dungeon.Direction;

/**
 * An interface that represents an edge
 * between two nodes in a graph.
 */

interface IEdge {

  /**
   * Gets the x, y position coordinates of the first node.
   * @return the x, y position coordinates of the first node.
   */

  int[] getFirstNodePosition();

  /**
   * Gets the x, y position coordinates of the second node.
   * @return the x, y position coordinates of the second node.
   */

  int[] getSecondNodePosition();

  /**
   * Gets the direction from node 1 to node 2.
   * @return the direction from node 1 to node 2.
   */

  Direction getDirectionFromNode1To2();
}
