package com.frzlyv.colors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.frzlyv.colors.services.ColorPrinter;

@SpringBootApplication
public class ColorsApplication implements CommandLineRunner {

  private ColorPrinter colorPrinter;

  public ColorsApplication(ColorPrinter colorPrinter) {
    this.colorPrinter = colorPrinter;
  }

  public static void main(String[] args) {
    SpringApplication.run(ColorsApplication.class, args);
  }

  public void run(final String... args) {
    System.out.println(colorPrinter.printColors());
  }

}
