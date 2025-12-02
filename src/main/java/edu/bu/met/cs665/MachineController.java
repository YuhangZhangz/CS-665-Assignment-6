/**
 * Name: Yuhang Zhang
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/01/2025
 * File Name: MachineController.java
 * Description: System controller for the beverage vending machine.
 */

package edu.bu.met.cs665;

/**
 * The MachineController class acts as the main controller for the vending machine.
 * It coordinates beverage selection, condiment configuration, and temperature.
 */
public class MachineController {

  /** The beverage selected by the user (Coffee or Tea). */
  private Beverage selectedBeverage;

  /** The condiment configuration for the current beverage. */
  private final Condiment condiment;

  /** Current serving temperature for newly selected beverages. */
  private Temperature temperature;

  /** Creates a controller with default HOT temperature and empty condiment. */
  public MachineController() {
    this.temperature = Temperature.HOT;
    this.condiment = new Condiment();
  }

  /**
   * Sets the serving temperature using the enum type.
   * Also keeps the condiment temperature in sync.
   *
   * @param temperature the desired serving temperature
   */
  public void setTemperature(Temperature temperature) {
    if (temperature == null) {
      throw new IllegalArgumentException("temperature must not be null");
    }
    this.temperature = temperature;
    this.condiment.setTemperature(temperature);
  }

  /**
   * Backwards compatible helper that accepts a boolean.
   *
   * @param isHot true for HOT, false for COLD
   */
  public void setTemperature(boolean isHot) {
    setTemperature(isHot ? Temperature.HOT : Temperature.COLD);
  }

  /** @return true if controller is configured for HOT drinks. */
  public boolean getTemperature() {
    return temperature.isHot();
  }

  /** @return current temperature as enum. */
  public Temperature getTemperatureEnum() {
    return temperature;
  }

  /**
   * Choose a coffee by name, using the current controller temperature.
   *
   * @param name coffee name as string
   */
  public void chooseCoffee(String name) {
    this.selectedBeverage = new Coffee(name, temperature);
  }

  /**
   * Choose a tea by name, using the current controller temperature.
   *
   * @param name tea name as string
   */
  public void chooseTea(String name) {
    this.selectedBeverage = new Tea(name, temperature);
  }

  /**
   * Configure condiments for the current beverage.
   *
   * @param milk milk units (0–3)
   * @param sugar sugar units (0–3)
   */
  public void addCondiment(int milk, int sugar) {
    this.condiment.setMilkUnit(milk);
    this.condiment.setSugarUnit(sugar);
  }

  /**
   * Dispenses the currently selected beverage.
   * If the drink is hot, it will be brewed before being returned.
   *
   * @return the prepared Beverage
   * @throws IllegalStateException if no beverage has been selected
   */
  public Beverage dispense() {
    if (this.selectedBeverage == null) {
      throw new IllegalStateException("No beverage selected.");
    }
    if (temperature.isHot()) {
      this.selectedBeverage.brew();
    }
    return this.selectedBeverage;
  }

  /** @return the currently selected beverage (may be null if none selected). */
  public Beverage getSelectedBeverage() {
    return selectedBeverage;
  }

  /** @return the condiment configuration. */
  public Condiment getCondiment() {
    return condiment;
  }
}
