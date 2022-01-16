import questions.Likert;
import questions.MultipleChoice;
import questions.MultipleSelect;
import questions.Question;
import questions.TrueFalse;

public class Main {
  public static void main(String[] args) {
    Question tf = new TrueFalse("Is it true or false", "True");
    Question tf2 = new TrueFalse("As it true or false", "True");
    Question mcq = new MultipleChoice("Choose multiple choice", "1", new String[]{"1","2","3","4"});
    Question mcq2 = new MultipleChoice("Ahoose multiple choice", "1", new String[]{"1","2","3","4"});
    Question ms = new MultipleSelect("Choose multiple select", "1 4", new String[]{"1", "2", "3", "4"});
    Question ms2 = new MultipleSelect("Ahoose multiple select", "1 4", new String[]{"1", "2", "3", "4"});
    Question likert = new Likert("LIkeeeee");
    Question likert2 = new Likert("AIkeeeee");
    System.out.println(tf.equals(likert));
  }
}
