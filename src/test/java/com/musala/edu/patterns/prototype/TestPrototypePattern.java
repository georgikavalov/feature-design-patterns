package com.musala.edu.patterns.prototype;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.musala.edu.patterns.prototype.model.Laptop;
import com.musala.edu.patterns.prototype.model.OfficeEquipment;

/**
 * The {@code TestPrototypePattern} consists of tests for the creation of
 * objects using the prototype pattern.
 * 
 * @author georgi.kavalov
 *
 */
public class TestPrototypePattern {

	/**
	 * Tests the creation of {@link Laptop}.
	 */
	@Test
	public void testOfficeSuppliesStore() {
		OfficeEquipment newLaptop = OfficeSuppliesStore.getInstance().sellItem("laptop");
		Laptop anotherLaptop = new Laptop();
		assertEquals(newLaptop.getName(), anotherLaptop.getName());
	}
}
