package com.frzlyv.rpg.enums;

import java.util.List;

import com.frzlyv.rpg.ScreenMenu;
import com.frzlyv.rpg.ScreenMenuOption;
import com.frzlyv.rpg.actions.PlayerInventoryAction;
import com.frzlyv.rpg.actions.PlayerStatsAction;
import com.frzlyv.rpg.actions.QuitAction;

public enum Screen {
  // HOME(new ScreenMenu(List.of(new ScreenMenuOption(4, "Shop"))));

  HOME;

  private ScreenMenu menu;

  static {
    // ScreenMenuOption homePlay = new ScreenMenuOption(1, "Play");
    ScreenMenuOption homePlayerStats = new ScreenMenuOption(2, "Player Stats", new PlayerStatsAction());
    ScreenMenuOption homeInventory = new ScreenMenuOption(3, "Inventory", new PlayerInventoryAction());
    // ScreenMenuOption homeShop = new ScreenMenuOption(4, "Shop");

    // HOME.menu = new ScreenMenu(List.of(homePlay, homePlayerStats, homeInventory,
    // homeShop));
    HOME.menu = new ScreenMenu(List.of(homePlayerStats, homeInventory));
  }

  Screen() {
  }

  public ScreenMenu getMenu() {
    return menu;
  }

  // Screen(ScreenMenu menu) {
  // this.menu = menu;
  // }

  @Override
  public String toString() {
    var quitOption = new ScreenMenuOption(0, "Quit", new QuitAction());
    return "Please choose an option to continue:\n" + this.menu + "\n" + quitOption;
  }

}
