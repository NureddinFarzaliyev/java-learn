package com.frzlyv.rpg;

import java.util.Scanner;

import com.frzlyv.rpg.enums.Screen;

/**
 * GameEngine
 */
public class GameEngine {

  private Scanner scanner = new Scanner(System.in);

  private Player player;
  private Screen screen = Screen.HOME;

  private boolean isRunning = true;

  public GameEngine(Player player) {
    this.player = player;
  }

  public void start() {
    System.out.println("Welcome to the game!");
    System.out.println(screen);
    var choice = scanner.nextLine();
    System.out.println(choice);

    // System.out.println(player);
    // System.out.println(player.getInventory());
  }

}
