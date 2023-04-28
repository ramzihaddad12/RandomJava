package document;

import document.elements.BasicText;
import document.elements.BoldText;
import document.elements.Heading;
import document.elements.HyperText;
import document.elements.ItalicText;
import document.elements.Paragraph;

/**
 * An interface for the visitor any TextElement object.
 * From this interface, any type of TextElement can be
 * visited.
 *
 * @param <R> the type of the return parameter for the visit
 */
public interface TextElementVisitor<R> {

  /**
   * Visits a BasicText object.
   * @param e BasicText object.
   * @return the element
   */

  R visitBasicText(BasicText e);

  /**
   * Visits a BoldText object.
   * @param e BoldText object.
   * @return the element
   */

  R visitBoldText(BoldText e);

  /**
   * Visits a Heading object.
   * @param e Heading object.
   * @return the element
   */

  R visitHeading(Heading e);

  /**
   * Visits a HyperText object.
   * @param e HyperText object.
   * @return the element
   */

  R visitHyperText(HyperText e);

  /**
   * Visits a ItalicText object.
   * @param e ItalicText object.
   * @return the element
   */

  R visitItalicText(ItalicText e);

  /**
   * Visits a Paragraph object.
   * @param e Paragraph object.
   * @return the element
   */

  R visitParagraph(Paragraph e);
}
