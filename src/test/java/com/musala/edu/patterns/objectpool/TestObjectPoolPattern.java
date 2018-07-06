package com.musala.edu.patterns.objectpool;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.musala.edu.patterns.objectpool.model.Employee;
import com.musala.edu.patterns.objectpool.model.Gender;
import com.musala.edu.patterns.objectpool.model.OfficeManager;
import com.musala.edu.patterns.objectpool.model.Warehouse;
import com.musala.edu.patterns.prototype.model.Laptop;
import com.musala.edu.patterns.prototype.model.OfficeEquipment;

/**
 * The {@code TestObjectPoolPattern} consists of tests for the use of object
 * pool pattern
 * 
 * @author georgi.kavalov
 *
 */
public class TestObjectPoolPattern {

	private OfficeManager manager = new OfficeManager("manageress", Gender.FEMALE, "sofia");

	/**
	 * Tests the creation of a pooled {@link Laptop} object.
	 */
	@Test
	public void testWarehouse() {
		OfficeEquipment equipment = Warehouse.getInstance().getOfficeEquipment("laptop");
		assertNotNull(equipment);

		OfficeEquipment anotherEquipment = Warehouse.getInstance().getOfficeEquipment("desk");
		assertArrayEquals(new int[] { 0 }, new int[] { Warehouse.getInstance().getAvailableEquipmentCount() });
		Warehouse.getInstance().releaseEquipment(equipment);
		assertArrayEquals(new int[] { 1 }, new int[] { Warehouse.getInstance().getAvailableEquipmentCount() });
		Warehouse.getInstance().releaseEquipment(anotherEquipment);
		assertArrayEquals(new int[] { 2 }, new int[] { Warehouse.getInstance().getAvailableEquipmentCount() });
		Warehouse.getInstance().getOfficeEquipment("laptop");
		assertArrayEquals(new int[] { 1 }, new int[] { Warehouse.getInstance().getAvailableEquipmentCount() });
	}

	/**
	 * Tests the office manager.
	 */
	@Test
	public void testOfficeManager() {
		Employee leadDeveloper = manager.hireEmployee("developeress", Gender.FEMALE, "sofia");
		Employee developer = manager.hireEmployee("developer", Gender.MALE, "sofia");
		manager.sackEmployee(leadDeveloper);
		manager.sackEmployee(developer);
		assertArrayEquals(new int[] { 4 }, new int[] { Warehouse.getInstance().getAvailableEquipmentCount() });
	}

	/**
	 * Tests the maximum amount of office equipment items.
	 */
	@Test
	public void testMaxEquipmentCount() {
		for (int i = 0; i <= 5; i++) {
			manager.hireEmployee("developeress " + i, Gender.values()[i % 2], "sofia");
		}
		assertArrayEquals(new int[] { 10 }, new int[] { Warehouse.getInstance().getTotalEquipmentItemsCount() });
	}
}
