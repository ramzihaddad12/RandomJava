import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import organization.ContractEmployee;
import organization.CountingVisitor;
import organization.Employee;
import organization.FindByNameVisitor;
import organization.InternalEmployee;
import organization.MaxSalaryVisitor;
import organization.ToListVisitor;
import organization.ValidPayScaleVisitor;
import organization.XmlWriter;
import util.Gender;

import java.util.List;
import java.util.stream.Collectors;

/** Tests for the employees. */
public class EmployeeTest {
  private Employee ccis;
  private Employee startup;

  @Before
  public void setup() {

    Employee carla = new InternalEmployee("Carla Brodley", 400000, Gender.Female);

    ccis = carla; // the root of this tree

    Employee jay = new InternalEmployee("Jay Aslam", 350000, Gender.Male);

    Employee raj = new InternalEmployee("Rajmohan Rajaraman", 300000, Gender.Male);

    Employee tip = new InternalEmployee("Frank Tip", 300000, Gender.Male);

    Employee mislove = new InternalEmployee("Alan Mislove", 150000, Gender.Male);

    Employee martin = new InternalEmployee("Martin Schedlbauer", 100000, Gender.Male);

    Employee shesh = new InternalEmployee("Amit Shesh", 100000, Gender.Male);

    Employee razzaq = new InternalEmployee("Leena Razzaq", 120000, Gender.Female);

    Employee lackaye = new InternalEmployee("Bryan Lackaye", 150000, Gender.Male);

    Employee omerod = new InternalEmployee("Michelle Omerod", 100000, Gender.Female);

    Employee gale = new InternalEmployee("Sarah Gale", 100000, Gender.Female);

    Employee gill = new InternalEmployee("Catherine Gill", 200000, Gender.Female);

    Employee barry = new InternalEmployee("Megan Barry", 100000, Gender.Female);

    ccis = ccis.addSupervisee("Carla Brodley", jay);
    ccis = ccis.addSupervisee("Jay Aslam", raj);
    ccis = ccis.addSupervisee("Jay Aslam", tip);
    ccis = ccis.addSupervisee("Jay Aslam", mislove);
    ccis = ccis.addSupervisee("Alan Mislove", martin);
    ccis = ccis.addSupervisee("Frank Tip", shesh);
    ccis = ccis.addSupervisee("Frank Tip", razzaq);
    ccis = ccis.addSupervisee("Carla Brodley", lackaye);
    ccis = ccis.addSupervisee("Bryan Lackaye", omerod);
    ccis = ccis.addSupervisee("Bryan Lackaye", gale);
    ccis = ccis.addSupervisee("Carla Brodley", gill);
    ccis = ccis.addSupervisee("Catherine Gill", barry);

    /////////////////
    Employee bob = new InternalEmployee("Bob", 50000, Gender.UnDisclosed);

    Employee bill = new InternalEmployee("Bill", 20000, Gender.Male);

    Employee michelle = new InternalEmployee("Michelle", 30000, Gender.Female);

    Employee mark = new ContractEmployee("Mark", 10000, Gender.Male, 1, 9, 2018);

    Employee amit = new InternalEmployee("Amit", 10000, Gender.Male);

    Employee chuck = new ContractEmployee("Chuck", 10000, Gender.UnDisclosed, 1, 12, 2018);

    Employee tom = new ContractEmployee("Tom", 40000, Gender.Male, 15, 10, 2018);

    Employee tim = new ContractEmployee("Tim", 5000, Gender.Male, 15, 9, 2018);

    startup = bob;
    startup = startup.addSupervisee("Bob", bill);
    startup = startup.addSupervisee("Bob", michelle);
    startup = startup.addSupervisee("Bill", mark);
    startup = startup.addSupervisee("Bill", amit);
    startup = startup.addSupervisee("Michelle", chuck);
    startup = startup.addSupervisee("Bill", tom);
    startup = startup.addSupervisee("Michelle", tim);

  }

  @Test
  public void testGetSize() {
    assertEquals(Integer.valueOf(13), ccis.accept(new CountingVisitor(e -> true)));
    assertEquals(Integer.valueOf(6),
        ccis.accept(new CountingVisitor(e -> e.getGender() == Gender.Female)));
    assertEquals(Integer.valueOf(7),
        ccis.accept(new CountingVisitor(e -> e.getGender() == Gender.Male)));

    assertEquals(Integer.valueOf(8), startup.accept(new CountingVisitor(e -> true)));
    assertEquals(Integer.valueOf(1),
        startup.accept(new CountingVisitor(e -> e.getGender() == Gender.Female)));
    assertEquals(Integer.valueOf(5),
        startup.accept(new CountingVisitor(e -> e.getGender() == Gender.Male)));
    assertEquals(Integer.valueOf(2),
        startup.accept(new CountingVisitor(e -> e.getGender() == Gender.UnDisclosed)));
  }

  @Test
  public void testAllEmployees() {
    List<String> actualResult = ccis.accept(new ToListVisitor()).stream().map(e -> e.getName())
        .collect(Collectors.toList());
    String expected = "[Carla Brodley, Jay Aslam, Rajmohan Rajaraman, Frank "
        + "Tip, Amit Shesh, Leena Razzaq, Alan Mislove, Martin "
        + "Schedlbauer, Bryan Lackaye, Michelle Omerod, Sarah "
        + "Gale, Catherine Gill, Megan Barry]";
    assertEquals(expected, actualResult.toString());

    actualResult = startup.accept(new ToListVisitor()).stream().map(e -> e.getName())
        .collect(Collectors.toList());
    expected = "[Bob, Bill, Mark, Amit, Tom, Michelle, Chuck, Tim]";
    assertEquals(expected, actualResult.toString());
  }

  @Test
  public void testEmployeePay() {
    assertEquals(Integer.valueOf(5),
        ccis.accept(new CountingVisitor(b -> b.getAnnualPay() > 150000)));
    assertEquals(Integer.valueOf(2),
        ccis.accept(new CountingVisitor(b -> b.getAnnualPay() > 300000)));
  }

  @Test
  public void testMaximumSalary() {
    assertEquals(Double.valueOf(400000), ccis.accept(new MaxSalaryVisitor()));
    assertEquals(Double.valueOf(50000), startup.accept(new MaxSalaryVisitor()));
  }

  @Test
  public void testValidPay() {
    assertFalse(startup.accept(new ValidPayScaleVisitor()));
    assertTrue(ccis.accept(new ValidPayScaleVisitor()));
  }

  @Test
  public void testFindByName() {
    assertTrue(startup.accept(new FindByNameVisitor("Bob")));
    assertTrue(startup.accept(new FindByNameVisitor("Bill")));
    assertTrue(startup.accept(new FindByNameVisitor("Michelle")));
    assertTrue(startup.accept(new FindByNameVisitor("Mark")));
    assertTrue(startup.accept(new FindByNameVisitor("Amit")));
    assertTrue(startup.accept(new FindByNameVisitor("Chuck")));
    assertTrue(startup.accept(new FindByNameVisitor("Tom")));
    assertTrue(startup.accept(new FindByNameVisitor("Tim")));

    assertFalse(startup.accept(new FindByNameVisitor("Michael")));
    assertFalse(startup.accept(new FindByNameVisitor("Richard")));
    assertFalse(startup.accept(new FindByNameVisitor("Clark")));

  }

  @Test
  public void testXml() {
    String expected = "<supervisor name=\"Bob\">" + "  <supervisor name=\"Bill\">"
        + "    <contractemployee name=\"Mark\" endDate=\"1\" " + "endMonth=\"9\" "
        + "endYear=\"2018\"></contractemployee>"
        + "    <internalemployee name=\"Amit\"></internalemployee>"
        + "    <contractemployee name=\"Tom\" " + "endDate=\"15\" endMonth=\"10\" "
        + "endYear=\"2018\"></contractemployee>" + "  </supervisor>"
        + "  <supervisor name=\"Michelle\">" + "    <contractemployee name=\"Chuck\" "
        + "endDate=\"1\" endMonth=\"12\" " + "endYear=\"2018\"></contractemployee>"
        + "    <contractemployee name=\"Tim\" " + "endDate=\"15\" endMonth=\"9\" "
        + "endYear=\"2018\"></contractemployee>" + "  </supervisor>" + "</supervisor>";

    String actual = startup.accept(new XmlWriter());
    expected = expected.replaceAll("\\s+", "");
    actual = actual.replaceAll("\\s+", "");
    assertEquals(expected, actual);
  }
}