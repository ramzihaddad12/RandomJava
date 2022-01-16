package dungeon;

import java.util.Arrays;
import java.util.Objects;

/**
 * A class that implements the dungeon.IEdge interface and
 * represents an edge in a graph.
 */

class Edge implements IEdge {
  private int[] firstNodePosition;
  private int[] secondNodePosition;
  private Direction directionFromNode1To2;

  /**
   * A constructor for an edge.
   * @param firstNodePosition position of the first node.
   * @param secondNodePosition position of the second node.
   * @param directionFromNode1To2 direction from node 1 to node 2.
   */

  Edge(int[] firstNodePosition, int[] secondNodePosition, Direction directionFromNode1To2) {
    this.firstNodePosition = firstNodePosition;
    this.secondNodePosition = secondNodePosition;
    this.directionFromNode1To2 = directionFromNode1To2;
  }

  @Override
  public int[] getFirstNodePosition() {
    return firstNodePosition;
  }

  @Override
  public int[] getSecondNodePosition() {
    return secondNodePosition;
  }

  @Override
  public Direction getDirectionFromNode1To2() {
    return directionFromNode1To2;
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof Edge) {
      Edge otherEdge = (Edge) other;
      return (Arrays.equals(this.firstNodePosition, otherEdge.firstNodePosition)
              && Arrays.equals(this.secondNodePosition, otherEdge.secondNodePosition)
              && this.directionFromNode1To2.equals(otherEdge.directionFromNode1To2))
              || (Arrays.equals(this.firstNodePosition, otherEdge.secondNodePosition)
              && Arrays.equals(this.secondNodePosition, otherEdge.firstNodePosition)
              && this.directionFromNode1To2.equals(
                      otherEdge.directionFromNode1To2.getOppositeDirection()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstNodePosition, secondNodePosition)
            + Objects.hash(secondNodePosition, firstNodePosition)
            + Objects.hash(directionFromNode1To2)
            + Objects.hash(directionFromNode1To2.getOppositeDirection());
  }
}
