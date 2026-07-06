package com.frzlyv.rpg.actions;

import com.frzlyv.rpg.Armor;
import com.frzlyv.rpg.GameContext;
import com.frzlyv.rpg.Item;
import com.frzlyv.rpg.Weapon;
import com.frzlyv.rpg.enums.ItemType;
import com.frzlyv.rpg.utils.StatScaler;

/**
 * BuyItemAction
 */
public class BuyItemAction implements ScreenMenuAction {

  private ItemType itemType;
  private int price;

  private static final StatScaler scaler = new StatScaler();

  public BuyItemAction(ItemType itemType, int price) {
    this.itemType = itemType;
    this.price = price;
  }

  @Override
  public void execute(GameContext context) {

    var player = context.getPlayer();

    if (player.getCoins() < price) {
      System.out.println("Funds are not enough");
      return;
    }

    Item item;

    if (itemType == ItemType.ARMOR) {
      var armorDef = scaler.scaleStat(player.getDefence(), 0.4, 1.75);
      item = new Armor("random armor", armorDef);
    } else {
      var weaponDmg = scaler.scaleStat(player.getAvgDmg(), 0.4, 1.75);
      item = new Weapon("Random weapno", weaponDmg);
    }

    System.out.println(item);
    player.getInventory().addItem(item);
    player.decreaseCoins(price);
  }

}
