package com.musala.edu.patterns.builder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.musala.edu.patterns.builder.model.Engine;

/**
 * Abstract {@code EngineBuilder} class. Encapsulates common engine building
 * methods
 * 
 * @author georgi.kavalov
 *
 */
public abstract class EngineBuilder {
	/**
	 * Used for logging
	 */
	protected static final Logger LOGGER = LoggerFactory.getLogger(EngineBuilder.class);
	/**
	 * class member that holds the {@link Engine} object
	 */
	protected Engine engine;

	/**
	 * adds serial number to the engine by logging
	 * 
	 */
	public abstract void addSerialNumber();

	/**
	 * Sets the engine configuration and logging it
	 * 
	 */
	public abstract void setConfiguration();

	/**
	 * Adds turbo and logging it
	 */
	public abstract void addTurbo();

	/**
	 * Makes the engine for a specific fuel type
	 */
	public abstract void makeForFuel();

	/**
	 * Creates a new instance of an {@link Engine} object
	 */
	public void startNewBlueprint() {
		engine = new Engine();
	}

	/**
	 * Getter for {@link #engine}
	 * 
	 * @return {@link Engine}
	 */
	public Engine getEngine() {
		return engine;
	}
}
