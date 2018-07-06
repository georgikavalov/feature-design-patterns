package com.musala.edu.patterns.objectpool.model;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.musala.edu.patterns.prototype.OfficeSuppliesStore;
import com.musala.edu.patterns.prototype.model.OfficeEquipment;

/**
 * The {@code Warehouse} class provides methods for (creating and) using a
 * pooled {@link OfficeEquipment} and releasing one when the client is finished
 * with it
 * 
 * @author georgi.kavalov
 *
 */
public class Warehouse {
	private static final Logger LOGGER = LoggerFactory.getLogger(Warehouse.class);

	/**
	 * Singleton instance memeber.
	 */
	private static Warehouse warehouse = new Warehouse();
	/**
	 * Total number of officeEquipment across the organisation.
	 */
	private int totalCount = 0;
	/**
	 * Maximum number of equipment allowed.
	 */
	private static final int MAX_SIZE = 10;
	/**
	 * Pooled {@link OfficeEquipment} objects
	 */
	private List<OfficeEquipment> available = new LinkedList<OfficeEquipment>();

	/**
	 * Constructor
	 */
	private Warehouse() {
	}

	public static synchronized Warehouse getInstance() {
		return Warehouse.warehouse;
	}

	/**
	 * Gets for a pooled object.
	 * 
	 * @param itemName
	 *            The name of {@link OfficeEquipment} to acquire
	 * @return
	 */
	public OfficeEquipment getOfficeEquipment(String itemName) {
		if (!available.isEmpty()) {
			for (OfficeEquipment item : available) {
				if (item.getName().equals(itemName)) {
					return getEquipmentForReuse(item);
				}
			}
		}
		return buyOfficeEquipment(itemName);
	}

	/**
	 * Moves equipment object from available items to used items and logging it.
	 * 
	 * @param item
	 *            {@link OfficeEquipment} object that will be moved
	 * @return {@link OfficeEquipment}
	 */
	private OfficeEquipment getEquipmentForReuse(OfficeEquipment item) {
		OfficeEquipment equipment = popEquipmentItem(item);
		LOGGER.info("A {} has been taken for reuse", equipment.getName());
		return equipment;
	}

	/**
	 * Buys new equipment for use and logging it.
	 * 
	 * @param name
	 *            The name of item to be bought
	 * @return {@link OfficeEquipment}
	 */
	private OfficeEquipment buyOfficeEquipment(String name) {
		OfficeEquipment newEquipment = null;
		if (totalCount <= MAX_SIZE) {
			newEquipment = OfficeSuppliesStore.getInstance().sellItem(name);
			totalCount++;
			LOGGER.info("A new {} has been bought", newEquipment.getName());
		} else {
			LOGGER.info("Could not buy any more equipment because due to risk of overflow.");
		}

		return newEquipment;
	}

	/**
	 * Moves office equipment from used items to be released from use.
	 * 
	 * @param equipment
	 *            The {@link OfficeEquipment} object to available items.
	 */
	public void releaseEquipment(OfficeEquipment equipment) {
		pushEquipmentItem(equipment);
	}

	/**
	 * Moves a list of office equipment items to be released from use.
	 * 
	 * @param usedEquipment
	 *            The list {@link OfficeEquipment} object to available items.
	 */
	public synchronized void releaseEquipment(List<OfficeEquipment> usedEquipment) {
		for (OfficeEquipment item : usedEquipment) {
			releaseEquipment(item);
		}
	}

	/**
	 * Removes an {@link OfficeEquipment} object from a list.
	 * 
	 * @param item
	 *            The item of the KVP to be removed
	 * 
	 * @return The removed list item
	 */
	private OfficeEquipment popEquipmentItem(OfficeEquipment item) {
		if (!available.remove(item)) {
			LOGGER.error("No such item is currently in list {}", item.getName());
		}
		return item;
	}

	/**
	 * Pushes an {@link OfficeEquipment} object in a list.
	 * 
	 * @param item
	 *            The item that will be added
	 */
	private void pushEquipmentItem(OfficeEquipment item) {
		available.add(item);
	}

	public int getAvailableEquipmentCount() {
		return available.size();
	}

	/**
	 * @return the totalCount
	 */
	public int getTotalEquipmentItemsCount() {
		return totalCount;
	}
}