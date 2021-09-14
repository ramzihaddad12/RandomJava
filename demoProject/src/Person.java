public class Person {
  private final String name;
  private final int age;
  private final int weight;

  public Person(String name, int age, int weight) {
    this.name = name;
    this.age = age;
    this.weight = weight;
  }

  public Person(Person p) {
    System.out.println("Copy constructor called");
    this.name = p.name;
    this.age = p.age;
    this.weight = p.weight;
  }
  public String getName(){
    return name;
  }

  public int getAge() {
    return age;
  }

  public int getWeight() {
    return weight;
  }

  private void otherFunction(){
    System.out.println("I am in other function");
  }

  public void mainFunction(){
    System.out.println("I am in main fucntion");
    otherFunction();
  }

  @Override
  public boolean equals(Object o){
    if (this == o) {
      return true;
    }

    if (!(o instanceof Person)) {
      return false;
    }

    Person that = (Person) o;

    return name == that.getName() && age == that.getAge() && weight == that.getWeight();
  }
}
