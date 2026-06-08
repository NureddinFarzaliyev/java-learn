package com.frzlyv.rpg;

import com.frzlyv.rpg.enums.ItemType;

/**
 * Item
 */
public class Item {
  private String name;
  private ItemType type;

  public Item(String name, ItemType type) {
    this.name = name;
    this.type = type;
  }

  @Override
  public String toString() {
    return name + " (" + type + ")";
  }

  public ItemType getType() {
    return this.type;
  }
}
