package house;

import animal.Animal;

/**
 * An animal with location represents an animal, along with the room it is located in,
 * and its position in that room.
 */
public class AnimalsWithLocation {
  private final Animal animal;
  private final House house;
  private final int position;

  /**
   * Constructs a monkey in terms of the name, age, size, sex, weight, favorite food,
   * and species.
   *
   * @param animal   the animal
   * @param house    the house/room the animal is in
   * @param position the position of the animal in the house/room
   * @throws IllegalArgumentException if any argument is negative or null
   */

  public AnimalsWithLocation(Animal animal,
                             House house, int position) throws IllegalArgumentException {
    if (position < 0) {
      throw new IllegalArgumentException("Negative arguments not allowed");
    }
    this.animal = animal;
    this.house = house;
    this.position = position;
  }

  /**
   * Get the animal in question.
   *
   * @return the animal
   */

  public Animal getAnimal() {
    return animal;
  }

  /**
   * Get the house the animal is in.
   *
   * @return the house
   */

  public House getHouse() {
    return house;
  }

  /**
   * Get the position of that animal in the house.
   *
   * @return the position
   */

  public int getPosition() {
    return position;
  }
}
