package com.musala.edu.patterns.prototype;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.musala.edu.patterns.prototype.model.Desk;
import com.musala.edu.patterns.prototype.model.Laptop;
import com.musala.edu.patterns.prototype.model.OfficeEquipment;

/**
 * The {@code OfficeSuppliesStore} class holds a list of items for sale
 * 
 * @author georgi.kavalov
 *
 */
public class OfficeSuppliesStore {
	protected static final Logger LOGGER = LoggerFactory.getLogger(OfficeSuppliesStore.class);

	/**
	 * Singleton member
	 */
	private static OfficeSuppliesStore store = new OfficeSuppliesStore();

	/**
	 * Registry of prototypes
	 */
	private List<OfficeEquipment> itemsForSale = new LinkedList<OfficeEquipment>();

	/**
	 * Constructor
	 */
	private OfficeSuppliesStore() {
		addItem(new Laptop());
		addItem(new Desk());
	}

	/**
	 * Gets singleton instance
	 * 
	 * @return {@code OfficeSuppliesStore}
	 */
	public static synchronized OfficeSuppliesStore getInstance() {
		return OfficeSuppliesStore.store;
	}

	/**
	 * Creates a copy of an item in the registry, should it finds it.
	 * 
	 * @param requestedItemName
	 *            The name of the requested item
	 * @return A concrete object of {@link OfficeEquipment}
	 */
	public OfficeEquipment sellItem(String requestedItemName) {
		for (OfficeEquipment item : itemsForSale) {
			if (item.getName().equals(requestedItemName)) {
				OfficeEquipment newItem = item.issueEquipment();
				LOGGER.info("One {} has been sold at {}", requestedItemName, newItem.getPrice());
				return newItem;
			}
		}
		LOGGER.error("No such item: {}", requestedItemName);
		return null;
	}

	/**
	 * Adds an item to the registry
	 * 
	 * @param item
	 *            A concrete object of {@link OfficeEquipment}
	 */
	private void addItem(OfficeEquipment item) {
		itemsForSale.add(item);
	}
}