package com.frzlyv.rpg.utils;

import java.util.Random;

/**
 * StatScaler
 */
public class StatScaler {

  private static final Random random = new Random();

  public int scaleStat(int baseValue, double minMultiplier, double maxMultiplier) {
    double multiplier = minMultiplier + (maxMultiplier - minMultiplier) * random.nextDouble();
    return (int) Math.max(1, Math.round(baseValue * multiplier));
  }

}
