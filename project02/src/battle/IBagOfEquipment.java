package battle;

import gear.Gear;

import java.util.List;

/**
 * This interface represents a bag of equipment/gear
 * from which the player will choose from before starting fighting.
 */

public interface IBagOfEquipment {

  /**
   * A method that removes a gear from the bag given its index.
   * @param index the index/position of the gear to be removed in the bag
   */

  public void remove(int index);

  /**
   * A getter method that gets the bag of equipment/gear.
   * @return the gears in the bag in the form of a list of gear
   */

  public List<Gear> getBag();
}
