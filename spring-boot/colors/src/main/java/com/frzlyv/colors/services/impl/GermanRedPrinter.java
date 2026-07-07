package com.frzlyv.colors.services.impl;

import org.springframework.stereotype.Component;

import com.frzlyv.colors.services.RedPrinter;

/**
 * GermanRedPrinter
 */
@Component
public class GermanRedPrinter implements RedPrinter {

  @Override
  public String printRed() {
    return "Rot";
  }

}
