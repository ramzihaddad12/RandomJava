import java.util.Arrays;

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

//      Person greg = new Person("Greg", 38, 99);
//      Person greg2 = new Person(greg);
//    System.out.println(greg);
//    System.out.println(greg2);
//    System.out.println(greg == greg2);

//    Animal animal = new Cat();
//    animal.eat();
//    animal.fly();
//    animal.sleep();
//    Animal newAnimal = animal.makeSound();
//    System.out.println(newAnimal.getClass());
//
//    String s = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
//    String[] arr = s.split("\n");
//    for (int i = 0; i < arr.length; i++){
//      System.out.println(arr[i]);
//      for (int j = 0; j < arr[i].length(); j++){
//        char c = arr[i].charAt(j);
//        if (c == '\t'){
//          System.out.println("YEE");
//        }
//      }
//    }
//    System.out.println(arr.length);

//    Vehicle bmw = new Vehicle (5, 1998);
//    Vehicle benz = new Vehicle(5, 1998);
//
//    System.out.println(bmw.equals(benz));

    //System.out.println(0.1 + 0.1 + 0.1);
    String s = "      4       ";
    String[] splitS = s.trim().split("\\s+");
    System.out.println(splitS.length);
    for (String str: splitS) {
      System.out.println(str.length());
    }

    String[] arr = new String[]{"HI", "a", "b"};
    System.out.println(Arrays.toString(arr));

  }
}
