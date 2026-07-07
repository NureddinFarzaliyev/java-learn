package com.frzlyv.store;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HomeController
 */
@RestController
public class HomeController {

  @GetMapping(path = "/hello")
  public String helloWorld() {
    return "Hello, World!";
  }
}
