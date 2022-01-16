package organization;

import util.Gender;

import java.time.LocalDate;

/**
 * This interface represents a single employee in the organization. Every
 * employee is guaranteed to have a name, gender and pay on record
 */

public interface Employee {
  /**
   * Get the name of this employee.
   * 
   * @return the name of this employee as a string
   */
  String getName();

  /**
   * Get the gender of this employee as per the organization records.
   * 
   * @return the gender of this employee as an enum {@link organization.Gender}
   */
  Gender getGender();

  /**
   * Get the annual pay of this employee as per the organization records.
   * 
   * @return the annual pay of this employee
   */
  double getAnnualPay();

  /**
   * Add the given employee as the supervisee of the employee with the given name.
   * This method has no effect on the hierarchy if the supervisor cannot be found.
   * 
   * @param supervisorName the name of the supervisor
   * @param supervisee     the employee that will be supervised by this employee
   * @return the resulting hierarchy of this employee
   */
  Employee addSupervisee(String supervisorName, Employee supervisee);

  /**
   * Transform a visitor into elements.
   * 
   * @param <R>     the type of elements in the visitor
   * @param visitor the visitor to use
   * @return the accepted element
   */
  <R> R accept(EmployeeVisitor<R> visitor);

  /**
   * Returns the date of the end of employment of this employee.
   * 
   * @return the date as LocalDate object. It returns null if there is no
   *         termination date for this employee.
   */
  LocalDate getEmploymentEndDate();

}
