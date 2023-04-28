package questions;

/**
 * This class represents a likert question which asks for
 * an opinion from a 1 - 5 scale where 1 means strongly
 * agree and 5 means strongly disagree.
 */

public class Likert extends AbstractQuestion {

  /**
   * A constructor for the Likert taking in the text.
   * @param text the question description
   */

  public Likert(String text) {
    super(text, "1 2 3 4 5", new String[]{"1", "2", "3", "4", "5"});
  }

  @Override
  public String answer(String answer) {
    for (String option: options) {
      if (option.equals(answer.trim())) {
        return CORRECT;
      }
    }
    return INCORRECT;
  }

  @Override
  protected int compareMultipleChoice(MultipleChoice other) {
    return 1;
  }

  @Override
  protected int compareMultipleSelection(MultipleSelect other) {
    return 1;
  }

  @Override
  protected int compareTrueFalse(TrueFalse other) {
    return 1;
  }

  @Override
  public int compareTo(Question o) {

    if (o instanceof AbstractQuestion) {
      AbstractQuestion abstractQuestion = (AbstractQuestion) o;
      return -abstractQuestion.compareLikert(this);
    }
    return -1;
  }
}