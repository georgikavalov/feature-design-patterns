package com.musala.edu.patterns.builder;

import com.musala.edu.patterns.builder.model.Engine;
import com.musala.edu.patterns.builder.model.EngineConfiguration;
import com.musala.edu.patterns.builder.model.FuelType;

/**
 * {@code FerrariEngineBuilder} sets a {@link Engine#serialNumber},
 * {@link Engine#configuration}, {@link Engine#hasTurbo},
 * {@link Engine#fuelType} specific for a Ferrari engine
 * 
 * @author georgi.kavalov
 *
 */
public class FerrariEngineBuilder extends EngineBuilder {

	private static final FuelType PETROL = FuelType.PETROL;
	private static final boolean NO_TURBO = false;
	private static final EngineConfiguration V12 = EngineConfiguration.V12;
	private static final String F2018 = "F2018";

	/**
	 * Sets the serial number specific for the engine type
	 */
	@Override
	public void addSerialNumber() {
		engine.setSerialNumber(F2018);
		LOGGER.info("Ferrari engine has serial number: {}", F2018);
	}

	/**
	 * Sets the configuration specific for the engine type
	 */
	@Override
	public void setConfiguration() {
		engine.setConfiguration(V12);
		LOGGER.info("Ferrari engine has {} configuration", V12);
	}

	/**
	 * Adds a turbo specific for the engine type
	 */
	@Override
	public void addTurbo() {
		engine.addTurbo(NO_TURBO);
		LOGGER.info("Ferrari engine does NOT have a turbo unit");
	}

	/**
	 * Sets the fuel type
	 */
	@Override
	public void makeForFuel() {
		engine.setFuelType(PETROL);
		LOGGER.info("Ferrari engine uses {}", PETROL);
	}
}
