package battle;

import gear.Belt;
import gear.Footwear;
import gear.Gear;
import gear.GearFactory;
import gear.Headgear;
import gear.Potion;
import randomize.Randomness;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents an implementation of a bag of equipment/gear
 * from which the player will choose from before starting fighting.
 */

public class BagOfEquipment implements IBagOfEquipment {
  private List<Gear> gears;
  private GearFactory gearFactory;

  /**
   * A constructor for the BagOfEquipment which
   * constructs a list of gear where 25% of the bag include
   * gears that negatively impact their possessor.
   */

  public BagOfEquipment() {
    this.gearFactory = new GearFactory();
    this.gears = generateBag(new ArrayList<>(), gearFactory);
  }

  /**
   * A constructor for the BagOfEquipment which
   * constructs a list of gear where 25% of the bag include
   * gears that negatively impact their possessor.
   *
   * @param seed the random seed
   */

  public BagOfEquipment(int seed) {
    this.gearFactory = new GearFactory();
    this.gears = generateBag(new ArrayList<>(), gearFactory, seed);
  }

  /**
   * A constructor for the BagOfEquipment which
   * constructs a list of gear where 25% of the bag include
   * gears that negatively impact their possessor.
   *
   * @param randomness the random object
   */

  public BagOfEquipment(Randomness randomness) {
    this.gearFactory = new GearFactory();
    this.gears = generateBag(new ArrayList<>(), gearFactory, randomness);
  }

  /**
   * A copy constructor for the BagOfEquipment making a copy of a given
   * BagOfEquipment.
   * @param bagOfEquipment the BagOfEquipment to be copied
   */

  public BagOfEquipment(IBagOfEquipment bagOfEquipment) {
    this.gears = bagOfEquipment.getBag();
    this.gearFactory = new GearFactory();
  }

  @Override
  public void remove(int index) {
    if (index < 0 || index > gears.size()) {
      throw new IndexOutOfBoundsException("Index not in range");
    }

    gears.remove(index);
  }

  private static List<Gear> generateBag(List<Gear> gearList, GearFactory gearFactory) {
    int i = 1;
    //generate 3 negative footwear
    while (gearList.size() != 3) {
      Gear footWear = gearFactory.getFootWear("footwear " + i);
      if (footWear.getValue() < 0) {
        gearList.add(new Footwear(footWear));
        i++;
      }
    }

    //generate 2 negative headgear
    while (gearList.size() != 5) {
      Gear headgear = gearFactory.getHeadgear("headgear " + i);
      if (headgear.getValue() < 0) {
        gearList.add(new Headgear(headgear));
        i++;
      }
    }

    //generate 5 negative belts
    while (gearList.size() != 10) {
      Gear belt = gearFactory.getBelt("belt " + i);
      if (belt.getValue() < 0) {
        gearList.add(new Belt(belt));
        i++;
      }
    }

    //generate 10 negative potions
    while (gearList.size() != 20) {
      Gear potion = gearFactory.getPotion("potion " + i);
      if (potion.getValue() < 0) {
        gearList.add(new Potion(potion));
        i++;
      }
    }

    //generate 2 positive footwear
    while (gearList.size() != 22) {
      Gear footWear = gearFactory.getFootWear("footwear " + i);
      if (footWear.getValue() >= 0) {
        gearList.add(new Footwear(footWear));
        i++;
      }
    }

    //generate 3 positive headgear
    while (gearList.size() != 25) {
      Gear headgear = gearFactory.getHeadgear("headgear " + i);
      if (headgear.getValue() >= 0) {
        gearList.add(new Headgear(headgear));
        i++;
      }
    }

    //generate 20 positive belts
    while (gearList.size() != 40) {
      Gear belt = gearFactory.getBelt("belt " + i);
      if (belt.getValue() >= 0) {
        gearList.add(new Belt(belt));
        i++;
      }
    }

    //generate 40 positive potions
    while (gearList.size() != 80) {
      Gear potion = gearFactory.getPotion("potion " + i);
      if (potion.getValue() >= 0) {
        gearList.add(new Potion(potion));
        i++;
      }
    }

    return gearList;
  }

  private static List<Gear> generateBag(List<Gear> gearList, GearFactory gearFactory, int seed) {
    int i = 1;
    //generate 3 negative footwear
    while (gearList.size() != 3) {
      Gear footWear = gearFactory.getFootWear("footwear " + i);
      if (footWear.getValue() < 0) {
        gearList.add(new Footwear(footWear));
        i++;
      }
    }

    //generate 2 negative headgear
    while (gearList.size() != 5) {
      Gear headgear = gearFactory.getHeadgear("headgear " + i);
      if (headgear.getValue() < 0) {
        gearList.add(new Headgear(headgear));
        i++;
      }
    }

    //generate 5 negative belts
    while (gearList.size() != 10) {
      Gear belt = gearFactory.getBelt("belt " + i);
      if (belt.getValue() < 0) {
        gearList.add(new Belt(belt));
        i++;
      }
    }

    //generate 10 negative potions
    while (gearList.size() != 20) {
      Gear potion = gearFactory.getPotion("potion " + i);
      if (potion.getValue() < 0) {
        gearList.add(new Potion(potion));
        i++;
      }
    }

    //generate 2 positive footwear
    while (gearList.size() != 22) {
      Gear footWear = gearFactory.getFootWear("footwear " + i);
      if (footWear.getValue() >= 0) {
        gearList.add(new Footwear(footWear));
        i++;
      }
    }

    //generate 3 positive headgear
    while (gearList.size() != 25) {
      Gear headgear = gearFactory.getHeadgear("headgear " + i);
      if (headgear.getValue() >= 0) {
        gearList.add(new Headgear(headgear));
        i++;
      }
    }

    //generate 20 positive belts
    while (gearList.size() != 40) {
      Gear belt = gearFactory.getBelt("belt " + i);
      if (belt.getValue() >= 0) {
        gearList.add(new Belt(belt));
        i++;
      }
    }

    //generate 40 positive potions
    while (gearList.size() != 80) {
      Gear potion = gearFactory.getPotion("potion " + i);
      if (potion.getValue() >= 0) {
        gearList.add(new Potion(potion));
        i++;
      }
    }

    return gearList;
  }

  private static List<Gear> generateBag(List<Gear> gearList,
                                        GearFactory gearFactory, Randomness randomness) {
    int i = 1;
    List<Integer> list = new ArrayList<>();
    //generate 3 negative footwear
    while (gearList.size() != 3) {
      Gear footWear = gearFactory.getFootWear("footwear " + i, randomness);
      if (footWear.getValue() < 0) {
        gearList.add(new Footwear(footWear));
        i++;
        list.add(footWear.getValue());
      }
    }

    //generate 2 negative headgear
    while (gearList.size() != 5) {
      Gear headgear = gearFactory.getHeadgear("headgear " + i, randomness);
      if (headgear.getValue() < 0) {
        gearList.add(new Headgear(headgear));
        i++;
        list.add(headgear.getValue());

      }
    }

    //generate 5 negative belts
    while (gearList.size() != 10) {
      Gear belt = gearFactory.getBelt("belt " + i, randomness);
      if (belt.getValue() < 0) {
        gearList.add(new Belt(belt));
        i++;
        list.add(belt.getValue());

      }
    }

    //generate 10 negative potions
    while (gearList.size() != 20) {
      Gear potion = gearFactory.getPotion("potion " + i, randomness);
      if (potion.getValue() < 0) {
        gearList.add(new Potion(potion));
        i++;
        list.add(potion.getValue());

      }
    }

    //generate 2 positive footwear
    while (gearList.size() != 22) {
      Gear footWear = gearFactory.getFootWear("footwear " + i, randomness);
      if (footWear.getValue() >= 0) {
        gearList.add(new Footwear(footWear));
        i++;
        list.add(footWear.getValue());

      }
    }

    //generate 3 positive headgear
    while (gearList.size() != 25) {
      Gear headgear = gearFactory.getHeadgear("headgear " + i, randomness);
      if (headgear.getValue() >= 0) {
        gearList.add(new Headgear(headgear));
        i++;
        list.add(headgear.getValue());

      }
    }

    //generate 20 positive belts
    while (gearList.size() != 40) {
      Gear belt = gearFactory.getBelt("belt " + i, randomness);
      if (belt.getValue() >= 0) {
        gearList.add(new Belt(belt));
        i++;
        list.add(belt.getValue());

      }
    }

    //generate 40 positive potions
    while (gearList.size() != 80) {
      Gear potion = gearFactory.getPotion("potion " + i, randomness);
      if (potion.getValue() >= 0) {
        gearList.add(new Potion(potion));
        i++;
        list.add(potion.getValue());

      }
    }
    return gearList;
  }

  @Override
  public List<Gear> getBag() {
    return new ArrayList<>(gears);
  }

}
