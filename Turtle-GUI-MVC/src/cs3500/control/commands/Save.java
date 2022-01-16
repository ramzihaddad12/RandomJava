package cs3500.control.commands;

import cs3500.control.TracingTurtleCommand;
import cs3500.tracingmodel.TracingTurtleModel;

/**
 * Created by ashesh on 10/28/2016.
 */
public class Save implements TracingTurtleCommand{

  @Override
  public void go(TracingTurtleModel m) {
    m.save();
  }
}
