package com.frzlyv.rpg;

/**
 * ScreenMenuOption
 */
public class ScreenMenuOption {

  private int number;
  private String label;

  public ScreenMenuOption(int number, String label) {
    this.number = number;
    this.label = label;
  }

  @Override
  public String toString() {
    return number + ". " + label;
  }

  public int getNumber() {
    return number;
  }

}
