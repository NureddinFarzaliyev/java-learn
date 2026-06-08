package com.frzlyv.rpg;

import java.util.List;
import java.util.stream.Collectors;

/**
 * ScreenMenu
 */
public class ScreenMenu {

  private List<ScreenMenuOption> options;

  public ScreenMenu(List<ScreenMenuOption> options) {
    this.options = options;
  }

  public ScreenMenuOption getOption(int number) {
    return options.stream()
        .filter(o -> o.getNumber() == number)
        .findFirst()
        .orElse(null);
  }

  @Override
  public String toString() {
    return options.stream()
        .map(ScreenMenuOption::toString)
        .collect(Collectors.joining("\n"));
  }

}
