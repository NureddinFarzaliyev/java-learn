package com.frzlyv.rpg;

/**
 * GameEngine
 */
public class GameEngine {

  private GameContext context;

  public GameEngine(Interaction interaction) {
    var player = new Player();
    context = new GameContext(player, interaction);
  }

  public void start() {
    System.out.println("Welcome to the game!");

    while (context.isRunning()) {
      System.out.println(context.getCurrentScreen());
      var choice = context.getInteraction().getSafeIntInput();
      if (choice == -1) {
        System.out.println("Wrong input.");
      } else {
        var option = context.getCurrentScreen().getMenu().getOption(choice);
        if (option != null) {
          option.execute(context);
        } else {
          System.out.println("Wrong input.");
        }
      }
    }
  }
}
