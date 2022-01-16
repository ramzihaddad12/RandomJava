abstract class AnimalAbstract implements Animal{
    public void eat() {
      System.out.println("I am eating");
    }

    public void fly() {
      System.out.println("I am flying");
    }

    public void sleep() {
      System.out.println("zzzzz");
    }

    public Animal makeSound() {
      System.out.println("ROOOOOOAAAAR");
      return getAnimal();
    }

    abstract Animal getAnimal();

}
