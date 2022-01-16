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

  private IRoom[][] grid;
  private final int rows;
  private final int columns;
  private final int interConnectivity;
  private final boolean wrapped;
  private IPlayer player;
  private int[] start;
  private int[] end;
  private final Randomness randomness;
  private final TreasureFactory treasureFactory;
  private boolean isGameOver;
  private boolean didPlayerWin;
  private int numberOfMonsters;
  private final List<int[]> locationOfMonsters;

  //TODO: NEW
  private final boolean[][] visited;

  private final IRoom[][] initialGrid;
  private final IPlayer intialPlayer;
  private int initialNumberOfMonsters;
  private final static int minSize = 4;

//  private final List<int[]> locationOfMonsters;
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
                 int rows, int columns, int percentageOfCavesWithTreasure, int numberOfMonsters,
                 Randomness randomness) {
    if (rows < 0 || columns < 0 || interConnectivity < 0 || numberOfMonsters < 0) {
      throw new IllegalArgumentException("Arguments cannot be negative");
    }

    if (percentageOfCavesWithTreasure < 0 || percentageOfCavesWithTreasure > 100) {
      throw new IllegalArgumentException("Percentage should be between 0 and 100");
    }

    if (rows < minSize || columns < minSize) {
      throw new IllegalArgumentException("Row and column numbers should be at least 4");
    }

    if (numberOfMonsters > rows * columns) {
      throw new IllegalArgumentException("Number of monsters greater than number of rooms");
    }

    this.rows = rows;
    this.columns = columns;
    this.wrapped = wrapped;
    this.interConnectivity = interConnectivity;
    this.randomness = randomness;
    this.numberOfMonsters = numberOfMonsters;
    this.grid = constructDungeon(rows, columns, this.wrapped, this.interConnectivity);
    this.locationOfMonsters = new ArrayList<>();
    addMonsters();
    this.player = new Player(name, this.grid[start[0]][start[1]]);
    this.treasureFactory = new TreasureFactory(this.randomness);
    this.isGameOver = false;
    this.didPlayerWin = false;
    addTreasure(percentageOfCavesWithTreasure);
    addArrows(percentageOfCavesWithTreasure);

    this.visited = new boolean[rows][columns];
    this.visited[start[0]][start[1]] = true;
    this.intialPlayer = new Player((Player) this.player);//TODO: make sure rooms are a copy as well

//    this.initialGrid = this.grid; //TODO: make sure rooms are a copy as well
    this.initialGrid = new IRoom[rows][columns];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        this.initialGrid[i][j] = new Room(new int[]{i, j});
      }
    }
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
//        this.initialGrid[i][j] = new Room(new int[] {i, j});
        for (Direction dir: this.grid[i][j].getNextRooms().keySet()) {
          if (dir == Direction.EAST) {
            int col = j + 1;
            if (col >= this.columns) {
              col = 0;
            }
            this.initialGrid[i][j].connect(dir, this.initialGrid[i][col]);
          }

          else if (dir == Direction.SOUTH) {
            int row = i + 1;
            if (row >= this.rows) {
              row = 0;
            }
            this.initialGrid[i][j].connect(dir, this.initialGrid[row][j]);

          }

          else if (dir == Direction.WEST) {
            int col = j - 1;
            if (col < 0) {
              col = this.columns - 1;
            }
            this.initialGrid[i][j].connect(dir, this.initialGrid[i][col]);
          }

          else if (dir == Direction.NORTH) {
            int row = i - 1;
            if (row < 0) {
              row = this.rows - 1;
            }
            this.initialGrid[i][j].connect(dir, this.initialGrid[row][j]);
          }

        }

        if (this.grid[i][j].roomHasTreasure()) {
          this.initialGrid[i][j].addTreasures(this.grid[i][j].getTreasures());
        }
        this.initialGrid[i][j].addArrows(this.grid[i][j].getNumberOfArrows());
        if (this.grid[i][j].hasAMonster()) {
          this.initialGrid[i][j].addMonster();
        }
      }
    }
    this.initialNumberOfMonsters = numberOfMonsters;
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
    this.start = new int[]{xStart, yStart};
    this.end = new int[]{xEnd, yEnd};


    while (findShortestPath(start, end, dungeon) < 5 || dungeon[xEnd][yEnd].isTunnel()) {
      xStart = randomness.generateValueBetween(0, rows - 1);
      yStart = randomness.generateValueBetween(0, columns - 1);
      xEnd =  randomness.generateValueBetween(0, rows - 1);
      yEnd = randomness.generateValueBetween(0, columns - 1);
      this.start = new int[] {xStart, yStart};
      this.end = new int[] {xEnd, yEnd};
    }

//    this.start = start;
//    this.end = end;
    return dungeon;
  }

  private void addMonsters() {
    if (this.numberOfMonsters == 0) {
      return;
    }

    int numberOfMonstersInserted = 0;
    //insert at end position
    this.grid[end[0]][end[1]].addMonster();
    numberOfMonstersInserted++;

    List<IRoom> allCaves = getAllCaves();
    while (numberOfMonstersInserted < this.numberOfMonsters) {
      int randomIndex = randomness.generateValueBetween(0, allCaves.size() - 1);
      IRoom cave = allCaves.get(randomIndex);

      if (!Arrays.equals(cave.getPosition(), end)) {
        cave.addMonster();
        locationOfMonsters.add(cave.getPosition());
        allCaves.remove(randomIndex);
        numberOfMonstersInserted++;
      }

      if (allCaves.isEmpty()) {
        //TODO: how to notufy user??
        return;
      }
    }
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

  private void addArrows(int percentage) {
    int numberOfRooms = percentage  * rows * columns / 100;
    int count = 0;

    while (count < numberOfRooms) {
      int randomRow = randomness.generateValueBetween(0, rows - 1);
      int randomColumn = randomness.generateValueBetween(0, columns - 1);

      int numOfArrows = 1;
      IRoom room = this.grid[randomRow][randomColumn];
      room.addArrows(numOfArrows);
      count++;
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
    if (isGameOver) {
      throw new IllegalArgumentException("Game is over!");
    }

    this.player.move(direction);
    IRoom copy = this.player.getPosition();
    IRoom roomPlayerIsIn = this.grid[copy.getPosition()[0]][copy.getPosition()[1]];
    visited[copy.getPosition()[0]][copy.getPosition()[1]] = true;
    if (roomPlayerIsIn.hasAMonster()) {
      if (roomPlayerIsIn.getMonsterHealth().equals(Health.FULL_HEALTH)) {
        isGameOver = true;
        didPlayerWin = false;
        return;
      }

      else if (roomPlayerIsIn.getMonsterHealth().equals(Health.HALF_HEALTH)) {
        int flipCoin = randomness.generateValueBetween(0, 1);
        if (flipCoin == 0) {
          isGameOver = true;
          didPlayerWin = false;
        }
      }
    }

    if (isAtEnd()) {
      isGameOver = true;
      didPlayerWin = true;
    }
  }

  @Override
  public boolean pickUpTreasure() {
    if (isGameOver) {
      throw new IllegalArgumentException("Game is over!");
    }
    return this.player.pickUpTreasure();
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

  @Override
  public int shoot(int distance, Direction direction) {
    if (distance <= 0 || direction == null) {
      throw new IllegalArgumentException("Arguments cannot be negative or null");
    }
    if (isGameOver) {
      throw new IllegalStateException("Game is over!");
    }

    if (player.getNumOfArrows() <= 0) {
      throw new IllegalStateException("Player has no arrows. Can't shoot");
    }
    this.player.shoot();
    int[] arrowDestination = getArrowEndLocation(distance, direction,
            this.grid[getPlayerLocation()[0]][getPlayerLocation()[1]]);
    if (arrowDestination[0] == -1 && arrowDestination[0] == -1) {
      return -1;
    }

    IRoom roomDestination = this.grid[arrowDestination[0]][arrowDestination[1]];

    if (!roomDestination.hasAMonster()) {
      return -1;
    }

    try {
      roomDestination.hitMonster();
      if (!roomDestination.hasAMonster()) {
        this.numberOfMonsters--;
        return 1;
      }
      return 0;
    }
    catch (IllegalArgumentException e) {
      return -1;
    }
  }

  private int[] getArrowEndLocation(int distance, Direction shootingDirection, IRoom startRoom) {
    IRoom room = startRoom;
    Direction direction = shootingDirection;

    while (distance > 0) {
      if (!room.getNextRooms().containsKey(direction)) {
        throw new IllegalArgumentException("Invalid move");
      }

      // move to next room: I already have current room and direction needed
      IRoom nextRoom = null;

      int[] position = room.getPosition();
      int x = position[0];
      int y = position[1];

      if (direction.equals(Direction.SOUTH)) {
        if (wrapped && x == rows - 1) {
          nextRoom = this.grid[0][y];
        }

        else {
          nextRoom = this.grid[x + 1][y];
        }
      }

      else if (direction.equals(Direction.NORTH)) {
        if (wrapped && x == 0) {
          nextRoom = this.grid[rows - 1][y];
        }
        else {
          nextRoom = this.grid[x - 1][y];
        }
      }

      else if (direction.equals(Direction.EAST)) {
        if (wrapped && y == columns - 1) {
          nextRoom = this.grid[x][0];
        }

        else {
          nextRoom = this.grid[x][y + 1];
        }
      }

      else if (direction.equals(Direction.WEST)) {
        if (wrapped && y == 0) {
          nextRoom = this.grid[x][columns - 1];
        }

        else {
          nextRoom = this.grid[x][y - 1];
        }
      }

      room = nextRoom;


      //update distance
      if (!room.isTunnel()) {
        distance--;
      }

      if (distance == 0) {
        return room.getPosition();
      }

      //update direction from nextRoom/room

      Direction newDirection = null;

      if (room.isTunnel()) {
        for (Direction dir: room.getNextRooms().keySet()) {
          if (!dir.equals(direction.getOppositeDirection())) {
            newDirection = dir;
            break;
          }
        }
      }

      else {
        for (Direction dir: room.getNextRooms().keySet()) {
          if (dir.equals(direction)) {
            newDirection = dir;
            break;
          }
        }
      }

      if (newDirection == null) {
        return new int[] {-1, -1};
      }

      direction = newDirection;
    }

    return room.getPosition();
  }

  public boolean isGameOver() {
    return isGameOver;
  }

  public boolean isDidPlayerWin() {
    return didPlayerWin;
  }

  public int getNumberOfMonsters() {
    return numberOfMonsters;
  }

  @Override
  public boolean pickUpArrows() {
    return this.player.pickUpArrows();
  }

  @Override
  public boolean playerLocationHasArrows() {
    return this.grid[this.getPlayerLocation()[0]][this.getPlayerLocation()[1]].getNumberOfArrows()
            != 0;
  }

  @Override
  public boolean playerLocationHasTreasure() {
    return !this.grid[this.getPlayerLocation()[0]][this.getPlayerLocation()[1]]
            .getTreasures().isEmpty();
  }

  @Override
  public boolean[][] getVisitedLocations() {
    return visited;
  }

  @Override
  public String getRoomDescription(int row, int column) {
    return this.grid[row][column].getDescription();
  }

  @Override
  public boolean roomHasMonster(int row, int column) {
    return this.grid[row][column].hasAMonster();
  }

  @Override
  public boolean roomHasTreasure(int row, int column) {
    return !this.grid[row][column].getTreasures().isEmpty();
  }

  @Override
  public boolean roomHasArrow(int row, int column) {
    return this.grid[row][column].getNumberOfArrows() != 0;

  }

  @Override
  public IRoom[][] getDungeon() {
    return this.grid.clone();
  }

  @Override
  public void clearVisited() {
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        if (visited[i][j]) {
          if (!this.grid[i][j].isTunnel()) {
            this.grid[i][j].removeAllTreasures();
            this.grid[i][j].addTreasures(this.initialGrid[i][j].getTreasures());
          }


          this.grid[i][j].removeAllArrows();
          this.grid[i][j].addArrows(this.initialGrid[i][j].getNumberOfArrows());


        }

        if (this.initialGrid[i][j].hasAMonster()) {
          if (this.grid[i][j].hasAMonster()) {
            this.grid[i][j].removeMonster();
          }

          this.grid[i][j].addMonster();
        }
      }
    }

    for (boolean[] row: this.visited) {
      Arrays.fill(row, false);
    }
    this.visited[this.start[0]][this.start[1]] = true;
//    this.p
    this.isGameOver = false;
    this.didPlayerWin = false;

//    for (int i = 0; i < rows; i++) {
//      for (int j = 0; j < columns; j++) {
////        this.initialGrid[i][j] = new Room(new int[] {i, j});
//
//
//        if (this.initialGrid[i][j].roomHasTreasure()) {
//          this.grid[i][j].addTreasures(this.grid[i][j].getTreasures());
//        }
//        this.initialGrid[i][j].addArrows(this.grid[i][j].getNumberOfArrows());
//        if (this.initialGrid[i][j].hasAMonster()) {
//          this.grid[i][j].addMonster();
//        }
//      }
//    }
//    this.grid = this.initialGrid; //TODO: make sure rooms are a copy as well
//    this.player = this.intialPlayer;//TODO: make sure rooms are a copy as well
    this.player = new Player("player", this.grid[this.start[0]][this.start[1]]);


    this.numberOfMonsters = initialNumberOfMonsters;
    return;

  }

}
