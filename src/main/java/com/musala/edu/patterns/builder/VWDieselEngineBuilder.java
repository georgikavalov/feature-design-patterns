package com.musala.edu.patterns.builder;

import com.musala.edu.patterns.builder.model.Engine;
import com.musala.edu.patterns.builder.model.EngineConfiguration;
import com.musala.edu.patterns.builder.model.FuelType;

/**
 * {@code VWDieselEngineBuilder} sets a {@link Engine#serialNumber},
 * {@link Engine#configuration}, {@link Engine#hasTurbo},
 * {@link Engine#fuelType} specific for a VW diesel engine
 * 
 * @author georgi.kavalov
 *
 */
public class VWDieselEngineBuilder extends EngineBuilder {

	private static final FuelType DIESEL = FuelType.DIESEL;
	private static final boolean HAS_TURBO = true;
	private static final EngineConfiguration STRAIGHT4 = EngineConfiguration.STRAIGHT_4;
	private static final String VW1234D = "VW1234D";

	/**
	 * Sets the serial number specific for the engine type
	 */
	@Override
	public void addSerialNumber() {
		engine.setSerialNumber(VW1234D);
		LOGGER.info("VW diesel engine has serial number: {}", VW1234D);
	}

	/**
	 * Sets the configuration specific for the engine type
	 */
	@Override
	public void setConfiguration() {
		engine.setConfiguration(STRAIGHT4);
		LOGGER.info("VW diesel engine has {} configuration", STRAIGHT4);
	}

	/**
	 * Adds a turbo specific for the engine type
	 */
	@Override
	public void addTurbo() {
		engine.addTurbo(HAS_TURBO);
		LOGGER.info("VW diesel engine has a turbo unit");
	}

	/**
	 * Sets the fuel type
	 */
	@Override
	public void makeForFuel() {
		engine.setFuelType(DIESEL);
		LOGGER.info("VW diesel engine uses {}", DIESEL);
	}
}
