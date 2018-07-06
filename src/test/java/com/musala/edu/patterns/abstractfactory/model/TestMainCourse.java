package com.musala.edu.patterns.abstractfactory.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * The <code>TestMainCourse</code> consists of tests on the {@link Main} derived
 * model classes
 * 
 * @author georgi.kavalov
 *
 */
public class TestMainCourse {

	/**
	 * Tests the creation of a {@link WesternMainCourse} object
	 */
	@Test
	public void testWesternMainCourse() {
		List<String> ingredients = new LinkedList<String>();
		ingredients.add("Steak");
		ingredients.add("Gravy");
		ingredients.add("Onion");
		ingredients.add("Pastry");

		Meal main = new WesternMainCourse("Steak Pie", ingredients);
		assertNotNull(main);
		assertTrue(main.isPrepared());
	}

	/**
	 * Tests the creation of an {@link EasternMainCourse} object
	 */
	@Test
	public void testEasternMainCourse() {
		List<String> ingredients = new LinkedList<String>();
		ingredients.add("Vegetables");
		ingredients.add("Chicken");
		ingredients.add("Oil");

		Meal main = new EasternMainCourse("Checken Stir Fry", ingredients);
		assertNotNull(main);
		assertTrue(main.isPrepared());
	}
}
