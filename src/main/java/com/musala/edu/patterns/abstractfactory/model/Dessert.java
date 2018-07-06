package com.musala.edu.patterns.abstractfactory.model;

import java.util.List;

/**
 * The {@code Dessert} class declares an abstract method that all subclasses
 * will need to implement
 * 
 * @author georgi.kavalov
 *
 */
public abstract class Dessert extends Meal {

	/**
	 * The weight of a dessert based on its origin
	 */
	private int weight;

	public Dessert(String name, List<String> ingredients, int weight) {
		super(name, ingredients);
		this.weight = weight;
	}

	/**
	 * Abstract method for the concrete class to implement.Prepares a dessert by
	 * logging info
	 */
	public abstract void prepareDessert();

	/**
	 * Getter for {@link #weight}
	 * 
	 * @return int
	 */
	public int getSize() {
		return weight;
	}
}
