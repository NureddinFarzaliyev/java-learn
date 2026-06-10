package com.frzlyv.rpg.actions;

import com.frzlyv.rpg.GameContext;

/**
 * PlayerStatsAction
 */
public class PlayerStatsAction implements ScreenMenuAction {
  @Override
  public void execute(GameContext context) {
    System.out.println(context.getPlayer());
  }
}
