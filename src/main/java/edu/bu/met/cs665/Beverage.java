/**
 * Name: Yuhang Zhang
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/01/2025
 * File Name: Beverage.java
 * Description: Abstract base class for all beverages. It stores the shared
 *              attributes such as name and serving temperature.
 */

package edu.bu.met.cs665;

/**
 * This Beverage class is an abstract class for specific beverages.
 * It represents a generic beverage with a name and a Temperature.
 */
public abstract class Beverage {

  /** The display name of the beverage. */
  private final String name;

  /** Serving temperature for this beverage (HOT or COLD). */
  protected Temperature temperature;

  /**
   * Creates a Beverage with the given name and temperature (enum version).
   *
   * @param name the name of the beverage
   * @param temperature the serving temperature (HOT or COLD)
   */
  public Beverage(String name, Temperature temperature) {
    if (name == null || temperature == null) {
      throw new IllegalArgumentException("name and temperature must not be null");
    }
    this.name = name;
    this.temperature = temperature;
  }

  /**
   * Backwards compatible constructor that accepts a boolean.
   * true means HOT, false means COLD.
   *
   * @param name the name of the beverage
   * @param isHot true for hot, false for cold
   */
  public Beverage(String name, boolean isHot) {
    this(name, isHot ? Temperature.HOT : Temperature.COLD);
  }

  /**
   * Brew the beverage. Subclasses should implement the actual brewing logic.
   * Typically, only hot beverages are brewed and cold ones may throw an exception.
   */
  public abstract void brew();

  /** @return the name of this Beverage. */
  public String getName() {
    return name;
  }

  /** @return the serving temperature as an enum. */
  public Temperature getTemperatureEnum() {
    return temperature;
  }

  /** @return true if this Beverage is hot, false if it is cold. */
  public boolean getTemperature() {
    return temperature.isHot();
  }

  /** @return true if this Beverage is hot. */
  public boolean isHot() {
    return temperature.isHot();
  }
}
