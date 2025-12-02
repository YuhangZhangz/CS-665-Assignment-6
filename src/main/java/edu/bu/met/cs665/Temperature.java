/**
 * Name: Yuhang Zhang
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/01/2025
 * File Name: Temperature.java
 * Description: Enumeration for beverage serving temperature.
 */

package edu.bu.met.cs665;

/**
 * Defines the serving temperature of a beverage.
 */
public enum Temperature {
  HOT,
  COLD;

  /**
   * @return true if this temperature represents a hot drink.
   */
  public boolean isHot() {
    return this == HOT;
  }
}
