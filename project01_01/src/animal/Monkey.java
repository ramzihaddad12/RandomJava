package animal;

import java.util.Objects;

/**
 * A monkey represents a subclass of animal (a specific type of animal).
 */
public class Monkey implements Animal {
  static int counter = 0;
  private final String name;
  private int age;
  private Size size;
  private Sex sex;
  private int weight;
  private String favFood;
  private final Species species;
  private final int id;

  /**
   * Constructs a monkey in terms of the name, age, size, sex, weight, favorite food,
   * and species.
   *
   * @param name    the name of the monkey
   * @param age     the age of the monkey
   * @param size    the size of the monkey
   * @param sex     the sex of the monkey
   * @param weight  the weight of the monkey
   * @param favFood the favorite food of the monkey
   * @param species the species of the monkey
   * @throws IllegalArgumentException if any argument is negative or null
   */

  public Monkey(String name, int age, Size size, Sex sex, int weight,
                String favFood, Species species) {
    if (age < 0 || weight < 0) {
      throw new IllegalArgumentException("Negative arguments not allowed");
    }

    if (size == null || sex == null || species == null) {
      throw new IllegalArgumentException("Null arguments not allowed");
    }
    this.name = name;
    this.age = age;
    this.size = size;
    this.sex = sex;
    this.weight = weight;
    this.favFood = favFood;
    this.species = species;
    this.id = counter++;
  }

  /**
   * Copy constructor which constructs a monkey from an existing Animal object.
   *
   * @param monkey    the animal to be copied
   */

  public Monkey(Animal monkey) {
    this.name = monkey.getName();
    this.age = monkey.getAge();
    this.size = monkey.getSize();
    this.sex = monkey.getSex();
    this.weight = monkey.getWeight();
    this.favFood = monkey.getFavFood();
    this.species = monkey.getSpecies();
    this.id = monkey.getId();
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof Animal)) {
      return false;
    }

    Animal that = (Animal) o;

    return id == that.getId();
  }

  @Override
  public int getId() {
    return id;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getAge() {
    return age;
  }

  @Override
  public Size getSize() {
    return size;
  }

  @Override
  public Sex getSex() {
    return sex;
  }

  @Override
  public int getWeight() {
    return weight;
  }

  @Override
  public String getFavFood() {
    return favFood;
  }

  @Override
  public Species getSpecies() {
    return species;
  }

  @Override
  public void setAge(int newAge) {
    if (newAge < 0) {
      throw new IllegalArgumentException("Age cannot be negative");
    }
    this.age = newAge;
  }

  @Override
  public void setSize(Size newSize) {
    if (newSize == null) {
      throw new IllegalArgumentException("Size cannot be null");
    }
    this.size = newSize;
  }

  @Override
  public void setSex(Sex newSex) {
    if (newSex == null) {
      throw new IllegalArgumentException("Size cannot be null");
    }
    this.sex = newSex;
  }

  @Override
  public void setWeight(int newWeight) {
    if (newWeight < 0) {
      throw new IllegalArgumentException("Weight cannot be negative");
    }
    this.weight = newWeight;
  }

  @Override
  public void setFavFood(String newFavFood) {
    this.favFood = newFavFood;
  }
}
