package com.frzlyv.rpg.actions;

import com.frzlyv.rpg.Player;

/**
 * PlayerInventoryAction
 */
public class PlayerInventoryAction implements ScreenMenuAction {
  @Override
  public void execute(Player player) {
    System.out.println(player.getInventory());
  }
}
