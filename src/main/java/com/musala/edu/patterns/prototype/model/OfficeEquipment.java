package com.musala.edu.patterns.prototype.model;

/**
 * {@code OfficeEquipment} contains properties of the office item
 * 
 * @author georgi.kavalov
 *
 */
public abstract class OfficeEquipment {
	private static final double RECYCLING_FACTOR = 0.1;
	private String name;
	private double price;

	/**
	 * @param name
	 *            Name of office equipment
	 * @param price
	 *            Price at time of purchase
	 */
	public OfficeEquipment(String name, double price) {
		this.name = name;
		this.price = price;
	}

	/**
	 * Creates a copy of the concrete object
	 * 
	 * @return A concrete object of {@link OfficeEquipment}
	 */
	public abstract OfficeEquipment issueEquipment();

	/**
	 * Calculates a fraction of the first hand price
	 * 
	 * @return reduced price
	 */
	public double getRecycledPrice() {
		return price * RECYCLING_FACTOR;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
}