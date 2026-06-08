package com.frzlyv.rpg;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
  public static void main(String[] args) {
    var scanner = new Scanner(System.in);
    var interaction = new Interaction(scanner);
    var engine = new GameEngine(interaction);

    engine.start();
  }
}
