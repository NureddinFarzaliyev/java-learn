package com.frzlyv.rpg;

import java.util.Random;

import com.frzlyv.rpg.enums.CreatureType;

/**
 * Creature
 */
public class Creature {

  private String name;
  private CreatureType type;

  private int maxHP;
  private int currentHP;
  private int defence;
  private int avgDmg;
  private double critChance;
  private int coins;

  public Creature(String name, CreatureType type, int maxHP, int defence, int avgDmg, double critChance, int coins) {
    this.name = name;
    this.maxHP = maxHP;
    this.currentHP = maxHP;
    this.avgDmg = avgDmg;
    this.critChance = critChance;
    this.type = type;
    this.defence = defence;
    this.coins = coins;
  }

  @Override
  public String toString() {
    var before = "===== " + (type == CreatureType.ENEMY ? "Enemy" : "Player") + " Statistics =====";
    var after = "=============================";
    var stats = "- Name: " + name + "\n- HP: " + currentHP + "/" + maxHP + "\n- DEF: " + defence + "\n- DMG: " + avgDmg
        + "\n- Crit: " + critChance + "\n- Coins: " + coins;

    return before + "\n" + stats + "\n" + after;
  }

  public CreatureType getType() {
    return type;
  }

  public int getCoins() {
    return coins;
  }

  public void setCoins(int amount) {
    this.coins = amount;
  }

  public int getCurrentHP() {
    return currentHP;
  }

  public int getMaxHP() {
    return maxHP;
  }

  public void setCurrentHP(int amount) {
    this.currentHP = amount;
  }

  public boolean isCrit() {
    var r = new Random();
    double rDouble = r.nextDouble();
    return critChance >= rDouble;
  }

  public void consumeAttack(int incomingDmg, BattleEngine battle) {
    int prevHp = currentHP;
    int dmgAfterDef = Math.max(1, incomingDmg - defence);
    currentHP = Math.max(0, currentHP - dmgAfterDef);
    System.out.println("-> " + type + " Damaged: " + prevHp + " -> " + currentHP);
    if (currentHP <= 0) {
      battle.endBattle();
    }
  }

  public void attack(Creature creature, BattleEngine battle) {
    int dmg;

    if (isCrit()) {
      dmg = (int) Math.round(avgDmg * 1.1);
    } else {
      dmg = avgDmg;
    }

    System.out.println("-> " + " Attacking to " + creature.type + ": " + dmg);
    creature.consumeAttack(dmg, battle);
  }
}
