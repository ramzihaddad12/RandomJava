package assignments;

import java.util.List;

/**
 * A scheduling strategy interface that schedules the assignments for the user.
 */

public interface SchedulingStrategy {

  /**
   * A method that does the scheduling a list of assignments.
   * @param assignmentList a list of assignments.
   * @return a string with the name of the strategy that was used.
   */
  public String schedule(List<Assignment> assignmentList);
}
