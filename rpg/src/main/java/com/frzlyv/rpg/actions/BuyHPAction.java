package com.frzlyv.rpg.actions;

import com.frzlyv.rpg.GameContext;

/**
 * BuyHPAction
 */
public class BuyHPAction implements ScreenMenuAction {
  private int amount;

  public BuyHPAction(int amount) {
    this.amount = amount;
  }

  @Override
  public void execute(GameContext context) {
    var player = context.getPlayer();
    if (player.getCoins() < amount) {
      System.out.println("Funds are not enough");
    } else {
      player.increaseHP(amount);
      player.decreaseCoins(amount);
    }
  }
}
