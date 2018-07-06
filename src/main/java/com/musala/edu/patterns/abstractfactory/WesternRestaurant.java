package com.musala.edu.patterns.abstractfactory;

import java.util.LinkedList;
import java.util.List;

import com.musala.edu.patterns.abstractfactory.model.Dessert;
import com.musala.edu.patterns.abstractfactory.model.Main;
import com.musala.edu.patterns.abstractfactory.model.WesternDessert;
import com.musala.edu.patterns.abstractfactory.model.WesternMainCourse;

/**
 * {@code WesternRestaurant} is a concrete class of {@link Restaurant} of type
 * {@link RestaurantType#WESTERN}
 * 
 * @author georgi.kavalov
 *
 */
public class WesternRestaurant extends Restaurant {

	/**
	 * Creates an {@link WesternMainCourse}
	 * 
	 * @return {@link Main}
	 */
	@Override
	public Main makeMainCourse() {
		List<String> ingredients = new LinkedList<String>();
		ingredients.add("Steak");
		ingredients.add("Gravy");
		ingredients.add("Onion");
		ingredients.add("Pastry");

		return new WesternMainCourse("Steak Pie", ingredients);
	}

	/**
	 * Creates an {@link WesternDessert}
	 * 
	 * @return {@link Dessert}
	 */
	@Override
	public Dessert makeDessert() {
		List<String> ingredients = new LinkedList<String>();
		ingredients.add("Suet");
		ingredients.add("Custard");
		ingredients.add("Raisins");

		return new WesternDessert("Spotted dick with custard", ingredients);
	}

}
