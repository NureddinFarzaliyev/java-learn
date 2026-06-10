package com.frzlyv.rpg.actions;

import com.frzlyv.rpg.GameContext;

/**
 * PlayerInventoryAction
 */
public class PlayerInventoryAction implements ScreenMenuAction {
  @Override
  public void execute(GameContext context) {
    System.out.println(context.getPlayer().getInventory());
  }
}
