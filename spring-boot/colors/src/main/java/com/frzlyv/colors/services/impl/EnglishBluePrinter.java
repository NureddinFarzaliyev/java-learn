package com.frzlyv.colors.services.impl;

import org.springframework.stereotype.Component;

import com.frzlyv.colors.services.BluePrinter;

/**
 * EnglishBluePrinter
 */
public class EnglishBluePrinter implements BluePrinter {

  @Override
  public String printBlue() {
    return "Blue";
  }

}
