package document;

import document.elements.BasicText;
import document.elements.BoldText;
import document.elements.Heading;
import document.elements.HyperText;
import document.elements.ItalicText;
import document.elements.Paragraph;

/**
 * This visitor provides a word count operation,
 * counting the number of words for the TextElement given.
 */

public class WordCountVisitor implements TextElementVisitor<Integer> {
  @Override
  public Integer visitBasicText(BasicText e) {
    return countNumberOfWords(e.getText());
  }

  @Override
  public Integer visitBoldText(BoldText e) {
    return countNumberOfWords(e.getText());
  }

  @Override
  public Integer visitHeading(Heading e) {
    return countNumberOfWords(e.getText());
  }

  @Override
  public Integer visitHyperText(HyperText e) {
    return countNumberOfWords(e.getText());
  }

  @Override
  public Integer visitItalicText(ItalicText e) {
    return countNumberOfWords(e.getText());
  }

  @Override
  public Integer visitParagraph(Paragraph e) {
    int count = 0;
    for (int i = 0; i < e.getContent().size(); i++) {
      count += e.getContent().get(i).accept(this);
    }
    return count;
  }

  private int countNumberOfWords(String string) {
    String[] strings = string.split(" ");
    return strings.length;
  }
}
