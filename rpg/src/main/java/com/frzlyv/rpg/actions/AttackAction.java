package com.frzlyv.rpg.actions;

import com.frzlyv.rpg.GameContext;

/**
 * AttackAction
 */
public class AttackAction implements ScreenMenuAction {
  @Override
  public void execute(GameContext context) {
    var player = context.getPlayer();
    var enemy = context.getCurrentBattle().getEnemy();

    player.attack(enemy, context.getCurrentBattle());
    enemy.attack(player, context.getCurrentBattle());
  }
}
