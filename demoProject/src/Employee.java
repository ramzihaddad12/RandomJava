public class Employee extends Person {

  public Employee(String name, int age, int weight) {
    super(name, age, weight);
  }

  private void otherFunction(){
    System.out.println("I am in other function of Employee");
  }

  @Override
  public void mainFunction(){
    System.out.println("I am in main function of Employee");
    super.mainFunction();
  }
}
