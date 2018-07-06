package com.musala.edu.patterns.builder;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.musala.edu.patterns.builder.model.Engine;
import com.musala.edu.patterns.builder.model.EngineConfiguration;
import com.musala.edu.patterns.builder.model.FuelType;

/**
 * The {@code TestEngineBuilder} code consists of tests for the
 * {@link EngineBuilder} derived classes
 * 
 * @author georgi.kavalov
 *
 */
public class TestEngineBuilder {

	/**
	 * tests the building of an {@link Engine} from a (@link VWEngineBuilder}
	 */
	@Test
	public void testVWDieselEngineBuilder() {
		EngineBuilder engineBuilder = new VWDieselEngineBuilder();
		assertNull(engineBuilder.getEngine());
		engineBuilder.startNewBlueprint();
		engineBuilder.addSerialNumber();
		engineBuilder.addTurbo();
		engineBuilder.makeForFuel();
		engineBuilder.setConfiguration();

		Engine totalyTotalyEfficientDieselEngine = engineBuilder.getEngine();
		assertNotNull(totalyTotalyEfficientDieselEngine);

		engineBuilder.startNewBlueprint();
		assertFalse(totalyTotalyEfficientDieselEngine.equals(engineBuilder.getEngine()));
	}

	/**
	 * tests the building of an {@link Engine} from a (@link FerrariEngineBuilder}
	 */
	@Test
	public void testFerrariEngineBuilder() {
		EngineBuilder engineBuilder = new FerrariEngineBuilder();
		engineBuilder.startNewBlueprint();
		engineBuilder.addSerialNumber();
		engineBuilder.addTurbo();
		engineBuilder.makeForFuel();
		engineBuilder.setConfiguration();

		Engine pureBrillinace = engineBuilder.getEngine();
		assertNotNull(pureBrillinace);

		final String sn = "F2018";
		final FuelType fuel = FuelType.PETROL;
		final EngineConfiguration config = EngineConfiguration.V12;

		assertTrue(sn.equals(pureBrillinace.getSerialNumber()));
		assertTrue(pureBrillinace.getFuelType() == fuel);
		assertFalse(pureBrillinace.hasTurbo());
		assertTrue(pureBrillinace.getConfiguration() == config);
	}
}