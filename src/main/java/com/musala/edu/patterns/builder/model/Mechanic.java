package com.musala.edu.patterns.builder.model;

import com.musala.edu.patterns.builder.EngineBuilder;

/**
 * {@code Mechanic} represents an object that takes an abstract builder object
 * and executes the its abstract methods
 * 
 * @author georgi.kavalov
 *
 */
public class Mechanic {
	/**
	 * Abstract object
	 */
	private EngineBuilder buildingMachine;

	/**
	 * Constructor
	 * 
	 * @param engineBuilder
	 *            {@link EngineBuilder}
	 */
	public Mechanic(EngineBuilder engineBuilder) {
		this.buildingMachine = engineBuilder;
	}

	/**
	 * Injects the {@link EngineBuilder}
	 * 
	 * @param builder
	 *            The abstract {@link EngineBuilder} that consequently will deliver
	 *            the complex object it builds
	 */
	public void setEngineBuilder(EngineBuilder builder) {
		this.buildingMachine = builder;
	}

	/**
	 * @return {@link Engine} object
	 */
	public Engine getEngine() {
		return buildingMachine.getEngine();
	}

	/**
	 * Executes the abstract methods of the abstract object
	 * 
	 * @return
	 */
	public Engine buildEngine() {
		buildingMachine.startNewBlueprint();
		buildingMachine.addSerialNumber();
		buildingMachine.addTurbo();
		buildingMachine.makeForFuel();
		buildingMachine.setConfiguration();

		return buildingMachine.getEngine();
	}
}
