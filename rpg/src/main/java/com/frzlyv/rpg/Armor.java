package com.frzlyv.rpg;

import com.frzlyv.rpg.enums.ItemType;

/**
 * Armor
 */
public class Armor extends Item {
  private int def;

  public Armor(String name, int def) {
    super(name, ItemType.ARMOR);
    this.def = def;
  }

  @Override
  public String toString() {
    return super.toString() + " [" + def + " DEF]";
  }

}
