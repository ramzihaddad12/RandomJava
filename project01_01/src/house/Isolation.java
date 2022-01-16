package house;

import animal.Animal;
import animal.Monkey;
import animal.Sex;
import animal.Size;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * An isolation represents a type of housing that contains
 * a number of cages.
 */

public class Isolation extends Housing {
  private int numOfCages;
  private List<Animal> animalsInIsolation;

  /**
   * Constructs an isolation in terms of the number of cages.
   *
   * @param numOfCages the number of cages in the isolation
   * @throws IllegalArgumentException if any argument is negative
   */
  public Isolation(int numOfCages) throws IllegalArgumentException {
    if (numOfCages < 0) {
      throw new IllegalArgumentException("Negative argument not allowed");
    }
    this.numOfCages = numOfCages;
    this.animalsInIsolation = new ArrayList<>();
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
    if (animalsInIsolation.size() == numOfCages) {
      throw new IllegalArgumentException("No more room in isolation");
    }

    if (idExists(animalToBeAdded.getId(), animalsInIsolation)) {
      throw new IllegalArgumentException("Id already exists in the isolation");
    }
    animalsInIsolation.add(animalToBeAdded);
  }

  /**
   * {@inheritDoc}
   */

  public Animal remove(int idOfAnimal) {
    int indexToBeRemoved = getIndexOfMonkey(idOfAnimal, animalsInIsolation);
    Animal animalToBeRemoved = animalsInIsolation.get(indexToBeRemoved);
    animalsInIsolation.remove(indexToBeRemoved);
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
    if (newCapacity < numOfCages) {
      throw new IllegalArgumentException("Negative arguments not allowed");
    }
    this.numOfCages = newCapacity;
  }

  /**
   * {@inheritDoc}
   */

  public Map<String, Integer> getFoodList() {
    return getFoodListOfHouse(animalsInIsolation);
  }

  /**
   * {@inheritDoc}
   */

  public List<Animal> getAnimalsInside() {
    List<Animal> animalsInIsolationCopy = new ArrayList<>();

    for (Animal animal: animalsInIsolation) {
      animalsInIsolationCopy.add(new Monkey(animal));
    }
    return animalsInIsolationCopy;
  }

  /**
   * {@inheritDoc}
   */

  public void changeAnimalAge(int idOfAnimal, int newAge) {
    updateAnimalAge(idOfAnimal, newAge, animalsInIsolation);
  }

  /**
   * {@inheritDoc}
   */

  public void changeAnimalSize(int idOfAnimal, Size newSize) {
    updateAnimalSize(idOfAnimal, newSize, animalsInIsolation);
  }

  /**
   * {@inheritDoc}
   */

  public void changeAnimalSex(int idOfAnimal, Sex newSex) {
    updateAnimalSex(idOfAnimal, newSex, animalsInIsolation);
  }

  /**
   * {@inheritDoc}
   */

  public void changeAnimalWeight(int idOfAnimal, int newWeight) {
    updateAnimalWeight(idOfAnimal, newWeight, animalsInIsolation);
  }

  /**
   * {@inheritDoc}
   */

  public void changeAnimalFavFood(int idOfAnimal, String newFavFood) {
    updateAnimalFavFood(idOfAnimal, newFavFood, animalsInIsolation);
  }

  /**
   * Gets the number of cages in the isolation.
   *
   * @return number of occupied cages
   */

  public int getNumberOfCages() {
    return numOfCages;
  }

  /**
   * Gets the number of occupied cages in the isolation.
   *
   * @return number of occupied cages
   */

  public int getNumOfOccupiedCages() {
    return animalsInIsolation.size();
  }




}
