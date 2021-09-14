public class Main {
  public static void main(String[] args) {
//    Person person = new Person("Greg", 38, 99);
//    person.mainFunction();

//    Person employee = new Employee("Greg", 38, 99);
//    employee.mainFunction();

//    Person greg = new Person("Greg", 38, 99);
//    Person nick = new Person("Nick", 90, 130);
//    Person greg2 = new Person("Greg", 38, 99);
//
//    System.out.println("Greg and Nick");
//    System.out.println(greg.equals(nick));
//    System.out.println(nick.equals(greg));
//
//    System.out.println("Greg and Greg2");
//    System.out.println(greg.equals(greg2));
//    System.out.println(greg2.equals(greg));
//
//    System.out.println("Greg and Greg");
//    System.out.println(greg.equals(greg));
//
//    System.out.println("Greg hashscode: " + greg.hashCode() + " Greg: " + greg);
//    System.out.println("Nick hashcode: " + nick.hashCode() + " Nick " + nick);
//    System.out.println("Greg2 hashcode: " + greg2.hashCode() + " Greg2 " + greg2);
//
//    double d = 3.1;
//    System.out.println((int) d);

      Person greg = new Person("Greg", 38, 99);
      Person greg2 = new Person(greg);
    System.out.println(greg);
    System.out.println(greg2);
    System.out.println(greg == greg2);


  }
}
