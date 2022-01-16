package cs3500;

import cs3500.control.IController;
import cs3500.control.MVCCommandController;
import cs3500.tracingmodel.SmarterTurtle;
import cs3500.tracingmodel.TracingTurtleModel;
import cs3500.view.IView;
import cs3500.view.TurtleGraphicsView;

/**
 * Created by ashesh on 10/26/2016.
 */
public class TurtleRunner {
  public static void main(String[] args) {
    //System.out.println(Arrays.toString(args));
    TracingTurtleModel model = new SmarterTurtle();
    IView view = new TurtleGraphicsView();
    IController controller = new MVCCommandController(model,view);
    controller.go();
  }
}
