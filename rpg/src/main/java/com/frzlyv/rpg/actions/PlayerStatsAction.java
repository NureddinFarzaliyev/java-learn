package com.frzlyv.rpg.actions;

import com.frzlyv.rpg.Player;

/**
 * PlayerStatsAction
 */
public class PlayerStatsAction implements ScreenMenuAction {
  @Override
  public void execute(Player player) {
    System.out.println(player);
  }
}
