package questions;

import java.util.Arrays;

/**
 * This class represents an abstract question
 * where identical behaviours are defined.
 */

abstract class AbstractQuestion implements Question {

  protected final String text;
  protected final String correctAnswer;
  protected final String[] options;
  /**
   * A constructor for the AbstractQuestion taking in the text.
   * @param text the question description
   * @param correctAnswer the correct choice between the options
   * @param options the choices available to choose from
   */

  protected AbstractQuestion(String text, String correctAnswer, String[] options) {
    this.text = text;
    this.correctAnswer = correctAnswer.trim();
    this.options = options;
  }

  /**
   * Checks to see if the correct answer given is within
   * the given options.
   *
   * @param correctAnswer the correct answer
   * @param options   the available options to select from
   */

  protected boolean correctAnswerInOptions(String correctAnswer, String[] options) {
    int correctAnswerAsAnInteger = Integer.parseInt(correctAnswer);
    return correctAnswerAsAnInteger >= 1 && correctAnswerAsAnInteger <= options.length;
  }

  @Override
  public abstract String answer(String answer);

  @Override
  public String getText() {
    return text;
  }

  @Override
  public String toString() {
    return String.format("Text: %s, correct answer(s): %s, and options %s",
            text, correctAnswer, Arrays.toString(options));
  }

  /**
   * Compares a Question object with a Likert object.
   * @param other the Likert object being compared with
   */

  protected int compareLikert(Likert other) {
    return text.compareTo(other.getText());
  }

  /**
   * Compares a Question object with a Likert object.
   * @param other the MultipleChoice object being compared with
   */

  protected int compareMultipleChoice(MultipleChoice other) {
    return text.compareTo(other.getText());
  }

  /**
   * Compares a Question object with a Likert object.
   * @param other the MultipleSelect object being compared with
   */

  protected int compareMultipleSelection(MultipleSelect other) {
    return text.compareTo(other.getText());
  }

  /**
   * Compares a Question object with a Likert object.
   * @param other the TrueFalse object being compared with
   */

  protected int compareTrueFalse(TrueFalse other) {
    return text.compareTo(other.getText());
  }
}
