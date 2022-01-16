package dungeon;

import randomize.Randomness;
import treasure.Treasure;
import treasure.TreasureFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * An implementation of the dungeon.IDungeon interface
 * and represents a dungeon containing different rooms.
 */

public class Dungeon implements IDungeon {

  private final IRoom[][] grid;
  private final int rows;
  private final int columns;
  private final int interConnectivity;
  private final boolean wrapped;
  private final IPlayer player;
  private int[] start;
  private int[] end;
  private final Randomness randomness;
  private final TreasureFactory treasureFactory;

  /**
   * A constructor for the dungeon.
   * @param interConnectivity the interconnectivity of the dungeon.
   * @param name the name of the player in the cave.
   * @param wrapped the flag of whether the dungeon is wrapped or not.
   * @param rows the number of rows in the dungeon.
   * @param columns the number of columns in the dungeon.
   * @param percentageOfCavesWithTreasure the percentage of caves that have treasures in them.
   */

  public Dungeon(int interConnectivity, String name, boolean wrapped,
                 int rows, int columns, int percentageOfCavesWithTreasure, Randomness randomness) {
    if (rows < 0 || columns < 0 || interConnectivity < 0) {
      throw new IllegalArgumentException("Arguments cannot be negative");
    }
    if (percentageOfCavesWithTreasure < 0 || percentageOfCavesWithTreasure > 100) {
      throw new IllegalArgumentException("Percentage should be between 0 and 100");
    }

    if (rows <= 3 || columns <= 3) {
      throw new IllegalArgumentException("Row and column numbers should be at least 4");
    }
    this.rows = rows;
    this.columns = columns;
    this.wrapped = wrapped;
    this.interConnectivity = interConnectivity;
    this.randomness = randomness;
    this.grid = constructDungeon(rows, columns, this.wrapped, this.interConnectivity);
    this.player = new Player(name, this.grid[start[0]][start[1]]);
    this.treasureFactory = new TreasureFactory(this.randomness);
    addTreasure(percentageOfCavesWithTreasure);
  }

  private IRoom[][] constructDungeon(int rows, int columns,
                                     boolean wrapped, int interconnectivity) {
    IRoom[][] dungeon = new IRoom[rows][columns];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        dungeon[i][j] = new Room(new int[]{i, j});
      }
    }
    Set<IEdge> edges = generateAllEdges();

    List<IEdge> list = new ArrayList<>(edges);
    Collections.sort(list, (a, b) -> {
      if (Arrays.compare(a.getFirstNodePosition(), b.getFirstNodePosition()) == 0) {
        return Arrays.compare(a.getSecondNodePosition(), b.getSecondNodePosition());
      }
      return Arrays.compare(a.getFirstNodePosition(), b.getFirstNodePosition());
    });
    UnionFind uf = new UnionFind(rows * columns);
    int x;
    while (uf.getNumberOfComponents() > 1) {
      x = randomness.generateValueBetween(0, list.size() - 1);
      int[] firstRoom = list.get(x).getFirstNodePosition();
      int firstRoomIndex = firstRoom[0] * columns + firstRoom[1];

      int[] secondRoom = list.get(x).getSecondNodePosition();
      int secondRoomIndex = secondRoom[0] * columns + secondRoom[1];
      boolean unionHappened = uf.union(firstRoomIndex, secondRoomIndex);
      if (unionHappened) {
        connectTwoRooms(dungeon, list, x);
      }
    }

    int inter = interconnectivity;
    while (inter > 0 && !list.isEmpty()) {
      x = randomness.generateValueBetween(0, list.size() - 1);
      connectTwoRooms(dungeon, list, x);
      inter--;
    }

    int xStart = randomness.generateValueBetween(0, rows - 1);
    int yStart = randomness.generateValueBetween(0, columns - 1);
    int xEnd =  randomness.generateValueBetween(0, rows - 1);
    int yEnd = randomness.generateValueBetween(0, columns - 1);

    int[] start = {xStart, yStart};
    int[] end = {xEnd, yEnd};


    while (findShortestPath(start, end, dungeon) < 5) {
      xStart = randomness.generateValueBetween(0, rows - 1);
      yStart = randomness.generateValueBetween(0, columns - 1);
      xEnd =  randomness.generateValueBetween(0, rows - 1);
      yEnd = randomness.generateValueBetween(0, columns - 1);
      start = new int[] {xStart, yStart};
      end = new int[] {xEnd, yEnd};

    }

    this.start = start;
    this.end = end;
    return dungeon;
  }

  private void connectTwoRooms(IRoom[][] dungeon, List<IEdge> edges, int index) {
    IEdge edge = edges.get(index);
    int[] firstRoomPosition = edge.getFirstNodePosition();
    int[] secondRoomPosition = edge.getSecondNodePosition();
    Direction direction = edge.getDirectionFromNode1To2();

    int xFirstRoom = firstRoomPosition[0];
    int yFirstRoom = firstRoomPosition[1];
    int xSecondRoom = secondRoomPosition[0];
    int ySecondRoom = secondRoomPosition[1];
    IRoom room1 = dungeon[xFirstRoom][yFirstRoom];
    IRoom room2 = dungeon[xSecondRoom][ySecondRoom];
    Direction oppositeDirection = direction.getOppositeDirection();

    room1.connect(direction, room2);
    room2.connect(oppositeDirection, room1);
    edges.remove(index);
  }

  private Set<IEdge> generateAllEdges() {
    Set<IEdge> set = new HashSet<>();
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns - 1; j++) {
        IEdge horizontalEdge = new Edge(new int[]{i, j}, new int[] {i, j + 1}, Direction.EAST);
        set.add(horizontalEdge);
      }
    }

    for (int j = 0; j < columns; j++) {
      for (int i = 0; i < rows - 1; i++) {
        IEdge verticalEdge = new Edge(new int[]{i, j}, new int[] {i + 1, j}, Direction.SOUTH);
        set.add(verticalEdge);
      }
    }

    if (this.wrapped) {
      set.addAll(generateEdgesForWrapped());
    }

    return set;
  }

  private List<IEdge> generateEdgesForWrapped() {
    List<IEdge> list = new ArrayList<>();
    for (int j = 0; j < columns; j++) {
      list.add(new Edge(new int[] {rows - 1, j}, new int[] {0, j}, Direction.SOUTH));
    }

    for (int i = 0; i < rows; i++) {
      list.add(new Edge(new int[] {i, columns - 1}, new int[] {i, 0}, Direction.EAST));
    }

    return list;
  }

  private int findShortestPath(int[] start, int[] end, IRoom[][] grid) {
    int distance = 0;
    Queue<int[]> queue = new LinkedList<>();
    queue.add(start);
    Direction[] directions = {Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};
    int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    while (!queue.isEmpty()) {
      int size = queue.size();

      for (int s = 0; s < size; s++) {
        int[] currPosition = queue.poll();
        IRoom currRoom = grid[currPosition[0]][currPosition[1]];
        // add children
        for (int index = 0; index < directions.length; index++) {
          if (currRoom.getNextRooms().containsKey(directions[index])) {
            int nextX = currPosition[0] + dir[index][0];
            int nextY = currPosition[1] + dir[index][1];
            if (wrapped) {
              if (nextX == rows) {
                nextX = 0;
              }

              else if (nextX == -1) {
                nextX = rows - 1;
              }

              if (nextY == columns) {
                nextY = 0;
              }

              else if (nextY == -1) {
                nextY = columns - 1;
              }
            }
            if (nextX == end[0] && nextY == end[1]) {
              return distance + 1;
            }
            queue.add(new int[] {nextX, nextY});
          }
          else {
            continue;
          }
        }
      }

      distance++;
    }

    return -1;

  }

  private void addTreasure(int percentage) {
    List<IRoom> allCaves = getAllCaves();

    double proportion = ((double) percentage) / 100;

    int count = (int) (proportion * allCaves.size());
    for (int i = 0; i < count; i++) {
      int randomIndex = randomness.generateValueBetween(0, allCaves.size() - 1);
      IRoom cave = allCaves.get(randomIndex);
      List<Treasure> treasures = new ArrayList<>();
      treasures.add(treasureFactory.getTreasure());
      cave.addTreasures(treasures);
      allCaves.remove(randomIndex);
    }
    return;
  }

  private List<IRoom> getAllCaves() {
    List<IRoom> caves = new ArrayList<>();
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        if (!this.grid[i][j].isTunnel()) {
          caves.add(this.grid[i][j]);
        }
      }
    }
    return caves;
  }

  @Override
  public int[] getPlayerLocation() {
    return this.player.getPosition().getPosition();
  }

  @Override
  public boolean isCurrentRoomTunnel() {
    return this.player.getPosition().isTunnel();
  }

  @Override
  public String currentRoomDescription() {
    return this.player.getPosition().getDescription();
  }

  @Override
  public void movePlayer(Direction direction) {
    this.player.move(direction);
  }

  @Override
  public void pickUpTreasure() {
    this.player.pickUpTreasure();
  }

  @Override
  public boolean isAtEnd() {
    return Arrays.equals(getPlayerLocation(),(end));
  }

  /**
   * Representing the dungeon as a string where
   * each room is represented by parentheses ()
   * and the directions are represents as follows:
   * ^ for north, v for south, <- for left and -> for right.
   *
   * @return the string representation of the dungeon.
   */

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        stringBuilder.append(grid[i][j].toString());
        for (int k = grid[i][j].toString().length(); k < 8; k++) {
          stringBuilder.append(" ");
        }
      }
      stringBuilder.append("\n");
    }
    return stringBuilder.toString();
  }


  @Override
  public int[] getStart() {
    return new int[]{start[0], start[1]};
  }

  @Override
  public int[] getEnd() {
    return new int[]{end[0], end[1]};
  }

  @Override
  public String getPlayerDescription() {
    return this.player.getDescription();
  }

  @Override
  public String getRoomsDescription() {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        stringBuilder.append("\n" + this.grid[i][j].getDescription() );
      }
    }
    return stringBuilder.toString();
  }

  @Override
  public int getRows() {
    return rows;
  }

  @Override
  public int getColumns() {
    return columns;
  }

  @Override
  public int getInterConnectivity() {
    return interConnectivity;
  }

  @Override
  public boolean isWrapped() {
    return wrapped;
  }

  @Override
  public String getPlayerName() {
    return this.player.getName();
  }
}
