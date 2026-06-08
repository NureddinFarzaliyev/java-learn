package com.frzlyv.rpg;

import java.util.Scanner;

/**
 * Interaction
 */
public class Interaction {

  private Scanner scanner;

  public Interaction(Scanner scanner) {
    this.scanner = scanner;
  }

  public int getSafeIntInput() {
    String input = scanner.nextLine().trim();

    try {
      return Integer.parseInt(input);
    } catch (NumberFormatException e) {
      return -1;
    }
  }

}
