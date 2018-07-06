package com.musala.edu.patterns.abstractfactory.model;

import java.util.List;

import com.musala.edu.patterns.abstractfactory.RestaurantType;

/**
 * The {@code WesternMainCourse} class, represents a {@link Main} of type
 * {@link RestaurantType#WESTERN}
 * 
 * @author georgi.kavalov
 *
 */
public class WesternMainCourse extends Main {
	/**
	 * Constructor
	 * 
	 * @param name
	 *            The name of the meal
	 * @param ingredients
	 *            List of ingredients' names
	 */
	public WesternMainCourse(String name, List<String> ingredients) {
		super(name, ingredients, Preparation.BAKE);
		prepareMainCourse();
	}

	/**
	 * Prepares ingredients together by logging a message
	 */
	@Override
	public void prepareMainCourse() {
		LOGGER.info("{} ingiridients together to produce {}", getMethod(), getName());
		isPrepared = true;
	}
}
