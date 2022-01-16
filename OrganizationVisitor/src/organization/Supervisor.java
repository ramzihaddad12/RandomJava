package organization;

import util.Gender;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * This class represents an employee in a supervisory role. This means that this
 * employee supervises at least one other employee
 */
public class Supervisor extends GenericEmployee {

  private List<Employee> supervisee;

  /**
   * Constructor.
   * 
   * @param name   the name of this employee
   * @param pay    the pay for this employee
   * @param gender the gender of this employee
   */
  public Supervisor(String name, double pay, Gender gender) {
    super(name, pay, gender);
    supervisee = new LinkedList<Employee>();
  }

  /**
   * Accessor for the employees that report to this supervisor.
   * 
   * @return the list of employees that report to this supervisor
   */
  public List<Employee> getSupervisees() {
    return Collections.unmodifiableList(supervisee);
  }

  @Override
  public Employee addSupervisee(String supervisorName, Employee supervisee) {
    if (this.name.equals(supervisorName)) {
      this.supervisee.add(supervisee);
      return this;
    }
    for (int i = 0; i < this.supervisee.size(); i++) {
      this.supervisee.set(i, this.supervisee.get(i).addSupervisee(supervisorName, supervisee));
    }
    return this;
  }

  @Override
  public <R> R accept(EmployeeVisitor<R> visitor) {
    return visitor.visitSupervisor(this);
  }
}
