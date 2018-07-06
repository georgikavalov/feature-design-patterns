package com.musala.edu.patterns.abstractfactory;

import java.util.LinkedList;
import java.util.List;

import com.musala.edu.patterns.abstractfactory.model.Dessert;
import com.musala.edu.patterns.abstractfactory.model.EasternDessert;
import com.musala.edu.patterns.abstractfactory.model.EasternMainCourse;
import com.musala.edu.patterns.abstractfactory.model.Main;

/**
 * {@code EasternRestaurant} is a concrete class of {@link Restaurant} of type
 * {@link RestaurantType#EASTERN}
 * 
 * @author georgi.kavalov
 *
 */
public class EasternRestaurant extends Restaurant {

	/**
	 * Creates an {@link EasternMainCourse}
	 * 
	 * @return {@link Main}
	 */
	@Override
	public Main makeMainCourse() {
		List<String> ingredients = new LinkedList<String>();
		ingredients.add("Vegetables");
		ingredients.add("Chicken");
		ingredients.add("Oil");

		return new EasternMainCourse("Checken Stir Fry", ingredients);
	}

	/**
	 * Creates an {@link EasternDessert}
	 * 
	 * @return {@link Dessert}
	 */
	@Override
	public Dessert makeDessert() {
		List<String> ingredients = new LinkedList<String>();
		ingredients.add("Fruit");
		ingredients.add("Sugar Syrup");
		ingredients.add("Light Cream");

		return new EasternDessert("Cake", ingredients);
	}

}
