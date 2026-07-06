package com.frzlyv.rpg.enums;

import java.util.List;

import com.frzlyv.rpg.ScreenMenu;
import com.frzlyv.rpg.ScreenMenuOption;
import com.frzlyv.rpg.actions.AttackAction;
import com.frzlyv.rpg.actions.BattleAction;
import com.frzlyv.rpg.actions.BuyHPAction;
import com.frzlyv.rpg.actions.PlayerInventoryAction;
import com.frzlyv.rpg.actions.PlayerStatsAction;
import com.frzlyv.rpg.actions.QuitAction;
import com.frzlyv.rpg.actions.ShopAction;

public enum Screen {
  // HOME(new ScreenMenu(List.of(new ScreenMenuOption(4, "Shop"))));

  HOME, SHOP, BATTLE;

  private ScreenMenu menu;

  static {
    ScreenMenuOption quitOption = new ScreenMenuOption(0, "Quit", new QuitAction());

    ScreenMenuOption homePlay = new ScreenMenuOption(1, "Battle", new BattleAction());
    ScreenMenuOption homePlayerStats = new ScreenMenuOption(2, "Player Stats", new PlayerStatsAction());
    ScreenMenuOption homeInventory = new ScreenMenuOption(3, "Inventory", new PlayerInventoryAction());
    ScreenMenuOption homeShop = new ScreenMenuOption(4, "Shop", new ShopAction());

    HOME.menu = new ScreenMenu(List.of(homePlay, homePlayerStats, homeInventory, homeShop, quitOption));

    ScreenMenuOption buy10Hp = new ScreenMenuOption(1, "Fill 10HP", new BuyHPAction(10));
    ScreenMenuOption buy50Hp = new ScreenMenuOption(2, "Fill 50HP", new BuyHPAction(50));
    ScreenMenuOption buy100Hp = new ScreenMenuOption(3, "Fill 100HP", new BuyHPAction(100));

    SHOP.menu = new ScreenMenu(List.of(buy10Hp, buy50Hp, buy100Hp, quitOption));

    ScreenMenuOption battle = new ScreenMenuOption(1, "Attack", new AttackAction());

    BATTLE.menu = new ScreenMenu(List.of(battle));
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
    return "Please choose an option to continue:\n" + this.menu;
  }

}
