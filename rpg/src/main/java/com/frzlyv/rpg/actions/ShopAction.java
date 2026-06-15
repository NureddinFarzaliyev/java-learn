package com.frzlyv.rpg.actions;

import com.frzlyv.rpg.GameContext;
import com.frzlyv.rpg.enums.Screen;

/**
 * ShopAction
 */
public class ShopAction implements ScreenMenuAction {
  @Override
  public void execute(GameContext context) {
    System.out.println("You have " + context.getPlayer().getCoins() + " coins.");
    context.setCurrentScreen(Screen.SHOP);
  }
}
