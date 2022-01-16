package organization;

import util.Gender;

/**
 * This class represents an internal employee who has no managerial
 * responsibilities.
 */
public class InternalEmployee extends NonManagerEmployee {
  /**
   * Constructor.
   * 
   * @param name   the name for this employee
   * @param pay    the pay for this employee
   * @param gender the gender for this employee
   */
  public InternalEmployee(String name, double pay, Gender gender) {
    super(name, pay, gender);
  }

  @Override
  public <R> R accept(EmployeeVisitor<R> visitor) {
    return visitor.visitInternalEmployee(this);
  }
}
