package com.musala.edu.patterns.prototype.model;

/**
 * {@code Laptop} class encapsulates properties of a desk.
 * 
 * @author georgi.kavalov
 *
 */
public class Laptop extends OfficeEquipment {

	private static final String NAME = "laptop";
	private static final double PRICE = 1000;

	public Laptop() {
		super(NAME, PRICE);
	}

	@Override
	public OfficeEquipment issueEquipment() {
		return new Laptop();
	}
}