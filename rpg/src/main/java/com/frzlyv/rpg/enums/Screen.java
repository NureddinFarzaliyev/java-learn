package com.frzlyv.rpg.enums;

public enum Screen {

  HOME("1. Player Stats\n2. Inventory\n3. Shop"),
  SHOP("Shop Menu");

  private final String menu;

  Screen(String menu) {
    this.menu = menu;
  }

  @Override
  public String toString() {
    return "Please choose an option to continue:\n" + this.menu + "\n0. Quit";
  }

}
