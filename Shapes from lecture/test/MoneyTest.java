import currency.USMoney;
import org.junit.Test;

public class MoneyTest {
  @Test
  public void testMoney() {
    System.out.println(USMoney.NICKEL.toString());
    USMoney cash = USMoney.QUARTER;

    if (cash == USMoney.PENNY) {
      System.out.println("This is a penny");
    } else if (cash == USMoney.NICKEL) {
      System.out.println("This is a nickel");
    } else if (cash == USMoney.QUARTER) {
      //
    }

    switch (cash) {
      case PENNY:
        System.out.println("This is a penny");
        break;
      case NICKEL:
        System.out.println("This is a nickel");
        // DANGER: missing break here
      case QUARTER:
        System.out.println("This is a quarter");
        break;
      default:
        throw new IllegalStateException("Invalid denomination");

    }

  }
}
