package questions;

/**
 * This class represents a true or false question where only there are only 2 options.
 */

public class TrueFalse extends AbstractQuestion {
  private static final String TRUE = "True";
  private static final String FALSE = "False";
  private static final String[] options = new String[]{TRUE, FALSE};

  /**
   * A constructor for the TrueFalse taking in the text.
   * @param text the question description
   * @param correctAnswer the correct choice between the options
   * @throws IllegalArgumentException if the correct answer is not true or false
   *         or if the correct answer is not within the options given
   */

  public TrueFalse(String text, String correctAnswer) {
    super(text, correctAnswer, options);
    if (!correctAnswer.equals("True") && !correctAnswer.equals("False")) {
      throw new IllegalArgumentException("Correct answer should be either True or False");
    }
  }

  @Override
  public String answer(String answer) {
    return answer.trim().equals(correctAnswer) ? CORRECT : INCORRECT;
  }

  @Override
  protected int compareLikert(Likert other) {
    return -1;
  }

  @Override
  protected int compareMultipleChoice(MultipleChoice other) {
    return -1;
  }

  @Override
  protected int compareMultipleSelection(MultipleSelect other) {
    return -1;
  }

  @Override
  public int compareTo(Question o) {
    if (o instanceof AbstractQuestion) {
      AbstractQuestion abstractQuestion = (AbstractQuestion) o;
      return -abstractQuestion.compareTrueFalse(this);
    }
    return -1;
  }
}