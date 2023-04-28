package document;

import document.elements.BasicText;
import document.elements.BoldText;
import document.elements.Heading;
import document.elements.HyperText;
import document.elements.ItalicText;
import document.elements.Paragraph;

/**
 * This visitor provides a basic String conversion operation,
 * converting the TextElement given to a basic String format.
 */

public class BasicStringVisitor implements TextElementVisitor<String> {

  private StringBuilder builder;

  /**
   * Default constructor for the BasicStringVisitor.
   */
  public BasicStringVisitor() {
    this.builder = new StringBuilder();
  }

  @Override
  public String visitBasicText(BasicText e) {
    String string = " " + e.getText();
    this.builder.append(string);
    return string;
  }

  @Override
  public String visitBoldText(BoldText e) {
    String string = " " + e.getText();
    this.builder.append(string);
    return string;
  }

  @Override
  public String visitHeading(Heading e) {

    if (e.getLevel() == 1) {
      this.builder.append(e.getText());
      return e.getText();
    }
    String string = " " + e.getText();
    this.builder.append(string);
    return string;
  }

  @Override
  public String visitHyperText(HyperText e) {
    String string = " " + e.getText();
    this.builder.append(string);
    return string;
  }

  @Override
  public String visitItalicText(ItalicText e) {
    String string = " " + e.getText();
    this.builder.append(string);
    return string;
  }

  @Override
  public String visitParagraph(Paragraph e) {
    for (int i = 0; i < e.getContent().size(); i++) {
      BasicText text = e.getContent().get(i);
      text.accept(this);
    }
    return this.builder.toString();
  }

  @Override
  public String toString() {
    return builder.toString();
  }
}
