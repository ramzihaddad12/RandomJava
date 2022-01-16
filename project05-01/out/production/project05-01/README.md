# Project 5 - Dungeon

## About/Overview

This game consists of a  _dungeon_, a network of tunnels and caves that are interconnected so that player can explore the entire world by traveling from cave to cave through the tunnels that connect them. 

A dungeon is basically a 2 dimensional maze/grid made up of rooms. A room is either a cave or a tunnel, depending on the number of entrances it possesses. If a room has exactly 2 entrances, then it is classifies as a tunnel, else, it is a cave. A dungeon has at least one path between any 2 rooms. This number can increase, depending on the interconnectivity specified. Caves can have monsters in them which kill the player if the player enters that cave whilst the monster is at full health. The player has a 50-50 chance of surviving if the monster is at half health.

In addition, there is always a thief placed at a certain location if the dungeon (will let you figure that out!). When the player encounters the thief, all of the player's treasure gets stolen from him/her by the thief.![enter image description here](https://i.ibb.co/dbj8kpF/thief.png)

 Furthermore, a room can have a pit ![enter image description here](https://i.ibb.co/DWfT0WR/pit.png) which the player will fall into and die. There are no pits at the start and end locations. A player would know that there is a nearby pit if he/she is in danger. A player is in danger if there is a pit 1 room away from his/her current location. If the player is in danger, this icon ![enter image description here](https://i.ibb.co/MBnpnPh/danger.png) will be displayed.

There are 3 types of treasure in a dungeon: diamonds ![enter image description here](https://i.ibb.co/ZTZBhfX/diamond.png), sapphires ![enter image description here](https://i.ibb.co/k6xV8hD/sapphire.png), and rubies ![enter image description here](https://i.ibb.co/fxsFm7P/ruby.png). Only caves can have treasure; tunnels cannot have treasures in them. The percentage of caves that possess treasure is an attribute specified by the user when instantiating/creating the dungeon. In addition, arrows are scattered around the dungeon in both caves and tunnels. The arrows allow the player to shoot the monster from other rooms, (given a direction and a distance). A successful shot would remove half the health of the monster, meaning that the monster would die after 2 successful shots from the player.

A dungeon could be either wrapping or non-wrapping. Wrapping means that you could go from one end of the dungeon to the tunnel to the other, in one move. For example, moving to the north from row 0 (at the top) in the grid moves the player to the location in the same column in row 5 (at the bottom).

The start and end positions for the player in the dungeon are randomly selected such that the length of the path between them is at least  5 and the end is a cave.

Successful shots from the player require an exact distance, so even if the arrow would pass the monster, it would be categorized as a successful hit. Distance is defined as the number of caves (but not tunnels) that an arrow travels. Arrows travel freely down tunnels (even crooked ones) but only travel in a straight line through a cave.

A player would know that there is a nearby monster if he/she smells something. A very pungent smell by the player means that there is a monster 1 position from the player's position, or that there are multiple monsters 2 positions away from the player's position. A pungent smell means that there is one monster 2 positions away from the players location. Otherwise, a player would not smell anything.

## List of features
These features describe the feature of the model, which will communicate with the controller.

For the dungeon:

public int[] getPlayerLocation(): Gets the x and y coordinates of the player  in the dungeon. 

public boolean isCurrentRoomTunnel(): Determines whether the current room the player is in is a tunnel or not. 
  
public String currentRoomDescription(): Gets a description of the current room the player is in which includes information about the treasure in the room and the possible moves from that room. 

public void movePlayer(Direction direction): Moves the player in the dungeon given a direction.

public boolean pickUpTreasure(): Makes the player in the dungeon pick up  the treasure from the room he/she is currently  at, and returns if the pick up was successful.
  
public boolean isAtEnd(): Checks if the player in the dungeon has reached the final  destination. 
  
public int[] getStart(): Gets the start position of the player in the dungeon.
  
public int[] getEnd(): Gets the end position of the player in the dungeon.
  
public String getPlayerDescription(): Gets a description of player which includes information about the treasure possessed by the player and his/her location.
  
public String getRoomsDescription(): Gets a description of all rooms which includes information about the treasure in the room and the possible moves from that room.
 
public int getRows(): Gets the number of rows in the dungeon.

public int getColumns(): Gets the number of columns in the dungeon.
  
public int getInterConnectivity(): Gets the interconnectivity of the dungeon.  

public boolean isWrapped(): Gets whether the dungeon is wrapped or not.
  
public String getPlayerName(): Gets the name of the player in the dungeon.


public boolean shoot(int distance, Direction direction):  Shoots an arrow in the specified direction and to the specified distance, and returns whether the shot has been successful in hitting a monster or not.  

public boolean isGameOver(): Checks whether the game is over or not, and returns whether the game is over or not 

public boolean isDidPlayerWin(): Checks whether the player won, and returns whether the player won. 
  
public int getNumberOfMonsters():  The number of monsters in the dungeon, and returns the number of monsters in the dungeon. 

public boolean pickUpArrows(): Makes the player in the dungeon pick up the arrows from the room he/she is currently at, and returns whether there were arrows to pick up.
  
public boolean[][] getVisitedLocations(): Gets the visited locations of the player in the dungeon. 
  
public IRoom[][] getDungeon(): Gets the dungeon as a 2d grid.

public void clearDungeon(): Clears the dungeon, and re-initializes the dungeon to its initial state.

public boolean didPlayerFallInPit(): Checks if the player fell in a pit.

public boolean didPlayerGetRobbed(): Checks if the player got robbed. 

public int getNumberOfPits(): Gets the number of pits present in the dungeon. 

For the player:
public IRoom getPosition(): Gets the position or room the player is currently in.

public String getDescription(): Gets a description of player which includes information about the treasure possessed by the player and  his/her location. 

public List<**Treasure**> getTreasures(): Gets the treasures possessed by the player.  

public String getName(): Gets the name of the player. 
   
public void move(Direction direction): Moves the player from his/her current location to another one  based on the given direction. 

public void pickUpTreasure(): Picks up the treasure located in the room the player is currently in.

public int getNumOfArrows();  
  
public boolean pickUpArrows(): Picks up the arrows located in the room * the player is currently in., and returns whether there were arrows to pick up.  
  
public void shoot(): Shoots one of the arrows.
 
public Smell getSmell(): Gets the smell of the room, and returns the smell of the room.

public boolean isInDanger(): Checks if the player is in danger, meaning * that there is a pit nearby.

public void removeAllTreasures(): Removes all the treasures the player has.

For the room:

public List<**Treasure**> getTreasures(): Gets the treasures present in the room.  
  
public void removeAllTreasures(): Removes all the treasures present in the room.

public String getDescription(): Gets a description of the room which includes information about the treasure in the room and the possible moves from that room. 
 
public void addTreasures(List<**Treasure**> treasuresToAdd): Adds a list of treasures to the room. 
  
public Map<Direction, IRoom> getNextRooms(): Gets the possible next locations/rooms from the current room. This is done in  the form of a map of rooms possible to go to from the current room along with the direction needed to go to those rooms.
  
public boolean isTunnel(): Checks if the room is a tunnel or not.  

public int[] getPosition(): Gets the position of the room in the dungeon.
  
 public void connect(Direction direction, IRoom otherRoom):  Connects the room with another room. 
 
public int getNumberOfEntrances(): Gets the position of the room in the dungeon. 
  
public int getNumberOfArrows(): Gets the number of arrows present in the room, and returns the number of arrows present in the room. 
  
public void removeAllArrows(): Removes all the arrows present in the room.
  
public void addArrows(int numOfArrowsToAdd): Adds a number of arrows to the room. 
 
public void removeMonster(): Removes the monster from the room, meaning the monster has been killed.
  
public void addMonster(): Adds a monster to the room.
  
public boolean hasAMonster(): Checks whether the room has a monster in it, and returns whether the room has a monster in it.
  
public void hitMonster(): Hits the monster in the room by lowering its health. 

public Health getMonsterHealth(): Gets the health of the monster in the room if there is one.

public Monster getMonster(): Gets the monster in the room if it exists. , and returns the monster in the room if it exists. 

public boolean roomHasTreasure(): Checks whether the room has treasure in it or not. 

public boolean roomHasArrow(): Checks whether the room has arrows in it or not.

public boolean hasPit(): Checks if the room has a pit. 

public void addPit(): Adds a pit the room.

public boolean hasThief(): Checks if the room has a thief. 

public void addThief(): Adds a thief the room.

## How To Run

Assuming you have java 11 on your machine, run the following command:
java -jar *your-path-to-the-file-project05.jar*

To run in GUI mode, no command-line are needed.

To run in console-based mode, command-line arguments needed are: size of the dungeon, its interconnectivity, whether it is wrapping or not, and the percentage of the caves that have treasure, and the number of monsters desired, and number of pits desired.

The player will automatically start from the start position and will be prompted to select the next command from the following: M (Move), P (Pickup), or S(Shoot),If the user selects M, he/she will be prompted for a direction. If user selects P, user should enter "arrow" if he/she wants to pick up an arrow, and "treasure" if he/she wants to pick up treasure. If a user selects S, a direction and distance is needed. After each command, the updated player description is redisplayed, until the game is over.

## How to Use the Program
If no command line arguments are supplied, the program will run in Graphical User Interface (GUI) mode. In this mode, a graphical view of the dungeon is shown to the user with the player being represented as Pokemon's Pikachu. You will be able to move the player either by clicking on the desired location you want to move in using the mouse, or  by pressing the arrow keys to provide the direction. A green smoke-like indication indicates the smell the player is currently smelling. A blue warning sign ![enter image description here](https://i.ibb.co/MBnpnPh/danger.png) will be displayed next to the player when there is a pit nearby.

To pickup arrows, you can press the A key, and to pickup treasure, please press T.

To shoot, the user will need to hold Ctrl and press one of the arrow keys which represents the direction. This will trigger a pop-up from which you can input the distance you want the arrow to travel.

In addition, you will be able to see the player description, room description, and an indication of each action at the bottom of the view. 

Furthermore, at the top of the view, you can see a menu which has several features. There is a game settings feature which allows you to view the features of the dungeon you have constructed. There is also a Quit button from which you can exit the program and terminate it. There is also an option to restart the game using the same dungeon, and a feature to start a completely new game. Also, at the top of your screen there is images of the different types of treasure and an arrow with integer next to them, indicating the number of each the player currently holds. 

In addition, pop-up messages will be displayed when a player picks up arrow or treasure and when he/shoots, indicating the result of those actions and if they were successful or not.

If you want to run the console-based version of the game, you must first construct a dungeon and provide several arguments/attributes for the dungeon. These attributes include the number of rows of the dungeon, the number of columns, the interconnectivity, whether it is wrapping or not, and the percentage of the caves that have treasure, and the number of pits.
After constructing the dungeon, the player will start at the start position of the dungeon, the player description will be displayed, which has information about what the player possesses and what the possible next directions to move to. Move, Pickup, or Shoot (M-P-S)?  will be displayed, where M (Move), P (Pickup), or S(Shoot). If the user selects M, he/she will be prompted for a direction. If user selects P, user should enter "arrow" if he/she wants to pick up an arrow, and "treasure" if he/she wants to pick up treasure. If a user selects S, a direction and distance is needed. After each command, the updated player description is redisplayed, until the game is over.

## Description of Examples
First the user is prompted for the parameters of the dungeon , like so:![Input box](https://i.ibb.co/j8gpQw6/1.png)

And then, the user can start playing. As we can see, the player is represented by Pikachu, and there are rooms with arrows and/or treasure. We can also see at the bottom, there is a provided description of the player, the room, and the result of the last action.

There is also the menu at the top of the screen with the Quit, New Game, and Restart This Game buttons. There is also a visual display on the right of the Restart This Game button that is a representation of the amount of treasure and arrows the player holds. For example, in this case the player holds 1 sapphire and 7 arrows.

We can also see a blue warning sign next the player, indicating that there is a pit nearby. A thief is also seen on the 2nd column and 2nd row.
![Screenshot](https://i.ibb.co/v4ZvPtj/2.png)

## Design/Model Changes

<li>Added a number of pits argument in the Dungeon.</li> 
<li>Added a 2d-boolean attribute in Dungeon that keeps track of the
player's visited locations. </li> 
<li>Added the functionality to clear the dungeon, and initializing it to its initial states.</li>
<li>Added an initial grid and initial number of monsters attributes which 
will help in being able to restart the game. </li>
<li>Added 2 boolean attributes: fellInPit, and gotStolenFrom which will help
notify the user if he/she fell in a pit or has been stolen from the thief. </li>
<li>Added the following methods to the IDungeon interface: 
getVisitedLocations(), getDungeon(), clearDungeon(), didPlayerFallInPit(), didPlayerGetRobbed()</li>
<li> Also added under the hood functionality in order to add pits and a thief to the dungeon.</li>
<li> Made the shoot method return an integer which could be either -1 (indicating no moster was hit), 0 (meaning monster was hit) or 1 (monster was killed) . </li>
<li>Added the functionality to remove treasures from a player (in IPlayer).</li>
<li> Added a GuiController interface and implemented it in the DungeonSwingController class. This is done to help display the GUI. </li>
<li>Added a IView interface and implemented it in the DungeonGraphicView class, this displays the GUI shown to the user.</li>
<li>Added MockView which implements IView interface for testing.</li>
<li>Added DungeonPanel which extends JPanel, which displays the dungeon part of the view.</li>
<li>Added InputBox which extends JFrame, which displays the input boxes needed to construct the Dungeon.</li>

## Assumptions. 
<li>There is only 1 thief in the dungeon which is always placed at a specific location.</li>  
<li>You cannot kill a thief.</li>  
<li>The thief is fixed and does not move from his initial position.</li>  
<li>No pits places at start and end locations.</li>  
<li>A thief steals only treasure (and not arrows)</li>  
<li>Player will only get an indication that he/she is close to a pit when the pit is 1 rom away from the player's current position.</li>  
<li>The end location in the dungeon is a cave and not a tunnel.</li>  
<li>There is no limit to the number of treasure the player can hold.</li>  
<li>There is no limit to the number of arrows the player can hold.</li>  
<li>Arrows disappear after they are shot, even if they are unsuccessful.</li>  
<li>A player starts out with 3 arrows.</li>  
<li>There will at least 1 monster in the dungeon, placed at the end cave,</li>  
<li>The percentage of caves with treasure specified is equal to the percentage of rooms with arrows in them.</li>  
<li>Monsters are only allowed in caves.</li>  
<li>A cave can only inhabit one monster</li>  
<li>Only caves can hold treasure.</li>  
<li>Caves can have 1 piece of treasure at random.</li>  
<li>There should be at least a length of 5 between the start and end point.</li> 
<li>There are a maximum of 4 directions a player can move in: North, South, East and West. No diagonal movements allowed.</li> 
<li> Only one type of monster exists: Otyugh </li>
<li>Arrows are remove when invalid direction given</li>
<li>If the number of monsters is greater than the number of caves, then the number of monsters becomes equal to the number of caves.</li>
## Limitations
The limitations of this program include not having a limit to the number of treasure the player can hold or the number of arrows, caves only having 1 piece of treasure selected at random, and not being able to move diagonally or anti diagonally. In addition, not being able to pick up shot arrows is another limitation of the program, and that there are only one type of monster in the dungeon: Otyugh. 

There is only 1 thief in the dungeon which is always placed at a specific location, and a thief only steals treasure. He does not steal the arrows.  You cannot kill a thief. The thief is fixed and does not move from his initial position.

## Citations
https://docs.oracle.com/javase/tutorial/uiswing/



