package organization;

/**
 * This is an interface for the visitor on employees This interface offers a
 * chance to visit every kind of concrete employee in the hierarchy. Some
 * visitors may want this level of granularity, others may not
 * 
 * @param <R> the type of the return parameter for the visit
 */
public interface EmployeeVisitor<R> {
  /**
   * The action to take when visiting a contract employee.
   * 
   * @param e the contract employee
   * @return the element
   */
  R visitContractEmployee(ContractEmployee e);

  /**
   * The action to take when visiting a internal employee.
   * 
   * @param e the contract employee
   * @return the element
   */
  R visitInternalEmployee(InternalEmployee e);

  /**
   * The action to take when visiting a non-manager employee.
   * 
   * @param e the contract employee
   * @return the element
   */
  R visitNonManagerEmployee(NonManagerEmployee e);

  /**
   * The action to take when visiting a supervis employee.
   * 
   * @param e the contract employee
   * @return the element
   */
  R visitSupervisor(Supervisor e);
}
