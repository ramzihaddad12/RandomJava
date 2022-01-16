import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import battle.BagOfEquipment;
import battle.IBagOfEquipment;
import gear.BeltHelper;
import gear.FootWearHelper;
import gear.Gear;
import gear.HeadGearHelper;
import gear.PotionHelper;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * This test class tests the different
 * features for a bag of equipment.
 */

public class BagOfEquipmentTest {
  private IBagOfEquipment bagOfEquipment;

  /**
   * Creating the objects needed in the other tests.
   */

  @Before
  public void setUp() {
    bagOfEquipment = new BagOfEquipment();
  }

  /**
   * This method tests the getBag method
   * which returns a list of gear.
   */

  @Test
  public void testGetBag() {
    List<Gear> gears = bagOfEquipment.getBag();
    int expectedSize = 80;
    assertEquals(expectedSize, gears.size());
    for (int i = 0; i < 3; i++) {
      assertTrue(gears.get(i).checkIfType(FootWearHelper.getInstance()));
      assertTrue(gears.get(i).getValue() < 0);
    }

    for (int i = 3; i < 5; i++) {
      assertTrue(gears.get(i).checkIfType(HeadGearHelper.getInstance()));
      assertTrue(gears.get(i).getValue() < 0);
    }

    for (int i = 5; i < 10; i++) {
      assertTrue(gears.get(i).checkIfType(BeltHelper.getInstance()));
      assertTrue(gears.get(i).getValue() < 0);
    }

    for (int i = 10; i < 20; i++) {
      assertTrue(gears.get(i).checkIfType(PotionHelper.getInstance()));
      assertTrue(gears.get(i).getValue() < 0);
    }

    for (int i = 20; i < 22; i++) {
      assertTrue(gears.get(i).checkIfType(FootWearHelper.getInstance()));
      assertTrue(gears.get(i).getValue() > 0);
    }

    for (int i = 22; i < 25; i++) {
      assertTrue(gears.get(i).checkIfType(HeadGearHelper.getInstance()));
      assertTrue(gears.get(i).getValue() > 0);
    }

    for (int i = 25; i < 40; i++) {
      assertTrue(gears.get(i).checkIfType(BeltHelper.getInstance()));
      assertTrue(gears.get(i).getValue() > 0);
    }

    for (int i = 40; i < 80; i++) {
      assertTrue(gears.get(i).checkIfType(PotionHelper.getInstance()));
      assertTrue(gears.get(i).getValue() > 0);
    }
  }

  /**
   * This method tests the remove method
   * which removes a gear from the bag given its index.
   */

  @Test
  public void testRemove() {
    bagOfEquipment.remove(40);
    int expectedSize = 79;
    assertEquals(expectedSize, bagOfEquipment.getBag().size());
    assertTrue(bagOfEquipment.getBag().get(40).checkIfType(PotionHelper.getInstance()));

    bagOfEquipment.remove(0);
    assertEquals(expectedSize - 1, bagOfEquipment.getBag().size());


  }
}
