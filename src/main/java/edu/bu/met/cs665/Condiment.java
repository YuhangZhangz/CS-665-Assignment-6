/**
 * Name: Yuhang Zhang
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/01/2025
 * File Name: Condiment.java
 * Description: Represents the milk and sugar configuration for a beverage.
 */

package edu.bu.met.cs665;

/**
 * Condiment models the milk and sugar units that can be added to a beverage,
 * together with the serving temperature.
 */
public class Condiment {

  /** The milk units in [0, 1, 2, 3]. */
  private int milkUnit;

  /** The sugar units in [0, 1, 2, 3]. */
  private int sugarUnit;

  /** Serving temperature for this condiment configuration. */
  private Temperature temperature;

  /** Default condiment: 0 milk, 0 sugar, HOT. */
  public Condiment() {
    this(0, 0, Temperature.HOT);
  }

  /**
   * Constructs a Condiment with explicit values.
   *
   * @param milkUnit milk units (0–3)
   * @param sugarUnit sugar units (0–3)
   * @param temperature serving temperature
   */
  public Condiment(int milkUnit, int sugarUnit, Temperature temperature) {
    setMilkUnit(milkUnit);
    setSugarUnit(sugarUnit);
    if (temperature == null) {
      throw new IllegalArgumentException("temperature must not be null");
    }
    this.temperature = temperature;
  }

  /** @return the milk unit. */
  public int getMilkUnit() {
    return milkUnit;
  }

  /**
   * Sets milk units, enforcing [0, 1, 2, 3].
   *
   * @param milkUnit milk units
   */
  public void setMilkUnit(int milkUnit) {
    if (milkUnit < 0 || milkUnit > 3) {
      throw new IllegalArgumentException("milkUnit must be between 0 and 3");
    }
    this.milkUnit = milkUnit;
  }

  /** @return the sugar unit. */
  public int getSugarUnit() {
    return sugarUnit;
  }

  /**
   * Sets sugar units, enforcing [0, 1, 2, 3].
   *
   * @param sugarUnit sugar units
   */
  public void setSugarUnit(int sugarUnit) {
    if (sugarUnit < 0 || sugarUnit > 3) {
      throw new IllegalArgumentException("sugarUnit must be between 0 and 3");
    }
    this.sugarUnit = sugarUnit;
  }

  /** @return the serving temperature as enum. */
  public Temperature getTemperatureEnum() {
    return temperature;
  }

  /** @return true if HOT, false if COLD. */
  public boolean getTemperature() {
    return temperature.isHot();
  }

  /**
   * Sets the serving temperature.
   *
   * @param temperature the new serving temperature
   */
  public void setTemperature(Temperature temperature) {
    if (temperature == null) {
      throw new IllegalArgumentException("temperature must not be null");
    }
    this.temperature = temperature;
  }
}
