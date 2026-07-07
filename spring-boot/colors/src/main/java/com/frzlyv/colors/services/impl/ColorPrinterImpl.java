package com.frzlyv.colors.services.impl;

import org.springframework.stereotype.Component;

import com.frzlyv.colors.services.BluePrinter;
import com.frzlyv.colors.services.ColorPrinter;
import com.frzlyv.colors.services.RedPrinter;

/**
 * ColorPrinterImpl
 */
@Component
public class ColorPrinterImpl implements ColorPrinter {

  private RedPrinter redPrinter;
  private BluePrinter bluePrinter;

  public ColorPrinterImpl(RedPrinter redPrinter, BluePrinter bluePrinter) {
    this.redPrinter = redPrinter;
    this.bluePrinter = bluePrinter;
  }

  @Override
  public String printColors() {
    return redPrinter.printRed() + " " + bluePrinter.printBlue();
  }

}
