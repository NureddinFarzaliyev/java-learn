package com.frzlyv.rpg;

import com.frzlyv.rpg.enums.Screen;

/**
 * BattleEngine
 */
public class BattleEngine {

  private GameContext context;
  private Creature creature;

  public BattleEngine(GameContext context) {
    this.context = context;
    this.creature = new Creature(context);
  }

  @Override
  public String toString() {
    return "BATTLE!\n" + context.getPlayer() + "\n" + creature;
  }

  public Creature getEnemy() {
    return creature;
  }

  public void initiateBattle() {
    if (context.getPlayer().getCurrentHP() <= 0) {
      System.out.println("Your HP is too low to start battle.");
      return;
    }
    context.setCurrentBattle(this);
    context.setCurrentScreen(Screen.BATTLE);
  }

  public void endBattle() {
    System.out.println("Battle ended");
    if (creature.getCurrentHP() <= 0 && context.getPlayer().getCurrentHP() <= 0) {
      System.out.println("Draw!!!");
    } else if (creature.getCurrentHP() <= 0) {
      System.out.println("Player Won!!!");
      System.out.println("+" + creature.getCoins() + " coins");
      context.getPlayer().increaseCoins(creature.getCoins());
    } else {
      System.out.println("Player Lost!!!");
    }
    context.setCurrentBattle(null);
    context.setCurrentScreen(Screen.HOME);
  }

}
