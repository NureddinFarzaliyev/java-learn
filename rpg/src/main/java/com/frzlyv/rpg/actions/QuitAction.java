package com.frzlyv.rpg.actions;

import com.frzlyv.rpg.Player;

/**
 * QuitAction
 */
public class QuitAction implements ScreenMenuAction {
  @Override
  public void execute(Player player) {
    System.out.println("QUIT");
  }
}
