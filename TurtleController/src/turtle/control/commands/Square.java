package turtle.control.commands;

import turtle.control.TracingTurtleCommand;
import turtle.tracingmodel.TracingTurtleModel;

/**
 * Created by blerner on 10/10/16.
 */
public class Square implements TracingTurtleCommand {
  private double d;

  /**
   * Constructor.
   * 
   * @param d The size of the square
   */
  public Square(double d) {
    this.d = d;
  }

  @Override
  public void go(TracingTurtleModel m) {
    if (m == null) {
      throw new IllegalArgumentException("model cannot be null");
    }
    for (int i = 0; i < 4; i++) {
      m.trace(this.d);
      m.turn(90);
    }
  }
}
