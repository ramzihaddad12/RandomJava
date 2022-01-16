package house;

import animal.Animal;
import animal.Monkey;
import animal.Sex;
import animal.Size;
import animal.Species;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * An enclosure represents a type of housing where an enclosure
 * can only house animals of the same species.
 */
public class Enclosure extends Housing {
  private int capacity;
  private int usedCapacity;
  private List<Animal> animalsInEnclosure;

  /**
   * Constructs an enclosure in terms of the capacity.
   *
   * @param capacity the capacity of the enclosure in m^2
   * @throws IllegalArgumentException if any argument is negative or null
   */

  public Enclosure(int capacity) throws IllegalArgumentException {
    if (capacity < 0) {
      throw new IllegalArgumentException("Negative arguments not allowed");
    }
    this.capacity = capacity;
    this.usedCapacity = 0;
    this.animalsInEnclosure = new ArrayList<>();
  }

  /**
   * {@inheritDoc}
   */

  public void add(List<Animal> animalsToBeAdded) {
    for (Animal animal : animalsToBeAdded) {
      add(animal);
    }
  }

  /**
   * {@inheritDoc}
   */

  public void add(Animal animalToBeAdded) throws IllegalArgumentException {
    Species speciesOfList = getSpecies();
    if (idExists(animalToBeAdded.getId(), animalsInEnclosure)) {
      throw new IllegalArgumentException("Id already exists in the isolation");
    }
    if (isEmpty()) {
      if (animalToBeAdded.getSize().getArea() <= capacity - usedCapacity) {
        animalsInEnclosure.add(animalToBeAdded);
        usedCapacity += animalToBeAdded.getSize().getArea();
        return;
      } else {
        throw new IllegalArgumentException("Not enough room to add the animal to the enclosure");
      }
    }

    if (speciesOfList == animalToBeAdded.getSpecies()
            && animalToBeAdded.getSize().getArea() <= capacity - usedCapacity) {
      animalsInEnclosure.add(animalToBeAdded);
      usedCapacity += animalToBeAdded.getSize().getArea();
      return;
    } else {
      throw new IllegalArgumentException("Not enough room to add the animal to the enclosure");
    }
  }

  /**
   * {@inheritDoc}
   */
  public Animal remove(int idOfAnimal) {
    int indexToBeRemoved = getIndexOfMonkey(idOfAnimal, animalsInEnclosure);
    Animal animalToBeRemoved = animalsInEnclosure.get(indexToBeRemoved);
    animalsInEnclosure.remove(indexToBeRemoved);
    usedCapacity -= animalToBeRemoved.getSize().getArea();
    return animalToBeRemoved;
  }

  /**
   * {@inheritDoc}
   */

  public List<Animal> remove(List<Integer> idsOfAnimals) {
    List<Animal> animalsToBeRemoved = new ArrayList<>();

    for (int idOfAnimal : idsOfAnimals) {
      animalsToBeRemoved.add(remove(idOfAnimal));
    }

    return animalsToBeRemoved;
  }

  /**
   * {@inheritDoc}
   */
  public void resize(int newCapacity) throws IllegalArgumentException {
    if (newCapacity < capacity) {
      throw new IllegalArgumentException("Negative arguments not allowed");
    }
    this.capacity = newCapacity;
  }

  /**
   * {@inheritDoc}
   */

  public void changeAnimalAge(int idOfAnimal, int newAge) {
    updateAnimalAge(idOfAnimal, newAge, animalsInEnclosure);
  }

  /**
   * {@inheritDoc}
   */

  public void changeAnimalSize(int idOfAnimal, Size newSize) {
    updateAnimalSize(idOfAnimal, newSize, animalsInEnclosure);
  }

  /**
   * {@inheritDoc}
   */

  public void changeAnimalSex(int idOfAnimal, Sex newSex) {
    updateAnimalSex(idOfAnimal, newSex, animalsInEnclosure);
  }

  /**
   * {@inheritDoc}
   */

  public void changeAnimalWeight(int idOfAnimal, int newWeight) {
    updateAnimalWeight(idOfAnimal, newWeight, animalsInEnclosure);
  }

  /**
   * {@inheritDoc}
   */

  public void changeAnimalFavFood(int idOfAnimal, String newFavFood) {
    updateAnimalFavFood(idOfAnimal, newFavFood, animalsInEnclosure);
  }

  /**
   * {@inheritDoc}
   */

  public Map<String, Integer> getFoodList() {
    return getFoodListOfHouse(animalsInEnclosure);
  }

  /**
   * {@inheritDoc}
   */

  public List<Animal> getAnimalsInside() {
    List<Animal> animalsInEnclosureCopy = new ArrayList<>();

    for (Animal animal: animalsInEnclosure) {
      animalsInEnclosureCopy.add(new Monkey(animal));
    }
    return animalsInEnclosureCopy;
  }

  /**
   * Informs if the enclosure is empty or not.
   *
   * @return true or false depending on if enclosure is empty or not
   */

  public boolean isEmpty() {
    return animalsInEnclosure.isEmpty();
  }

  /**
   * Gets the capacity of the enclosure.
   *
   * @return the capacity of the enclosure
   */

  public int getCapacity() {
    return capacity;
  }

  /**
   * Gets the species that is housed in the enclosure.
   *
   * @return the species class that is housed in the enclosure
   */

  public Species getSpecies() {
    if (!animalsInEnclosure.isEmpty()) {
      return animalsInEnclosure.get(0).getSpecies();
    }
    return null;
  }

  /**
   * Gets the signs of the animals in the enclosure.
   *
   * @return the signs of the animals in the enclosure
   */

  public List<Sign> getSign() {
    return getSignOfHouse(animalsInEnclosure);
  }

}
