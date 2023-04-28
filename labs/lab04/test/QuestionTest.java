import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import questions.Likert;
import questions.MultipleChoice;
import questions.MultipleSelect;
import questions.Question;
import questions.TrueFalse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This class tests different types of questions.
 */

public class QuestionTest {
  private Question likertQuestion;
  private Question multipleSelectQuestion;
  private Question multipleChoiceQuestion;
  private Question trueFalseQuestion;

  /**
   * Creating the objects needed in the other tests.
   * */

  @Before
  public void setUp() {
    likertQuestion = new Likert("The Departed is a great movie");
    multipleSelectQuestion = new MultipleSelect("Which teams are basketball teams?",
            "1 2",
            "Knicks", "Celtics",
            "Boston Red Sox", "Patriots");
    multipleChoiceQuestion = new MultipleChoice("When did WWI begin?", "4",
            "1910", "1911", "1913", "1914", "1916");
    trueFalseQuestion = new TrueFalse("WWI ended in 1918", "True");
  }

  /**
   * Tests the invalidity of having less than 3 options in a multiple select question.
   * */

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorOfMultipleSelectWhenOptionsLessThan3() {
    new MultipleSelect("Which of the following are German car manufacturers?",
            "1 2", "BMW", "Audi");
  }

  /**
   * Tests the invalidity of having greater than 8 options in a multiple select question.
   * */

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorOfMultipleSelectWhenOptionsGreaterThan8() {
    new MultipleSelect("Which of the following are German car manufacturers?",
            "1 2", "BMW", "Audi", "Ford", "Chevrolet", "Cadillac", "Dodge", "Hyundai",
            "Nissan", "Mazda");
  }

  /**
   * Tests the invalidity of having less than 3 options in a multiple choice question.
   * */

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorOfMultipleChoiceWhenOptionsLessThan3() {
    new MultipleChoice("Which of the following are German car manufacturers?",
            "1", "BMW", "Mazda");
  }

  /**
   * Tests the invalidity of having greater than 8 options in a multiple choice question.
   * */

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorOfMultipleChoiceWhenOptionsGreaterThan8() {
    new MultipleChoice("Which of the following are German car manufacturers?",
            "1 2", "BMW", "Isuzu", "Ford", "Chevrolet", "Cadillac", "Dodge", "Hyundai",
            "Nissan", "Mazda");
  }
  //

  /**
   * Tests the invalidity of having one of the correct answers not
   * in the options in a multiple select question.
   * */

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorOfMultipleSelectWhenCorrectAnswerNotInTheAvailableOptions() {
    new MultipleSelect("Which of the following are German car manufacturers?",
            "1 4", "BMW", "Audi", "Mercedes");
  }

  /**
   * Tests the invalidity of having one of the correct answers not
   * in the options in a multiple choice question.
   * */

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorOfMultipleChoiceWhenCorrectAnswerNotInTheAvailableOptions() {
    new MultipleChoice("Which of the following are German car manufacturers?",
            "4", "BMW", "Audi", "Mercedes");
  }

  /**
   * Tests the invalidity of having one of the correct answers not
   * in the options in a true/false question.
   * */

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorOfTrueFalseWhenCorrectAnswerNotInTheAvailableOptions() {
    new TrueFalse("WWI ended in 1918", "Maybe");
  }

  /**
   * Tests the getText method.
   * */

  @Test
  public void testGetText() {
    String expectedResult = "The Departed is a great movie";
    assertEquals(expectedResult, likertQuestion.getText());
    expectedResult = "Which teams are basketball teams?";
    assertEquals(expectedResult, multipleSelectQuestion.getText());
    expectedResult = "When did WWI begin?";
    assertEquals(expectedResult, multipleChoiceQuestion.getText());
    expectedResult = "WWI ended in 1918";
    assertEquals(expectedResult, trueFalseQuestion.getText());
  }

  /**
   * Tests the answer method when provided the correct answer
   * for the likert question.
   * */

  @Test
  public void testAnswerIfCorrectAnswerForLikertQuestion() {
    String expectedResult = "Correct";
    assertEquals(expectedResult, likertQuestion.answer("1"));
    assertEquals(expectedResult, likertQuestion.answer("2"));
    assertEquals(expectedResult, likertQuestion.answer("3"));
    assertEquals(expectedResult, likertQuestion.answer("4"));
    assertEquals(expectedResult, likertQuestion.answer("5"));
    assertEquals(expectedResult, likertQuestion.answer("   1   "));
    assertEquals(expectedResult, likertQuestion.answer("  2   "));
    assertEquals(expectedResult, likertQuestion.answer("  3  "));
    assertEquals(expectedResult, likertQuestion.answer("  4  "));
    assertEquals(expectedResult, likertQuestion.answer("  5  "));
  }

  /**
   * Tests the answer method when provided the correct answer
   * for the multiple select question.
   * */

  @Test
  public void testAnswerIfCorrectAnswerForMultipleSelect() {
    String expectedResult = "Correct";
    assertEquals(expectedResult, multipleSelectQuestion.answer("1 2"));
    assertEquals(expectedResult, multipleSelectQuestion.answer("2 1"));
    assertEquals(expectedResult, multipleSelectQuestion.answer("  1    2   "));
  }

  /**
   * Tests the answer method when provided the correct answer
   * for the multiple choice question.
   * */

  @Test
  public void testAnswerIfCorrectAnswerForMultipleChoice() {
    String expectedResult = "Correct";
    assertEquals(expectedResult, multipleChoiceQuestion.answer("4"));
    assertEquals(expectedResult, multipleChoiceQuestion.answer("      4    "));
  }

  /**
   * Tests the answer method when provided the correct answer
   * for the true/false question.
   * */

  @Test
  public void testAnswerIfCorrectAnswerForTrueFalse() {
    String expectedResult = "Correct";
    assertEquals(expectedResult, trueFalseQuestion.answer("True"));
    assertEquals(expectedResult, trueFalseQuestion.answer("      True    "));
  }

  /**
   * Tests the answer method when provided an invalid answer
   * for the likert question.
   * */

  @Test
  public void testAnswerIfInvalidAnswerForLikertQuestion() {
    String expectedResult = "Incorrect";
    assertEquals(expectedResult, likertQuestion.answer("6"));
    assertEquals(expectedResult, likertQuestion.answer("     6    "));
    assertEquals(expectedResult, likertQuestion.answer("0"));
    assertEquals(expectedResult, likertQuestion.answer("     0    "));
    assertEquals(expectedResult, likertQuestion.answer("-1"));
    assertEquals(expectedResult, likertQuestion.answer("     -1    "));
  }

  /**
   * Tests the answer method when provided an incorrect answer
   * for the multiple select question.
   * */

  @Test
  public void testAnswerIfIncorrectAnswerForMultipleSelect() {
    String expectedResult = "Incorrect";
    assertEquals(expectedResult, multipleSelectQuestion.answer("4"));
    assertEquals(expectedResult, multipleSelectQuestion.answer("    4    "));
    assertEquals(expectedResult, multipleSelectQuestion.answer("1 2 4"));
    assertEquals(expectedResult, multipleSelectQuestion.answer("1    2    4"));
  }

  /**
   * Tests the answer method when provided an invalid answer
   * for the multiple select question.
   * */

  @Test
  public void testAnswerIfInvalidAnswerForMultipleSelect() {
    String expectedResult = "Incorrect";
    assertEquals(expectedResult, multipleSelectQuestion.answer("6 7"));
    assertEquals(expectedResult, multipleSelectQuestion.answer("0"));
    assertEquals(expectedResult, multipleSelectQuestion.answer("    0    "));
    assertEquals(expectedResult, multipleSelectQuestion.answer("-1"));
    assertEquals(expectedResult, multipleSelectQuestion.answer("    -1    "));
    assertEquals(expectedResult, multipleSelectQuestion.answer("1 2 -1"));
    assertEquals(expectedResult, multipleSelectQuestion.answer("1    2    -1"));
  }

  /**
   * Tests the answer method when provided an incorrect answer
   * for the multiple choice question.
   * */

  @Test
  public void testAnswerIfIncorrectAnswerForMultipleChoice() {
    String expectedResult = "Incorrect";
    assertEquals(expectedResult, multipleChoiceQuestion.answer("1"));
    assertEquals(expectedResult, multipleChoiceQuestion.answer("2"));
    assertEquals(expectedResult, multipleChoiceQuestion.answer("3"));
    assertEquals(expectedResult, multipleChoiceQuestion.answer("5"));
    assertEquals(expectedResult, multipleChoiceQuestion.answer("  1  "));
    assertEquals(expectedResult, multipleChoiceQuestion.answer("  2  "));
    assertEquals(expectedResult, multipleChoiceQuestion.answer("  3  "));
    assertEquals(expectedResult, multipleChoiceQuestion.answer("  5  "));
  }

  /**
   * Tests the answer method when provided an invalid answer
   * for the multiple choice question.
   * */

  @Test
  public void testAnswerIfInvalidAnswerForMultipleChoice() {
    String expectedResult = "Incorrect";
    assertEquals(expectedResult, multipleChoiceQuestion.answer("7"));
    assertEquals(expectedResult, multipleChoiceQuestion.answer("  7   "));
    assertEquals(expectedResult, multipleChoiceQuestion.answer("0"));
    assertEquals(expectedResult, multipleChoiceQuestion.answer("  0   "));
    assertEquals(expectedResult, multipleChoiceQuestion.answer("-1"));
    assertEquals(expectedResult, multipleChoiceQuestion.answer("  -1   "));
    assertEquals(expectedResult, multipleChoiceQuestion.answer("  4 5  "));
    assertEquals(expectedResult, multipleChoiceQuestion.answer("  1 4  "));
  }

  /**
   * Tests the answer method when provided an incorrect answer
   * for the true/false question.
   * */

  @Test
  public void testAnswerIfIncorrectAnswerForTrueFalse() {
    String expectedResult = "Incorrect";
    assertEquals(expectedResult, trueFalseQuestion.answer("False"));
    assertEquals(expectedResult, trueFalseQuestion.answer("  False   "));
  }

  /**
   * Tests the answer method when provided an invalid answer
   * for the true/false question.
   * */

  @Test
  public void testAnswerIfInvalidAnswerForTrueFalse() {
    String expectedResult = "Incorrect";
    assertEquals(expectedResult, trueFalseQuestion.answer("Maybe"));
    assertEquals(expectedResult, trueFalseQuestion.answer("  Maybe  "));
  }

  /**
   * Tests the toString method for a likert question.
   * */

  @Test
  public void testToStringForLikert() {
    String expectedResult = String.format("Text: %s, correct answer(s): %s, and options %s",
            likertQuestion.getText(), "1 2 3 4 5",
            Arrays.toString(new String[] {"1", "2", "3", "4", "5"}));
    assertEquals(expectedResult, likertQuestion.toString());
  }

  /**
   * Tests the toString method for a multiple select question.
   * */

  @Test
  public void testToStringForMultipleSelect() {
    String expectedResult = String.format("Text: %s, correct answer(s): %s, and options %s",
            multipleSelectQuestion.getText(), "1 2",
            Arrays.toString(new String[] {"Knicks", "Celtics",
              "Boston Red Sox", "Patriots"}));
    assertEquals(expectedResult, multipleSelectQuestion.toString());
  }

  /**
   * Tests the toString method for a multiple choice question.
   * */

  @Test
  public void testToStringForMultipleChoice() {
    String expectedResult = String.format("Text: %s, correct answer(s): %s, and options %s",
            multipleChoiceQuestion.getText(), "4",
            Arrays.toString(new String[] {"1910", "1911", "1913", "1914", "1916"}));
    assertEquals(expectedResult, multipleChoiceQuestion.toString());
  }

  /**
   * Tests the toString method for a true false question.
   * */

  @Test
  public void testToStringForTrueFalse() {
    String expectedResult = String.format("Text: %s, correct answer(s): %s, and options %s",
            trueFalseQuestion.getText(), "True", Arrays.toString(new String[] {"True", "False"}));
    assertEquals(expectedResult, trueFalseQuestion.toString());
  }

  /**
   * Tests the compareTo method for Likert question
   * when compared to another likert question.
   * */

  @Test
  public void testCompareLikertQuestionWithAnotherLikertQuestion() {
    Question likertQuestion2 = new Likert("The patriots are the best team in the NFL");
    assertTrue(likertQuestion.compareTo(likertQuestion2) < 0);
  }

  /**
   * Tests the compareTo method for Likert question
   * when compared to multiple select question.
   * */

  @Test
  public void testCompareLikertQuestionWithMultipleSelectQuestion() {
    assertTrue(likertQuestion.compareTo(multipleSelectQuestion) > 0);
  }

  /**
   * Tests the compareTo method for Likert question
   * when compared to multiple choice question.
   * */

  @Test
  public void testCompareLikertQuestionWithMultipleChoiceQuestion() {
    assertTrue(likertQuestion.compareTo(multipleChoiceQuestion) > 0);
  }

  /**
   * Tests the compareTo method for Likert question
   * when compared to true/false question.
   * */

  @Test
  public void testCompareLikertQuestionWithTrueFalseQuestion() {
    assertTrue(likertQuestion.compareTo(trueFalseQuestion) > 0);
  }

  /**
   * Tests the compareTo method for a multiple select question
   * when compared to a likert question.
   * */

  @Test
  public void testCompareMultipleSelectWithLikertQuestion() {
    assertTrue(multipleSelectQuestion.compareTo(likertQuestion) < 0);
  }

  /**
   * Tests the compareTo method for a multiple select question
   * when compared to another multiple select question.
   * */

  @Test
  public void testCompareMultipleSelectWithAnotherMultipleSelectQuestion() {
    MultipleSelect multipleSelectQuestion2 = new MultipleSelect(
            "Which of the following is a product from Sony?",
            "1 2","PS5", "PS4", "XBOX", "Switch", "Atari");
    assertTrue(multipleSelectQuestion.compareTo(multipleSelectQuestion2) > 0);
  }

  /**
   * Tests the compareTo method for a multiple select question
   * when compared to a multiple choice question.
   * */

  @Test
  public void testCompareMultipleSelectWithMultipleChoiceQuestion() {
    assertTrue(multipleSelectQuestion.compareTo(multipleChoiceQuestion) > 0);
  }

  /**
   * Tests the compareTo method for a multiple select question
   * when compared to a true/false question.
   * */

  @Test
  public void testCompareMultipleSelectWithTrueFalseQuestion() {
    assertTrue(multipleSelectQuestion.compareTo(trueFalseQuestion) > 0);
  }

  /**
   * Tests the compareTo method for a multiple choice question
   * when compared to a likert question.
   * */

  @Test
  public void testCompareMultipleChoiceWithLikertQuestion() {
    assertTrue(multipleChoiceQuestion.compareTo(likertQuestion) < 0);
  }

  /**
   * Tests the compareTo method for a multiple choice question
   * when compared to a multiple select question.
   * */

  @Test
  public void testCompareMultipleChoiceWithMultipleSelectQuestion() {
    assertTrue(multipleChoiceQuestion.compareTo(multipleSelectQuestion) < 0);
  }

  /**
   * Tests the compareTo method for a multiple choice question
   * when compared to another multiple choice question.
   * */

  @Test
  public void testCompareMultipleChoiceWithAnotherMultipleChoiceQuestion() {
    Question multipleChoiceQuestion2 = new MultipleChoice("When did WWII start?", "2",
            "1937", "1939", "1941", "1943", "1945");

    assertTrue(multipleChoiceQuestion.compareTo(multipleChoiceQuestion2) < 0);
  }

  /**
   * Tests the compareTo method for a multiple choice question
   * when compared to a true/false question.
   * */

  @Test
  public void testCompareMultipleChoiceWithTrueFalseQuestion() {
    assertTrue(multipleChoiceQuestion.compareTo(trueFalseQuestion) > 0);
  }

  /**
   * Tests the compareTo method for a true/false question
   * when compared to a likert question.
   * */

  @Test
  public void testCompareTrueFalseWithLikertQuestion() {
    assertTrue(trueFalseQuestion.compareTo(likertQuestion) < 0);
  }

  /**
   * Tests the compareTo method for a true/false question
   * when compared to a multiple select question.
   * */

  @Test
  public void testCompareTrueFalseWithMultipleSelectQuestion() {
    assertTrue(trueFalseQuestion.compareTo(multipleSelectQuestion) < 0);
  }

  /**
   * Tests the compareTo method for a true/false question
   * when compared to a multiple choice question.
   * */

  @Test
  public void testCompareTrueFalseWithMultipleChoiceQuestion() {
    assertTrue(trueFalseQuestion.compareTo(multipleChoiceQuestion) < 0);
  }

  /**
   * Tests the compareTo method for a true/false question
   * when compared to another true/false question.
   * */

  @Test
  public void testCompareTrueFalseWithAnotherTrueFalseQuestion() {
    Question trueFalseQuestion2 = new TrueFalse("WWII ended in 1947", "False");
    assertTrue(trueFalseQuestion.compareTo(trueFalseQuestion2) < 0);
  }

  /**
   * Tests sorting a list of questions based on
   * the type of question when all types are present.
   * */

  @Test
  public void testSortingListOfQuestionsWhenAllTypesArePresent() {
    List<Question> list = new ArrayList<>(Arrays.asList(
            multipleSelectQuestion, likertQuestion, trueFalseQuestion, multipleChoiceQuestion));
    Collections.sort(list);
    assertEquals(trueFalseQuestion, list.get(0));
    assertEquals(multipleChoiceQuestion, list.get(1));
    assertEquals(multipleSelectQuestion, list.get(2));
    assertEquals(likertQuestion, list.get(3));
  }

  /**
   * Tests sorting a list of questions based on
   * the type of question when true/false question
   * type is not present in the list.
   * */

  @Test
  public void testSortingListOfQuestionsWhenNoTrueFalseInList() {
    List<Question> list = new ArrayList<>(Arrays.asList(
            multipleSelectQuestion, likertQuestion, multipleChoiceQuestion));
    Collections.sort(list);
    assertEquals(multipleChoiceQuestion, list.get(0));
    assertEquals(multipleSelectQuestion, list.get(1));
    assertEquals(likertQuestion, list.get(2));
  }

  /**
   * Tests sorting a list of questions based on
   * the type of question when multiple choice question
   * type is not present in the list.
   * */

  @Test
  public void testSortingListOfQuestionsWhenNoMultipleChoiceInList() {
    List<Question> list = new ArrayList<>(Arrays.asList(
            multipleSelectQuestion, likertQuestion, trueFalseQuestion));
    Collections.sort(list);
    assertEquals(trueFalseQuestion, list.get(0));
    assertEquals(multipleSelectQuestion, list.get(1));
    assertEquals(likertQuestion, list.get(2));
  }

  /**
   * Tests sorting a list of questions based on
   * the type of question when multiple select question
   * type is not present in the list.
   * */

  @Test
  public void testSortingListOfQuestionsWhenNoMultipleSelectInList() {
    List<Question> list = new ArrayList<>(Arrays.asList(
             likertQuestion, trueFalseQuestion, multipleChoiceQuestion));
    Collections.sort(list);
    assertEquals(trueFalseQuestion, list.get(0));
    assertEquals(multipleChoiceQuestion, list.get(1));
    assertEquals(likertQuestion, list.get(2));
  }

  /**
   * Tests sorting a list of questions based on
   * the type of question when likert question
   * type is not present in the list.
   * */

  @Test
  public void testSortingListOfQuestionsWhenNoLikertInList() {
    List<Question> list = new ArrayList<>(Arrays.asList(
            multipleSelectQuestion, trueFalseQuestion, multipleChoiceQuestion));
    Collections.sort(list);
    assertEquals(trueFalseQuestion, list.get(0));
    assertEquals(multipleChoiceQuestion, list.get(1));
    assertEquals(multipleSelectQuestion, list.get(2));
  }

  /**
   * Tests sorting a list of questions based on
   * the type of question when all types are present multiple times.
   * */

  @Test
  public void testSortingListOfQuestionsWhenSameTypesArePresent() {
    MultipleSelect multipleSelectQuestion2 = new MultipleSelect(
            "Which of the following is a product from Sony?",
            "1 2","PS5", "PS4", "XBOX", "Switch", "Atari");
    Question likertQuestion2 = new Likert("The Patriots are the best team in the NFL");
    Question trueFalseQuestion2 = new TrueFalse("WWII ended in 1947", "False");
    Question multipleChoiceQuestion2 = new MultipleChoice("When did WWII start?", "2",
            "1937", "1939", "1941", "1943", "1945");
    List<Question> list = new ArrayList<>(Arrays.asList(
            multipleSelectQuestion, likertQuestion, trueFalseQuestion, multipleChoiceQuestion,
            multipleSelectQuestion2, likertQuestion2, trueFalseQuestion2, multipleChoiceQuestion2));
    Collections.sort(list);
    assertEquals(trueFalseQuestion, list.get(0));
    assertEquals(trueFalseQuestion2, list.get(1));
    assertEquals(multipleChoiceQuestion, list.get(2));
    assertEquals(multipleChoiceQuestion2, list.get(3));
    assertEquals(multipleSelectQuestion2, list.get(4));
    assertEquals(multipleSelectQuestion, list.get(5));
    assertEquals(likertQuestion, list.get(6));
    assertEquals(likertQuestion2, list.get(7));
  }
}
