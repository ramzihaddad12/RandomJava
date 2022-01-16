package organization;

/**
 * This visitor computes the maximum salary in an organization.
 */

public class MaxSalaryVisitor implements EmployeeVisitor<Double> {

  @Override
  public Double visitContractEmployee(ContractEmployee e) {
    return maxSalary(e);
  }

  @Override
  public Double visitInternalEmployee(InternalEmployee e) {
    return maxSalary(e);
  }

  @Override
  public Double visitNonManagerEmployee(NonManagerEmployee e) {
    return maxSalary(e);
  }

  @Override
  public Double visitSupervisor(Supervisor e) {
    return maxSalary(e);
  }

  /**
   * Gets the maximum salary for the employee.
   * 
   * @param e the employee
   * @return the maximum salary
   */
  private Double maxSalary(NonManagerEmployee e) {
    return e.getAnnualPay();
  }

  /**
   * Get the maximum salary for the employee or any employee that works for them.
   * 
   * @param e the supervisor
   * @return the maximum salary
   */
  private Double maxSalary(Supervisor e) {
    Double max = e.getAnnualPay();
    for (Employee emp : e.getSupervisees()) {
      max = Math.max(max, emp.accept(this));
    }
    return max;
  }
}
