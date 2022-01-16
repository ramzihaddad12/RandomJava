package turtle.control;

import turtle.control.commands.Koch;
import turtle.control.commands.Move;
import turtle.control.commands.Square;
import turtle.control.commands.Trace;
import turtle.control.commands.Turn;
import turtle.tracingmodel.Line;
import turtle.tracingmodel.SmarterTurtle;
import turtle.tracingmodel.TracingTurtleModel;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.function.Function;

/**
 * Created by blerner on 10/10/16.
 */
public class ExtensibleController {
  /**
   * Starting point of our example.
   * 
   * @param args Not used
   */
  public static void main(String[] args) {
    TracingTurtleModel m = new SmarterTurtle();
    Stack<TracingTurtleCommand> commands = new Stack<>();

    Map<String, Function<Scanner, TracingTurtleCommand>> knownCommands = new HashMap<>();
    knownCommands.put("move", s -> new Move(s.nextDouble()));
    knownCommands.put("turn", s -> new Turn(s.nextDouble()));
    knownCommands.put("trace", s -> new Trace(s.nextDouble()));
    knownCommands.put("square", (Scanner s) -> {
      return new Square(s.nextDouble());
    });
    knownCommands.put("koch", (Scanner s) -> {
      return new Koch(s.nextDouble(), s.nextInt());
    });
    knownCommands.put("show", (Scanner s) -> {
      return (TracingTurtleModel model) -> {
        for (Line l : model.getLines()) {
          System.out.println(l);
        }
      };
    });

    Scanner scan = new Scanner(System.in);
    while (scan.hasNext()) {
      TracingTurtleCommand c;
      String in = scan.next();
      if (in.equalsIgnoreCase("q") || in.equalsIgnoreCase("quit")) {
        return;
      }
      Function<Scanner, TracingTurtleCommand> cmd = knownCommands.getOrDefault(in, null);
      if (cmd == null) {
        throw new IllegalArgumentException();
      } else {
        c = cmd.apply(scan);
        commands.add(c);
        c.go(m);
      }
    }
  }
}
