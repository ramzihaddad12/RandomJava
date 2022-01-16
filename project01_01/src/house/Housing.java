package house;

import animal.Animal;
import animal.Sex;
import animal.Size;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Housing represents an abstract class that represents generic housing functionalities.
 */
abstract class Housing {

  /**
   * adds animals to the isolation.
   *
   * @param animalsToBeAdded the animals to be added to the isolation.
   */

  public abstract void add(List<Animal> animalsToBeAdded);

  /**
   * adds an animal to the isolation.
   *
   * @param animalToBeAdded the animal to be added to the isolation
   * @throws IllegalArgumentException if animal cannot be added to the isolation
   */

  public abstract void add(Animal animalToBeAdded) throws IllegalArgumentException;

  /**
   * removes an animal from the isolation given its id.
   *
   * @param idOfAnimal the id of the animal to be removed
   * @return the animal that was removed
   */

  public abstract Animal remove(int idOfAnimal);

  /**
   * removes animals from the isolation given their ids.
   *
   * @param idsOfAnimals the ids of the animal to be removed
   * @return the animals that were removed
   */

  public abstract List<Animal> remove(List<Integer> idsOfAnimals);

  /**
   * resizes the house to a new capacity.
   *
   * @param newCapacity the new capacity of the house
   * @throws IllegalArgumentException if new capacity is negative
   */

  public abstract void resize(int newCapacity) throws IllegalArgumentException;

  /**
   * Gets the food list of the animals in the enclosure.
   *
   * @return the ood list of the animals in the enclosure as a map
   */

  public abstract Map<String, Integer> getFoodList();

  /**
   * Gets the animals in the house.
   *
   * @return the animals in the house
   */

  public abstract List<Animal> getAnimalsInside();

  public abstract void changeAnimalAge(int idOfAnimal, int newAge);

  public abstract void changeAnimalSize(int idOfAnimal, Size newSize);

  public abstract void changeAnimalSex(int idOfAnimal, Sex newSex);

  public abstract void changeAnimalWeight(int idOfAnimal, int newWeight);

  public abstract void changeAnimalFavFood(int idOfAnimal, String newFavFood);

  protected static void updateAnimalAge(int idOfAnimal, int newAge, List<Animal> animals) {
    if (!idExists(idOfAnimal, animals)) {
      throw new IllegalArgumentException("id not available here!");
    }

    for (Animal animal: animals) {
      if (animal.getId() == idOfAnimal) {
        animal.setAge(newAge);
        return;
      }
    }
  }

  protected static void updateAnimalSize(int idOfAnimal, Size newSize, List<Animal> animals) {
    if (!idExists(idOfAnimal, animals)) {
      throw new IllegalArgumentException("id not available here!");
    }

    for (Animal animal: animals) {
      if (animal.getId() == idOfAnimal) {
        animal.setSize(newSize);
        return;
      }
    }
  }

  protected static void updateAnimalSex(int idOfAnimal, Sex newSex, List<Animal> animals) {
    if (!idExists(idOfAnimal, animals)) {
      throw new IllegalArgumentException("id not available here!");
    }

    for (Animal animal: animals) {
      if (animal.getId() == idOfAnimal) {
        animal.setSex(newSex);
        return;
      }
    }
  }

  protected static void updateAnimalWeight(int idOfAnimal, int newWeight, List<Animal> animals) {
    if (!idExists(idOfAnimal, animals)) {
      throw new IllegalArgumentException("id not available here!");
    }

    for (Animal animal: animals) {
      if (animal.getId() == idOfAnimal) {
        animal.setWeight(newWeight);
        return;
      }
    }
  }

  protected static void updateAnimalFavFood(int idOfAnimal, String newFavFood,
                                            List<Animal> animals) {
    if (!idExists(idOfAnimal, animals)) {
      throw new IllegalArgumentException("id not available here!");
    }

    for (Animal animal: animals) {
      if (animal.getId() == idOfAnimal) {
        animal.setFavFood(newFavFood);
        return;
      }
    }
  }

  protected static boolean idExists(int id, List<Animal> animals) {
    for (Animal animal : animals) {
      if (animal.getId() == id) {
        return true;
      }
    }
    return false;
  }

  protected static int getIndexOfMonkey(int idOfMonkey,
                                        List<Animal> animals) throws IllegalArgumentException {
    for (int index = 0; index < animals.size(); index++) {
      Animal animal = animals.get(index);
      if (animal.getId() == idOfMonkey) {
        return index;
      }
    }
    throw new IllegalArgumentException("Animal with that ID is not present here");
  }

  protected static Map<String, Integer> getFoodListOfHouse(List<Animal> animals) {
    Map<String, Integer> favFoodList = new HashMap<>();
    for (Animal animal : animals) {
      favFoodList.put(animal.getFavFood(),
              favFoodList.getOrDefault(animal.getFavFood(), 0) + animal.getSize().getFoodPortion());
    }

    return favFoodList;
  }

  protected static List<Sign> getSignOfHouse(List<Animal> animals) {
    List<Sign> allSigns = new ArrayList<>();

    for (Animal animal : animals) {
      Sign signOfAnimal = new Sign(animal.getName(), animal.getSize(), animal.getFavFood());
      allSigns.add(signOfAnimal);
    }

    return allSigns;
  }
}
