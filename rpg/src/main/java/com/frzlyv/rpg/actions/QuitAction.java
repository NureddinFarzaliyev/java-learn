package com.frzlyv.rpg.actions;

import com.frzlyv.rpg.GameContext;
import com.frzlyv.rpg.enums.Screen;

/**
 * QuitAction
 */
public class QuitAction implements ScreenMenuAction {
  @Override
  public void execute(GameContext context) {
    context.setCurrentScreen(Screen.HOME);
  }
}
