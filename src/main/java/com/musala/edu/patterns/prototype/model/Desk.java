/**
 * 
 */
package com.musala.edu.patterns.prototype.model;

/**
 * {@code Desk} class encapsulates properties of a desk.
 * 
 * @author georgi.kavalov
 *
 */
public class Desk extends OfficeEquipment {

	private static final String NAME = "desk";
	private static final double PRICE = 200;

	public Desk() {
		super(NAME, PRICE);
	}

	// huh
	@Override
	public OfficeEquipment issueEquipment() {
		return new Desk();
	}
}