package com.musala.edu.patterns.abstractfactory.model;

import java.util.List;

import com.musala.edu.patterns.abstractfactory.RestaurantType;

/**
 * The {@code EasternDessert} class, represents a {@link Dessert} of type
 * {@link RestaurantType#EASTERN}
 * 
 * @author georgi.kavalov
 *
 */
public class EasternDessert extends Dessert {

	/**
	 * Weight of an eastern dessert {@value #WEIGHT} grams
	 */
	private static final int WEIGHT = 100;

	/**
	 * Constructor
	 * 
	 * @param name
	 *            The name of the dessert
	 * @param ingredients
	 *            List of ingredients' names
	 */
	public EasternDessert(String name, List<String> ingredients) {
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
