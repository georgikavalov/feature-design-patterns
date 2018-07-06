package com.musala.edu.patterns.abstractfactory.model;

import java.util.List;

/**
 * The {@code Main} class declares an abstract method that all subclasses will
 * need to implement
 * 
 * @author georgi.kavalov
 *
 */
public abstract class Main extends Meal {

	/**
	 * The way a main course is prepared based on its origin
	 * 
	 * @see {@link Preparation}
	 */
	private Preparation method;

	/**
	 * Constructor
	 * 
	 * @param name
	 *            The name of the main course
	 * @param ingredients
	 *            List of ingredients' names
	 * @param method
	 *            Way of preparation
	 */
	public Main(String name, List<String> ingredients, Preparation method) {
		super(name, ingredients);
		this.method = method;
	}

	/**
	 * Abstract method for the concrete class to implement. Prepares ingredients
	 * together by logging a message
	 */
	public abstract void prepareMainCourse();

	/**
	 * Getter for {@link #method}
	 * 
	 * @return {@linkplain Preparation}
	 */
	public Preparation getMethod() {
		return method;
	}
}
