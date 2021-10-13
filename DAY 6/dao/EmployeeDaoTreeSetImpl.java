package com.hsbc.dao;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.hsbc.beans.Employee;
import com.hsbc.exception.EmployeeAlreadyExistException;

public class EmployeeDaoTreeSetImpl implements EmployeeDao {

	private static Set<Employee> employees = new TreeSet<Employee>();

	@Override
	public void save(Employee employee) throws EmployeeAlreadyExistException {
		employees.add(employee);

		for (int i = 0; i < employees.size(); i++) {
			if (employee.getId() == employees.hashCode()) {
				throw new EmployeeAlreadyExistException("Employee Already exist");
			}
		}
	}

	@Override
	public Employee fetchEmployeeById(int id) {

		return null;
	}

	@Override
	public Employee[] findAllEmployees() {

		return null;
	}

	@Override
	public void updateEmployee(int id, Employee employee) {

	}

}