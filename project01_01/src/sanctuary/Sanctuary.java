package sanctuary;

import animal.Animal;
import animal.Sex;
import animal.Size;
import house.AnimalsWithLocation;
import house.Sign;

import java.util.List;
import java.util.Map;

/**
 * A sanctuary is a permanent home for animals who have been cast-off.
 * it consists of an isolation and a group of enclosures.
 */

public interface Sanctuary {
  /**
   * Moves an animal to the isolation room.
   *
   * @param animal an animal to be moved to isolation
   */

  public void moveToIsolation(Animal animal);

  /**
   * Moves a list of animals to the isolation room.
   *
   * @param animals animals to be moved to isolation
   */

  public void moveToIsolation(List<Animal> animals);

  /**
   * Moves an animal from the isolation room to an enclosure.
   *
   * @param idOfAnimal the id of the animal to be moved from isolation to the enclosure.
   */

  public void moveFromIsolationToEnclosure(int idOfAnimal);

  /**
   * Moves animals from the isolation room to enclosures.
   *
   * @param idsOfAnimals the ids of the animals to be moved from isolation to the enclosure.
   */

  public void moveFromIsolationToEnclosure(List<Integer> idsOfAnimals);

  /**
   * Removes an animal from the isolation room.
   *
   * @param idOfAnimal the id of the animal to be removed from isolation.
   */
  public Animal removeFromIsolation(int idOfAnimal);

  /**
   * Removes animals from the isolation room.
   *
   * @param idsOfAnimals the ids of the animals to be removed from isolation.
   */

  public List<Animal> removeFromIsolation(List<Integer> idsOfAnimals);

  /**
   * Removes an animal from the enclosures.
   *
   * @param idOfAnimal the id of the animal to be removed from enclosures.
   */

  public Animal removeFromEnclosure(int idOfAnimal);

  /**
   * Removes animals from the enclosures.
   *
   * @param idsOfAnimals the ids of the animals to be removed from enclosures.
   */

  public List<Animal> removeFromEnclosure(List<Integer> idsOfAnimals);

  /**
   * Get the number of cages in isolation.
   *
   * @return number of cages in the isolation room of the sanctuary.
   */

  public abstract int getNumberOfCagesInIsolation();

  /**
   * Get the number of enclosures.
   *
   * @return number of enclosures of the sanctuary.
   */

  public abstract int getNumberOfEnclosures();

  /**
   * Get the capacities of enclosures.
   *
   * @return capacities of enclosures of the sanctuary.
   */

  public abstract List<Integer> getCapacitiesOfEnclosures();


  /**
   * Get the animals present in the isolation room.
   *
   * @return animals present in the isolation room.
   */

  public List<Animal> getAnimalsInIsolation();

  /**
   * Get the animals present in the enclosures.
   *
   * @return animals present in the enclosures.
   */

  public List<List<Animal>> getAnimalsInEnclosures();

  /**
   * Expands the isolation room to have more cages.
   *
   * @param newNumOfCages the new number of cages present in the isolation room.
   */

  public void expandIsolation(int newNumOfCages);

  /**
   * Expands the number of enclosures.
   *
   * @param numberOfNewEnclosures the number of new enclosures added.
   * @param newCapacities        the new capacities for the new added enclosures.
   */

  public void expandEnclosures(int numberOfNewEnclosures, List<Integer> newCapacities);

  /**
   * Expands the number of enclosures.
   *
   * @param enclosureNumber the enclosure number of the enclosure to be expanded.
   * @param newCapacity        the new capacity for the enclosure.
   */

  public void expandExistingEnclosure(int enclosureNumber, int newCapacity);

  /**
   * Changes the age of an animal given its id.
   *
   * @param idOfAnimal id of the animal to be changed.
   * @param newAge new age of the animal.
   */

  public void changeAnimalAge(int idOfAnimal, int newAge);

  /**
   * Changes the size of an animal given its id.
   *
   * @param idOfAnimal id of the animal to be changed.
   * @param newSize new size of the animal.
   */

  public void changeAnimalSize(int idOfAnimal, Size newSize);

  /**
   * Changes the sex of an animal given its id.
   *
   * @param idOfAnimal id of the animal to be changed.
   * @param newSex new sex of the animal.
   */
  public void changeAnimalSex(int idOfAnimal, Sex newSex);

  /**
   * Changes the weight of an animal given its id.
   *
   * @param idOfAnimal id of the animal to be changed.
   * @param newWeight new weight of the animal.
   */

  public void changeAnimalWeight(int idOfAnimal, int newWeight);

  /**
   * Changes the favorite food of an animal given its id.
   *
   * @param idOfAnimal id of the animal to be changed.
   * @param newFavFood new favorite food of the animal.
   */

  public void changeAnimalFavFood(int idOfAnimal, String newFavFood);

  /**
   * Gets all the signs of the animals present in the enclosures.
   *
   * @return signs of the animals present in theh enclosures.
   */

  public List<List<Sign>> getAllSigns();

  /**
   * Gets the food list containing the favorite food of each animal and the amounts needed to buy.
   *
   * @return the food list as a map containing
   *          the favorite food of each animal and the amounts needed to buy.
   */

  public Map<String, Integer> getFoodList();

  /**
   * Gets the list of animals, containing what room it
   * is in and what position in those room it is in.
   *
   * @return the list of animals, containing what room it
   *          is in and what position in those room it is in.
   */

  public List<AnimalsWithLocation> getLocationOfMonkeys();

  /**
   * Gets the list of species, containing the animals that
   * belong to that species, and their locations.
   *
   * @return the list of species as a map, containing the
   *          animals belong to that species, and their locations.
   */

  public Map<String, List<AnimalsWithLocation>> getLocationOfSpecies();

  /**
   * Look up or search for the animals that belong to a specific species,
   * along with their respective location .
   *
   * @param speciesName name of the species
   * @return the list of animals, containing the animals belong to
   *          that species, and their locations.
   * @throws IllegalArgumentException if species not found in the sanctuary
   */

  public List<AnimalsWithLocation> lookUp(String speciesName) throws IllegalArgumentException;

}
