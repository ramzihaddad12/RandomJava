package currency;

public enum USMoney {
  PENNY(1), NICKEL(5), DIME(10), QUARTER(25),
  DOLLAR(100), FIVE(500), TEN(1000), TWENTY(2000),
  FIFTY(5000), HUNDRED(10000);

  private final int cents; // enums should never be mutable

  USMoney(int cents) {
    if (cents < 1) {
      throw new IllegalArgumentException("Cents must be pos");
    }
    this.cents = cents;
  }

  public int getCents() {
    return cents;
  }

  @Override
  public String toString() {
    return "$" + String.format("%.2f", this.cents / 100.0);
  }
}
