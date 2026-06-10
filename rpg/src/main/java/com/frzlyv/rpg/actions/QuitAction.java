package com.frzlyv.rpg.actions;

import com.frzlyv.rpg.GameContext;

/**
 * QuitAction
 */
public class QuitAction implements ScreenMenuAction {
  @Override
  public void execute(GameContext context) {
    System.out.println("QUIT");
  }
}
