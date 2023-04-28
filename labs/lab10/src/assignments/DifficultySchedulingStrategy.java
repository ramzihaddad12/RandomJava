package assignments;

import java.util.Collections;
import java.util.List;

/**
 * A scheduling strategy based on the order of the assignment difficulties.
 */

public class DifficultySchedulingStrategy implements SchedulingStrategy {
  @Override
  public String schedule(List<Assignment> assignmentList) {
    if (assignmentList == null || assignmentList.isEmpty()) {
      throw new IllegalArgumentException("List can't be null.");
    }

    Collections.sort(assignmentList, (a, b) -> {
      if (b.getDifficulty() == a.getDifficulty()) {
        return a.compareTo(b);
      }

      else {
        return b.getDifficulty() - a.getDifficulty();
      }
    });
    return "difficulty";
  }
}
