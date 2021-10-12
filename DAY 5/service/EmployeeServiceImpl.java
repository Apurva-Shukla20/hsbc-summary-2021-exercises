package com.hsbc.service;

import com.hsbc.beans.Employee;
import com.hsbc.dao.EmployeeDao;
import com.hsbc.exception.EmployeeAlreadyExistsException;
import com.hsbc.exception.EmployeeNotFoundException;
import com.hsbc.factory.ObjectFactory;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao dao = null;

	public EmployeeServiceImpl() {
		ObjectFactory factory = new ObjectFactory();
		dao = factory.getDaoInstance();
	}

 	public void store(Employee employee) throws EmployeeAlreadyExistsException {
		Employee[] emp = dao.findAllEmployees();
		for (Employee e : emp) {
			if (e.getId() == employee.getId()) {
				throw new EmployeeAlreadyExistsException("The Employee with " + e.getId() + " already exists");
			}
		}
		dao.save(employee);
	}

 	public Employee findEmployee(int id) throws EmployeeNotFoundException {
		Employee emp = dao.fetchEmployeeById(id);
		if (emp == null) {
			throw new EmployeeNotFoundException("Sorry employee with an id " + id + " not found");
		}
		return emp;
	}

	public Employee[] findAllEmployees() {
		return dao.findAllEmployees();
	}

	public void updateSalary(int id, double salary) throws EmployeeNotFoundException {
		Employee employee = findEmployee(id);
		employee.setSalary(salary);
		dao.updateEmployee(id, employee);
	}

	public void updateName(int id, String name) throws EmployeeNotFoundException {
		Employee employee = findEmployee(id);
		employee.setName(name);
		dao.updateEmployee(id, employee);
	}

}