package organization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This visitor converts the organization hierarchy to a list of employees.
 */
public class ToListVisitor implements EmployeeVisitor<List<Employee>> {
  @Override
  public List<Employee> visitContractEmployee(ContractEmployee e) {
    return visitSingle(e);
  }

  @Override
  public List<Employee> visitInternalEmployee(InternalEmployee e) {
    return visitSingle(e);
  }

  @Override
  public List<Employee> visitNonManagerEmployee(NonManagerEmployee e) {
    return visitSingle(e);
  }

  @Override
  public List<Employee> visitSupervisor(Supervisor e) {
    return visitComposite(e);
  }

  /**
   * Helper to convert the employee to a list of employees.
   * 
   * @param e the employee
   * @return a list containing the employee
   */
  private List<Employee> visitSingle(NonManagerEmployee e) {
    return Arrays.asList(e);
  }

  /**
   * Helper to convert a supervisor to a list of employees.
   * 
   * @param e the supervisor
   * @return a list containing the supervisor and all of their supervisees
   */
  private List<Employee> visitComposite(Supervisor e) {
    List<Employee> list = new ArrayList<>();
    list.add(e);
    for (Employee emp : e.getSupervisees()) {
      list.addAll(emp.accept(this));
    }
    return list;
  }
}
