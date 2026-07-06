package com.frzlyv.rpg;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * PlayerInventory
 */
public class PlayerInventory {

  private List<Weapon> weapons = new ArrayList<Weapon>();
  private List<Armor> armors = new ArrayList<Armor>();

  private Weapon equippedWeapon;
  private Armor equippedArmor;

  public PlayerInventory(Weapon initialWeapon, Armor initialArmor) {
    this.equippedWeapon = initialWeapon;
    this.equippedArmor = initialArmor;
  }

  @Override
  public String toString() {
    var equipped = "Equipped Weapon: " + equippedWeapon.toString() + "\n" + "Equipped Armor: "
        + equippedArmor.toString();

    var invArmors = armors.stream()
        .map(Armor::toString)
        .collect(Collectors.joining("\n"));

    var invWeapons = weapons.stream()
        .map(Weapon::toString)
        .collect(Collectors.joining("\n"));

    return equipped + "\n" + "Armors:\n" + invArmors + "\nWeapons:\n" + invWeapons;
  }

  public void equipItem(Item item) {
    if (item instanceof Weapon weapon) {
      if (this.equippedWeapon != null) {
        this.weapons.add(this.equippedWeapon);
      }
      this.equippedWeapon = weapon;
      this.weapons.remove(equippedWeapon);
    } else if (item instanceof Armor armor) {
      if (this.equippedArmor != null) {
        this.armors.add(this.equippedArmor);
      }
      this.equippedArmor = armor;
      this.armors.remove(equippedArmor);
    }
  }

  public void addItem(Item item) {
    if (item instanceof Weapon weapon) {
      this.weapons.add(weapon);
      if (weapon.getDmg() > equippedWeapon.getDmg()) {
        equipItem(item);
      }
    } else if (item instanceof Armor armor) {
      this.armors.add(armor);
      if (armor.getDef() > equippedArmor.getDef()) {
        equipItem(item);
      }
    }
  }

  public Weapon getEquippedWeapon() {
    return this.equippedWeapon;
  }

  public Armor getEquippedArmor() {
    return this.equippedArmor;
  }
}
