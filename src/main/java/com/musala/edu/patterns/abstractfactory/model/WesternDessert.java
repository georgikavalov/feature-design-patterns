package com.musala.edu.patterns.abstractfactory.model;

import java.util.List;

import com.musala.edu.patterns.abstractfactory.RestaurantType;

/**
 * The {@code WesternDessert} class, represents a {@link Dessert} of type
 * {@link RestaurantType#WESTERN}
 * 
 * @author georgi.kavalov
 *
 */
public class WesternDessert extends Dessert {

	/**
	 * Weight of a western dessert {@value #WEIGHT} grams
	 */
	private static final int WEIGHT = 1000;

	/**
	 * Constructor
	 * 
	 * @param name
	 *            The name of the dessert
	 * @param ingredients
	 *            List of ingredients' names
	 */
	public WesternDessert(String name, List<String> ingredients) {
		super(name, ingredients, WEIGHT);
		prepareDessert();
	}

	/**
	 * Prepares ingredients together by logging a message
	 */
	@Override
	public void prepareDessert() {
		LOGGER.info("Mix ingredients and serve {} grams of {}", getSize(), getName());
		isPrepared = true;
	}
}
