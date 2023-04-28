import static org.junit.Assert.assertEquals;

import assignments.AlphabeticalSchedulingStrategy;
import assignments.AssignedSchedulingStrategy;
import assignments.Assignment;
import assignments.AssignmentList;
import assignments.DeadlineSchedulingStrategy;
import assignments.DifficultySchedulingStrategy;
import assignments.SchedulingStrategy;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/** Class that tests the tasks. */
public class AssignmentTest {
  private Assignment t1;
  private Assignment t2;
  private Assignment t3;
  private Assignment t4;

  private AssignmentList list;
  private SchedulingStrategy alphabeticalSchedulingStrategy;
  private SchedulingStrategy assignedSchedulingStrategy;
  private SchedulingStrategy deadlineSchedulingStrategy;
  private SchedulingStrategy difficultySchedulingStrategy;

  /**
   * A method that sets up and instantiates all the needed
   * variables.
   */
  @Before
  public void setUp() {
    t1 = new Assignment("task 1");
    t1.setDeadline(3, 4, 2022);
    t1.setStart(3, 2, 2022);

    t2 = new Assignment("task 2");
    t2.setDeadline(3, 10, 2022);
    t2.setStart(3, 3, 2022);

    t3 = new Assignment("task 3");
    t3.setDeadline(3, 15, 2022);
    t3.setStart(3, 14, 2022);

    t4 = new Assignment("task 4");
    t4.setDeadline(3, 14, 2022);
    t4.setStart(3, 14, 2022);

    list = new AssignmentList();
    list.add(t4);
    list.add(t3);
    list.add(t2);
    list.add(t1);

    alphabeticalSchedulingStrategy
            = new AlphabeticalSchedulingStrategy();
    assignedSchedulingStrategy
            = new AssignedSchedulingStrategy();
    deadlineSchedulingStrategy
            = new DeadlineSchedulingStrategy();
    difficultySchedulingStrategy
            = new DifficultySchedulingStrategy();
  }

  /** Testing constructor and toString(). */
  @Test
  public void testConstructor() {
    assertEquals("task 1, starting " + "2022-03-02" + ", ending 2022-03-04", t1.toString());
    assertEquals("task 2, starting " + "2022-03-03" + ", ending 2022-03-10", t2.toString());
    assertEquals("task 3, starting " + "2022-03-14" + ", ending 2022-03-15", t3.toString());
    assertEquals("task 4, starting " + "2022-03-14" + ", ending 2022-03-14", t4.toString());
  }

  /** Testing schedule assignments by alphabetical order. */
  @Test
  public void testScheduleAssignmentsByAlphabeticalOrder() {
    list.scheduleAssignments(alphabeticalSchedulingStrategy);
    String expectedString = "Ordered by alphabetical\n"
            + "1 -- task 1, starting 2022-03-02, ending 2022-03-04\n"
            + "2 -- task 2, starting 2022-03-03, ending 2022-03-10\n"
            + "3 -- task 3, starting 2022-03-14, ending 2022-03-15\n"
            + "4 -- task 4, starting 2022-03-14, ending 2022-03-14\n";
    assertEquals(expectedString, list.toString());
  }

  /** Testing schedule assignments by alphabetical order
   * after another strategy has been used. */
  @Test
  public void testScheduleAssignmentsByAlphabeticalOrderAfterAnotherStrategyHasBeenUsed() {
    list.scheduleAssignments(deadlineSchedulingStrategy);

    String expectedString = "Ordered by deadline\n"
            +  "1 -- task 1, starting 2022-03-02, ending 2022-03-04\n"
            + "2 -- task 2, starting 2022-03-03, ending 2022-03-10\n"
            + "3 -- task 4, starting 2022-03-14, ending 2022-03-14\n"
            + "4 -- task 3, starting 2022-03-14, ending 2022-03-15\n";
    assertEquals(expectedString, list.toString());

    list.scheduleAssignments(alphabeticalSchedulingStrategy);
    expectedString = "Ordered by alphabetical\n"
            + "1 -- task 1, starting 2022-03-02, ending 2022-03-04\n"
            + "2 -- task 2, starting 2022-03-03, ending 2022-03-10\n"
            + "3 -- task 3, starting 2022-03-14, ending 2022-03-15\n"
            + "4 -- task 4, starting 2022-03-14, ending 2022-03-14\n";
    assertEquals(expectedString, list.toString());
  }

  /** Testing schedule assignments by alphabetical order
   * when two assignments have the same description. */
  @Test
  public void testScheduleAssignmentsByAlphabeticalOrderWhenAssignmentsHaveSameDescription() {
    Assignment t5  = new Assignment("task 4");
    t5.setDeadline(3, 4, 2022);
    t5.setStart(3, 2, 2022);

    list.add(t5);
    list.scheduleAssignments(alphabeticalSchedulingStrategy);
    String expectedString = "Ordered by alphabetical\n"
            + "1 -- task 1, starting 2022-03-02, ending 2022-03-04\n"
            + "2 -- task 2, starting 2022-03-03, ending 2022-03-10\n"
            + "3 -- task 3, starting 2022-03-14, ending 2022-03-15\n"
            + "4 -- task 4, starting 2022-03-14, ending 2022-03-14\n"
            + "5 -- task 4, starting 2022-03-02, ending 2022-03-04\n";

    assertEquals(expectedString, list.toString());
  }

  /** Testing schedule assignments for alphabetical is not dynamic. */
  @Test
  public void testScheduleAssignmentsByAlphabeticalIsNotDynamic() {
    list.scheduleAssignments(alphabeticalSchedulingStrategy);
    String expectedString = "Ordered by alphabetical\n"
            + "1 -- task 1, starting 2022-03-02, ending 2022-03-04\n"
            + "2 -- task 2, starting 2022-03-03, ending 2022-03-10\n"
            + "3 -- task 3, starting 2022-03-14, ending 2022-03-15\n"
            + "4 -- task 4, starting 2022-03-14, ending 2022-03-14\n";
    assertEquals(expectedString, list.toString());

    Assignment t5  = new Assignment("aTask 5");
    t5.setDeadline(3, 8, 2022);
    t5.setStart(3, 2, 2022);

    list.add(t5);
    expectedString = "Ordered by alphabetical\n"
            + "1 -- task 1, starting 2022-03-02, ending 2022-03-04\n"
            + "2 -- task 2, starting 2022-03-03, ending 2022-03-10\n"
            + "3 -- task 3, starting 2022-03-14, ending 2022-03-15\n"
            + "4 -- task 4, starting 2022-03-14, ending 2022-03-14\n"
            + "5 -- aTask 5, starting 2022-03-02, ending 2022-03-08\n";
    assertEquals(expectedString, list.toString());
  }

  /** Testing schedule assignments by assignment order. */
  @Test
  public void testScheduleAssignmentsByAssignmentOrder() {
    list.scheduleAssignments(assignedSchedulingStrategy);
    String expectedString = "Ordered by assigned\n"
            + "1 -- task 1, starting 2022-03-02, ending 2022-03-04\n"
            + "2 -- task 2, starting 2022-03-03, ending 2022-03-10\n"
            + "3 -- task 3, starting 2022-03-14, ending 2022-03-15\n"
            + "4 -- task 4, starting 2022-03-14, ending 2022-03-14\n";
    assertEquals(expectedString, list.toString());
  }

  /** Testing schedule assignments by assignment order
   * after another strategy has been used. */
  @Test
  public void testScheduleAssignmentsByAssignmentOrderAfterAnotherStrategyHasBeenUsed() {
    list.scheduleAssignments(deadlineSchedulingStrategy);

    String expectedString = "Ordered by deadline\n"
            +  "1 -- task 1, starting 2022-03-02, ending 2022-03-04\n"
            + "2 -- task 2, starting 2022-03-03, ending 2022-03-10\n"
            + "3 -- task 4, starting 2022-03-14, ending 2022-03-14\n"
            + "4 -- task 3, starting 2022-03-14, ending 2022-03-15\n";
    assertEquals(expectedString, list.toString());
    list.scheduleAssignments(assignedSchedulingStrategy);
    expectedString = "Ordered by assigned\n"
            + "1 -- task 1, starting 2022-03-02, ending 2022-03-04\n"
            + "2 -- task 2, starting 2022-03-03, ending 2022-03-10\n"
            + "3 -- task 3, starting 2022-03-14, ending 2022-03-15\n"
            + "4 -- task 4, starting 2022-03-14, ending 2022-03-14\n";
    assertEquals(expectedString, list.toString());
  }

  /** Testing schedule assignments by assignment order is not dynamic. */
  @Test
  public void testScheduleAssignmentsByAssignmentOrderIsNotDynamic() {
    list.scheduleAssignments(assignedSchedulingStrategy);
    String expectedString = "Ordered by assigned\n"
            + "1 -- task 1, starting 2022-03-02, ending 2022-03-04\n"
            + "2 -- task 2, starting 2022-03-03, ending 2022-03-10\n"
            + "3 -- task 3, starting 2022-03-14, ending 2022-03-15\n"
            + "4 -- task 4, starting 2022-03-14, ending 2022-03-14\n";
    assertEquals(expectedString, list.toString());

    Assignment t5 = new Assignment("task 5");
    t5.setDeadline(3, 4, 2022);
    t5.setStart(3, 2, 2022);

    list.add(t5);
    expectedString = "Ordered by assigned\n"
            + "1 -- task 1, starting 2022-03-02, ending 2022-03-04\n"
            + "2 -- task 2, starting 2022-03-03, ending 2022-03-10\n"
            + "3 -- task 3, starting 2022-03-14, ending 2022-03-15\n"
            + "4 -- task 4, starting 2022-03-14, ending 2022-03-14\n"
            + "5 -- task 5, starting 2022-03-02, ending 2022-03-04\n";

    assertEquals(expectedString, list.toString());
  }

  /** Testing schedule assignments by deadline order. */
  @Test
  public void testScheduleAssignmentsByDeadlineOrder() {
    list.scheduleAssignments(deadlineSchedulingStrategy);

    String expectedString = "Ordered by deadline\n"
            +  "1 -- task 1, starting 2022-03-02, ending 2022-03-04\n"
            + "2 -- task 2, starting 2022-03-03, ending 2022-03-10\n"
            + "3 -- task 4, starting 2022-03-14, ending 2022-03-14\n"
            + "4 -- task 3, starting 2022-03-14, ending 2022-03-15\n";
    assertEquals(expectedString, list.toString());
  }

  /** Testing schedule assignments by deadline order
   * after another strategy has been used. */
  @Test
  public void testScheduleAssignmentsByDeadlineAfterAnotherStrategyHasBeenUsed() {
    list.scheduleAssignments(difficultySchedulingStrategy);
    String expectedString = "Ordered by difficulty\n"
            + "1 -- task 2, starting 2022-03-03, ending 2022-03-10\n"
            + "2 -- task 1, starting 2022-03-02, ending 2022-03-04\n"
            + "3 -- task 3, starting 2022-03-14, ending 2022-03-15\n"
            + "4 -- task 4, starting 2022-03-14, ending 2022-03-14\n";
    assertEquals(expectedString, list.toString());


    list.scheduleAssignments(deadlineSchedulingStrategy);

    expectedString = "Ordered by deadline\n"
            +  "1 -- task 1, starting 2022-03-02, ending 2022-03-04\n"
            + "2 -- task 2, starting 2022-03-03, ending 2022-03-10\n"
            + "3 -- task 4, starting 2022-03-14, ending 2022-03-14\n"
            + "4 -- task 3, starting 2022-03-14, ending 2022-03-15\n";
    assertEquals(expectedString, list.toString());


  }

  /** Testing schedule assignments by deadline order
   * when two assignments have the same deadline. */

  @Test
  public void testScheduleAssignmentsByDeadlineOrderWhenAssignmentsHaveSameDeadline() {



    Assignment t5  = new Assignment("task 5");
    t5.setDeadline(3, 10, 2022);
    t5.setStart(3, 2, 2022);

    list.add(t5);

    list.scheduleAssignments(deadlineSchedulingStrategy);
    String expectedString = "Ordered by deadline\n"
            + "1 -- task 1, starting 2022-03-02, ending 2022-03-04\n"
            + "2 -- task 2, starting 2022-03-03, ending 2022-03-10\n"
            + "3 -- task 5, starting 2022-03-02, ending 2022-03-10\n"
            + "4 -- task 4, starting 2022-03-14, ending 2022-03-14\n"
            + "5 -- task 3, starting 2022-03-14, ending 2022-03-15\n";
    assertEquals(expectedString, list.toString());
  }

  /** Testing schedule assignments for deadline is not dynamic. */
  @Test
  public void testScheduleAssignmentsByDeadlineIsNotDynamic() {
    list.scheduleAssignments(deadlineSchedulingStrategy);
    String expectedString = "Ordered by deadline\n"
            +  "1 -- task 1, starting 2022-03-02, ending 2022-03-04\n"
            + "2 -- task 2, starting 2022-03-03, ending 2022-03-10\n"
            + "3 -- task 4, starting 2022-03-14, ending 2022-03-14\n"
            + "4 -- task 3, starting 2022-03-14, ending 2022-03-15\n";
    assertEquals(expectedString, list.toString());

    Assignment t5  = new Assignment("task 5");
    t5.setDeadline(3, 8, 2022);
    t5.setStart(3, 2, 2022);

    list.add(t5);
    expectedString = "Ordered by deadline\n"
            +  "1 -- task 1, starting 2022-03-02, ending 2022-03-04\n"
            + "2 -- task 2, starting 2022-03-03, ending 2022-03-10\n"
            + "3 -- task 4, starting 2022-03-14, ending 2022-03-14\n"
            + "4 -- task 3, starting 2022-03-14, ending 2022-03-15\n"
            + "5 -- task 5, starting 2022-03-02, ending 2022-03-08\n";
    assertEquals(expectedString, list.toString());
  }

  /** Testing schedule assignments by difficulty order. */
  @Test
  public void testScheduleAssignmentsByDifficultyOrder() {
    list.scheduleAssignments(difficultySchedulingStrategy);
    String expectedString = "Ordered by difficulty\n"
            + "1 -- task 2, starting 2022-03-03, ending 2022-03-10\n"
            + "2 -- task 1, starting 2022-03-02, ending 2022-03-04\n"
            + "3 -- task 3, starting 2022-03-14, ending 2022-03-15\n"
            + "4 -- task 4, starting 2022-03-14, ending 2022-03-14\n";
    assertEquals(expectedString, list.toString());
  }

  /** Testing schedule assignments by difficulty order
   * after another strategy has been used. */
  @Test
  public void testScheduleAssignmentsByDifficultyAfterAnotherStrategyHasBeenUsed() {
    list.scheduleAssignments(deadlineSchedulingStrategy);

    String expectedString = "Ordered by deadline\n"
            +  "1 -- task 1, starting 2022-03-02, ending 2022-03-04\n"
            + "2 -- task 2, starting 2022-03-03, ending 2022-03-10\n"
            + "3 -- task 4, starting 2022-03-14, ending 2022-03-14\n"
            + "4 -- task 3, starting 2022-03-14, ending 2022-03-15\n";
    assertEquals(expectedString, list.toString());

    list.scheduleAssignments(difficultySchedulingStrategy);
    expectedString = "Ordered by difficulty\n"
            + "1 -- task 2, starting 2022-03-03, ending 2022-03-10\n"
            + "2 -- task 1, starting 2022-03-02, ending 2022-03-04\n"
            + "3 -- task 3, starting 2022-03-14, ending 2022-03-15\n"
            + "4 -- task 4, starting 2022-03-14, ending 2022-03-14\n";
    assertEquals(expectedString, list.toString());
  }

  /** Testing schedule assignments by difficulty order
   * when two assignments have the same difficulty. */

  @Test
  public void testScheduleAssignmentsByDifficultyOrderWhenAssignmentsHaveSameDifficulty() {


    Assignment t5  = new Assignment("task 5");
    t5.setDeadline(3, 7, 2022);
    t5.setStart(3, 5, 2022);

    list.add(t5);
    list.scheduleAssignments(difficultySchedulingStrategy);
    String expectedString = "Ordered by difficulty\n"
            + "1 -- task 2, starting 2022-03-03, ending 2022-03-10\n"
            + "2 -- task 1, starting 2022-03-02, ending 2022-03-04\n"
            + "3 -- task 5, starting 2022-03-05, ending 2022-03-07\n"
            + "4 -- task 3, starting 2022-03-14, ending 2022-03-15\n"
            + "5 -- task 4, starting 2022-03-14, ending 2022-03-14\n";
    assertEquals(expectedString, list.toString());
  }

  /** Testing schedule assignments for difficulty is not dynamic. */
  @Test
  public void testScheduleAssignmentsByDifficultyIsNotDynamic() {
    list.scheduleAssignments(difficultySchedulingStrategy);
    String expectedString = "Ordered by difficulty\n"
            + "1 -- task 2, starting 2022-03-03, ending 2022-03-10\n"
            + "2 -- task 1, starting 2022-03-02, ending 2022-03-04\n"
            + "3 -- task 3, starting 2022-03-14, ending 2022-03-15\n"
            + "4 -- task 4, starting 2022-03-14, ending 2022-03-14\n";
    assertEquals(expectedString, list.toString());

    Assignment t5  = new Assignment("task 5");
    t5.setDeadline(3, 20, 2022);
    t5.setStart(3, 2, 2022);

    list.add(t5);
    expectedString = "Ordered by difficulty\n"
            + "1 -- task 2, starting 2022-03-03, ending 2022-03-10\n"
            + "2 -- task 1, starting 2022-03-02, ending 2022-03-04\n"
            + "3 -- task 3, starting 2022-03-14, ending 2022-03-15\n"
            + "4 -- task 4, starting 2022-03-14, ending 2022-03-14\n"
            + "5 -- task 5, starting 2022-03-02, ending 2022-03-20\n";
    assertEquals(expectedString, list.toString());
  }

  /** Testing schedule assignments when strategy is null. */
  @Test(expected = IllegalArgumentException.class)
  public void testScheduleAssignmentsWhenStrategyIsNull() {


    list.scheduleAssignments(null);
  }

  /** Testing schedule when list is empty. */
  @Test(expected = IllegalArgumentException.class)
  public void testScheduleWhenListIsEmpty() {
    List<Assignment> emptyList = new ArrayList<>();
    deadlineSchedulingStrategy.schedule(emptyList);
  }

  /** Testing schedule when list is null. */
  @Test(expected = IllegalArgumentException.class)
  public void testScheduleWhenListIsNull() {
    deadlineSchedulingStrategy.schedule(null);
  }
}
