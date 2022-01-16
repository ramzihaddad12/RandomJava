import java.util.List;
import java.util.Random;

import battle.BagOfEquipment;
import battle.Battle;
import battle.Player;
import gear.*;
import randomize.Randomness;
import weapon.*;

public class Driver {
  public static void main(String[] args) {
//    gear.Gear foot = new gear.Footwear();
//
//    System.out.println(foot.checkIfType(gear.HeadGearHelper.getInstance()));
//
//    int[] ints = new Random().ints(1, 5).distinct().limit(2).toArray();
//
//    System.out.println(ints[0]);
//    System.out.println(ints[1]);

//    Weapon weapon = new Axe();
//
//    System.out.println(weapon.checkIfType(KatanaHelper.getInstance()));
//    System.out.println(weapon.checkIfType(BroadSwordHelper.getInstance()));
//    System.out.println(weapon.checkIfType(TwoHandedSwordHelper.getInstance()));
//    System.out.println(weapon.checkIfType(AxeHelper.getInstance()));
//    System.out.println(weapon.checkIfType(FlailHelper.getInstance()));
//    System.out.println("/////////////////////////////////////");
//
//    System.out.println(Randomness.generateValueBetween(1, 4));
//    System.out.println(Randomness.generateBoolean());
//    System.out.println("/////////////////////////////////////");
//    Gear gear = new Headgear("HI");
//    System.out.println(gear.getValue());
//
//    System.out.println("/////////////////////////////////////");
//    Weapon weapon1 = new Flail();
//    System.out.println(weapon1.getRange()[0] + " " + weapon1.getRange()[1] + " ");
//    System.out.println("/////////////////////////////////////");
//
//    BagOfEquipment bagOfEquipment = new BagOfEquipment();
////    bagOfEquipment.generateBag();
//    List<Gear> gearList = bagOfEquipment.getBag();
//    for (int i = 0; i < gearList.size(); i++) {
//      System.out.println(gearList.get(i).getValue());
//      System.out.println(gearList.get(i).getName());
//
//    }

//    System.out.println("/////////////////////////////////////");
//    Battle battle = new Battle();
////    BagOfEquipment bagOfEquipment = new BagOfEquipment();
//
//
////    battle.equipPlayer1();
//
////
//    List<Gear> belts = battle.getPlayer1().getBelts();
//    for (int i = 0; i < belts.size(); i++) {
//      System.out.println(belts.get(i).getValue());
//      System.out.println(belts.get(i).getName());
//    }
//
//    List<Gear> potions = battle.getPlayer1().getPotions();
//    for (int i = 0; i < potions.size(); i++) {
//      System.out.println(potions.get(i).getValue());
//      System.out.println(potions.get(i).getName());
//    }
//    System.out.println(battle.getPlayer1().getHeadGear().getName());
//    System.out.println(battle.getPlayer1().getHeadGear().getValue());
//
//    System.out.println(battle.getPlayer1().getFootWear().getName());
//    System.out.println(battle.getPlayer1().getFootWear().getValue());
//
//    List<Gear> gearList = battle.getBagOfEquipment().getBag();
//    System.out.println(gearList.size());
////    for (int i = 0; i < gearList.size(); i++) {
////      System.out.println(gearList.get(i).getValue());
////      System.out.println(gearList.get(i).getName());
////
////    }
//
//    Random random = new Random(95);
//    for (int i = 0; i < 10; i++) {
//      System.out.println(random.nextInt());
//    }
//    Gear headGear = new Belt("hg");
//
//    System.out.println(headGear.getNumberOfUnits());
    int seed = 10;
    Randomness randomness = new Randomness();
    Player p1 = new Player(randomness.generateValueBetween(6, 18), randomness.generateValueBetween(6, 18),randomness.generateValueBetween(6, 18),randomness.generateValueBetween(6, 18));
    Player p2 = new Player(randomness.generateValueBetween(6, 18), randomness.generateValueBetween(6, 18),randomness.generateValueBetween(6, 18),randomness.generateValueBetween(6, 18));
    System.out.println(p1.getStrength());
    System.out.println(p1.getConstitution());
    System.out.println(p1.getDexterity());
    System.out.println(p1.getCharisma());
    System.out.println("Health of the 1st player is : " + p1.getHealth());
    System.out.println("/////////////////////////");
    System.out.println(p2.getStrength());
    System.out.println(p2.getConstitution());
    System.out.println(p2.getDexterity());
    System.out.println(p2.getCharisma());
    System.out.println("Health of the 2nd player is : " + p2.getHealth());

    Battle battle = new Battle(p1, p2, seed);
    battle.player2Attacks();
    System.out.println(p2.getStrikingPower());
    System.out.println(p1.getAvoidanceAbility());
    System.out.println(p2.getPotentialStrikingDamage());
    System.out.println("Health of the 1st player is : " + p1.getHealth());

  }
}
