package questions;

/**
 * This class represents a multiple choice question where one and only one option is correct.
 */

public class MultipleChoice extends AbstractQuestion {

  /**
   * A constructor for the MultipleChoice taking in the text.
   * @param text the question description
   * @param correctAnswer the correct choice between the options
   * @param options the choices available to choose from
   * @throws IllegalArgumentException if the options not between 3 and 8
   *         or if the correct answer is not within the options given
   */

  public MultipleChoice(String text, String correctAnswer, String... options) {
    super(text, correctAnswer, options);
    if (options.length < 3 || options.length > 8) {
      throw new IllegalArgumentException("Number of options should be between 3 and 8");
    }
    if (!correctAnswerInOptions(correctAnswer.trim(), options)) {
      throw new IllegalArgumentException("Correct Answer not within the options given");
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
  protected int compareMultipleSelection(MultipleSelect other) {
    return -1;
  }

  @Override
  protected int compareTrueFalse(TrueFalse other) {
    return 1;
  }

  @Override
  public int compareTo(Question o) {
    if (o instanceof AbstractQuestion) {
      AbstractQuestion abstractQuestion = (AbstractQuestion) o;
      return -abstractQuestion.compareMultipleChoice(this);
    }
    return -1;
  }
}


