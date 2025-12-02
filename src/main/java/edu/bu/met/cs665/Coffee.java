/**
 * Name: Yuhang Zhang
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/01/2025
 * File Name: Coffee.java
 * Description: Coffee beverage type. Includes different coffee variants.
 */

package edu.bu.met.cs665;

/**
 * Coffee is a concrete Beverage.
 * The exact coffee variant is stored in coffeeName.
 */
public class Coffee extends Beverage {

  /** Concrete coffee name, e.g. "Americano", "Espresso". */
  private final String coffeeName;

  /**
   * Constructs a Coffee using the Temperature enum.
   *
   * @param coffeeName the concrete coffee name
   * @param temperature serving temperature (HOT or COLD)
   */
  public Coffee(String coffeeName, Temperature temperature) {
    super(coffeeName, temperature);
    this.coffeeName = coffeeName;
  }

  /**
   * Backwards compatible constructor that accepts a boolean.
   *
   * @param coffeeName the concrete coffee name
   * @param isHot true for hot, false for cold
   */
  public Coffee(String coffeeName, boolean isHot) {
    super(coffeeName, isHot);
    this.coffeeName = coffeeName;
  }

  /**
   * Brewing rule for coffee.
   * Only hot coffee can be brewed; cold coffee throws an exception.
   */
  @Override
  public void brew() {
    if (!isHot()) {
      throw new UnsupportedOperationException("Cold coffee cannot be brewed.");
    }
    // Actual brewing logic would go here in a real system.
  }

  /** @return the concrete coffee name. */
  public String getCoffeeName() {
    return coffeeName;
  }
}
