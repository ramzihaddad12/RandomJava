package dungeon;

import java.io.IOException;
import java.util.Scanner;

/**
 * An implemention for a console controller for the
 * dungeon.
 */

public class DungeonController implements IDungeonController {

  private final Appendable out;
  private final Scanner scan;

  /**
   * Constructor for the controller.
   *
   * @param out the target to print to
   * @param in the source to read from
   */
  public DungeonController(Appendable out, Readable in) {
    if (in == null || out == null) {
      throw new IllegalArgumentException("Readable and Appendable can't be null");
    }
    this.out = out;
    this.scan = new Scanner(in);
  }

  @Override
  public void playGame(IDungeon m) {
    if (m == null) {
      throw new IllegalArgumentException();
    }

    while (!m.isGameOver()) {
      try {
        this.out.append(m.getPlayerDescription());
        this.out.append("\nMove, Pickup, or Shoot (M-P-S)? ");

        boolean haveCommand = false;
        String command = null;
        while (!haveCommand) {
          String input = scan.next();

          if (input.equals("M")) {
            command = "M";
            haveCommand = true;
          }

          else if (input.equals("P")) {
            command = "P";
            haveCommand = true;
          }

          else if (input.equals("S")) {
            command = "S";
            haveCommand = true;
          }

          else {
            out.append(String.format("Not a valid command. Try again: "));
          }
        }

        if (command.equals("M")) {
          this.out.append("\nWhere to? ");

          boolean success = false;
          Direction direction = null;
          while (!success) {
            String inputDirection = scan.next();

            if (inputDirection.equals("N")) {
              direction = Direction.NORTH;
              success = true;
            }

            else if (inputDirection.equals("S")) {
              direction = Direction.SOUTH;
              success = true;
            }

            else if (inputDirection.equals("E")) {
              direction = Direction.EAST;
              success = true;
            }

            else if (inputDirection.equals("W")) {
              direction = Direction.WEST;
              success = true;
            }

            if (success) {
              try {
                m.movePlayer(direction);
              } catch (IllegalArgumentException e) {
                success = false;
                this.out.append("Impossible direction. Try again: ");
              }
            }

            else {
              this.out.append("Invalid direction. Try again: ");
            }
          }
        }

        else if (command.equals("P")) {
          boolean success = false;
          this.out.append("What? ");
          success = false;
          while (!success) {
            String inputObject = scan.next();

            if (inputObject.equals("arrow")) {
              success = true;
              boolean pickUp = m.pickUpArrows();

              if (pickUp) {
                this.out.append("You pick up an arrow\n");
              }

              else {
                this.out.append("No arrows here\n");
              }
            }

            else if (inputObject.equals("treasure")) {
              success = true;
              boolean pickUp = m.pickUpTreasure();

              if (pickUp) {
                this.out.append("You pick up some treasure\n");
              }

              else {
                this.out.append("No treasure here\n");
              }

            }

            else {
              out.append(String.format("Not a valid command. Try again: "));
            }
          }
        }

        else if (command.equals("S")) {
          boolean bothSuccess = false;
          while (!bothSuccess) {
            this.out.append("\nWhere to? ");
            boolean success = false;
            Direction direction = null;
            while (!success) {
              String inputDirection = scan.next();

              if (inputDirection.equals("N")) {
                direction = Direction.NORTH;
                success = true;
              }

              else if (inputDirection.equals("S")) {
                direction = Direction.SOUTH;
                success = true;
              }

              else if (inputDirection.equals("E")) {
                direction = Direction.EAST;
                success = true;
              }

              else if (inputDirection.equals("W")) {
                direction = Direction.WEST;
                success = true;
              }

              else {
                this.out.append("Invalid direction. Try again: ");
              }
            }

            this.out.append("\nNo. of caves/ distance? ");

            boolean success2 = false;
            Integer distance = null;
            while (!success2) {
              String input = scan.next();
              try {
                int inputInteger = Integer.parseInt(input);
                success2 = true;
                distance = inputInteger;
              }
              catch (NumberFormatException e) {
                this.out.append("Distance should be an integer");
                continue;
              }
            }

            if (success2) {
              try {
                int result = m.shoot(distance, direction);
                if (result == 1) {
                  this.out.append("Shot successful! You hear a great howl in the distance\n");
                }

                else if (result == 0) {
                  this.out.append("Shot successful! You hear a great howl in the distance\n");
                }

                else {
                  this.out.append("Shot unsuccessful! You shoot an arrow into the darkness\n");
                }
                bothSuccess = true;
              }
              catch (IllegalArgumentException e) {
                this.out.append(e.getMessage() + "\n");
                this.out.append("Invalid shot. Try again: \n");
              }

              catch (IllegalStateException e) {
                this.out.append(e.getMessage() + "\n");
                bothSuccess = true;
              }
            }
          }

        }

        this.out.append("\n\n");
      }

      catch (IOException e) {
        e.printStackTrace();
      }
    }

    try {
      if (!m.isDidPlayerWin()) {
        this.out.append("\nChomp, chomp, chomp, you are eaten by an Otyugh!\n"
                + "Better luck next time");
      }
      else {
        this.out.append("You are victorious!");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
