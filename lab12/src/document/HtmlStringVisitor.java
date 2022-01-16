package document;

import document.elements.BasicText;
import document.elements.BoldText;
import document.elements.Heading;
import document.elements.HyperText;
import document.elements.ItalicText;
import document.elements.Paragraph;

/**
 * This visitor provides an HTML conversion operation,
 * converting the TextElement given to an HTML format.
 */

public class HtmlStringVisitor implements TextElementVisitor<String> {

  private StringBuilder builder;

  /**
   * Default constructor for the HtmlStringVisitor.
   */

  public HtmlStringVisitor() {
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
    String string = "\n<b>" + e.getText() + "</b>";
    this.builder.append(string);
    return string;
  }

  @Override
  public String visitHeading(Heading e) {
    if (e.getLevel() == 1) {
      String string = "<h" + e.getLevel() + ">" + e.getText() + "</h" + e.getLevel() + ">";
      this.builder.append(string);
      return string;
    }
    String string = "\n<h" + e.getLevel() + ">" + e.getText() + "</h" + e.getLevel() + ">";
    this.builder.append(string);
    return string;
  }

  @Override
  public String visitHyperText(HyperText e) {
    String string = "\n<a href=\"" + e.getUrl() + "\">" + e.getText() + "</a>";
    this.builder.append(string);
    return string;
  }

  @Override
  public String visitItalicText(ItalicText e) {
    String string = "\n<i>" + e.getText() + "</i>";
    this.builder.append(string);
    return string;
  }

  @Override
  public String visitParagraph(Paragraph e) {
    this.builder.append("\n<p>");

    for (int i = 0; i < e.getContent().size(); i++) {
      BasicText text = e.getContent().get(i);
      if (i == 0 ) {
        text.accept(this).trim();
      }

      else {
        text.accept(this);
      }
    }
    builder.append("\n</p>");
    return builder.toString();
  }

  @Override
  public String toString() {
    return builder.toString();
  }
}
