public class Cat extends AnimalAbstract{

  Animal getAnimal() {
    System.out.println("Got a cat");
    return new Cat();
  }

}