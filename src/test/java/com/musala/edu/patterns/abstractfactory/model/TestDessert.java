package com.musala.edu.patterns.abstractfactory.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * The <code>TestDessert</code> consists of tests on the {@link Dessert} derived
 * model classes
 * 
 * @author georgi.kavalov
 *
 */
public class TestDessert {
	/**
	 * Tests the creation of an {@link EasternDessert} object
	 */
	@Test
	public void testEasternDessert() {
		List<String> ingredients = new LinkedList<String>();
		ingredients.add("Fruit");
		ingredients.add("Sugar Syrup");
		ingredients.add("Light Cream");

		Dessert dessert = new EasternDessert("Cake", ingredients);
		assertNotNull(dessert);
		assertTrue(dessert.isPrepared());
	}

	/**
	 * Tests the creation of a {@link WesternDessert} object
	 */
	@Test
	public void testWesternDessert() {
		List<String> ingredients = new LinkedList<String>();
		ingredients.add("Suet");
		ingredients.add("Custard");
		ingredients.add("Raisins");

		Dessert dessert = new WesternDessert("Spotted dick with custard", ingredients);
		assertNotNull(dessert);
		assertTrue(dessert.isPrepared());
	}
}
