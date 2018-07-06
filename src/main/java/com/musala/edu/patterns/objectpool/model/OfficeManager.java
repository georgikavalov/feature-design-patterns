package com.musala.edu.patterns.objectpool.model;

import java.util.List;

import com.musala.edu.patterns.prototype.model.OfficeEquipment;

public class OfficeManager extends Employee {

	public OfficeManager(String name, Gender sex, String location) {
		super(name, sex, location);
	}

	public Employee hireEmployee(String name, Gender sex, String location) {
		Employee newEmployee = new Employee(name, sex, location);
		newEmployee.giveEquipmentToUse(Warehouse.getInstance().getOfficeEquipment(("laptop")));
		newEmployee.giveEquipmentToUse(Warehouse.getInstance().getOfficeEquipment(("desk")));
		return newEmployee;
	}

	public void sackEmployee(Employee employee) {
		List<OfficeEquipment> usedEquipment = employee.getEquipmentInUse();
		Warehouse.getInstance().releaseEquipment(usedEquipment);
	}
}
