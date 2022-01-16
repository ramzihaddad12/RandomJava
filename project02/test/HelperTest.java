import static org.junit.Assert.assertTrue;

import gear.BeltHelper;
import gear.FootWearHelper;
import gear.HeadGearHelper;
import gear.PotionHelper;
import org.junit.Test;
import weapon.AxeHelper;
import weapon.BroadSwordHelper;
import weapon.FlailHelper;
import weapon.KatanaHelper;
import weapon.TwoHandedSwordHelper;


/**
 * This test class tests that all helpers
 * follow the singleton design pattern.
 */

public class HelperTest {

  /**
   * A method that tests that AxeHelper
   * returns the same object.
   */

  @Test
  public void testAxeHelper() {
    assertTrue(AxeHelper.getInstance() == AxeHelper.getInstance());
  }

  /**
   * A method that tests that KatanaHelper
   * returns the same object.
   */

  @Test
  public void testKatanaHelper() {
    assertTrue(KatanaHelper.getInstance() == KatanaHelper.getInstance());
  }

  /**
   * A method that tests that FlailHelper
   * returns the same object.
   */

  @Test
  public void testFlailHelper() {
    assertTrue(FlailHelper.getInstance() == FlailHelper.getInstance());
  }

  /**
   * A method that tests that TwoHandedSwordHelper
   * returns the same object.
   */

  @Test
  public void testTwoHandedSwordHelper() {
    assertTrue(TwoHandedSwordHelper.getInstance() == TwoHandedSwordHelper.getInstance());
  }

  /**
   * A method that tests that BroadSwordHelper
   * returns the same object.
   */

  @Test
  public void testBroadSwordHelper() {
    assertTrue(BroadSwordHelper.getInstance() == BroadSwordHelper.getInstance());
  }

  /**
   * A method that tests that BeltHelper
   * returns the same object.
   */

  @Test
  public void testBeltHelper() {
    assertTrue(BeltHelper.getInstance() == BeltHelper.getInstance());
  }

  /**
   * A method that tests that FootWearHelper
   * returns the same object.
   */

  @Test
  public void testFootWearHelper() {
    assertTrue(FootWearHelper.getInstance() == FootWearHelper.getInstance());
  }

  /**
   * A method that tests that HeadGearHelper
   * returns the same object.
   */

  @Test
  public void testHeadGearHelper() {
    assertTrue(HeadGearHelper.getInstance() == HeadGearHelper.getInstance());
  }

  /**
   * A method that tests that PotionHelper
   * returns the same object.
   */

  @Test
  public void testPotionHelper() {
    assertTrue(PotionHelper.getInstance() == PotionHelper.getInstance());
  }

}
