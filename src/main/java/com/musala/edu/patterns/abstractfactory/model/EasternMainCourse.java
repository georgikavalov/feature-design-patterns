package com.musala.edu.patterns.abstractfactory.model;

import java.util.List;

import com.musala.edu.patterns.abstractfactory.RestaurantType;

/**
 * The {@code EasternMainCourse} class, represents a {@link Main} of type
 * {@link RestaurantType#EASTERN}
 * 
 * @author georgi.kavalov
 *
 */
public class EasternMainCourse extends Main {

	/**
	 * Constructor
	 * 
	 * @param name
	 *            The name of the meal
	 * @param ingredients
	 *            List of ingredients' names
	 */
	public EasternMainCourse(String name, List<String> ingredients) {
		super(name, ingredients, Preparation.FRY);
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
