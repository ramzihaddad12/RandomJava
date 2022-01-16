package animal;

/**
 * An animal represents an organism that possesses attributes such as
 * id, name, age, size, sex, weight, favorite food, and species.
 */
public interface Animal {
  /**
   * Get the unique id of the animal.
   *
   * @return the id
   */

  public int getId();

  /**
   * Get the name of the animal.
   *
   * @return the name
   */

  public String getName();

  /**
   * Get the age of the animal.
   *
   * @return the age
   */

  public int getAge();

  /**
   * Get the size of the animal.
   *
   * @return the size
   */

  public Size getSize();

  /**
   * Get the sex of the animal.
   *
   * @return the sex
   */

  public Sex getSex();

  /**
   * Get the weight of the animal.
   *
   * @return the weight
   */

  public int getWeight();

  /**
   * Get the favorite food of the animal.
   *
   * @return the favorite food
   */

  public String getFavFood();

  /**
   * Get the species of the animal.
   *
   * @return the species
   */

  public Species getSpecies();

  /**
   * Set the age of the animal.
   *
   * @param newAge the new age
   */

  public void setAge(int newAge);

  /**
   * Set the size of the animal.
   *
   * @param newSize the new size
   */

  public void setSize(Size newSize);

  /**
   * Set the sex of the animal.
   *
   * @param newSex the new sex
   */

  public void setSex(Sex newSex);

  /**
   * Set the weight of the animal.
   *
   * @param newWeight the new weight
   */

  public void setWeight(int newWeight);

  /**
   * Set the favorite food of the animal.
   *
   * @param newFavFood the favorite food
   */

  public void setFavFood(String newFavFood);
}
