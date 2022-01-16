import static org.junit.Assert.assertTrue;

import org.junit.Test;
import weapon.AxeHelper;
import weapon.BroadSwordHelper;
import weapon.FlailHelper;
import weapon.KatanaHelper;
import weapon.TwoHandedSwordHelper;
import weapon.WeaponFactory;

/**
 * This test class tests the weapon factory
 * and its getters.
 */

public class WeaponFactoryTest {

  /**
   * A method that tests the getWeapon method
   * which gets a katana.
   */

  @Test
  public void testGetWeaponWhichGetsAKatana() {
    int seed = 10;
    WeaponFactory weaponFactory = new WeaponFactory(seed);
    assertTrue(weaponFactory.getWeapon("katana").checkIfType(KatanaHelper.getInstance()));
  }

  /**
   * A method that tests the getWeapon method
   * which gets an axe.
   */

  @Test
  public void testGetWeaponWhichGetsAnAxe() {
    int seed = 1;
    WeaponFactory weaponFactory = new WeaponFactory(seed);
    assertTrue(weaponFactory.getWeapon("axe").checkIfType(AxeHelper.getInstance()));
  }

  /**
   * A method that tests the getWeapon method
   * which gets a flail.
   */

  @Test
  public void testGetWeaponWhichGetsAFlail() {
    int seed = 50;
    WeaponFactory weaponFactory = new WeaponFactory(seed);
    assertTrue(weaponFactory.getWeapon("flail").checkIfType(FlailHelper.getInstance()));
  }

  /**
   * A method that tests the getWeapon method
   * which gets a TwoHandedSword.
   */

  @Test
  public void testGetWeaponWhichGetsATwoHandedSword() {
    int seed = 75;
    WeaponFactory weaponFactory = new WeaponFactory(seed);
    assertTrue(weaponFactory.getWeapon("twoHandedSword")
            .checkIfType(TwoHandedSwordHelper.getInstance()));
  }

  /**
   * A method that tests the getWeapon method
   * which gets a BroadSword.
   */

  @Test
  public void testGetWeaponWhichGetsABroadSword() {
    int seed = 98;
    WeaponFactory weaponFactory = new WeaponFactory(seed);
    assertTrue(weaponFactory.getWeapon("broadSword").checkIfType(BroadSwordHelper.getInstance()));
  }
}
