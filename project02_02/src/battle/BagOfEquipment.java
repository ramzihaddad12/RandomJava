package battle;

import gear.Gear;
import gear.GearFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a bag of equipment/gear
 * from which the player will choose from before starting fighting.
 */

public class BagOfEquipment {
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
   * A copy constructor for the BagOfEquipment making a copy of a given
   * BagOfEquipment.
   * @param bagOfEquipment the BagOfEquipment to be copied
   */

  public BagOfEquipment(BagOfEquipment bagOfEquipment) {
    //TODO: How
    this.gearFactory = bagOfEquipment.gearFactory;
    this.gears = bagOfEquipment.getBag();
  }

  /**
   * A method that removes a gear from the bag given its index.
   * @param index the index/position of the gear to be removed in the bag
   */

  public void remove(int index) {
    if (index < 0 || index > gears.size()) {
      throw new IndexOutOfBoundsException("Index not in range");
    }

    gears.remove(index);
  }


  //TODO: optimize
  private static List<Gear> generateBag(List<Gear> gearList, GearFactory gearFactory) {
    int i = 1;
    //generate 3 negative footwear
    while (gearList.size() != 3) {
      Gear footWear = gearFactory.getFootWear("footwear " + i);
      if (footWear.getValue() < 0) {
        //TODO: pass by copy?
        gearList.add(footWear);
        i++;
      }
    }

    //generate 2 negative headgear
    while (gearList.size() != 5) {
      Gear headgear = gearFactory.getHeadgear("headgear " + i);
      if (headgear.getValue() < 0) {
        //TODO: pass by copy?
        gearList.add(headgear);
        i++;
      }
    }

    //generate 5 negative belts
    while (gearList.size() != 10) {
      Gear belt = gearFactory.getBelt("belt " + i);
      if (belt.getValue() < 0) {
        //TODO: pass by copy?
        gearList.add(belt);
        i++;
      }
    }

    //generate 5 negative potions
    while (gearList.size() != 15) {
      Gear potion = gearFactory.getPotion("potion " + i);
      if (potion.getValue() < 0) {
        //TODO: pass by copy?
        gearList.add(potion);
        i++;
      }
    }

    ///////////////////////

    //generate 2 positive footwear
    while (gearList.size() != 17) {
      Gear footWear = gearFactory.getFootWear("footwear " + i);
      if (footWear.getValue() >= 0) {
        //TODO: pass by copy?
        gearList.add(footWear);
        i++;
      }
    }

    //generate 3 positive headgear
    while (gearList.size() != 20) {
      Gear headgear = gearFactory.getHeadgear("headgear " + i);
      if (headgear.getValue() >= 0) {
        //TODO: pass by copy?
        gearList.add(headgear);
        i++;
      }
    }

    //generate 20 positive belts
    while (gearList.size() != 40) {
      Gear belt = gearFactory.getBelt("belt " + i);
      if (belt.getValue() >= 0) {
        //TODO: pass by copy?
        gearList.add(belt);
        i++;
      }
    }

    //generate 20 positive potions
    while (gearList.size() != 60) {
      Gear potion = gearFactory.getPotion("potion " + i);
      if (potion.getValue() >= 0) {
        //TODO: pass by copy?
        gearList.add(potion);
        i++;
      }
    }

    return gearList;
  }

  //TODO: optimize
  private static List<Gear> generateBag(List<Gear> gearList, GearFactory gearFactory, int seed) {
    int i = 1;
    //generate 3 negative footwear
    while (gearList.size() != 3) {
      Gear footWear = gearFactory.getFootWear("footwear " + i, seed);
      if (footWear.getValue() < 0) {
        //TODO: pass by copy?
        gearList.add(footWear);
        i++;
      }
    }

    //generate 2 negative headgear
    while (gearList.size() != 5) {
      Gear headgear = gearFactory.getHeadgear("headgear " + i, seed);
      if (headgear.getValue() < 0) {
        //TODO: pass by copy?
        gearList.add(headgear);
        i++;
      }
    }

    //generate 5 negative belts
    while (gearList.size() != 10) {
      Gear belt = gearFactory.getBelt("belt " + i, seed);
      if (belt.getValue() < 0) {
        //TODO: pass by copy?
        gearList.add(belt);
        i++;
      }
    }

    //generate 5 negative potions
    while (gearList.size() != 15) {
      Gear potion = gearFactory.getPotion("potion " + i, seed);
      if (potion.getValue() < 0) {
        //TODO: pass by copy?
        gearList.add(potion);
        i++;
      }
    }

    ///////////////////////

    //generate 2 positive footwear
    while (gearList.size() != 17) {
      Gear footWear = gearFactory.getFootWear("footwear " + i, seed);
      if (footWear.getValue() >= 0) {
        //TODO: pass by copy?
        gearList.add(footWear);
        i++;
      }
    }

    //generate 3 positive headgear
    while (gearList.size() != 20) {
      Gear headgear = gearFactory.getHeadgear("headgear " + i, seed);
      if (headgear.getValue() >= 0) {
        //TODO: pass by copy?
        gearList.add(headgear);
        i++;
      }
    }

    //generate 20 positive belts
    while (gearList.size() != 40) {
      Gear belt = gearFactory.getBelt("belt " + i, seed);
      if (belt.getValue() >= 0) {
        //TODO: pass by copy?
        gearList.add(belt);
        i++;
      }
    }

    //generate 20 positive potions
    while (gearList.size() != 60) {
      Gear potion = gearFactory.getPotion("potion " + i, seed);
      if (potion.getValue() >= 0) {
        //TODO: pass by copy?
        gearList.add(potion);
        i++;
      }
    }

    return gearList;
  }

  /**
   * A getter method that gets the bag of equipment/gear.
   * @return the gears in the bag in the form of a list of gear
   */

  public List<Gear> getBag() {
    return gears;
  }

}
