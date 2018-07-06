package com.musala.edu.patterns.abstractfactory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.musala.edu.patterns.abstractfactory.model.Dessert;
import com.musala.edu.patterns.abstractfactory.model.EasternDessert;
import com.musala.edu.patterns.abstractfactory.model.EasternMainCourse;
import com.musala.edu.patterns.abstractfactory.model.Meal;
import com.musala.edu.patterns.abstractfactory.model.WesternDessert;
import com.musala.edu.patterns.abstractfactory.model.WesternMainCourse;

/**
 * The <code>FactoryTest</code> class consists of tests on the factory classes
 * 
 * @author georgi.kavalov
 *
 */
public class TestConcreteResturants {

	/**
	 * Tests on the creation of a {@link WesternRestaurant} object
	 */
	@Test
	public void testWesternRestaurant() {
		Restaurant restaurant = Restaurant.getRestaurant(RestaurantType.WESTERN);

		Meal main = restaurant.makeMainCourse();
		Dessert dessert = restaurant.makeDessert();

		assertNotNull(main);
		assertNotNull(dessert);
		assertTrue(main instanceof WesternMainCourse);
		assertTrue(dessert instanceof WesternDessert);
	}

	/**
	 * Tests on the creation of a {@link EasternRestaurant} object
	 */
	@Test
	public void testEasternRestaurant() {
		Restaurant restaurant = Restaurant.getRestaurant(RestaurantType.EASTERN);

		Meal main = restaurant.makeMainCourse();
		Dessert dessert = restaurant.makeDessert();

		assertNotNull(main);
		assertNotNull(dessert);
		assertTrue(main instanceof EasternMainCourse);
		assertTrue(dessert instanceof EasternDessert);
	}

	/**
	 * Tests on the creation of a {@link WesternRestaurant} menu items
	 */
	@Test
	public void testMenu() {
		List<Meal> menu = Restaurant.getRestaurant(RestaurantType.WESTERN).makeMenu();
		assertTrue(menu.size() == 2);
	}
}