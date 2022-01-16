package cs3500.control.commands;

import cs3500.control.TracingTurtleCommand;
import cs3500.tracingmodel.TracingTurtleModel;

/**
 * Created by blerner on 10/10/16.
 */
public class Move implements TracingTurtleCommand {
  double d;

  public Move(Double d) {
    this.d = d;
  }

  @Override
  public void go(TracingTurtleModel m) {
    m.move(this.d);
  }
}
