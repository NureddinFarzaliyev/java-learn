package com.frzlyv.rpg;

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

  public Creature(String name, CreatureType type, int maxHP, int defence, int avgDmg, double critChance) {
    this.name = name;
    this.maxHP = maxHP;
    this.currentHP = maxHP;
    this.avgDmg = avgDmg;
    this.critChance = critChance;
    this.type = type;
    this.defence = defence;

    if (type == CreatureType.PLAYER) {
      this.coins = 200;
    } else {
      this.coins = 0;
    }
  }

  @Override
  public String toString() {
    var before = "===== Player Statistics =====";
    var after = "=============================";
    var stats = "- Name: " + name + "\n- HP: " + currentHP + "/" + maxHP + "\n- DEF: " + defence + "\n- DMG: " + avgDmg
        + "\n- Crit: "
        + critChance;
    var finalStats = type == CreatureType.PLAYER ? "- Coins: " + coins + "\n" + stats : stats;

    return before + "\n" + finalStats + "\n" + after;
  }
}
