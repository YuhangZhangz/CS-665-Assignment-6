package edu.bu.met.cs665;

import static org.junit.Assert.*;
import org.junit.Test;

public class CondimentTest {

  /** Tests to ensure that milk and sugar units are within range. */
  @Test
  public void inRangeIsOk() {
    Condiment c = new Condiment();
    c.setMilkUnit(0);
    c.setSugarUnit(2);
    assertEquals(0, c.getMilkUnit());
    assertEquals(2, c.getSugarUnit());
  }

  @Test(expected = IllegalArgumentException.class)
  public void tooMuchMilkThrows() {
    Condiment c = new Condiment();
    c.setMilkUnit(100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void negativeSugarThrows() {
    Condiment c = new Condiment();
    c.setSugarUnit(-100);
  }
}
