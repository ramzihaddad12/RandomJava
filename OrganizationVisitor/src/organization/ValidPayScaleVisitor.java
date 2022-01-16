package organization;

/**
 * An example of a visitor that determines if a pay scale is valid. This visitor
 * implements the operation: "Does every manager make more than all of the
 * subordinates of that manager?" The subordinate is anybody who works under
 * this supervisor, directly or indirectly
 */
public class ValidPayScaleVisitor implements EmployeeVisitor<Boolean> {

  @Override
  public Boolean visitContractEmployee(ContractEmployee e) {
    return true;
  }

  @Override
  public Boolean visitInternalEmployee(InternalEmployee e) {
    return true;
  }

  @Override
  public Boolean visitNonManagerEmployee(NonManagerEmployee e) {
    return true;
  }

  @Override
  public Boolean visitSupervisor(Supervisor e) {
    Boolean result = true;
    for (Employee emp : e.getSupervisees()) {
      result = result && emp.accept(this) && e.getAnnualPay() > emp.accept(new MaxSalaryVisitor());
    }
    return result;
  }

}
