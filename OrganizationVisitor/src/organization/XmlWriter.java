package organization;

/**
 * This visitor is used to create and return the XML representation of the
 * employee tree as a string.
 */
public class XmlWriter implements EmployeeVisitor<String> {

  @Override
  public String visitContractEmployee(ContractEmployee e) {
    return "<contractemployee name=\"" + e.getName() + "\" endDate=\""
        + e.getEmploymentEndDate().getDayOfMonth() + "\" endMonth=\""
        + e.getEmploymentEndDate().getMonthValue() + "\" endYear=\""
        + e.getEmploymentEndDate().getYear() + "\"></contractemployee>";
  }

  @Override
  public String visitInternalEmployee(InternalEmployee e) {
    return "<internalemployee name=\"" + e.getName() + "\"></internalemployee>";
  }

  @Override
  public String visitNonManagerEmployee(NonManagerEmployee e) {
    return "<nonmanager name=\"" + e.getName() + "\"></nonmanager>";
  }

  @Override
  public String visitSupervisor(Supervisor e) {
    StringBuilder sb = new StringBuilder();
    sb.append("<supervisor name=\"" + e.getName() + "\">");

    for (Employee emp : e.getSupervisees()) {
      sb.append(emp.accept(this));
    }
    sb.append("</supervisor>");
    return sb.toString();
  }
}
