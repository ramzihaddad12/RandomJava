public class Vehicle {
  private int price;
  private int yearProduced;

  Vehicle(int price, int yearProduced){
    this.price = price;
    this.yearProduced = yearProduced;
  }

  public int getPrice() {
    return price;
  }

  public int getYearProduced() {
    return yearProduced;
  }

  @Override
  public boolean equals(Object o){
    if (this == o) {
      return true;
    }

    if (!(o instanceof Vehicle)) {
      return false;
    }

    Vehicle that = (Vehicle) o;

    return price == that.price && yearProduced == that.yearProduced;
  }
}
