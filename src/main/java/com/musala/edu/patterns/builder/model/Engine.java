package com.musala.edu.patterns.builder.model;

import java.util.Objects;

/**
 * Encapsulating {@code Engine} properties
 * 
 * @author georgi.kavalov
 *
 */
public class Engine {
	private String serialNumber;
	private EngineConfiguration configuration;
	private boolean hasTurbo;
	private FuelType fuelType;

	/**
	 * Overrides the equals method
	 */
	@Override
	public boolean equals(Object eng) {
		if (eng == null) {
			return false;
		}
		if (!(eng instanceof Engine)) {
			return false;
		}

		Engine castEngine = (Engine) eng;

		return this.serialNumber.equals(castEngine.getSerialNumber())
				&& this.configuration == castEngine.getConfiguration() && this.hasTurbo == castEngine.hasTurbo()
				&& this.fuelType == castEngine.getFuelType();
	}

	/**
	 * Overrides the hashCode method
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.configuration, this.hasTurbo, this.fuelType, this.serialNumber);
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public Engine setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
		return this;
	}

	public EngineConfiguration getConfiguration() {
		return configuration;
	}

	public Engine setConfiguration(EngineConfiguration configuration) {
		this.configuration = configuration;
		return this;
	}

	public boolean hasTurbo() {
		return hasTurbo;
	}

	public Engine addTurbo(boolean hasTurbo) {
		this.hasTurbo = hasTurbo;
		return this;
	}

	public FuelType getFuelType() {
		return fuelType;
	}

	public Engine setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
		return this;
	}
}
