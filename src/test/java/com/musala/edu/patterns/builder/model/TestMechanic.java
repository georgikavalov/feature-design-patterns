package com.musala.edu.patterns.builder.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.musala.edu.patterns.builder.FerrariEngineBuilder;
import com.musala.edu.patterns.builder.VWDieselEngineBuilder;

/**
 * The {@code TestMechanic} code consists of tests for the {@link Mechanic}
 * class
 * 
 * @author georgi.kavalov
 *
 */
public class TestMechanic {

	/**
	 * Tests the creation of a mechanic class and its methods.
	 */
	@Test
	public void testMechanicSkills() {
		Mechanic mechanic = new Mechanic(new FerrariEngineBuilder());
		Engine pureBrillinace = mechanic.buildEngine();

		assertNotNull(pureBrillinace);

		assertEquals("F2018", pureBrillinace.getSerialNumber());
		assertEquals(FuelType.PETROL, pureBrillinace.getFuelType());
		assertFalse(pureBrillinace.hasTurbo());
		assertEquals(EngineConfiguration.V12, pureBrillinace.getConfiguration());

		mechanic.setEngineBuilder(new VWDieselEngineBuilder());
		Engine totalyTotalyEfficientDieselEngine = mechanic.buildEngine();
		final String vwSN = "VW1234D";
		final FuelType vwFuel = FuelType.DIESEL;
		final EngineConfiguration vwConfig = EngineConfiguration.STRAIGHT_4;

		assertTrue(vwSN.equals(totalyTotalyEfficientDieselEngine.getSerialNumber()));
		assertTrue(totalyTotalyEfficientDieselEngine.getFuelType() == vwFuel);
		assertTrue(totalyTotalyEfficientDieselEngine.hasTurbo());
		assertTrue(totalyTotalyEfficientDieselEngine.getConfiguration() == vwConfig);
	}
}
