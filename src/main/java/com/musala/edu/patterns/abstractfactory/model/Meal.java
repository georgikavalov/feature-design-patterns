package com.musala.edu.patterns.abstractfactory.model;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class encapsulating common properties of any meal
 * 
 * @author georgi.kavalov
 *
 */
public abstract class Meal {
	/**
	 * Logger object
	 */
	protected static final Logger LOGGER = LoggerFactory.getLogger(Meal.class);
	/**
	 * The name of a meal
	 */
	protected String name;
	/**
	 * The list of ingredients' names
	 */
	protected List<String> ingredients;
	/**
	 * Boolean flag indicating completeness of a meal
	 */
	protected boolean isPrepared;

	/**
	 * Constructor
	 * 
	 * @param name
	 *            The name of the meal
	 * @param ingredients
	 *            List of ingredients' names
	 */
	public Meal(String name, List<String> ingredients) {
		this.name = name;
		this.ingredients = ingredients;
		this.isPrepared = false;
	}

	/**
	 * Getter for {@link #name}
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for {@link #name}
	 * 
	 * @return
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for {@link #ingredients}
	 * 
	 * @return
	 */
	public List<String> getingredients() {
		return new LinkedList<String>(ingredients);
	}

	/**
	 * Getter for {@link #isPrepared}
	 * 
	 * @return
	 */
	public boolean isPrepared() {
		return isPrepared;
	}
}