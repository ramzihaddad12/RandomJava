package document;

import document.elements.BasicText;
import document.elements.BoldText;
import document.elements.Heading;
import document.elements.HyperText;
import document.elements.ItalicText;
import document.elements.Paragraph;

/**
 * This visitor provides a MarkDown conversion operation,
 * converting the TextElement given to a MarkDown format.
 */

public class MarkdownStringVisitor implements TextElementVisitor<String> {
  private StringBuilder builder;

  /**
   * Default constructor for the MarkdownStringVisitor.
   */

  public MarkdownStringVisitor() {
    this.builder = new StringBuilder();
  }

  @Override
  public String visitBasicText(BasicText e) {
    String string = "\n" + e.getText();
    this.builder.append(string);
    return string;
  }

  @Override
  public String visitBoldText(BoldText e) {
    String string = "\n**" + e.getText() + "**";
    this.builder.append(string);
    return string;
  }

  @Override
  public String visitHeading(Heading e) {
    if (e.getLevel() == 1) {
      String string = "# " + e.getText();
      this.builder.append(string);
      return string;
    }
    StringBuilder newBuilder = new StringBuilder();
    newBuilder.append("\n");

    for (int i = 0; i < e.getLevel(); i++) {
      newBuilder.append("#");
    }
    newBuilder.append(" ");
    newBuilder.append(e.getText());
    this.builder.append(newBuilder.toString());
    return newBuilder.toString();
  }

  @Override
  public String visitHyperText(HyperText e) {
    String string = "\n[" + e.getText() + "](" + e.getUrl() + ")";
    this.builder.append(string);
    return string;
  }

  @Override
  public String visitItalicText(ItalicText e) {
    String string = "\n*" + e.getText() + "*";
    this.builder.append(string);
    return string;
  }

  @Override
  public String visitParagraph(Paragraph e) {
    builder.append("\n");

    for (int i = 0; i < e.getContent().size(); i++) {
      BasicText text = e.getContent().get(i);
      text.accept(this);
    }
    return builder.toString();
  }

  @Override
  public String toString() {
    return builder.toString();
  }
}
