package com.frzlyv.rpg;

import com.frzlyv.rpg.enums.CreatureType;

/**
 * Player
 */
public class Player extends Creature {

  private PlayerInventory inventory;

  public Player() {
    super("Player", CreatureType.PLAYER, 100, 0, 15, 0.001, 200);

    var defaultWeapon = new Weapon("Wooden Sword", 5);
    var defaultArmor = new Armor("Wooden Armor", 5);

    this.inventory = new PlayerInventory(defaultWeapon, defaultArmor);
  }

  public PlayerInventory getInventory() {
    return inventory;
  }

  public void increaseHP(int amount) {
    setCurrentHP(Math.min(getCurrentHP() + amount, getMaxHP()));
  }

  public void decreaseCoins(int amount) {
    setCoins(Math.max(getCoins() - amount, 0));
  }

  public void increaseCoins(int amount) {
    setCoins(getCoins() + amount);
  }

  @Override
  public int getDefence() {
    var playerDefence = super.getDefence();
    var armorDefence = inventory.getEquippedArmor().getDef();
    return playerDefence + armorDefence;
  }

  @Override
  public int getAvgDmg() {
    var playerDamage = super.getAvgDmg();
    var weaponDamage = inventory.getEquippedWeapon().getDmg();
    return playerDamage + weaponDamage;
  }

}
