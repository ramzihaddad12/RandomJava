package turtle.tracingmodel;

import turtle.model.Position2D;
import turtle.model.SimpleTurtle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by blerner on 10/10/16.
 */
public class SmarterTurtle extends SimpleTurtle implements TracingTurtleModel {
  // list of lines traced since this object was created
  private List<Line> lines;

  /** Default constructor. */
  public SmarterTurtle() {
    super();
    lines = new ArrayList<Line>();
  }

  @Override
  public void trace(double distance) {
    Position2D cur = this.getPosition();
    move(distance);
    lines.add(new Line(cur, this.getPosition()));
  }

  @Override
  public List<Line> getLines() {
    // make a copy rather than sharing our private list
    return new ArrayList<>(lines);
  }
}
