package sanctuary;

import animal.Animal;
import animal.Monkey;
import animal.Sex;
import animal.Size;
import house.AnimalsWithLocation;
import house.Enclosure;
import house.House;
import house.Isolation;
import house.Sign;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * A sanctuary of monkey animals only.
 */

public class MonkeySanctuary implements Sanctuary {
  private Isolation isolation;
  private List<Enclosure> enclosures;

  /**
   * Constructs a sanctuary for monkeys based on the number of cages, number of enclosures, along
   * with the capacities for the respective enclosures.
   *
   * @param numOfCages      the number of cages in the isolation room
   * @param numOfEnclosures the number of enclosures in the sanctuary
   * @throws IllegalArgumentException if capacities
   *                                  provided are not equal to the number of enclosures
   */
  public MonkeySanctuary(int numOfCages, int numOfEnclosures,
                         List<Integer> capacitiesForEnclosures) {
    if (capacitiesForEnclosures.size() != numOfEnclosures) {
      throw new IllegalArgumentException(
              "Number of capacities should be the same as number of enclosures");
    }
    this.isolation = new Isolation(numOfCages);
    this.enclosures = new ArrayList<>();
    for (int index = 0; index < numOfEnclosures; index++) {
      this.enclosures.add(new Enclosure(capacitiesForEnclosures.get(index)));
    }
  }

  @Override
  public void moveToIsolation(Animal animal) {
    isolation.add(new Monkey(animal));
  }

  @Override
  public void moveToIsolation(List<Animal> animals) {
    for (Animal animal : animals) {
      moveToIsolation(animal);
    }
  }

  @Override
  public void moveFromIsolationToEnclosure(int idOfAnimal) {
    Animal animalToBeMoved = isolation.remove(idOfAnimal);
    for (Enclosure enclosure : enclosures) {
      if (enclosure.getSpecies() == null
              || enclosure.getSpecies() == animalToBeMoved.getSpecies()) {
        enclosure.add(animalToBeMoved);
        return;
      }
    }
    isolation.add(animalToBeMoved);
    throw new IllegalArgumentException("Animal could not be added. No enclosures available");
  }

  @Override
  public void moveFromIsolationToEnclosure(List<Integer> idsOfAnimals) {
    for (int idOfAnimal : idsOfAnimals) {
      moveFromIsolationToEnclosure(idOfAnimal);
    }
  }

  @Override
  public Animal removeFromIsolation(int idOfAnimal) {
    return new Monkey(isolation.remove(idOfAnimal));
  }

  @Override
  public List<Animal> removeFromIsolation(List<Integer> idsOfAnimals) {
    List<Animal> animalsRemoved = new ArrayList<>();
    for (Animal animal: isolation.remove(idsOfAnimals)) {
      animalsRemoved.add(new Monkey(animal));
    }
    return animalsRemoved;
  }

  @Override
  public Animal removeFromEnclosure(int idOfAnimal) {
    for (Enclosure enclosure : enclosures) {
      for (Animal animal: enclosure.getAnimalsInside()) {
        if (animal.getId() == idOfAnimal) {
          return new Monkey(enclosure.remove(idOfAnimal));
        }
      }
    }

    throw new IllegalArgumentException("Id not available in the enclosures");
  }

  @Override
  public List<Animal> removeFromEnclosure(List<Integer> idsOfAnimals) {
    List<Animal> animals = new ArrayList<>();
    for (int idOfAnimal : idsOfAnimals) {
      animals.add(removeFromEnclosure(idOfAnimal));
    }

    return animals;
  }

  public int getNumberOfCagesInIsolation() {
    return isolation.getNumberOfCages();
  }

  @Override
  public int getNumberOfEnclosures() {
    return enclosures.size();
  }

  @Override
  public List<Integer> getCapacitiesOfEnclosures() {
    List<Integer> capacities = new ArrayList<>();
    for (Enclosure enclosure : enclosures) {
      capacities.add(enclosure.getCapacity());
    }
    return capacities;
  }

  @Override
  public List<Animal> getAnimalsInIsolation() {
    return isolation.getAnimalsInside();
  }

  @Override
  public List<List<Animal>> getAnimalsInEnclosures() {
    List<List<Animal>> animalsInEnclosures = new ArrayList<>();
    for (Enclosure enclosure : enclosures) {
      if (!enclosure.getAnimalsInside().isEmpty()) {
        animalsInEnclosures.add(enclosure.getAnimalsInside());
      }
    }
    return animalsInEnclosures;
  }

  @Override
  public void expandIsolation(int newNumOfCages) {
    isolation.resize(newNumOfCages);
  }

  @Override
  public void expandEnclosures(int numberOfNewEnclosures, List<Integer> newCapacities) {
    if (newCapacities.size() != numberOfNewEnclosures) {
      throw new IllegalArgumentException(
              "Number of capacities should be the same as number of enclosures");
    }
    for (int index = 0; index < numberOfNewEnclosures; index++) {
      this.enclosures.add(new Enclosure(newCapacities.get(index)));
    }
  }

  @Override
  public void expandExistingEnclosure(int enclosureNumber, int newCapacity) {
    if (enclosureNumber < 1 || enclosureNumber > getNumberOfEnclosures()) {
      throw new IllegalArgumentException("enclosure number does not exist");
    }

    enclosures.get(enclosureNumber - 1).resize(newCapacity);
  }

  private boolean isIdInIsolation(int idOfAnimal) {
    for (Animal animal: getAnimalsInIsolation()) {
      if (animal.getId() == idOfAnimal) {
        return true;
      }
    }
    return false;
  }

  private boolean isIdInEnclosure(int idOfAnimal) {
    for (List<Animal> animals: getAnimalsInEnclosures()) {
      for (Animal animal: animals) {
        if (animal.getId() == idOfAnimal) {
          return true;
        }
      }
    }
    return false;
  }

  @Override
  public void changeAnimalAge(int idOfAnimal, int newAge) {
    if (isIdInIsolation(idOfAnimal)) {
      isolation.changeAnimalAge(idOfAnimal, newAge);
      return;
    }

    if (isIdInEnclosure(idOfAnimal)) {
      for (Enclosure enclosure: enclosures) {
        for (Animal animal: enclosure.getAnimalsInside()) {
          if (animal.getId() == idOfAnimal) {
            enclosure.changeAnimalAge(idOfAnimal, newAge);
            return;
          }
        }
      }
    }
    throw new IllegalArgumentException("id does not exist in sanctuary!");
  }

  @Override
  public void changeAnimalSize(int idOfAnimal, Size newSize) {
    if (isIdInIsolation(idOfAnimal)) {
      isolation.changeAnimalSize(idOfAnimal, newSize);
      return;
    }

    if (isIdInEnclosure(idOfAnimal)) {
      for (Enclosure enclosure: enclosures) {
        for (Animal animal: enclosure.getAnimalsInside()) {
          if (animal.getId() == idOfAnimal) {
            enclosure.changeAnimalSize(idOfAnimal, newSize);
            return;
          }
        }
      }
    }
    throw new IllegalArgumentException("id does not exist in sanctuary!");
  }

  @Override
  public void changeAnimalSex(int idOfAnimal, Sex newSex) {
    if (isIdInIsolation(idOfAnimal)) {
      isolation.changeAnimalSex(idOfAnimal, newSex);
      return;
    }

    if (isIdInEnclosure(idOfAnimal)) {
      for (Enclosure enclosure: enclosures) {
        for (Animal animal: enclosure.getAnimalsInside()) {
          if (animal.getId() == idOfAnimal) {
            enclosure.changeAnimalSex(idOfAnimal, newSex);
            return;
          }
        }
      }
    }
    throw new IllegalArgumentException("id does not exist in sanctuary!");
  }

  @Override
  public void changeAnimalWeight(int idOfAnimal, int newWeight) {
    if (isIdInIsolation(idOfAnimal)) {
      isolation.changeAnimalWeight(idOfAnimal, newWeight);
      return;
    }

    if (isIdInEnclosure(idOfAnimal)) {
      for (Enclosure enclosure: enclosures) {
        for (Animal animal: enclosure.getAnimalsInside()) {
          if (animal.getId() == idOfAnimal) {
            enclosure.changeAnimalWeight(idOfAnimal, newWeight);
            return;
          }
        }
      }
    }
    throw new IllegalArgumentException("id does not exist in sanctuary!");
  }

  @Override
  public void changeAnimalFavFood(int idOfAnimal, String newFavFood) {
    if (isIdInIsolation(idOfAnimal)) {
      isolation.changeAnimalFavFood(idOfAnimal, newFavFood);
      return;
    }

    if (isIdInEnclosure(idOfAnimal)) {
      for (Enclosure enclosure: enclosures) {
        for (Animal animal: enclosure.getAnimalsInside()) {
          if (animal.getId() == idOfAnimal) {
            enclosure.changeAnimalFavFood(idOfAnimal, newFavFood);
            return;
          }
        }
      }
    }
    throw new IllegalArgumentException("id does not exist in sanctuary!");
  }

  @Override
  public List<List<Sign>> getAllSigns() {
    List<List<Sign>> allSigns = new ArrayList<>();
    for (Enclosure enclosure : enclosures) {
      if (!enclosure.isEmpty()) {
        allSigns.add(enclosure.getSign());
      }
    }
    return allSigns;
  }

  @Override
  public Map<String, Integer> getFoodList() {
    Map<String, Integer> favFoodList = isolation.getFoodList();
    // citation: https://stackoverflow.com/questions/66799907/merging-two-hashmaps-with-duplicate-keys-and-update-value
    for (Enclosure enclosure : enclosures) {
      enclosure.getFoodList().forEach((key, value) ->
              favFoodList.merge(key, value, (v1, v2) -> v1 + v2));
    }

    return favFoodList;
  }

  @Override
  public List<AnimalsWithLocation> getLocationOfMonkeys() {
    List<AnimalsWithLocation> animalsWithLocations = new ArrayList<>();
    List<Animal> animalsInIsolation = isolation.getAnimalsInside();

    for (int index = 1; index <= animalsInIsolation.size(); index++) {
      animalsWithLocations.add(new AnimalsWithLocation(animalsInIsolation.get(index - 1),
              House.ISOLATION, index));
    }

    for (int enclosureNumber = 1; enclosureNumber <= enclosures.size(); enclosureNumber++) {
      Enclosure enclosure = enclosures.get(enclosureNumber - 1);
      List<Animal> animalsInEnclosure = enclosure.getAnimalsInside();
      for (int index = 0; index < animalsInEnclosure.size(); index++) {
        animalsWithLocations.add(new AnimalsWithLocation(animalsInEnclosure.get(index),
                House.ENCLOSURE, enclosureNumber));
      }
    }
    animalsWithLocations.sort(Comparator.comparing(a -> a.getAnimal().getName()));
    return animalsWithLocations;
  }

  @Override
  public Map<String, List<AnimalsWithLocation>> getLocationOfSpecies() {
    List<AnimalsWithLocation> animalsWithLocations = getLocationOfMonkeys();
    Map<String, List<AnimalsWithLocation>> speciesMap = new TreeMap<>();

    for (AnimalsWithLocation animalsWithLocation : animalsWithLocations) {
      List<AnimalsWithLocation> sameSpecies = speciesMap.getOrDefault(
              animalsWithLocation.getAnimal().getSpecies().toString(), new ArrayList<>());
      sameSpecies.add(animalsWithLocation);
      speciesMap.put(animalsWithLocation.getAnimal().getSpecies().toString(), sameSpecies);
    }

    return speciesMap;

  }

  @Override
  public List<AnimalsWithLocation> lookUp(String speciesName) throws IllegalArgumentException {
    Map<String, List<AnimalsWithLocation>> speciesMap = getLocationOfSpecies();
    List<AnimalsWithLocation> animalsOfSpecies = new ArrayList<>();
    if (speciesMap.containsKey(speciesName)) {
      animalsOfSpecies = speciesMap.get(speciesName);
    } else {
      throw new IllegalArgumentException("Species not found in the sanctuary");
    }

    return animalsOfSpecies;
  }
}
