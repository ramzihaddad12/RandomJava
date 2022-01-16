public class Dog extends AnimalAbstract{

  Animal getAnimal() {
    System.out.println("Got a new dog");
    return new Dog();
  }

}
