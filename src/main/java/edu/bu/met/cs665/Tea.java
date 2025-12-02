/**
 * Name: Yuhang Zhang
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/01/2025
 * File Name: Tea.java
 * Description: Tea beverage type. Includes different tea variants.
 */

package edu.bu.met.cs665;

/**
 * Tea is a concrete Beverage.
 * The exact tea variant is stored in teaName.
 */
public class Tea extends Beverage {

  /** Concrete tea name, e.g. "Black Tea", "Green Tea". */
  private final String teaName;

  /**
   * Constructs a Tea using the Temperature enum.
   *
   * @param teaName the concrete tea name
   * @param temperature serving temperature (HOT or COLD)
   */
  public Tea(String teaName, Temperature temperature) {
    super(teaName, temperature);
    this.teaName = teaName;
  }

  /**
   * Backwards compatible constructor that accepts a boolean.
   *
   * @param teaName the concrete tea name
   * @param isHot true for hot, false for cold
   */
  public Tea(String teaName, boolean isHot) {
    super(teaName, isHot);
    this.teaName = teaName;
  }

  /**
   * Brewing rule for tea.
   * Only hot tea can be brewed; cold tea throws an exception.
   */
  @Override
  public void brew() {
    if (!isHot()) {
      throw new UnsupportedOperationException("Cold tea cannot be brewed.");
    }
    // Actual brewing logic would go here in a real system.
  }

  /** @return the concrete tea name. */
  public String getTeaName() {
    return teaName;
  }
}
