package organization;

import java.util.function.Predicate;

/**
 * This visitor performs counting operations on the hierarchy. It can work on an
 * optional predicate to filter certain nodes.
 */
public class CountingVisitor implements EmployeeVisitor<Integer> {

  private Predicate<Employee> condition;

  /**
   * Constructor.
   */
  public CountingVisitor() {
    // default is that the predicate is a tautology
    condition = e -> true;
  }

  /**
   * Constructor with the predicate that must be satisfied.
   * 
   * @param c the predicate
   */
  public CountingVisitor(Predicate<Employee> c) {
    condition = c;
  }

  @Override
  public Integer visitContractEmployee(ContractEmployee e) {
    return visitHelper(e);
  }

  /**
   * Helper counting employees and all of the employees that report to them.
   * 
   * @param e the supervisor
   * @return the number of employees rooted here
   */
  private Integer visitCompositeHelper(Supervisor e) {
    int count = 0;
    if (condition.test(e)) {
      count += 1;
    }
    for (Employee sup : e.getSupervisees()) {
      count += sup.accept(this);
    }
    return count;
  }

  /**
   * Helper for counting an employee.
   * 
   * @param e the employee
   * @return 1 if the employee shuld be counted, 0 if not
   */
  private Integer visitHelper(Employee e) {
    if (condition.test(e)) {
      return 1;
    }
    return 0;
  }

  @Override
  public Integer visitInternalEmployee(InternalEmployee e) {
    return visitHelper(e);
  }

  @Override
  public Integer visitNonManagerEmployee(NonManagerEmployee e) {
    return visitHelper(e);
  }

  @Override
  public Integer visitSupervisor(Supervisor e) {
    return visitCompositeHelper(e);
  }
}
