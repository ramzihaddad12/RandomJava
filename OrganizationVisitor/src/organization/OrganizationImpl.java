package organization;

import util.Gender;
import util.Organization;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class represents an organization with employees.
 */

public class OrganizationImpl implements Organization {
  private Employee root;

  /**
   * Constructor.
   * 
   * @param nameCeo the name of the CEO for this organization
   * @param pay     the pay for the CEO of this organization
   * @param gender  the gender for the CEO of this organization
   */
  public OrganizationImpl(String nameCeo, double pay, Gender gender) {
    root = new InternalEmployee(nameCeo, pay, gender);
  }

  @Override
  public void addEmployee(String name, double pay, Gender gender, String supervisorName) {
    Employee newEmployee = new NonManagerEmployee(name, pay, gender);
    root = root.addSupervisee(supervisorName, newEmployee);
  }

  @Override
  public void addContractEmployee(String name, double pay, Gender gender, int endDate, int endMonth,
      int endYear, String supervisorName) {
    Employee newEmployee = new ContractEmployee(name, pay, gender, endDate, endMonth, endYear);
    root = root.addSupervisee(supervisorName, newEmployee);
  }

  @Override
  public int getSize() {
    return root.accept(new CountingVisitor(b -> true));
  }

  @Override
  public int getSizeByGender(Gender gender) {
    return root.accept(new CountingVisitor(b -> b.getGender() == gender));
  }

  @Override
  public List<String> allEmployees() {
    return root.accept(new ToListVisitor()).stream().map(e -> e.getName())
        .collect(Collectors.toList());
  }

  @Override
  public int countPayAbove(double amount) {
    return root.accept(new CountingVisitor(b -> b.getAnnualPay() > amount));
  }

  @Override
  public int terminatedBefore(int date, int month, int year) {
    LocalDate threshold;

    try {
      threshold = LocalDate.of(year, month, date);
    } catch (DateTimeException e) {
      return 0;
    }
    return root.accept(new CountingVisitor(b -> {
      if (b.getEmploymentEndDate() == null) {
        return false;
      } else {
        LocalDate d = b.getEmploymentEndDate();
        return d.compareTo(threshold) < 0;
      }
    }));
  }
}
