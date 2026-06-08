package com.frzlyv.rpg;

/**
 * Hello world!
 */
public class App {
  public static void main(String[] args) {
    var player = new Player();
    var engine = new GameEngine(player);

    engine.start();
  }
}
