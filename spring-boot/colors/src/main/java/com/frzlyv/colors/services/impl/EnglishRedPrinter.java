package com.frzlyv.colors.services.impl;

import org.springframework.stereotype.Component;

import com.frzlyv.colors.services.RedPrinter;

/**
 * EnglishRedPrinter
 */
public class EnglishRedPrinter implements RedPrinter {

  @Override
  public String printRed() {
    return "Red";
  }

}
