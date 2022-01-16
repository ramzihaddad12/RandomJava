package dungeon;

/**
 * A class that represents the union find
 * data structure.
 */
class UnionFind {

  private int[] parents;
  private int[] sizes;
  private int numberOfComponents;

  /**
   * A constructor for the union find.
   * @param n the number of nodes.
   */

  UnionFind(int n) {
    this.parents = new int[n];
    this.sizes = new int[n];
    this.numberOfComponents = n;

    for (int i = 0; i < n; i++) {
      parents[i] = i;
    }
  }


  /**
   * Find the parent of a given node.
   * @param curr the node to find its parent.
   * @return the parent of the node.
   */

  int find(int curr) {
    int root = curr;
    while (root != parents[root]) {
      root = parents[root];
    }

    return root;
  }

  /**
   * Joins two nodes.
   * @param room1 the first node to join.
   * @param room2 the second node to join.
   * @return if union is possible or not.
   */

  boolean union(int room1, int room2) {
    int room1Parent = find(room1);
    int room2Parent = find(room2);

    if (room1Parent == room2Parent) {
      return false;
    }

    if (sizes[room1Parent] > sizes[room2Parent]) {
      parents[room2Parent] = room1Parent;
      sizes[room1Parent] += sizes[room2Parent];

    }

    else {
      parents[room1Parent] = room2Parent;
      sizes[room2Parent] += sizes[room1Parent];
    }
    numberOfComponents--;
    return true;
  }

  /**
   * Gets the number of components in the union find data structure.
   * @return the number of components in the union find data structure.
   */
  int getNumberOfComponents() {
    return numberOfComponents;
  }
}
