package edu.bu.met.cs665;

import static org.junit.Assert.*;
import org.junit.Test;

public class MachineControllerTest {

  /** Tests to ensure that a hot espresso with condiments can be brewed. */
  @Test
  public void hotEspressoWithCondiments() {
    MachineController mc = new MachineController();
    mc.setTemperature(true);
    mc.chooseCoffee("Americano");
    mc.addCondiment(0, 0);

    Beverage b = mc.dispense();
    assertEquals("Americano", b.getName());
    assertTrue(mc.getTemperature());
  }

  @Test
  public void coldGreenTeaShouldNotBrewAndNoThrow() {
    MachineController mc = new MachineController();
    mc.setTemperature(false);
    mc.chooseTea("Red Tea");
    mc.addCondiment(3, 3);

    Beverage b = mc.dispense();
    assertEquals("Red Tea", b.getName());
    assertFalse(mc.getTemperature());
    assertFalse(b.getTemperature());
  }
}
