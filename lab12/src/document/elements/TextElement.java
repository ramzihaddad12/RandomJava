package document.elements;

import document.TextElementVisitor;

/**
 * Representation for any of the text elements of a document.
 */
public interface TextElement {

  /**
   * Returns the text of the element.
   * 
   * @return the text
   */
  public String getText();

  /**
   * Transform a visitor into elements of the needed type.
   *
   * @param <R>     the type of element needed to be returned
   * @param visitor the visitor to use
   * @return the accepted type element
   */
  public <R> R accept(TextElementVisitor<R> visitor);
}
