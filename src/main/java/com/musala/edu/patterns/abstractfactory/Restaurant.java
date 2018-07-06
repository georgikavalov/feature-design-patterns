package com.musala.edu.patterns.abstractfactory;

import java.util.Arrays;
import java.util.List;

import com.musala.edu.patterns.abstractfactory.model.Dessert;
import com.musala.edu.patterns.abstractfactory.model.Main;
import com.musala.edu.patterns.abstractfactory.model.Meal;

/**
 * 
 * @author georgi.kavalov
 *
 */
public abstract class Restaurant {
	/**
	 * creates a main course object specific to the type of restaurant
	 * 
	 * @return {@link Main}
	 */
	public abstract Main makeMainCourse();

	/**
	 * creates a dessert object specific to the type of restaurant
	 * 
	 * @return {@link Dessert}
	 */
	public abstract Dessert makeDessert();

	/**
	 * Creates a restaurant object
	 * 
	 * @param type
	 *            The origin of the restaurant
	 * @return {@link Restaurant}
	 */
	public static Restaurant getRestaurant(RestaurantType type) {
		Restaurant restaurant = null;
		switch (type) {
		case EASTERN:
			restaurant = new EasternRestaurant();
			break;
		case WESTERN:
			restaurant = new WesternRestaurant();
			break;
		}
		return restaurant;
	}

	/**
	 * Creates a menu
	 * 
	 * @return A list of {@link Meal} items
	 */
	public List<Meal> makeMenu() {
		return Arrays.asList(makeMainCourse(), makeDessert());
	}
}