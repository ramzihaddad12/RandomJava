package cs3500.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import cs3500.control.commands.Koch;
import cs3500.control.commands.Move;
import cs3500.control.commands.Retrieve;
import cs3500.control.commands.Save;
import cs3500.control.commands.Square;
import cs3500.control.commands.Trace;
import cs3500.control.commands.Turn;
import cs3500.tracingmodel.TracingTurtleModel;
import cs3500.view.IView;

/**
 * This is a controller that is very similar to the
 * CommandController class. The main difference
 * is that the main is replaced with the controller
 * method processCommand
 */
public class MVCCommandController implements IController, ActionListener {
  private TracingTurtleModel model;
  private IView view;

  public MVCCommandController(TracingTurtleModel model, IView view) {
    this.model = model;
    this.view = view;
  }

  @Override
  public void go() {
    this.view.setCommandButtonListener(this);
    this.view.makeVisible();
  }

  @Override
  public String processCommand(String command) {
    StringBuilder output = new StringBuilder();
    Scanner s = new Scanner(command);
    TracingTurtleCommand cmd = null;

    while (s.hasNext()) {
      String in = s.next();
      switch (in) {
        case "move":
          cmd = new Move(s.nextDouble());
          break;
        case "trace":
          cmd = new Trace(s.nextDouble());
          break;
        case "turn":
          cmd = new Turn(s.nextDouble());
          break;
        case "square":
          cmd = new Square(s.nextDouble());
          break;
        case "koch":
          cmd = new Koch(s.nextDouble(), s.nextInt());
          break;
        case "save":
          cmd = new Save();
          break;
        case "retrieve":
          cmd = new Retrieve();
          break;
        default:
          //output.append(String.format("Unknown command %s", in));
          throw new IllegalArgumentException("Unknown command " + in);
          //cmd = null;
          //break;
      }
      cmd.go(model);
      output.append("Successfully executed: " + command);
    }

    return output.toString();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String command = view.getTurtleCommand();
    String status;

    try {
      status = processCommand(command);
      view.setLines(model.getLines());
      //set turtle position and heading
      view.setTurtlePosition(model.getPosition());
      view.setTurtleHeading(model.getHeading());
      view.refresh();
    }
    catch (Exception ex) {
      view.showErrorMessage(ex.getMessage());
    }
  }
}
