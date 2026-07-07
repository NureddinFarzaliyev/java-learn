package com.frzlyv.colors.services.impl;

import org.springframework.stereotype.Component;

import com.frzlyv.colors.services.BluePrinter;

/**
 * GermanBluePrinter
 */
@Component
public class GermanBluePrinter implements BluePrinter {

  @Override
  public String printBlue() {
    return "Blau";
  }

}
