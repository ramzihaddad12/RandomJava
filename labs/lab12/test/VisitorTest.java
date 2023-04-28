import static org.junit.Assert.assertEquals;

import document.BasicStringVisitor;
import document.Document;
import document.HtmlStringVisitor;
import document.MarkdownStringVisitor;
import document.TextElementVisitor;
import document.WordCountVisitor;
import document.elements.BasicText;
import document.elements.BoldText;
import document.elements.Heading;
import document.elements.HyperText;
import document.elements.ItalicText;
import document.elements.Paragraph;
import document.elements.TextElement;
import org.junit.Before;
import org.junit.Test;

/**
 * This class contains all the unit tests for
 * all types of TextElementVisitor.
 */

public class VisitorTest {

  private TextElement basicText;
  private TextElement boldText;
  private TextElement heading;
  private TextElement hyperText;
  private TextElement italicText;
  private Paragraph paragraph;
  private TextElementVisitor<Integer> wordCountVisitor;
  private Document document;

  /**
   * Setting up all the variables needed for testing.
   */
  @Before
  public void setup() {
    basicText = new BasicText("Basic Text");
    boldText = new BoldText("Bold Text");
    heading = new Heading("Heading Text", 1);
    hyperText = new HyperText("Hyper Text", "lichess.org");
    italicText = new ItalicText("Italic Text");
    paragraph = new Paragraph();
    paragraph.add(new BasicText("Word One"));
    paragraph.add(new BasicText("Word Two"));
    paragraph.add(new BasicText("Word Three"));

    wordCountVisitor = new WordCountVisitor();
    document = new Document();
  }

  /**
   * A test that tests the WordCountVisitor on BasicText.
   */
  @Test
  public void testWordCountVisitorForBasicText() {
    TextElementVisitor<String> basicStringVisitor = new BasicStringVisitor();
    int actual = basicText.accept(wordCountVisitor);
    int expected = 2;
    assertEquals(expected, actual);

    document.add(basicText);
    assertEquals(expected, document.countWords());
  }

  /**
   * A test that tests the WordCountVisitor on BoldText.
   */

  @Test
  public void testWordCountVisitorForBoldText() {
    int actual = boldText.accept(wordCountVisitor);
    int expected = 2;
    assertEquals(expected, actual);

    document.add(boldText);
    assertEquals(expected, document.countWords());
  }

  /**
   * A test that tests the WordCountVisitor on HyperText.
   */

  @Test
  public void testWordCountVisitorForHyperText() {
    int actual = hyperText.accept(wordCountVisitor);
    int expected = 2;
    assertEquals(expected, actual);

    document.add(hyperText);
    assertEquals(expected, document.countWords());
  }

  /**
   * A test that tests the WordCountVisitor on ItalicText.
   */

  @Test
  public void testWordCountVisitorForItalicText() {
    int actual = italicText.accept(wordCountVisitor);
    int expected = 2;
    assertEquals(expected, actual);

    document.add(italicText);
    assertEquals(expected, document.countWords());
  }

  /**
   * A test that tests the WordCountVisitor on Paragraph.
   */

  @Test
  public void testWordCountVisitorForParagraph() {
    int actual = paragraph.accept(wordCountVisitor);
    int expected = 6;
    assertEquals(expected, actual);

    document.add(paragraph);
    assertEquals(expected, document.countWords());
  }

  /**
   * A test that tests the WordCountVisitor on Heading
   * of level 1.
   */

  @Test
  public void testWordCountVisitorForHeadingOfLevel1() {
    int actual = heading.accept(wordCountVisitor);
    int expected = 2;
    assertEquals(expected, actual);

    document.add(heading);
    assertEquals(expected, document.countWords());
  }

  /**
   * A test that tests the WordCountVisitor on Heading
   * of level 2.
   */

  @Test
  public void testWordCountVisitorForHeadingOfLevel2() {
    TextElement levelTwoHeading = new Heading("Heading With Level Two", 2);

    int actual = levelTwoHeading.accept(wordCountVisitor);
    int expected = 4;
    assertEquals(expected, actual);

    document.add(levelTwoHeading);
    assertEquals(expected, document.countWords());
  }

  /**
   * A test that tests the WordCountVisitor on Heading
   * of level 3.
   */

  @Test
  public void testWordCountVisitorForHeadingOfLevel3() {
    TextElement levelThreeHeading = new Heading("Heading With Level Three", 3);

    int actual = levelThreeHeading.accept(wordCountVisitor);
    int expected = 4;
    assertEquals(expected, actual);

    document.add(levelThreeHeading);
    assertEquals(expected, document.countWords());
  }

  /**
   * A test that tests the WordCountVisitor on Headings
   * of different levels together.
   */

  @Test
  public void testWordCountVisitorForHeadingsWithDifferentLevelsTogether() {
    int actual = heading.accept(wordCountVisitor);
    int expected = 2;
    assertEquals(expected, actual);
    document.add(heading);
    assertEquals(expected, document.countWords());

    TextElement levelTwoHeading = new Heading("Heading With Level Two", 2);
    expected = 4;
    actual = levelTwoHeading.accept(wordCountVisitor);
    assertEquals(expected, actual);
    document.add(levelTwoHeading);
    assertEquals(expected + 2, document.countWords());

    TextElement levelThreeHeading = new Heading("Heading With Level Three", 3);
    expected = 4;
    actual = levelThreeHeading.accept(wordCountVisitor);
    assertEquals(expected, actual);

    document.add(levelThreeHeading);
    expected = 10;
    assertEquals(expected, document.countWords());
  }

  /**
   * A test that tests the WordCountVisitor on Basic, Bold,
   * and Italic elements together.
   */
  @Test
  public void testWordCountVisitorForBasicBoldAndItalicElementsTogether() {
    int expected = 2;

    document.add(basicText);
    assertEquals(expected, document.countWords());

    expected += 2;
    document.add(boldText);
    assertEquals(expected, document.countWords());


    expected += 2;
    document.add(italicText);
    assertEquals(expected, document.countWords());
  }


  /**
   * A test that tests the WordCountVisitor on Basic, Bold,
   * and Italic elements together.
   */
  @Test
  public void testWordCountVisitorForAllElementsTogether() {
    int expected = 2;

    document.add(basicText);
    assertEquals(expected, document.countWords());

    expected += 2;
    document.add(boldText);
    assertEquals(expected, document.countWords());


    expected += 2;
    document.add(italicText);
    assertEquals(expected, document.countWords());

    expected += 2;
    document.add(hyperText);
    assertEquals(expected, document.countWords());

    expected += 6;
    document.add(paragraph);
    assertEquals(expected, document.countWords());
  }

  /**
   * A test that tests the basicStringVisitor on BasicText.
   */
  @Test
  public void testBasicStringVisitorForBasicText() {
    TextElementVisitor<String> basicStringVisitor = new BasicStringVisitor();
    String expected = " Basic Text";
    document.add(basicText);
    assertEquals(expected, document.toText(basicStringVisitor));
  }

  /**
   * A test that tests the basicStringVisitor on BoldText.
   */

  @Test
  public void testBasicStringVisitorForBoldText() {
    TextElementVisitor<String> basicStringVisitor = new BasicStringVisitor();

    String expected = " Bold Text";
    document.add(boldText);
    assertEquals(expected, document.toText(basicStringVisitor));
  }

  /**
   * A test that tests the basicStringVisitor on HyperText.
   */

  @Test
  public void testBasicStringVisitorForHyperText() {
    TextElementVisitor<String> basicStringVisitor = new BasicStringVisitor();

    String expected = " Hyper Text";
    document.add(hyperText);
    assertEquals(expected, document.toText(basicStringVisitor));
  }

  /**
   * A test that tests the basicStringVisitor on ItalicText.
   */

  @Test
  public void testBasicStringVisitorForItalicText() {
    TextElementVisitor<String> basicStringVisitor = new BasicStringVisitor();

    String expected = " Italic Text";
    document.add(italicText);
    assertEquals(expected, document.toText(basicStringVisitor));
  }

  /**
   * A test that tests the basicStringVisitor on Paragraph.
   */

  @Test
  public void testBasicStringVisitorForParagraph() {
    TextElementVisitor<String> basicStringVisitor = new BasicStringVisitor();

    String expected = " Word One Word Two Word Three";
    document.add(paragraph);
    assertEquals(expected, document.toText(basicStringVisitor));
  }

  /**
   * A test that tests the basicStringVisitor on Heading
   * of level 1.
   */

  @Test
  public void testBasicStringVisitorForHeadingOfLevel1() {
    TextElementVisitor<String> basicStringVisitor = new BasicStringVisitor();

    String expected = "Heading Text";
    document.add(heading);
    assertEquals(expected, document.toText(basicStringVisitor));
  }

  /**
   * A test that tests the basicStringVisitor on Heading
   * of level 2.
   */

  @Test
  public void testBasicStringVisitorForHeadingOfLevel2() {
    TextElement levelTwoHeading = new Heading("Heading With Level Two", 2);
    TextElementVisitor<String> basicStringVisitor = new BasicStringVisitor();

    String expected = " Heading With Level Two";
    document.add(levelTwoHeading);
    assertEquals(expected, document.toText(basicStringVisitor));
  }

  /**
   * A test that tests the basicStringVisitor on Heading
   * of level 3.
   */

  @Test
  public void testBasicStringVisitorForHeadingOfLevel3() {
    TextElement levelThreeHeading = new Heading("Heading With Level Three", 3);
    TextElementVisitor<String> basicStringVisitor = new BasicStringVisitor();

    String expected = " Heading With Level Three";
    document.add(levelThreeHeading);
    assertEquals(expected, document.toText(new BasicStringVisitor()));
  }

  /**
   * A test that tests the basicStringVisitor on Headings
   * of different levels together.
   */

  @Test
  public void testBasicStringVisitorForHeadingsWithDifferentLevelsTogether() {
    String expected = "Heading Text";
    document.add(heading);
    TextElementVisitor<String> basicStringVisitor = new BasicStringVisitor();

    assertEquals(expected, document.toText(new BasicStringVisitor()));

    TextElement levelTwoHeading = new Heading("Heading With Level Two", 2);
    expected = " Heading With Level Two";
    document.add(levelTwoHeading);
    assertEquals("Heading Text" + expected,  document.toText(new BasicStringVisitor()));

    TextElement levelThreeHeading = new Heading("Heading With Level Three", 3);
    expected = " Heading With Level Three";

    document.add(levelThreeHeading);
    expected = "Heading Text" + " Heading With Level Two" + " Heading With Level Three";
    assertEquals(expected, document.toText(new BasicStringVisitor()));
  }

  /**
   * A test that tests the basicStringVisitor on Basic, Bold,
   * and Italic elements together.
   */
  @Test
  public void testBasicStringVisitorForBasicBoldAndItalicElementsTogether() {
    String expected = " Basic Text";
    TextElementVisitor<String> basicStringVisitor = new BasicStringVisitor();

    document.add(basicText);
    assertEquals(expected, document.toText(new BasicStringVisitor()));

    expected += " Bold Text";
    document.add(boldText);
    assertEquals(expected, document.toText(new BasicStringVisitor()));


    expected += " Italic Text";
    document.add(italicText);
    assertEquals(expected, document.toText(new BasicStringVisitor()));
  }


  /**
   * A test that tests the basicStringVisitor on Basic, Bold,
   * and Italic elements together.
   */
  @Test
  public void testBasicStringVisitorForAllElementsTogether() {
    String expected = " Basic Text";
    TextElementVisitor<String> basicStringVisitor = new BasicStringVisitor();

    document.add(basicText);
    assertEquals(expected, document.toText(new BasicStringVisitor()));

    expected += " Bold Text";
    document.add(boldText);
    assertEquals(expected, document.toText(new BasicStringVisitor()));


    expected += " Italic Text";
    document.add(italicText);
    assertEquals(expected, document.toText(new BasicStringVisitor()));

    expected += " Hyper Text";
    document.add(hyperText);
    assertEquals(expected, document.toText(new BasicStringVisitor()));

    expected += " Word One Word Two Word Three";
    document.add(paragraph);
    assertEquals(expected, document.toText(new BasicStringVisitor()));
  }

  ////////////////////////////////////

  /**
   * A test that tests the htmlVisitor on BasicText.
   */
  @Test
  public void testHtmlVisitorForBasicText() {
    TextElementVisitor<String> htmlVisitor = new HtmlStringVisitor();
    String expected = "\nBasic Text";
    document.add(basicText);
    assertEquals(expected, document.toText(new HtmlStringVisitor()));
  }

  /**
   * A test that tests the htmlVisitor on BoldText.
   */

  @Test
  public void testHtmlVisitorForBoldText() {
    TextElementVisitor<String> htmlVisitor = new HtmlStringVisitor();

    String expected = "\n<b>Bold Text</b>";
    document.add(boldText);
    assertEquals(expected, document.toText(htmlVisitor));
  }

  /**
   * A test that tests the htmlVisitor on HyperText.
   */

  @Test
  public void testHtmlVisitorForHyperText() {
    TextElementVisitor<String> htmlVisitor = new HtmlStringVisitor();

    String expected = "\n<a href=\"lichess.org\">Hyper Text</a>";
    document.add(hyperText);
    assertEquals(expected, document.toText(htmlVisitor));
  }

  /**
   * A test that tests the htmlVisitor on ItalicText.
   */

  @Test
  public void testHtmlVisitorForItalicText() {
    TextElementVisitor<String> htmlVisitor = new HtmlStringVisitor();

    String expected = "\n<i>Italic Text</i>";
    document.add(italicText);
    assertEquals(expected, document.toText(htmlVisitor));
  }

  /**
   * A test that tests the htmlVisitor on Paragraph.
   */

  @Test
  public void testHtmlVisitorForParagraph() {
    String expected = "\n<p>\nWord One\n"
            + "Word Two\n"
            + "Word Three\n"
            + "</p>";
    TextElementVisitor<String> htmlVisitor = new HtmlStringVisitor();

    document.add(paragraph);
    assertEquals(expected, document.toText(htmlVisitor));
  }

  /**
   * A test that tests the htmlVisitor on Heading
   * of level 1.
   */

  @Test
  public void testHtmlVisitorForHeadingOfLevel1() {
    TextElementVisitor<String> htmlVisitor = new HtmlStringVisitor();

    String expected = "<h1>Heading Text</h1>";
    document.add(heading);
    assertEquals(expected, document.toText(htmlVisitor));
  }

  /**
   * A test that tests the htmlVisitor on Heading
   * of level 2.
   */

  @Test
  public void testHtmlVisitorForHeadingOfLevel2() {
    TextElementVisitor<String> htmlVisitor = new HtmlStringVisitor();

    TextElement levelTwoHeading = new Heading("Heading With Level Two", 2);
    String expected = "\n<h2>Heading With Level Two</h2>";
    document.add(levelTwoHeading);
    assertEquals(expected, document.toText(htmlVisitor));
  }

  /**
   * A test that tests the htmlVisitor on Heading
   * of level 3.
   */

  @Test
  public void testHtmlVisitorForHeadingOfLevel3() {
    TextElementVisitor<String> htmlVisitor = new HtmlStringVisitor();

    TextElement levelThreeHeading = new Heading("Heading With Level Three", 3);
    String expected = "\n<h3>Heading With Level Three</h3>";

    document.add(levelThreeHeading);
    assertEquals(expected, document.toText(htmlVisitor));
  }

  /**
   * A test that tests the htmlVisitor on Headings
   * of different levels together.
   */

  @Test
  public void testHtmlVisitorForHeadingsWithDifferentLevelsTogether() {
    TextElementVisitor<String> htmlVisitor = new HtmlStringVisitor();

    String expected = "<h1>Heading Text</h1>";
    document.add(heading);
    assertEquals(expected, document.toText(new HtmlStringVisitor()));

    TextElement levelTwoHeading = new Heading("Heading With Level Two", 2);
    expected = "\n<h2>Heading With Level Two</h2>";
    document.add(levelTwoHeading);
    assertEquals("<h1>Heading Text</h1>" + expected, document.toText(new HtmlStringVisitor()));

    TextElement levelThreeHeading = new Heading("Heading With Level Three", 3);

    document.add(levelThreeHeading);

    expected = "<h1>Heading Text</h1>" + "\n<h2>Heading With Level Two</h2>"
             + "\n<h3>Heading With Level Three</h3>";
    assertEquals(expected, document.toText(new HtmlStringVisitor()));
  }

  /**
   * A test that tests the htmlVisitor on Basic, Bold,
   * and Italic elements together.
   */
  @Test
  public void testHtmlVisitorForBasicBoldAndItalicElementsTogether() {
    TextElementVisitor<String> htmlVisitor = new HtmlStringVisitor();

    String expected = "\nBasic Text";

    document.add(basicText);
    assertEquals(expected, document.toText(new HtmlStringVisitor()));

    expected += "\n<b>Bold Text</b>";
    document.add(boldText);
    assertEquals(expected, document.toText(new HtmlStringVisitor()));


    expected += "\n<i>Italic Text</i>";
    document.add(italicText);
    assertEquals(expected, document.toText(new HtmlStringVisitor()));
  }


  /**
   * A test that tests the htmlVisitor on Basic, Bold,
   * and Italic elements together.
   */
  @Test
  public void testHtmlVisitorForAllElementsTogether() {
    TextElementVisitor<String> htmlVisitor = new HtmlStringVisitor();

    String expected = "\nBasic Text";

    document.add(basicText);
    assertEquals(expected, document.toText(new HtmlStringVisitor()));

    expected += "\n<b>Bold Text</b>";
    document.add(boldText);
    assertEquals(expected, document.toText(new HtmlStringVisitor()));


    expected += "\n<i>Italic Text</i>";
    document.add(italicText);
    assertEquals(expected, document.toText(new HtmlStringVisitor()));

    expected += "\n<a href=\"lichess.org\">Hyper Text</a>";
    document.add(hyperText);
    assertEquals(expected, document.toText(new HtmlStringVisitor()));

    expected += "\n<p>\nWord One\n"
            + "Word Two\n"
            + "Word Three\n"
            + "</p>";
    document.add(paragraph);
    assertEquals(expected, document.toText(new HtmlStringVisitor()));
  }

  //////

  /**
   * A test that tests the markdownVisitor on BasicText.
   */
  @Test
  public void testMarkdownVisitorForBasicText() {
    TextElementVisitor<String> markdownVisitor = new MarkdownStringVisitor();

    String actual = basicText.accept(markdownVisitor);
    String expected = "\nBasic Text";
    assertEquals(expected, actual);

    document.add(basicText);
    assertEquals(expected, document.toText(new MarkdownStringVisitor()));
  }

  /**
   * A test that tests the markdownVisitor on BoldText.
   */

  @Test
  public void testMarkdownVisitorForBoldText() {
    TextElementVisitor<String> markdownVisitor = new MarkdownStringVisitor();

    String actual = boldText.accept(markdownVisitor);
    String expected = "\n**Bold Text**";
    assertEquals(expected, actual);

    document.add(boldText);
    assertEquals(expected, document.toText(new MarkdownStringVisitor()));
  }

  /**
   * A test that tests the markdownVisitor on HyperText.
   */

  @Test
  public void testMarkdownVisitorForHyperText() {
    TextElementVisitor<String> markdownVisitor = new MarkdownStringVisitor();

    String actual = hyperText.accept(markdownVisitor);
    String expected = "\n[Hyper Text](lichess.org)";
    assertEquals(expected, actual);

    document.add(hyperText);
    assertEquals(expected, document.toText(new MarkdownStringVisitor()));
  }

  /**
   * A test that tests the markdownVisitor on ItalicText.
   */

  @Test
  public void testMarkdownVisitorForItalicText() {
    TextElementVisitor<String> markdownVisitor = new MarkdownStringVisitor();

    String actual = italicText.accept(markdownVisitor);
    String expected = "\n*Italic Text*";
    assertEquals(expected, actual);

    document.add(italicText);
    assertEquals(expected, document.toText(new MarkdownStringVisitor()));
  }

  /**
   * A test that tests the markdownVisitor on Paragraph.
   */

  @Test
  public void testMarkdownVisitorForParagraph() {
    TextElementVisitor<String> markdownVisitor = new MarkdownStringVisitor();

    String actual = paragraph.accept(markdownVisitor);
    String expected = "\n\nWord One\n"
            + "Word Two\n"
            + "Word Three";
    assertEquals(expected, actual);

    document.add(paragraph);
    assertEquals(expected, document.toText(new MarkdownStringVisitor()));
  }

  /**
   * A test that tests the markdownVisitor on Heading
   * of level 1.
   */

  @Test
  public void testMarkdownVisitorForHeadingOfLevel1() {
    TextElementVisitor<String> markdownVisitor = new MarkdownStringVisitor();

    String actual = heading.accept(markdownVisitor);
    String expected = "# Heading Text";
    assertEquals(expected, actual);

    document.add(heading);
    assertEquals(expected, document.toText(new MarkdownStringVisitor()));
  }

  /**
   * A test that tests the markdownVisitor on Heading
   * of level 2.
   */

  @Test
  public void testMarkdownVisitorForHeadingOfLevel2() {
    TextElementVisitor<String> markdownVisitor = new MarkdownStringVisitor();

    TextElement levelTwoHeading = new Heading("Heading With Level Two", 2);

    String actual = levelTwoHeading.accept(markdownVisitor);
    String expected = "\n## Heading With Level Two";
    assertEquals(expected, actual);

    document.add(levelTwoHeading);
    assertEquals(expected, document.toText(new MarkdownStringVisitor()));
  }

  /**
   * A test that tests the markdownVisitor on Heading
   * of level 3.
   */

  @Test
  public void testMarkdownVisitorForHeadingOfLevel3() {
    TextElementVisitor<String> markdownVisitor = new MarkdownStringVisitor();

    TextElement levelThreeHeading = new Heading("Heading With Level Three", 3);

    String actual = levelThreeHeading.accept(markdownVisitor);
    String expected = "\n### Heading With Level Three";
    assertEquals(expected, actual);

    document.add(levelThreeHeading);
    assertEquals(expected, document.toText(new MarkdownStringVisitor()));
  }

  /**
   * A test that tests the markdownVisitor on Headings
   * of different levels together.
   */

  @Test
  public void testMarkdownVisitorForHeadingsWithDifferentLevelsTogether() {
    TextElementVisitor<String> markdownVisitor = new MarkdownStringVisitor();

    String actual = heading.accept(markdownVisitor);
    String expected = "# Heading Text";
    assertEquals(expected, actual);
    document.add(heading);
    assertEquals(expected, document.toText(new MarkdownStringVisitor()));

    TextElement levelTwoHeading = new Heading("Heading With Level Two", 2);
    expected = "\n## Heading With Level Two";
    actual = levelTwoHeading.accept(markdownVisitor);
    assertEquals(expected, actual);
    document.add(levelTwoHeading);
    assertEquals("# Heading Text" + expected, document.toText(new MarkdownStringVisitor()));

    TextElement levelThreeHeading = new Heading("Heading With Level Three", 3);
    expected = "\n### Heading With Level Three";
    actual = levelThreeHeading.accept(markdownVisitor);
    assertEquals(expected, actual);

    document.add(levelThreeHeading);

    expected = "# Heading Text" + "\n## Heading With Level Two"
            + "\n### Heading With Level Three";
    assertEquals(expected, document.toText(new MarkdownStringVisitor()));
  }

  /**
   * A test that tests the markdownVisitor on Basic, Bold,
   * and Italic elements together.
   */
  @Test
  public void testMarkdownVisitorForBasicBoldAndItalicElementsTogether() {
    TextElementVisitor<String> markdownVisitor = new MarkdownStringVisitor();

    String expected = "\nBasic Text";

    document.add(basicText);
    assertEquals(expected, document.toText(new MarkdownStringVisitor()));

    expected += "\n**Bold Text**";
    document.add(boldText);
    assertEquals(expected, document.toText(new MarkdownStringVisitor()));


    expected += "\n*Italic Text*";
    document.add(italicText);
    assertEquals(expected, document.toText(new MarkdownStringVisitor()));
  }


  /**
   * A test that tests the markdownVisitor on Basic, Bold,
   * and Italic elements together.
   */
  @Test
  public void testMarkdownVisitorForAllElementsTogether() {
    TextElementVisitor<String> markdownVisitor = new MarkdownStringVisitor();

    String expected = "\nBasic Text";

    document.add(basicText);
    assertEquals(expected, document.toText(new MarkdownStringVisitor()));

    expected += "\n**Bold Text**";
    document.add(boldText);
    assertEquals(expected, document.toText(new MarkdownStringVisitor()));


    expected += "\n*Italic Text*";
    document.add(italicText);
    assertEquals(expected, document.toText(new MarkdownStringVisitor()));

    expected += "\n[Hyper Text](lichess.org)";
    document.add(hyperText);
    assertEquals(expected, document.toText(new MarkdownStringVisitor()));

    expected += "\n\nWord One\n"
            + "Word Two\n"
            + "Word Three";
    document.add(paragraph);
    assertEquals(expected, document.toText(new MarkdownStringVisitor()));
  }
}
