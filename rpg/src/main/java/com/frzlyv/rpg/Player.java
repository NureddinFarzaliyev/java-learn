package com.frzlyv.rpg;

import com.frzlyv.rpg.enums.CreatureType;

/**
 * Player
 */
public class Player extends Creature {

  private PlayerInventory inventory;

  public Player() {
    super("Player", CreatureType.PLAYER, 100, 0, 0, 0.05);

    var defaultWeapon = new Weapon("Wooden Sword", 5);
    var defaultArmor = new Armor("Wooden Armor", 5);

    this.inventory = new PlayerInventory(defaultWeapon, defaultArmor);
  }

  public PlayerInventory getInventory() {
    return inventory;
  }

}
