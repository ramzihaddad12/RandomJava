package assignments;

import java.util.Collections;
import java.util.List;

/**
 * A scheduling strategy based on the order of the assignment assigned dates.
 */

public class AssignedSchedulingStrategy implements SchedulingStrategy {
  @Override
  public String schedule(List<Assignment> assignmentList) {
    if (assignmentList == null || assignmentList.isEmpty()) {
      throw new IllegalArgumentException("List can't be null.");
    }

    Collections.sort(assignmentList, (a, b) -> a.getNumber() - b.getNumber());
    return "assigned";
  }
}
