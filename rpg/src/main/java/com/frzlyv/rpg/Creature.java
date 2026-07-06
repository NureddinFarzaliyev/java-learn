package com.frzlyv.rpg;

import java.util.Random;

import com.frzlyv.rpg.enums.CreatureType;
import com.frzlyv.rpg.utils.StatScaler;

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

  private static final Random random = new Random();
  private static final StatScaler scaler = new StatScaler();

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

  public Creature(GameContext context) {
    var player = context.getPlayer();

    this.type = CreatureType.ENEMY;

    String[] enemyNames = { "Goblin", "Orc", "Skeleton", "Thief" };
    this.name = enemyNames[random.nextInt(enemyNames.length)];

    this.maxHP = scaler.scaleStat(player.getMaxHP(), 0.75, 1.15);
    this.currentHP = this.maxHP;
    this.avgDmg = scaler.scaleStat(player.getAvgDmg(), 0.80, 1.10);
    this.defence = scaler.scaleStat(player.getDefence(), 0.75, 1.10);
    double rawCrit = player.getCritChance() * (0.8 + random.nextDouble() * 0.4);
    this.critChance = Math.min(0.25, Math.round(rawCrit * 100.0) / 100.0);
    this.coins = scaler.scaleStat(player.getCoins() / 5 + 5, 0.9, 1.2);
  }

  @Override
  public String toString() {
    var before = "===== " + (type == CreatureType.ENEMY ? "Enemy" : "Player") + " Statistics =====";
    var after = "=============================";
    var stats = "- Name: " + name + "\n- HP: " + currentHP + "/" + maxHP + "\n- DEF: " + this.getDefence() + "\n- DMG: "
        + this.getAvgDmg() + "\n- Crit: " + critChance + "\n- Coins: " + coins;

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

  public void setCurrentHP(int amount) {
    this.currentHP = amount;
  }

  public int getMaxHP() {
    return maxHP;
  }

  public int getAvgDmg() {
    return this.avgDmg;
  }

  public int getDefence() {
    return this.defence;
  }

  public double getCritChance() {
    return this.critChance;
  }

  public boolean isCrit() {
    double rDouble = random.nextDouble();
    return critChance >= rDouble;
  }

  public void consumeAttack(int incomingDmg, BattleEngine battle) {
    int prevHp = currentHP;
    int dmgAfterDef = Math.max(1, incomingDmg - this.getDefence());
    currentHP = Math.max(0, currentHP - dmgAfterDef);
    System.out.println("-> " + type + " Damaged: " + prevHp + " -> " + currentHP);
    if (currentHP <= 0 && battle != null) {
      battle.endBattle();
    }
  }

  public void attack(Creature creature, BattleEngine battle) {
    int dmg;

    if (isCrit()) {
      dmg = (int) Math.round(this.getAvgDmg() * 1.1);
    } else {
      dmg = this.getAvgDmg();
    }

    System.out.println("-> " + " Attacking to " + creature.type + ": " + dmg);
    creature.consumeAttack(dmg, battle);
  }

}
