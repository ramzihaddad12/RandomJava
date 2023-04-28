package assignments;

import java.util.Collections;
import java.util.List;

/**
 * A scheduling strategy based on the alphabetical order of the assignment descriptions.
 */
public class AlphabeticalSchedulingStrategy implements SchedulingStrategy {
  @Override
  public String schedule(List<Assignment> assignmentList) {
    if (assignmentList == null || assignmentList.isEmpty()) {
      throw new IllegalArgumentException("List can't be null.");
    }

    Collections.sort(assignmentList);
    return "alphabetical";
  }
}
