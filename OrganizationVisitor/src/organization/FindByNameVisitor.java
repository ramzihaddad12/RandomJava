package organization;

/**
 * This visitor defines a find operation to find an employee by first and last
 * name in the hierarchy. It does so by doing a top-down left-right traversal
 * over the hierarchy
 */
public class FindByNameVisitor implements EmployeeVisitor<Boolean> {
  private String name;

  /**
   * Constructor.
   * 
   * @param name the name to look for
   */
  public FindByNameVisitor(String name) {
    this.name = name;
  }

  @Override
  public Boolean visitContractEmployee(ContractEmployee e) {
    return visitSingleNode(e);
  }

  @Override
  public Boolean visitInternalEmployee(InternalEmployee e) {
    return visitSingleNode(e);
  }

  @Override
  public Boolean visitNonManagerEmployee(NonManagerEmployee e) {
    return visitSingleNode(e);
  }

  /**
   * Predicate function.
   * 
   * @param e the employee
   * @return true if e has the name
   */
  private Boolean visitSingleNode(Employee e) {
    return e.getName().equals(name);
  }

  @Override
  public Boolean visitSupervisor(Supervisor e) {
    if (visitSingleNode(e)) {
      return true;
    }
    for (Employee emp : e.getSupervisees()) {
      if (emp.accept(this)) {
        return true;
      }
    }
    return false;
  }
}
