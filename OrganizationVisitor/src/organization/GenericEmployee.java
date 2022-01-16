package organization;

import util.Gender;

import java.time.LocalDate;

/**
 * This class represents the data and operations of any employee. It defines all
 * the operations that either ought to be common to all implementations, or have
 * a reasonable default to be overridden by them.
 */

public abstract class GenericEmployee implements Employee {
  protected String name;
  protected double pay;
  protected Gender gender;

  /**
   * Constructor.
   * 
   * @param name   the name of this employee
   * @param pay    the pay for this employee
   * @param gender the gender for this employee
   */
  public GenericEmployee(String name, double pay, Gender gender) {
    this.name = name;
    this.pay = pay;
    this.gender = gender;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public Gender getGender() {
    return this.gender;
  }

  @Override
  public double getAnnualPay() {
    return this.pay;
  }

  /**
   * By default, there is no end date for an employee. Only contract employees
   * have an actual end date.
   * 
   * @return
   */
  @Override
  public LocalDate getEmploymentEndDate() {
    return null;
  }
}
