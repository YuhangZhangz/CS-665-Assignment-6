package edu.bu.met.cs665;

import org.junit.Test;

public class BrewRulesTest {

  /** Tests to ensure that only hot beverages can be brewed. */
  @Test(expected = UnsupportedOperationException.class)
  public void coldCoffeeCannotBrew() {
    new Coffee("Americano", false).brew();
  }

  @Test(expected = UnsupportedOperationException.class)
  public void coldTeaCannotBrew() {
    new Tea("Red Tea", false).brew();
  }
}
