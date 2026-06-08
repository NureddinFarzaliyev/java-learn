package com.frzlyv.rpg;

import com.frzlyv.rpg.enums.Screen;

/**
 * GameEngine
 */
public class GameEngine {

  private Interaction interaction;
  private Player player = new Player();
  private Screen screen = Screen.HOME;

  private boolean isRunning = true;

  public GameEngine(Interaction interaction) {
    this.interaction = interaction;
  }

  public void start() {
    System.out.println("Welcome to the game!");

    while (isRunning) {
      System.out.println(screen);
      var choice = interaction.getSafeIntInput();
      if (choice == -1) {
        System.out.println("Wrong input.");
      } else {
        var option = screen.getMenu().getOption(choice);
        if (option != null) {
          option.execute(player);
        } else {
          System.out.println("Wrong input.");
        }
      }
    }
  }
}
