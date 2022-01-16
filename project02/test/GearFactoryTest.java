import static org.junit.Assert.assertTrue;

import gear.BeltHelper;
import gear.FootWearHelper;
import gear.GearFactory;
import gear.HeadGearHelper;
import gear.PotionHelper;
import org.junit.Before;
import org.junit.Test;

/**
 * This test class tests the gear factory
 * and its different getters.
 */

public class GearFactoryTest {
  private GearFactory gearFactory;

  /**
   * Creating the objects needed in the other tests.
   */

  @Before
  public void setUp() {
    gearFactory = new GearFactory();
  }

  /**
   * A method that tests the getBelt method.
   */

  @Test
  public void testGetBelt() {
    assertTrue(gearFactory.getBelt("belt").checkIfType(BeltHelper.getInstance()));
  }

  /**
   * A method that tests the getBelt method with seed.
   */

  @Test
  public void testGetBeltWithSeed() {
    int seed = 10;
    assertTrue(gearFactory.getBelt("belt", seed).checkIfType(BeltHelper.getInstance()));
  }

  /**
   * A method that tests the getHeadgear method.
   */

  @Test
  public void testGetHeadGear() {
    assertTrue(gearFactory.getHeadgear("headGear").checkIfType(HeadGearHelper.getInstance()));
  }

  /**
   * A method that tests the getHeadgear method with seed.
   */

  @Test
  public void testGetHeadGearWithSeed() {
    int seed = 10;
    assertTrue(gearFactory.getHeadgear("headGear", seed).checkIfType(HeadGearHelper.getInstance()));
  }

  /**
   * A method that tests the getFootWear method.
   */

  @Test
  public void testGetFootWear() {
    assertTrue(gearFactory.getFootWear("footWear").checkIfType(FootWearHelper.getInstance()));
  }

  /**
   * A method that tests the getFootWear method with seed.
   */

  @Test
  public void testGetFootWearWithSeed() {
    int seed = 10;
    assertTrue(gearFactory.getFootWear("footWear", seed).checkIfType(FootWearHelper.getInstance()));
  }

  /**
   * A method that tests the getPotion method.
   */

  @Test
  public void testGetPotion() {
    assertTrue(gearFactory.getPotion("potion").checkIfType(PotionHelper.getInstance()));
  }

  /**
   * A method that tests the getPotion method with seed.
   */

  @Test
  public void testGetPotionWithSeed() {
    int seed = 10;
    assertTrue(gearFactory.getPotion("potion", seed).checkIfType(PotionHelper.getInstance()));
  }
}
