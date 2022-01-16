package assignments;

import java.util.Collections;
import java.util.List;

/**
 * A scheduling strategy based on the order of the assignment deadlines.
 */

public class DeadlineSchedulingStrategy implements SchedulingStrategy {
  @Override
  public String schedule(List<Assignment> assignmentList) {
    if (assignmentList == null || assignmentList.isEmpty()) {
      throw new IllegalArgumentException("List can't be null.");
    }

    Collections.sort(assignmentList, (a, b) -> {
      if (b.getEndDate().compareTo(a.getEndDate()) == 0) {
        return a.compareTo(b);
      }

      else {
        return a.getEndDate().compareTo(b.getEndDate());
      }
    });

    return "deadline";
  }
}
