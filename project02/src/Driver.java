import battle.Battle;
import battle.IBattle;
import battle.IPlayer;
import battle.Player;
import randomize.MockRandomness;
import randomize.Randomness;

import java.util.Scanner;

/**
 * A driver class that displays a run of the program/battle.
 */

public class Driver {

  /**
   * A main method that runs and displays a battle.
   */

  public static void main(String[] args) {

    System.out.println("*******************WELCOME TO THE ARENA********************");
    int seed = -10;
    Randomness randomness = new MockRandomness();
    IPlayer p1 = new Player("player1",randomness.generateValueBetween(6, 18),
            randomness.generateValueBetween(6, 18),randomness.generateValueBetween(6, 18),
            randomness.generateValueBetween(6, 18), seed);
    IPlayer p2 = new Player("player2",randomness.generateValueBetween(6, 18),
            randomness.generateValueBetween(6, 18),randomness.generateValueBetween(6, 18),
            randomness.generateValueBetween(6, 18), seed);

    System.out.println(p1.getDescription());
    System.out.println("Health of the 1st player is : " + p1.getHealth());

    System.out.println(p1.getDescription());
    System.out.println("Health of the 2nd player is : " + p2.getHealth());

    System.out.println("LET THE BATTLE BEGIN");

    IBattle battle = new Battle(p1, p2, seed);
    battle.equipGears();
    battle.equipWeapons();
    System.out.println("PLAYERS HAVE BEEN FULLY EQUIPPED WITH WEAPONS AND GEAR");

    for (int i = 0; i < 10; i++) {
      System.out.println(p1.getDescription());
      System.out.println(p2.getDescription());

      while (battle.getWinner() == null) {

        System.out.println("PLAYERS HAVE FULL HEALTH");
        System.out.println(String.format("It is %s's turn now", battle.whoseTurnIsIt()));
        System.out.println(String.format("%s's attacks", battle.whoseTurnIsIt()));
        System.out.println("Battling");
        int initialHealthForPlayer1 = battle.getHealthOfPlayer1();
        int initialHealthForPlayer2 = battle.getHealthOfPlayer2();
        battle.attack();

        if (initialHealthForPlayer1 == battle.getHealthOfPlayer1()) {
          System.out.println(String.format("Damage Done: %d",
                  initialHealthForPlayer2 - battle.getHealthOfPlayer2()));
        }
        else {
          System.out.println(String.format("Damage Done: %d",
                  initialHealthForPlayer1 - battle.getHealthOfPlayer1()));
        }

        System.out.println("Health of the 1st player is : " + battle.getHealthOfPlayer1());
        System.out.println("Health of the 2nd player is : " + battle.getHealthOfPlayer2());
      }


      System.out.println("The winner is " + battle.getWinner());

      Scanner scanner = new Scanner(System.in);
      System.out.println("Do you want a rematch: Y/N");

      String input = scanner.nextLine();
      if (!input.equals("Y")) {
        return;
      }
      battle.rematch();
    }


  }
}
