package com.frzlyv.rpg;

import com.frzlyv.rpg.enums.Screen;

/**
 * GameContext
 */
public class GameContext {

  private Player player;
  private Screen currentScreen;
  private Interaction interaction;
  private boolean running;
  private BattleEngine currentBattle;

  public GameContext(Player player, Interaction interaction) {
    this.player = player;
    this.currentScreen = Screen.HOME;
    this.interaction = interaction;
    this.running = true;
  }

  public Player getPlayer() {
    return player;
  }

  public Interaction getInteraction() {
    return interaction;
  }

  public Screen getCurrentScreen() {
    return currentScreen;
  }

  public void setCurrentScreen(Screen screen) {
    this.currentScreen = screen;
  }

  public boolean isRunning() {
    return running;
  }

  public void setRunning(boolean running) {
    this.running = running;
  }

  public void setCurrentBattle(BattleEngine battle) {
    this.currentBattle = battle;
  }

  public BattleEngine getCurrentBattle() {
    return currentBattle;
  }
}
