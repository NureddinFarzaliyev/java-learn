package com.frzlyv.rpg;

import com.frzlyv.rpg.actions.ScreenMenuAction;

/**
 * ScreenMenuOption
 */
public class ScreenMenuOption {

  private final int number;
  private final String label;
  private final ScreenMenuAction action;

  public ScreenMenuOption(int number, String label, ScreenMenuAction action) {
    this.number = number;
    this.label = label;
    this.action = action;
  }

  public void execute(Player player) {
    if (action != null) {
      action.execute(player);
    }
  }

  @Override
  public String toString() {
    return number + ". " + label;
  }

  public int getNumber() {
    return number;
  }

}
