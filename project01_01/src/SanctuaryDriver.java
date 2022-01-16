import animal.Animal;
import animal.Howler;
import animal.Monkey;
import animal.Sex;
import animal.Size;
import animal.SpiderMonkey;
import animal.SquirrelMonkey;
import house.AnimalsWithLocation;
import house.House;
import sanctuary.MonkeySanctuary;
import sanctuary.Sanctuary;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Driver program for Sanctuary to show how it works.
 *
 */

public class SanctuaryDriver {

  /**
   * Displaying the driver class.
   *
   */

  public static void main(String[] args) {

    Sanctuary sanctuary = new MonkeySanctuary(10, 2, Arrays.asList(7, 9));

    Animal spiderMonkey = new Monkey("Spidey", 1, Size.SMALL, Sex.MALE,
            33, "Banana", SpiderMonkey.getInstance());
    Animal anotherSpiderMonkey = new Monkey("Peter", 1, Size.MEDIUM, Sex.MALE,
            33, "Grapes", SpiderMonkey.getInstance());
    Animal squirrelMonkey = new Monkey("Humphrey", 4, Size.MEDIUM, Sex.FEMALE,
            36, "Lollipop", SquirrelMonkey.getInstance());
    Animal howlerMonkey = new Monkey("Howard", 7, Size.LARGE, Sex.OTHER,
            39, "Grapes", Howler.getInstance());
    Animal anotherHowlerMonkey = new Monkey("Halley", 7, Size.SMALL, Sex.FEMALE,
            39, "Banana", Howler.getInstance());
    sanctuary.moveToIsolation(spiderMonkey);
    sanctuary.moveToIsolation(Arrays.asList(
            anotherSpiderMonkey, squirrelMonkey, howlerMonkey, anotherHowlerMonkey));

    sanctuary.moveFromIsolationToEnclosure(spiderMonkey.getId());
    sanctuary.moveFromIsolationToEnclosure(
            Arrays.asList(anotherSpiderMonkey.getId(), squirrelMonkey.getId()));

    System.out.println("The animals in isolation are: ");
    for (Animal animal: sanctuary.getAnimalsInIsolation()) {
      System.out.println(String.format("%s who belongs to the %s species, and its id is %d",
              animal.getName(), animal.getSpecies(), animal.getId()));
    }
    System.out.println("The animals in the enclosures are: ");
    for (int index = 0; index < sanctuary.getAnimalsInEnclosures().size(); index++) {
      List<Animal> animalsInSameEnclosure = sanctuary.getAnimalsInEnclosures().get(index);
      for (Animal animal: animalsInSameEnclosure) {
        System.out.println(String.format("%s who is in enclosure #%d belongs to the %s species,"
                + " and its id is %d", animal.getName(), index + 1,
                animal.getSpecies(), animal.getId()));
      }
    }
    System.out.println();
    System.out.println("**********************************");
    System.out.println();
    System.out.println("Adding howlerMonkey to enclosures when no more space: ");
    try {
      sanctuary.moveFromIsolationToEnclosure(howlerMonkey.getId());
    }
    catch (IllegalArgumentException e) {
      System.out.println(String.format("No room to add %s to enclosures", howlerMonkey.getName()));
    }

    System.out.println();
    System.out.println("**********************************");
    System.out.println();
    System.out.println("Removing from isolation: ");
    //remove from isolation
    List<Animal> animalsRemovedFromIsolation = sanctuary.removeFromIsolation(Arrays.asList(
            howlerMonkey.getId(), anotherHowlerMonkey.getId()));
    System.out.println("Animals removed from isolation are: ");
    for (Animal animal: animalsRemovedFromIsolation) {
      System.out.println(String.format("%s who belongs to the %s species,"
              + " and its id is %d", animal.getName(), animal.getSpecies(), animal.getId()));
    }

    System.out.println("The number of animals in the isolation now is "
            + sanctuary.getAnimalsInIsolation().size());

    //remove from enclosure
    System.out.println();
    System.out.println("**********************************");
    System.out.println();
    System.out.println("Removing from enclosures: ");
    List<Animal> animalsRemovedFromEnclosures = sanctuary.removeFromEnclosure(
            Arrays.asList(spiderMonkey.getId(), squirrelMonkey.getId()));
    System.out.println("Animals removed from enclosure are: ");
    for (Animal animal: animalsRemovedFromEnclosures) {
      System.out.println(String.format("%s who belongs to the %s species,"
              + " and its id is %d", animal.getName(), animal.getSpecies(), animal.getId()));
    }
    System.out.println("The size of the enclosures now is "
            + sanctuary.getAnimalsInEnclosures().size());

    //reverse removals

    sanctuary.moveToIsolation(Arrays.asList(
            spiderMonkey, squirrelMonkey, howlerMonkey, anotherHowlerMonkey));
    sanctuary.moveFromIsolationToEnclosure(Arrays.asList(
            spiderMonkey.getId(), squirrelMonkey.getId()));

    System.out.println();
    System.out.println("**********************************");
    System.out.println();
    System.out.println("Removals Reversed:.....");

    System.out.println();
    System.out.println("**********************************");
    System.out.println();
    System.out.println("Expanded isolation: ");
    sanctuary.expandIsolation(15);
    System.out.println("Number of isolation cages is now "
            + sanctuary.getNumberOfCagesInIsolation());

    System.out.println();
    System.out.println("**********************************");
    System.out.println();
    System.out.println("Expanded existing enclosure: ");
    sanctuary.expandExistingEnclosure(1, 10);
    for (int index = 0; index < sanctuary.getNumberOfEnclosures(); index++) {
      System.out.println(String.format("Enclosure %d has a capacity of %d",
              index + 1, sanctuary.getCapacitiesOfEnclosures().get(index)));
    }
    System.out.println();
    System.out.println("**********************************");
    System.out.println();
    System.out.println("Added new enclosures: ");
    sanctuary.expandEnclosures(2, Arrays.asList(11, 12));
    for (int index = 0; index < sanctuary.getNumberOfEnclosures(); index++) {
      System.out.println(String.format("Enclosure %d has a capacity of %d",
              index + 1, sanctuary.getCapacitiesOfEnclosures().get(index)));
    }
    // try adding howlerMonkey now after expanding enclosures
    System.out.println();
    System.out.println("**********************************");
    System.out.println();
    System.out.println("After expanding enclosures by adding new ones,"
            + " howlerMonkey can be added to enclosures");
    sanctuary.moveFromIsolationToEnclosure(howlerMonkey.getId());

    //change animals
    System.out.println();
    System.out.println("**********************************");
    System.out.println();
    System.out.println("Changing states of the animals: ");
    sanctuary.changeAnimalAge(3, 8);
    sanctuary.changeAnimalWeight(3, 40);
    sanctuary.changeAnimalSex(3, Sex.FEMALE);
    sanctuary.changeAnimalSize(3, Size.MEDIUM);
    sanctuary.changeAnimalFavFood(3, "Berries");
    for (Animal animal: sanctuary.getAnimalsInIsolation()) {
      System.out.println(String.format("%s is %d years old, it weighs %d, "
                      + "it's size is %s, it's sex is %s, and its favorite food is %s",
              animal.getName(), animal.getAge(), animal.getWeight(), animal.getSize(),
              animal.getSex(), animal.getFavFood()));
    }

    //get signs from enclosures
    System.out.println();
    System.out.println("**********************************");
    System.out.println();
    System.out.println("Getting the signs of the animals in the enclosures: ");
    System.out.println(sanctuary.getAllSigns());

    //getFoodList
    System.out.println();
    System.out.println("**********************************");
    System.out.println();
    System.out.println("Getting the food list: ");
    System.out.println(sanctuary.getFoodList());

    //get location of animals
    System.out.println();
    System.out.println("**********************************");
    System.out.println();
    System.out.println("Getting location of animals: ");
    for (AnimalsWithLocation animalsWithLocation: sanctuary.getLocationOfMonkeys()) {
      if (animalsWithLocation.getHouse() == House.ENCLOSURE) {
        System.out.println(String.format("%s is in %s room, and it's in enclosure number #%d",
                animalsWithLocation.getAnimal().getName(), animalsWithLocation.getHouse(),
                animalsWithLocation.getPosition()));
      }

      else {
        System.out.println(String.format("%s is in %s room, and it's in position number #%d",
                animalsWithLocation.getAnimal().getName(), animalsWithLocation.getHouse(),
                animalsWithLocation.getPosition()));
      }
    }

    //get location of species
    System.out.println();
    System.out.println("**********************************");
    System.out.println();
    System.out.println("Getting location of species: ");

    //https://stackoverflow.com/questions/1066589/iterate-through-a-hashmap
    for (Map.Entry<String, List<AnimalsWithLocation>> entry :
            sanctuary.getLocationOfSpecies().entrySet()) {
      String species = entry.getKey();
      List<AnimalsWithLocation> listOfSameSpecies = entry.getValue();
      System.out.println(String.format("The %s species exist in the "
              + "following place(s): ", species));
      for (AnimalsWithLocation animalsWithLocation: listOfSameSpecies) {
        if (animalsWithLocation.getHouse() == House.ENCLOSURE) {
          System.out.println(String.format("%s is in %s room, and it's in enclosure number #%d",
                  animalsWithLocation.getAnimal().getName(), animalsWithLocation.getHouse(),
                  animalsWithLocation.getPosition()));
        }

        else {
          System.out.println(String.format("%s is in %s room, and it's in position number #%d",
                  animalsWithLocation.getAnimal().getName(), animalsWithLocation.getHouse(),
                  animalsWithLocation.getPosition()));
        }
      }

    }
    System.out.println();

    //lookUp
    System.out.println();
    System.out.println("**********************************");
    System.out.println();
    System.out.println("Looking up the SpiderMonkey Species: ");
    for (AnimalsWithLocation animalsWithLocation: sanctuary.lookUp("SpiderMonkey")) {
      if (animalsWithLocation.getHouse() == House.ENCLOSURE) {
        System.out.println(String.format("%s is in %s room, and it's in enclosure number #%d",
                animalsWithLocation.getAnimal().getName(), animalsWithLocation.getHouse(),
                animalsWithLocation.getPosition()));
      }

      else {
        System.out.println(String.format("%s is in %s room, and it's in position number #%d",
                animalsWithLocation.getAnimal().getName(), animalsWithLocation.getHouse(),
                animalsWithLocation.getPosition()));
      }
    }
  }
}
