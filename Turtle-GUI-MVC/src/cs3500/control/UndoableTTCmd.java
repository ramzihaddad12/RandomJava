package cs3500.control;

import cs3500.tracingmodel.TracingTurtleModel;

/**
 * Created by blerner on 10/10/16.
 */
public interface UndoableTTCmd extends TracingTurtleCommand {
  void undo(TracingTurtleModel m);
}
