package com.frzlyv.rpg.actions;

import com.frzlyv.rpg.BattleEngine;
import com.frzlyv.rpg.GameContext;

/**
 * BattleAction
 */
public class BattleAction implements ScreenMenuAction {
  @Override
  public void execute(GameContext context) {
    var battle = new BattleEngine(context);
    battle.initiateBattle();
  }
}
