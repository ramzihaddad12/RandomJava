package questions;

import java.util.Arrays;

/**
 * This class represents a multiple select question where multiple options can be correct.
 */

public class MultipleSelect extends AbstractQuestion {

  /**
   * A constructor for the MultipleSelect taking in the text.
   * @param text the question description
   * @param correctAnswer the correct choice(s) between the options
   * @param options the choices available to choose from
   * @throws IllegalArgumentException if the options not between 3 and 8
   *         or if the correct answer is not within the options given
   */
  public MultipleSelect(String text, String correctAnswer, String... options) {
    super(text, correctAnswer, options);
    if (options.length < 3 || options.length > 8) {
      throw new IllegalArgumentException("Number of options should be between 3 and 8");
    }

    String[] correctAnswers = correctAnswer.trim().split("\\s+");
    for (String answer: correctAnswers) {
      if (!correctAnswerInOptions(answer, options)) {
        throw new IllegalArgumentException("Correct Answer not within the options given");
      }
    }
  }

  //https://stackoverflow.com/questions/16524709/finding-if-an-array-contains-all-elements-in-another-array
  @Override
  public String answer(String answer) {
    String[] splitCorrectAnswers = correctAnswer.trim().split("\\s+");
    String[] splitAnswers = answer.trim().split("\\s+");

    if (splitAnswers.length != splitCorrectAnswers.length) {
      return INCORRECT;
    }

    Arrays.sort(splitCorrectAnswers);
    Arrays.sort(splitAnswers);

    for (int index = 0; index < splitCorrectAnswers.length; index++) {
      if (!(splitCorrectAnswers[index].equals(splitAnswers[index]))) {
        return INCORRECT;
      }
    }

    return CORRECT;
  }

  @Override
  protected int compareLikert(Likert other) {
    return -1;
  }

  @Override
  protected int compareMultipleChoice(MultipleChoice other) {
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
      return -abstractQuestion.compareMultipleSelection(this);
    }
    return -1;
  }
}