package com.frzlyv.rpg;

import com.frzlyv.rpg.enums.ItemType;

/**
 * Weapon
 */
public class Weapon extends Item {
  private int dmg;

  public Weapon(String name, int dmg) {
    super(name, ItemType.WEAPON);
    this.dmg = dmg;
  }

  public int getDmg() {
    return this.dmg;
  }

  @Override
  public String toString() {
    return super.toString() + " [" + dmg + " DMG]";
  }
}
