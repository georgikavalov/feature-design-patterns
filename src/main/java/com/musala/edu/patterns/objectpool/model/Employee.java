package com.musala.edu.patterns.objectpool.model;

import java.util.LinkedList;
import java.util.List;

import com.musala.edu.patterns.prototype.model.OfficeEquipment;

/**
 * Properties of an {@code Employee}
 * 
 * @author georgi.kavalov
 *
 */
public class Employee {
	private String name;
	private Gender sex;
	private String location;
	private List<OfficeEquipment> equipmentInUse;

	/**
	 * Constructor
	 * 
	 * @param name
	 *            of {@code Employee}
	 * @param sex
	 *            of {@code Employee}
	 * @param location
	 *            of {@code Employee}
	 */
	public Employee(String name, Gender sex, String location) {
		super();
		this.name = name;
		this.sex = sex;
		this.location = location;
		this.equipmentInUse = new LinkedList<OfficeEquipment>();
	}

	/**
	 * Adds the reference object that employee uses
	 * 
	 * @param equipmentInUse
	 *            the equipmentInUse to set
	 */
	public void giveEquipmentToUse(OfficeEquipment equipmentInUse) {
		this.equipmentInUse.add(equipmentInUse);
	}

	public String getLocation() {
		return location;
	}

	public Employee setLocation(String location) {
		this.location = location;
		return this;
	}

	public String getName() {
		return name;
	}

	public Gender getSex() {
		return sex;
	}

	public List<OfficeEquipment> getEquipmentInUse() {
		List<OfficeEquipment> equipment = new LinkedList<OfficeEquipment>(equipmentInUse);
		equipmentInUse.clear();
		return equipment;
	}
}