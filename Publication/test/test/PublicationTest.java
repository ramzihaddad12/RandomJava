package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import publication.Article;
import publication.Book;
import publication.Publication;
import publication.Webpage;

/**
 * Test class for the Publication and related classes written in lecture 1.
 */
public class PublicationTest {
  private Publication rushdie;
  private Publication turing;
  private Publication ccis;

  /** Setup method for all of the tests. */
  @Before
  public void setup() {
    rushdie = new Book("Midnight's Children", "Salman Rushdie", "Jonathan Cape", "London", 1980);

    turing = new Article("Computing machinery and intelligence", "A. M. Turing", "Mind", 59, 236,
        1950);

    ccis = new Webpage("Khoury at Northeastern University", "https://www.khoury.northeastern.edu/",
        "10th August 2018");

  }

  @Test
  public void testCiteApa() {

    String expectedOutput = "Salman Rushdie (1980). Midnight's Children. London: Jonathan Cape.";
    assertEquals(expectedOutput, rushdie.citeApa());

    expectedOutput = "A. M. Turing (1950). Computing machinery and "
        + "intelligence. Mind, 59(236).";
    assertEquals(expectedOutput, turing.citeApa());

    expectedOutput = "Khoury at Northeastern University. Retrieved 10th August "
        + "2018, from https://www.khoury.northeastern.edu/.";
    assertEquals(expectedOutput, ccis.citeApa());
  }

  @Test
  public void testCiteMla() {

    String expectedOutput = "Salman Rushdie. Midnight's Children. London: "
        + "Jonathan Cape, 1980.";
    assertEquals(expectedOutput, rushdie.citeMla());

    expectedOutput = "A. M. Turing. \"Computing machinery and "
        + "intelligence.\" Mind 59.236 (1950).";
    assertEquals(expectedOutput, turing.citeMla());

    expectedOutput = "\"Khoury at Northeastern University.\" Web. 10th August "
        + "2018 <https://www.khoury.northeastern.edu/>.";
    assertEquals(expectedOutput, ccis.citeMla());
  }
}